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

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	private int id;
	private String code;	//页面代码
	private String pcode;   //父节点代码
	private String name;	//页面名字
	private String open;    //记录节点的 展开 / 折叠 状态
	private String pageUrl;	//页面路径
	private String statu;	//页面状态
	private String describe;	//页面描述

	private boolean checked;     //是否具有页面权限

	@Id
	@Column(name = "PAGE_ID")
	@GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "URL")
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	@Column(name = "NOTE")
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Column(name = "PCODE")
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	@Column(name = "OPEN")
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}

	@Transient
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Column(name = "STATU")
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
}