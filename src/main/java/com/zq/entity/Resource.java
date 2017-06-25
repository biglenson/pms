package com.zq.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the resource database table.
 * 
 */
@Entity
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	private String description;

	private String icon;

	private String name;

	@Column(name="open_mode")
	private String openMode;

	private String opened;

	private Long pid;

	@Column(name="resource_type")
	private byte resourceType;

	private byte seq;

	private byte status;

	private String url;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="resources")
	private List<Role> roles;

	public Resource() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpenMode() {
		return this.openMode;
	}

	public void setOpenMode(String openMode) {
		this.openMode = openMode;
	}

	public String getOpened() {
		return this.opened;
	}

	public void setOpened(String opened) {
		this.opened = opened;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public byte getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(byte resourceType) {
		this.resourceType = resourceType;
	}

	public byte getSeq() {
		return this.seq;
	}

	public void setSeq(byte seq) {
		this.seq = seq;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}