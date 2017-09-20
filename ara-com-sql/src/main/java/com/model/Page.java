/*
 * 文件名：${Page}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.6.3}
 * 修改：
 * 描述：页面对象  PO类
 *
 *
 * 版权：亚略特
 */
package com.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "TAS_SYS_PAGE")
public class Page {
	@Id
	@Column(name = "PAGE_ID",length = 36, nullable = false)
	@GeneratedValue(generator = "systemUUID" )   //指定生成器名称
	@GenericGenerator(name = "systemUUID", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类
	private String id;
	@Column(name = "CODE")
	private String code;	//页面代码
	@Column(name = "PCODE")
	private String pcode;   //父节点代码
	@Column(name = "OPEN")
	private String open;    //记录节点的 展开 / 折叠 状态
	@Column(name = "NAME")
	private String name;	//页面名字
	@Column(name = "URL")
	private String pageUrl;	//页面路径
	@Column(name = "STATU")
	private String statu;	//页面状态
	@Column(name = "NOTE")
	private String describe;	//页面描述
	@Transient
	private boolean checked;     //是否具有页面权限

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}

	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
}