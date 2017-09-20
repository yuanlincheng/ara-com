/*
 * 文件名：${ParameterDaoImpl}
 * 作者：${Tree}
 * 版本：
 * 时间：${2016.5.23}
 * 修改：
 * 描述：Parameter  dao实现层
 *
 *
 * 版权：亚略特
 */
package com.dao.impl;


import com.dao.ParameterDao;
import com.model.Parameter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("parameterDao")
public class ParameterDaoImpl extends BaseDaoImpl<Parameter> implements ParameterDao {

	@Override
	public List<Parameter> getAllShowParameter() {
		StringBuffer hql = new StringBuffer("from Parameter where showStatus = 'T' order by id asc");
		List<Parameter> parameterlist = new ArrayList<Parameter>();

		//模型参数构造
		List<Parameter> parameterListTemp = find(hql.toString(),null);
		if(null != parameterListTemp && parameterListTemp.size() > 0){
			for(Parameter parameterTemp : parameterListTemp){
				try {
					parameterlist.add(Parameter.convert(parameterTemp));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return parameterlist;
	}
}