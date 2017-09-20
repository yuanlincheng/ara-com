/*
 * 文件名：${ParameterDao}
 * 作者：${Tree}
 * 版本：
 * 时间：${2016.5.23}
 * 修改：
 * 描述：Parameter  dao层
 *
 *
 * 版权：亚略特
 */
package com.dao;


import com.model.Parameter;

import java.util.List;


public interface ParameterDao extends BaseDao<Parameter> {

	/**
	 * 获取可见的系统参数列表
	 * @param
	 * @return  可见的系统参数列表
	 */
	List<Parameter> getAllShowParameter();
}