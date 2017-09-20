/*
 * 文件名：${PageDaoImpl}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.21}
 * 修改：
 * 描述：Page  Dao实现层
 *
 *
 * 版权：亚略特
 */
package com.dao.impl;


import com.dao.PageDao;
import com.model.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pageDao")
public class PageDaoImpl extends BaseDaoImpl<Page> implements PageDao {
	@Override
	public List<Page> getAllEnablePages() {
		StringBuffer hql = new StringBuffer("from Page where statu = 'Y' ");
		return find(hql.toString(),null);
	}
}