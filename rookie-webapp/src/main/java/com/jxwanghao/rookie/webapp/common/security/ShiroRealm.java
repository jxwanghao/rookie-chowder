package com.jxwanghao.rookie.webapp.common.security;

import com.jxwanghao.rookie.webapp.model.po.UserPO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author wanghao
 * @version V1.0
 * @date 2017/6/13
 */
public class ShiroRealm extends AuthorizingRealm {

	private Logger log = LoggerFactory.getLogger(this.getClass());

/*
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private ResourceService resourceService;
*/

	// 用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		/*
		 * 获取基于用户名和密码的令牌实际上这个authcToken是从LoginController里面
		 * currentUser.login(token)传过来的两个token的引用都是一样的
		 */
		/*try {
			UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
			String userName = token.getUsername();
			log.info("shiro checking user [" + userName + "] from db");
			UserPO userPO = userService.login(userName);
			// 检查用户是否合法
			if (null == userPO) {
				// 用户登录验证未通过, 未知账户");
				throw new UnknownAccountException("can not found [" + userName + "] in the system");
			} else {
				int userId = userPO.getUserId();
				// 当前用户登录失败次数
				Date failTime = userPO.getLoginFileTime();
				// 判断登录失败时间与当前时间对比是否超过24小时
				boolean flag = false;
				if (failTime != null) {
					flag = (System.currentTimeMillis() / 1000 - failTime.getTime() / 1000) < 3600 * 24;
					if (!flag) {
						// 如果经超过24小时,重置登录密码是吧次数为0
						userService.resetFailCount(userId);
						userPO.setLoginFailCount(0);
						userPO.setLoginFileTime(null);
					}
				}
				if (userPO.getStatus() == -1) {
					// 用户登录验证未通过, 账户无效或已经删除
					throw new DisabledAccountException("the account [" + userName + "] is disabled.");
				} else if (userPO.getStatus() == 1) {
					// 用户登录验证未通过, 账户已锁定
					throw new LockedAccountException("the account [" + userName + "] is locked.");
				} else if (userPO.getLoginFailCount() >= 5 && flag) {
					// 用户登录验证未通过, 用户名或密码错误次数过多
					throw new ExcessiveAttemptsException("the account [" + userName + "] is logined fail many time.");
				} else if (!userPO.getPassword().equals(String.valueOf(token.getPassword()))) {
					// 用户登录验证未通过, 登录密码输入错误");
					userService.addFailCount(userId);
					throw new IncorrectCredentialsException("the account [" + userName + "] password didn't match.");
				}
				// 登录成功更新失败次数为0
				userService.resetFailCount(userId);

				// 登录成功记录当前登录IP和登录时间
				UserVO info = new UserVO();
				userPO.setUserId(userId);
				userPO.setLastLoginIp(token.getHost());
				userService.updateAfterLoginSuccess(info);

				return new SimpleAuthenticationInfo(userPO, userPO.getPassword(), getName());
			}
		} catch (Exception e) {
			log.error("{}", e);
			throw translateAuthenticationException(e);
		}*/

		return null;
	}

	// 授权用户权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = null;
		UserPO userPO = null;
		String userName = "";
		try {
			userPO = (UserPO) getAvailablePrincipal(principals);
			userName = userPO.getUserName();
			log.info("====>> 开始授权[{}]....", userPO.getUserName());
			// User user = userService.getByUserName(userName);
			// 设置角色
			List<String> roleList = null;
			// 设置权限
			List<String> permissionList = null;
			// 如果当前登录账号是SPADMIN(超级管理员)
//			if ("spadmin".equalsIgnoreCase(userPO.getUserName())) {
//				roleList = roleService.getSpadminRole();
//				permissionList = resourceService.getSpadminResource();
//			} else { // 普通管理员
//				roleList = userRoleService.getRoleCodeByUserId(userPO.getUserId());
//				permissionList = resourceService.getResourceByUserId(userPO.getUserId());
//			}

			info = new SimpleAuthorizationInfo();
			info.addRoles(roleList);
			info.addStringPermissions(permissionList);
			log.info("====>> 用户[{}]授权完毕.", userName);
		} catch (Exception e) {
			log.error("====>> 用户[{}]授权失败.", userName);
			e.printStackTrace();
		}
		// 若该方法什么都不做直接返回null的话,就会导致任何用户访问授权资源时都会自动跳转到unauthorizedUrl指定的地址
		// 详见applicationSecurity.xml中的<bean id="shiroFilter">的配置
		return info;
	}

	/**
	 * 异常转换
	 *
	 * @param e
	 * @return
	 */
	private AuthenticationException translateAuthenticationException(Exception e) {
		if (e instanceof UnknownAccountException) {
			return (UnknownAccountException) e;
		}
		if (e instanceof DisabledAccountException) {
			return (DisabledAccountException) e;
		}
		if (e instanceof LockedAccountException) {
			return (LockedAccountException) e;
		}
		if (e instanceof ExcessiveAttemptsException) {
			return (ExcessiveAttemptsException) e;
		}
		if (e instanceof AuthenticationException) {
			return (AuthenticationException) e;
		}
		return new AuthenticationException(e);
	}

	public void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, value);
				log.info("Session默认超时时间为[" + (session.getTimeout() / 1000) + "]秒");
			}
		}
	}
}
