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
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TAS_SYS_MANAGER")
public class Manager implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;				//标示ID
	private String account;		//管理员账号
	private String password;	//管理员密码
	private String isRoot;		//是否超级管理员  Y/N
	private Role role;			//关联角色
	private String statu;		//管理员状态    Y/N
	private String lastLogin;	//最近登录时间
	private String createOn;	//管理员创建时间
	private String createBy;	//创建者
	private String modifiedOn;	//管理员修改时间
	private String modifiedBy;	//修改者

    private String roleName;    //角色名

	public static Manager convert(Manager manager) throws CommonUtilException {
		CommonStringUtil.nullConvertNullString(manager);
		parseObjectForWeb(manager);
		return manager;
	}


	@Id
	@Column(name = "MANAGER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="trustafis_seq")
	@SequenceGenerator(name="trustafis_seq", sequenceName="SEQ_TAS_SYS_MANAGER",allocationSize = 1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ACCOUNT")
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "CREATE_DATE")
	public String getCreateOn() {
		return createOn;
	}
	public void setCreateOn(String createOn) {
		this.createOn = createOn;
	}

	@Column(name = "CREATE_BY")
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "MODIFY_DATE")
	public String getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Column(name = "MODIFY_BY")
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name = "IS_ROOT")
	public String getIsRoot() {
		return isRoot;
	}
	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	@NotFound(action= NotFoundAction.IGNORE)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "LAST_LOGIN")
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name = "STATU")
	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

    @Transient
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