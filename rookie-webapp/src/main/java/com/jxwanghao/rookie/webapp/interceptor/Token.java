package com.jxwanghao.rookie.webapp.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wanghao
 * @version V1.0
 * @date 2017/6/7
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
	/**
	 * 添加token
	 *
	 * @return
	 */
	boolean save() default false;

	/**
	 * 删除token
	 *
	 * @return
	 */
	boolean remove() default false;

	/**
	 * 如果是重复提交这Token拦截后,重定向到指定的 action中.
	 *
	 * @return
	 */
	String redirect() default "";
}
