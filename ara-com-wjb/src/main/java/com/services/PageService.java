/*
 * 文件名：${PageService}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.21}
 * 修改：
 * 描述：页面  Service接口层
 *
 *
 * 版权：亚略特
 */
package com.services;

import com.model.Page;

import java.util.List;

public interface PageService{
	/**
	 * 获取当前可用页面对象
	 * @param
	 * @return 页面List
	 */
	List<Page> getAllEnablePages();
}