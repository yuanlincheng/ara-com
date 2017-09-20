/*
 * 文件名：${Parameter}
 * 作者：${Tree}
 * 版本：
 * 时间：${2016.5.23}
 * 修改：
 * 描述：参数设置表  model
 *
 *
 * 版权：亚略特
 */
package com.model;


import com.util.CommonStringUtil;

import javax.persistence.*;

@Entity
@Table(name = "TAS_SYS_SETTING")
@SuppressWarnings("unused")
public class Parameter {

	private static final long serialVersionUID = 1L;

	private int id;				  //字典标示
	private String appId;		  		//字典码
	private String mainKey;      //字典码说明
	private String subKey;      //字典码说明
	private String value;      //字典码说明
	private String modifyStatus;      //字典码说明
	private String showStatus;      //字典码说明
	private String parameterName;	  //字典类型（只适用于普通字典）
	private String describe;	  //字典描述

	public static Parameter convert(Parameter parameter) throws Exception {
		CommonStringUtil.nullConvertNullString(parameter);
        parseObjectForWeb(parameter);
		return parameter;
	}


	@Id
	@Column(name = "SETTING_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="trustafis_seq")
	@SequenceGenerator(name="trustafis_seq", sequenceName="SEQ_TAS_SYS_SETTING",allocationSize = 1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "APP_ID")
	public String getAppId() {
		return appId;
	}


	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Column(name = "MAIN_KEY")
	public String getMainKey() {
		return mainKey;
	}


	public void setMainKey(String mainKey) {
		this.mainKey = mainKey;
	}

	@Column(name = "SUB_KEY")
	public String getSubKey() {
		return subKey;
	}


	public void setSubKey(String subKey) {
		this.subKey = subKey;
	}

	@Column(name = "VALUE")
	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "MODEFY_STATUS")
	public String getModifyStatus() {
		return modifyStatus;
	}


	public void setModifyStatus(String modifyStatus) {
		this.modifyStatus = modifyStatus;
	}

	@Column(name = "SHOW_STATUS")
	public String getShowStatus() {
		return showStatus;
	}


	public void setShowStatus(String showStatus) {
		this.showStatus = showStatus;
	}

	@Column(name = "PARANAME")
	public String getParameterName() {
		return parameterName;
	}


	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	@Column(name = "NOTE")
	public String getDescribe() {
		return describe;
	}


	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public static void parseObjectForWeb(Parameter parameter){
		switch (parameter.mainKey){
			case "Master":
				parameter.setMainKey("比对引擎");
				break;
			default:
				parameter.setMainKey("支撑系统");
				break;
		}
		switch (parameter.modifyStatus){
			case "T":
				parameter.setModifyStatus("是");
				break;
			default:
				parameter.setModifyStatus("否");
				break;
		}
	}
}