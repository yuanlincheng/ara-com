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
import com.util.CommonObjectUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("parameterDao")
public class ParameterDaoImpl extends BaseDaoImpl<Parameter> implements ParameterDao {

	@Override
	public List<Parameter> getAllShowParameter() {
		String hql = "from Parameter where showStatus = 'T' order by id asc";
		//模型参数构造
		List<Parameter> parameterlist = find(hql,null);
        if(Optional.ofNullable(parameterlist).isPresent()){
            parameterlist.forEach(CommonObjectUtil::convert);
        }
		return parameterlist;
	}
}