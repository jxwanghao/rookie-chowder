package com.jxwanghao.rookie.webapp.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 监听session的销毁
 * 
 * @author Dylan
 * @time 2013-8-15
 */
public class SessionListener extends SessionListenerAdapter {

	private final static Logger logger = LoggerFactory.getLogger(SessionListener.class);

	/*
	 * @Autowired private ShiroOperations shiroOperations;
	 */
	/**
	 * session创建
	 */
	@Override
	public void onStart(Session session) {
		// do noting...
		logger.info("session Start");
	}

	/**
	 * session销毁
	 */
	@Override
	public void onStop(Session session) {
		logger.info("Session Stop");
		// do noting...
		/*
		 * String username = ShiroSecurityHelper.getCurrentUsername();
		 * if(StringUtils.isNotBlank(username)){
		 * shiroOperations.clearCachedAuthorizationInfo(username); LOG.debug(
		 * "session 销毁，清理用户【"+username+"】权限缓存信息"); }
		 */
	}

}
