package com.jxwanghao.rookie.webapp.model.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台管理员实体类
 * 
 * @author qinqz
 * @date 2015-11-21
 * @version V1.0
 * @since 1.0
 */
public class UserPO implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 主键ID */
	private Integer userId;
	/** 所属部门ID */
	private Integer deptId;
	/** 用户名 */
	private String userName;
	/** 密码 */
	private String password;
	/** 电子邮箱 */
	private String email;
	/** 手机号码 */
	private String phone;
	/** 真实姓名 */
	private String realName;
	/** 昵称 */
	private String nickName;
	/** 性别 */
	private Integer gender;
	/** 登录异常次数 */
	private Integer loginFailCount;
	/** 登录异常时间 */
	private Date loginFileTime;
	/** 上一次登录IP */
	private String lastLoginIp;
	/** 上一次登录时间 */
	private Date lastLoginTime;
	/** 用户状态 */
	private Integer status;
	/** 创建人 */
	private Integer createBy;
	/** 修改人 */
	private Integer updateBy;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;

	public UserPO() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getLoginFailCount() {
		return loginFailCount;
	}

	public void setLoginFailCount(Integer loginFailCount) {
		this.loginFailCount = loginFailCount;
	}

	public Date getLoginFileTime() {
		return loginFileTime;
	}

	public void setLoginFileTime(Date loginFileTime) {
		this.loginFileTime = loginFileTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}