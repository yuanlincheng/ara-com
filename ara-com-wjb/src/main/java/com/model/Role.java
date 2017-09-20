/*
 * 文件名：${Role}
 * 作者：${Tree}
 * 版本：
 * 时间：${2013.8.16}
 * 修改：
 * 描述：系统权限角色model
 *
 *
 * 版权：亚略特
 */
package com.model;

import com.exception.CommonUtilException;
import com.util.CommonStringUtil;

import javax.persistence.*;

@Entity
@Table(name = "TAS_SYS_ROLE")
public class Role {

	private int id;

	private String name;	//角色名称

	private String purview;	//角色页面权限

	private String isRoot;

	private String describe;	//角色描述

	public static Role convertRole(Role role) throws CommonUtilException {
		CommonStringUtil.nullConvertNullString(role);
		return role;
	}


	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="trustafis_seq")
	@SequenceGenerator(name="trustafis_seq", sequenceName="SEQ_TAS_SYS_ROLE",allocationSize = 1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "purview")
	public String getPurview() {
		return purview;
	}
	public void setPurview(String purview) {
		this.purview = purview;
	}

	@Column(name = "note")
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Column(name = "is_root")
	public String getIsRoot() {
		return isRoot;
	}

	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}
}