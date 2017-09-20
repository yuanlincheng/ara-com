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
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "TAS_SYS_SETTING")
@SuppressWarnings("unused")
public class Parameter {
	@Id
	@Column(name = "SETTING_ID",length = 36, nullable = false)
	@GeneratedValue(generator = "systemUUID" )   //指定生成器名称
	@GenericGenerator(name = "systemUUID", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类
	private String id;				  //字典标示
	@Column(name = "APP_ID")
	private String appId;		  		//字典码
	@Column(name = "MAIN_KEY")
	private String mainKey;      //字典码说明
	@Column(name = "SUB_KEY")
	private String subKey;      //字典码说明
	@Column(name = "VALUE")
	private String value;      //字典码说明
	@Column(name = "MODEFY_STATUS")
	private String modifyStatus;      //字典码说明
	@Column(name = "SHOW_STATUS")
	private String showStatus;      //字典码说明
	@Column(name = "PARANAME")
	private String parameterName;	  //字典类型（只适用于普通字典）
	@Column(name = "NOTE")
	private String describe;	  //字典描述

	public static Parameter convert(Parameter parameter) throws Exception {
		CommonStringUtil.nullConvertNullString(parameter);
        parseObjectForWeb(parameter);
		return parameter;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMainKey() {
		return mainKey;
	}

	public void setMainKey(String mainKey) {
		this.mainKey = mainKey;
	}

	public String getSubKey() {
		return subKey;
	}

	public void setSubKey(String subKey) {
		this.subKey = subKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getModifyStatus() {
		return modifyStatus;
	}

	public void setModifyStatus(String modifyStatus) {
		this.modifyStatus = modifyStatus;
	}

	public String getShowStatus() {
		return showStatus;
	}


	public void setShowStatus(String showStatus) {
		this.showStatus = showStatus;
	}

	public String getParameterName() {
		return parameterName;
	}


	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

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