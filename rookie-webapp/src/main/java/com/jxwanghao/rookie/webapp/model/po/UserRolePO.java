package com.jxwanghao.rookie.webapp.model.po;

import java.io.Serializable;

/**
 * 用户角色实体类
 * 
 * @author qinqz
 * @date 2015-11-21
 * @version V1.0
 * @since 1.0
 */
public class UserRolePO implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 用户ID */
	private Integer userId;
	/** 角色ID */
	private Integer roleId;

	public UserRolePO() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}