/*
 * 文件名：${PageDao}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.21}
 * 修改：
 * 描述：page  dao层
 *
 *
 * 版权：亚略特
 */
package com.dao;


import com.model.Page;

import java.util.List;


public interface PageDao extends BaseDao<Page> {

	/**
	 * 获取当前可用页面对象
	 * @param
	 * @return 页面List
	 */
	List<Page> getAllEnablePages();
}