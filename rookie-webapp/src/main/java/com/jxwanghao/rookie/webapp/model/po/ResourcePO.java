package com.jxwanghao.rookie.webapp.model.po;

import java.io.Serializable;

/**
 * 系统资源实体类
 * 
 * @author qinqz
 * @date 2015-11-21
 * @version V1.0
 * @since 1.0
 */
public class ResourcePO implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 资源ID */
	private Integer resourceId;
	/** 上级ID */
	private Integer parentId;
	/** 资源级别 */
	private Integer level;
	/** 资源类型 */
	private String type;
	/** 资源名称 */
	private String name;
	/** 资源代码 */
	private String code;
	/** 资源序号 */
	private Integer sequence;
	/** 资源备注 */
	private String remark;
	/** 资源状态 */
	private Integer status;

	public ResourcePO() {
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}