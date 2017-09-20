/*
 * 文件名：${Manager}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.12}
 * 修改：
 * 描述：管理员  PO类
 *
 *
 * 版权：亚略特
 */
package com.model;

import com.exception.CommonUtilException;
import com.util.CommonStringUtil;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TAS_SYS_MANAGER")
public class Manager implements Serializable {

	@Id
	@Column(name = "MANAGER_ID",length = 36, nullable = false)
	@GeneratedValue(generator = "systemUUID" )   //指定生成器名称
	@GenericGenerator(name = "systemUUID", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类
	private String id;				//标示ID
	@Column(name = "ACCOUNT")
	private String account;		//管理员账号
	@Column(name = "PASSWORD")
	private String password;	//管理员密码
	@Column(name = "IS_ROOT")
	private String isRoot;		//是否超级管理员  Y/N
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	@NotFound(action= NotFoundAction.IGNORE)
	private Role role;			//关联角色
	@Column(name = "STATU")
	private String statu;		//管理员状态    Y/N
	@Column(name = "LAST_LOGIN")
	private String lastLogin;	//最近登录时间
	@Column(name = "CREATE_DATE")
	private String createOn;	//管理员创建时间
	@Column(name = "CREATE_BY")
	private String createBy;	//创建者
	@Column(name = "MODIFY_DATE")
	private String modifiedOn;	//管理员修改时间
	@Column(name = "MODIFY_BY")
	private String modifiedBy;	//修改者
	@Transient
    private String roleName;    //角色名

	public static Manager convert(Manager manager) throws CommonUtilException {
		CommonStringUtil.nullConvertNullString(manager);
		parseObjectForWeb(manager);
		return manager;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateOn() {
		return createOn;
	}
	public void setCreateOn(String createOn) {
		this.createOn = createOn;
	}

	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getIsRoot() {
		return isRoot;
	}
	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public static void parseObjectForWeb(Manager manager){
		switch (manager.statu){
			case "E":
				manager.setStatu("可用");
				break;
			default:
				manager.setStatu("停用");
				break;
		}
        manager.setRoleName(manager.getRole().getName());
	}
}