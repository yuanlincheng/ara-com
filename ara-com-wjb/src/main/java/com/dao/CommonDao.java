/*
 * 文件名：${commonDao}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.12}
 * 修改：
 * 描述：dao 公共层
 *
 *
 * 版权：亚略特
 */
package com.dao;

public interface CommonDao<T> {
	/**
	 * 校验对象是否存在
	 * @return boolean
	 */
	boolean checkExist(String obj, int id);

	/**
	 * 校验对象是否存在
	 * @return boolean
	 */
	boolean checkExist(int id, Object... values);
}