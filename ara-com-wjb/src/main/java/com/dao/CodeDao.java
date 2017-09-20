/*
 * 文件名：${CodeDao}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.18}
 * 修改：
 * 描述：字典    dao层
 *
 *
 * 版权：亚略特
 */
package com.dao;


import com.model.Code;
import com.vo.PageVO;

import java.util.List;

public interface CodeDao extends BaseDao<Code>,CommonDao<Code> {

	/**
	 * 分页获取code
	 * @param page（分页对象）
	 * @param values（查询条件）
	 * @return 字典list
	 */
	List<Code> getCodePage(PageVO page, Object... values);

	/**
	 * 获取所有此种类型的字典对象
	 * @param type（字典类型）
	 * @return  字典列表
	 */
	List<Code> getAllCodeByType(int type);

	/**
	 * 获取所有基础字典对象
	 * @param
	 * @return  基础字典列表
	 */
	List<Code> getAllBaseCode();

	/**
	 * 根据字典类型码获取基础字典类型
	 * @param  type(字典类型码)
	 * @return  字典类型
	 */
	Code getBaseCodeType(int type);
}