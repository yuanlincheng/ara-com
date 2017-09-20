/*
 * 文件名：${Code}
 * 作者：${Tree}
 * 版本：
 * 时间：${2016.1.12}
 * 修改：
 * 描述：系统字典model
 *
 *
 * 版权：亚略特
 */
package com.model;

import com.exception.CommonUtilException;
import com.util.CommonStringUtil;

import javax.persistence.*;

@Entity
@Table(name = "TAS_SYS_CODE")
public class Code {

	private int id;				  //字典标示
	private String code;		  //字典码
	private String codeMean;      //字典码说明
	private int type;			  //字典类型码
	private String typeMean;	  //字典类型（只适用于普通字典）
	private String isbase;		  //是否基础字典类型  Y:是   N：不是
	private String statu;		  //字典是不是可用
	private String describe;	  //字典描述
	private String createOn;      //添加日期

	public static Code convert(Code code) throws CommonUtilException {
		CommonStringUtil.nullConvertNullString(code);
		parseObjectForWeb(code);
		return code;
	}


	@Id
	@Column(name = "CODE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="trustafis_seq")
	@SequenceGenerator(name="trustafis_seq", sequenceName="SEQ_TAS_SYS_CODE",allocationSize = 1)
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

	@Column(name = "CODE_MEAN")
	public String getCodeMean() {
		return codeMean;
	}


	public void setCodeMean(String codeMean) {
		this.codeMean = codeMean;
	}

	@Column(name = "TYPE")
	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "NOTE")
	public String getDescribe() {
		return describe;
	}


	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Column(name = "CREATE_DATE")
	public String getCreateOn() {
		return createOn;
	}


	public void setCreateOn(String createOn) {
		this.createOn = createOn;
	}

	@Column(name = "ISBASE")
	public String getIsbase() {
		return isbase;
	}


	public void setIsbase(String isbase) {
		this.isbase = isbase;
	}

	@Column(name = "TYPE_MEAN")
	public String getTypeMean() {
		return typeMean;
	}


	public void setTypeMean(String typeMean) {
		this.typeMean = typeMean;
	}

	@Column(name = "STATU")
	public String getStatu() {
		return statu;
	}


	public void setStatu(String statu) {
		this.statu = statu;
	}

	public static void parseObjectForWeb(Code code){
		switch (code.statu){
			case "E":
				code.setStatu("可用");
				break;
			default:
				code.setStatu("停用");
				break;
		}
	}
}