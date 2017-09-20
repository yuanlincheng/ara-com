/*
 * 文件名：${ParameterServiceImpl}
 * 作者：${Tree}
 * 版本：
 * 时间：${2016.5.23}
 * 修改：
 * 描述：参数设置  Service实现层
 *
 *
 * 版权：亚略特
 */
package com.services.impl;

import com.dao.ParameterDao;
import com.model.Parameter;
import com.vo.PageVO;
import com.services.ParameterService;
import com.util.CommonObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("parameterService")
public class ParameterServiceImpl implements ParameterService {

	@Autowired
	private ParameterDao parameterDao;

	@Override
	public void saveObj(Parameter obj, String operator, Object... values){
		// TODO Auto-generated method stub

	}

	@Override
	public void updateObj(Parameter obj, String operator, int id, Object... values){
		obj.setId(id);
		Parameter parameterTemp = parameterDao.findById(id);
		//系统参数持久对象构造
		if(null != parameterTemp){
			CommonObjectUtil.Copy(parameterTemp,obj);
		}
		//保存系统参数对象
		parameterDao.merge(obj);
	}

	@Override
	public void delObj(int id, Object... values){
		// TODO Auto-generated method stub

	}

	@Override
	public List<Parameter> getObjListPage(PageVO page, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parameter> getObjList(Object... values) {
		return null;
	}

	@Override
	public Parameter getObj(int id) {
		return parameterDao.findById(id);
	}

	@Override
	public Parameter getObjByObj(String param, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parameter> getAllShowParameter() {
		return parameterDao.getAllShowParameter();
	}
}