/*
 * 文件名：${CommonService}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.12}
 * 修改：
 * 描述：Service 公共层
 *
 *
 * 版权：亚略特
 */
package com.services;

import com.exception.ServiceException;
import com.vo.PageVO;

import java.util.List;

public interface CommonService<T>  {
	/**
	 * 保存对象信息
	 * @param obj（对象）
	 * @param operator（操作者）
	 * @param values（泛型参数，主要是为了适配各种模型）
	 * @return
	 */
	void saveObj(T obj, String operator, Object... values) throws ServiceException;

	/**
	 * 修改对象信息
	 * @param obj（对象）
	 * @param operator（操作者）
	 * @param id（标示ID）
	 * @param values（泛型参数，主要是为了适配各种模型）
	 * @return boolean  是否成功
	 */

	void updateObj(T obj, String operator, Object id, Object... values) throws ServiceException;


	/**
	 * 删除对象
	 * @param id（标示ID）
	 * @param values（泛型参数，主要是为了适配各种模型）
	 * @return 对象
	 */
	void delObj(Object id, Object... values) throws ServiceException;

	/**
	 * 分页获取对象列表
	 * @param page（分页对象）
	 * @param queryType (查询类型 1.全字段模糊查询  2. 精确查询)
	 * @param values（查询条件）
	 * @return 对象list
	 */
	List<T> getObjListPage(PageVO page, int queryType, Object... values);

	/**
	 * 获取对象列表
	 * @param values（查询条件）
	 * @return 对象list
	 */
	List<T> getObjList(Object... values);

	/**
	 * 根据id获取对象
	 * @param id（对象id）
	 * @return 对象
	 */
	T getObj(Object id);

	/**
	 * 根据属性以及属性值获取对象
	 * @param param 属性以及属性值
	 * @return 对象
	 */
	T getObjByObj(String param, Object value);

}