package com.jxwanghao.rookie.webapp.model.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统角色实体类
 * 
 * @author qinqz
 * @date 2015-11-21
 * @version V1.0
 * @since 1.0
 */
public class RolePO implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 角色ID */
	private Integer roleId;
	/** 角色代码 */
	private String roleCode;
	/** 角色名称 */
	private String roleName;
	/** 角色状态 */
	private Integer status;
	/** 备注 */
	private String remark;
	/** 创建人 */
	private Integer createBy;
	/** 修改人 */
	private Integer updateBy;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;

	private boolean checked;

	private List<String> resourceList;

	public RolePO() {
	}

	public List<String> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<String> resourceList) {
		this.resourceList = resourceList;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}