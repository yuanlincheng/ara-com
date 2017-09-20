/*
 * 文件名：${ManagerDaoImpl}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.21}
 * 修改：
 * 描述：管理员  Dao实现层
 *
 *
 * 版权：亚略特
 */
package com.dao.impl;

import com.dao.ManagerDao;
import com.jce.KeyTools;
import com.model.Manager;
import com.vo.PageVO;
import com.time.TimeUtil;
import com.util.CommonObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository("managerDao")
public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao {

	@Override
	public boolean checkExist(String obj, Object id) {
		StringBuilder hql = new StringBuilder("from Manager where account = :account ");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account", obj);
		if(StringUtils.isNotBlank((String)id)){
			hql.append(" and id != :id ");
            paramMap.put("id", id);
		}
		List<Manager> list = find(hql.toString(), paramMap);
        return list != null && list.size() > 0;
	}

	@Override
	public boolean checkRoleExist(String roleId) {
		String hql = "from Manager where role.id = :roleId ";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("roleId", roleId);
		List<Manager> list = find(hql, paramMap);
        return list != null && list.size() > 0;
	}

	@Override
	public boolean checkExist(Object id, Object... values) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean checkLogin(String name, String password) {
		String hql = "from Manager where account = :account and password = :password ";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account", name);
        paramMap.put("password", KeyTools.GetPasswordMD5(password));
        List<Manager> list = find(hql,paramMap);
		if(Optional.ofNullable(list).isPresent() && list.size() > 0){
            //更新最近登录时间
            Manager managerTemp = list.get(0);
            managerTemp.setLastLogin(TimeUtil.getFormatDate());
            save(managerTemp);
            return true;
		}
		return false;
	}


	@Override
	public List<Manager> getNormalManager(PageVO page, Object... values){
		String hql = "from Manager where isRoot != 'Y' ";
		//若为条件查询，构造查询数据
        Map<String, Object> paramMap = new HashMap<>();
		//模型参数构造
		List<Manager> managerlist;
		if(page != null){
            managerlist = findPage(hql,page,paramMap);
		}else{
            managerlist = find(hql,paramMap);
		}
        if(Optional.ofNullable(managerlist).isPresent()){
            managerlist.forEach(CommonObjectUtil::convert);
        }
		return managerlist;
	}


	@Override
	public Manager getObjByObj(String param, Object value) {
		StringBuilder hql = new StringBuilder("from Manager where 1 = 1 ");
		//构造查询数据
        Map<String, Object> paramMap = new HashMap<>();
		if("account".equals(param)){
            hql.append(" and account = :account ");
            paramMap.put("account", value);
		}else if("statu".equals(param)){
            hql.append(" and statu = :statu ");
            paramMap.put("statu", value);
		}
		List<Manager> list = find(hql.toString(),paramMap);
		return list!=null&&list.size()>0?list.get(0):null;
	}

}