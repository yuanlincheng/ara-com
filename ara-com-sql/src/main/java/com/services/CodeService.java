/*
 * 文件名：${CodeService}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.25}
 * 修改：
 * 描述：字典     Service接口层
 *
 *
 * 版权：亚略特
 */
package com.services;


import com.model.Code;

import java.util.List;


public interface CodeService extends CommonService<Code> {
	/**
	 * 获取所有此种类型的字典对象
	 * @param type（字典类型）
	 * @return  字典列表
	 */
	List<Code> getAllCodeByType(int type);

	/**
	 * 获取下一个基础字典类型码
	 * @param
	 * @return  字典类型（包含下一个基础字典类型码）
	 */
	Code getNextCodeType();

	/**
	 * 根据字典类型码获取基础字典类型
	 * @param  type(字典类型码)
	 * @return  字典类型
	 */
	Code getBaseCodeType(int type);

	/**
	 * 获取所有基础字典对象
	 * @param
	 * @return  基础字典列表
	 */
	List<Code> getAllBaseCode();
}