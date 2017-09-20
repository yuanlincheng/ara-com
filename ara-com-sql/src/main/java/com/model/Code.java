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
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "TAS_SYS_CODE")
public class Code {

	@Id
	@Column(name = "CODE_ID",length = 36, nullable = false)
	@GeneratedValue(generator = "systemUUID" )   //指定生成器名称
	@GenericGenerator(name = "systemUUID", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类
	private String id;				  //字典标示
	@Column(name = "CODE")
	private String code;		  //字典码
	@Column(name = "CODE_MEAN")
	private String codeMean;      //字典码说明
	@Column(name = "TYPE")
	private int type;			  //字典类型码
	@Column(name = "TYPE_MEAN")
	private String typeMean;	  //字典类型（只适用于普通字典）
	@Column(name = "ISBASE")
	private String isbase;		  //是否基础字典类型  Y:是   N：不是
	@Column(name = "STATU")
	private String statu;		  //字典是不是可用
	@Column(name = "NOTE")
	private String describe;	  //字典描述
	@Column(name = "CREATE_DATE")
	private String createOn;      //添加日期

	public static Code convert(Code code) throws CommonUtilException {
		CommonStringUtil.nullConvertNullString(code);
		parseObjectForWeb(code);
		return code;
	}

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

	public String getCodeMean() {
		return codeMean;
	}

	public void setCodeMean(String codeMean) {
		this.codeMean = codeMean;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getCreateOn() {
		return createOn;
	}

	public void setCreateOn(String createOn) {
		this.createOn = createOn;
	}

	public String getIsbase() {
		return isbase;
	}

	public void setIsbase(String isbase) {
		this.isbase = isbase;
	}

	public String getTypeMean() {
		return typeMean;
	}

	public void setTypeMean(String typeMean) {
		this.typeMean = typeMean;
	}

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