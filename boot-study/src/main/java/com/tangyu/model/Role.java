package com.tangyu.model;

import java.util.Date;

/****
 * 角色实体类
 * 
 * @author tangyu
 *
 */
public class Role {
	private Long id;
	private String name;
	private Integer status;
	private Integer level;
	private Long orgId;
	private Date createdAt;
	private Date updatedAt;
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", status=" + status + ", level=" + level + ", orgId=" + orgId
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", remark=" + remark + "]";
	}
}
