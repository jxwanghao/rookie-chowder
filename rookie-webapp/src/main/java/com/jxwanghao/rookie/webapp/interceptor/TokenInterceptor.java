package com.jxwanghao.rookie.webapp.interceptor;

import com.jxwanghao.rookie.framework.utils.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author wanghao
 * @version V1.0
 * @date 2017/6/7
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {
	private static Logger log = Logger.getLogger(TokenInterceptor.class);

	private static final String TOKEN_KEY = "token";
	private long privious;// 上次生成表单标识号得时间值

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Token annotation = method.getAnnotation(Token.class);
			if (annotation != null) {
				// 保存Token
				boolean saveToken = annotation.save();
				if (saveToken) {
					String token = makeToken();
					System.out.println(token);
					request.getSession().setAttribute(TOKEN_KEY, token);
					log.info("token = " + token);
				}
				// 保存移除Token
				boolean removeToken = annotation.remove();
				if (removeToken) {
					// 判断是否是重复提交
					if (isRepeatSubmit(request)) {
						String actionUrl = request.getRequestURI().toString();
						log.info("repeat submit,redirect:" + actionUrl);
						if (annotation.redirect() != null && annotation.redirect().trim().length() > 0) {
							// 如果是重复提交并且设置了actionUrl,则重定向到指定的Action.
							actionUrl = request.getContextPath() + annotation.redirect().trim().toString();
						}
						response.sendRedirect(actionUrl);
						return false;
					}
					request.getSession().removeAttribute(TOKEN_KEY);
				}
			}
		}
		return super.preHandle(request, response, handler);
	}

	private boolean isRepeatSubmit(HttpServletRequest request) {
		String clinetToken = request.getParameter(TOKEN_KEY);
		if (StringUtils.isBlank(clinetToken)) {
			return true;
		}
		String serverToken = (String) request.getSession().getAttribute(TOKEN_KEY);
		if (StringUtils.isBlank(serverToken)) {
			return true;
		}
		if (!serverToken.equals(clinetToken)) {
			return true;
		}
		return false;
	}

	public synchronized String makeToken() {
		long current = System.currentTimeMillis();
		if (current == privious) {
			current++;
		}
		privious = current;
		return Md5Util.md5(privious + "");
	}
}
