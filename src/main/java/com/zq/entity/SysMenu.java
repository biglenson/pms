package com.zq.entity;

import java.io.Serializable;
import javax.persistence.*;


/** 
* @ClassName: SysMenu 
* @Description: TODO(系统菜单实体) 
* @author shujukuss 
* @date 2017年6月18日 下午7:06:52 
*  
*/
@Entity
@Table(name="sys_menu")
public class SysMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SYS_MENU_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SYS_MENU_ID_GENERATOR")
	private int id;

	private String clienturl;

	private String description;

	private String description1;

	private String imageurl;

	private String name;

	private int parentid;

	private int policy;

	private int seqno;

	private int status;

	private int type;

	public SysMenu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClienturl() {
		return this.clienturl;
	}

	public void setClienturl(String clienturl) {
		this.clienturl = clienturl;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription1() {
		return this.description1;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentid() {
		return this.parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public int getPolicy() {
		return this.policy;
	}

	public void setPolicy(int policy) {
		this.policy = policy;
	}

	public int getSeqno() {
		return this.seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}