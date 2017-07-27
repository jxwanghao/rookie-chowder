package com.jxwanghao.rookie.webapp.common.cache;

/**
 * Cache 名称常量管理类
 * 
 * @author qinqz
 * @date 2015-11-21
 * @version V1.0
 * @since 1.0
 */
public class CacheName {

	// 默认的KEY
	public static final String DEFAULT_CACHE = "DEFAULT_CACHE";

	/** 后台缓存 */
	public interface OSS {
		/** 缓存全局缓存 */
		String GOLBAL_CACHE = "GOLBAL_CACHE";
		/** 系统常量缓存 */
		String SYS_CONSTANT_CACHE = "SYSTEM_CONSTANT_CACHE";
		/** 缓存用户实体信息 */
		String USER_INFO_CACHE = "USER_INFO_CACHE";
		/** 缓存用户角色 */
		String USER_ROLES_CACHE = "USER_ROLES_CACHE";
		/** 缓存系统资源 */
		String SYS_RESOURCES_CACHE = "SYS_RESOURCES_CACHE";
		/** 授权用户权限缓存 */
		String SHIRO_AUTHORIZATION_CACHE = "authorizationCache";
		/** 用户认证缓存 */
		String SHIRO_AUTHENTICATION_CACHE = "authenticationCache";
		/** Shiro Session 缓存 */
		String SHIRO_ACTIVE_SESSION_CACHE = "shiroActiveSessionCache";
		/** 用户登录成功后 userName和session绑定缓存 */
		String SHIRO_USER_SESSION_RELATION_CACHE = "userSessionRelationCache";
	}
}
