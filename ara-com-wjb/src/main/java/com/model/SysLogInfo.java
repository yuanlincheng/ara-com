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

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TAS_LOG_SYSTEM")
public class SysLogInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;            //标示ID
	private String type;		//日志类型
	private String operate;	    //操作类型
	private String content;	    //操作内容
	private String createBy;	//操作者
	private String createOn;   //操作时间

	private boolean logFlag = true;   //标志是否记日志


	public static SysLogInfo convert(SysLogInfo logInfo) throws CommonUtilException {
		CommonStringUtil.nullConvertNullString(logInfo);
		return logInfo;
	}

	@Id
	@Column(name = "LOG_SYSTEM_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="trustafis_seq")
	@SequenceGenerator(name="trustafis_seq", sequenceName="SEQ_TAS_LOG_SYSTEM",allocationSize = 1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	@Column(name = "create_date")
	public String getCreateOn() {
		return createOn;
	}
	public void setCreateOn(String createOn) {
		this.createOn = createOn;
	}

	@Column(name = "operate")
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "create_by")
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Transient
	public boolean getLogFlag() {
		return logFlag;
	}

	public void setLogFlag(boolean logFlag) {
		this.logFlag = logFlag;
	}
}