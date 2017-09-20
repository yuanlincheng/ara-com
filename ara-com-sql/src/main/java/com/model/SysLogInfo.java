/*
 * 文件名：${SysLogInfo}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.15}
 * 修改：
 * 描述：系统日志对象  PO类
 *
 *
 * 版权：亚略特
 */
package com.model;

import com.exception.CommonUtilException;
import com.util.CommonStringUtil;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TAS_LOG_SYSTEM")
public class SysLogInfo implements Serializable {
	@Id
	@Column(name = "LOG_SYSTEM_ID",length = 36, nullable = false)
	@GeneratedValue(generator = "systemUUID" )   //指定生成器名称
	@GenericGenerator(name = "systemUUID", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类
	private String id;            //标示ID
	@Column(name = "type")
	private String type;		//日志类型
	@Column(name = "operate")
	private String operate;	    //操作类型
	@Column(name = "content")
	private String content;	    //操作内容
	@Column(name = "create_by")
	private String createBy;	//操作者
	@Column(name = "create_date")
	private String createOn;   //操作时间
	@Transient
	private boolean logFlag = true;   //标志是否记日志


	public static SysLogInfo convert(SysLogInfo logInfo) throws CommonUtilException {
		CommonStringUtil.nullConvertNullString(logInfo);
		return logInfo;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCreateOn() {
		return createOn;
	}
	public void setCreateOn(String createOn) {
		this.createOn = createOn;
	}

	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public boolean getLogFlag() {
		return logFlag;
	}

	public void setLogFlag(boolean logFlag) {
		this.logFlag = logFlag;
	}
}