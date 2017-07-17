package com.zq.entity.system;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_resource database table.
 * 
 */
@Entity
@Table(name="sys_role_sys_resource")
public class RoleResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="resources_id")
	private Long resourceId;

	@Column(name="roles_id")
	private Long roleId;

	public RoleResource() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}