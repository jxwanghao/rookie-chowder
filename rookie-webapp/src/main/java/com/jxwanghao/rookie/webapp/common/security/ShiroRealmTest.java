package com.jxwanghao.rookie.webapp.common.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author wanghao
 * @version V1.0
 * @date 2017/6/12
 */
public class ShiroRealmTest implements Realm {
	@Override
	public String getName() {
		return "shiroRealmTest";
	}

	@Override
	public boolean supports(AuthenticationToken authenticationToken) {
		//仅支持UsernamePasswordToken类型的Token
		return authenticationToken instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String username = (String) authenticationToken.getPrincipal();
		String password = (String) authenticationToken.getCredentials();

		if(!"zhang".equals(username)) {
			throw new UnknownAccountException(); //如果用户名错误
		}
		if(!"123".equals(password)) {
			throw new IncorrectCredentialsException(); //如果密码错误
		}
		//如果身份认证验证成功，返回一个AuthenticationInfo实现；
		return new SimpleAuthenticationInfo(username, password, getName());
	}
}
