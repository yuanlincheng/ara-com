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
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "TAS_SYS_ROLE")
public class Role {
	@Id
	@Column(name = "ROLE_ID",length = 36, nullable = false)
	@GeneratedValue(generator = "systemUUID" )   //指定生成器名称
	@GenericGenerator(name = "systemUUID", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类
	private String id;
	@Column(name = "name")
	private String name;	//角色名称
	@Column(name = "purview")
	private String purview;	//角色页面权限
	@Column(name = "is_root")
	private String isRoot;
	@Column(name = "note")
	private String describe;	//角色描述

	public static Role convert(Role role) throws CommonUtilException {
		CommonStringUtil.nullConvertNullString(role);
		return role;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPurview() {
		return purview;
	}
	public void setPurview(String purview) {
		this.purview = purview;
	}

	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getIsRoot() {
		return isRoot;
	}

	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}
}