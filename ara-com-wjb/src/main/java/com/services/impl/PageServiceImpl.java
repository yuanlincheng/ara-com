/*
 * 文件名：${PageServiceImpl}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.21}
 * 修改：
 * 描述：页面  Service实现层
 *
 *
 * 版权：亚略特
 */
package com.services.impl;

import com.dao.PageDao;
import com.model.Page;
import com.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pageService")
public class PageServiceImpl implements PageService {

	@Autowired
	private PageDao pageDao;

	@Override
	public List<Page> getAllEnablePages() {
		return pageDao.getAllEnablePages();
	}


}