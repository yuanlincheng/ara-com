/*
 * 文件名：${ParameterService}
 * 作者：${Tree}
 * 版本：
 * 时间：${2016.5.23}
 * 修改：
 * 描述：系统参数  Service接口层
 *
 *
 * 版权：亚略特
 */
package com.services;

import com.model.Parameter;

import java.util.List;

public interface ParameterService extends CommonService<Parameter> {
	/**
	 * 获取可见的系统参数列表
	 * @param
	 * @return  可见的系统参数列表
	 */
	List<Parameter> getAllShowParameter();
}