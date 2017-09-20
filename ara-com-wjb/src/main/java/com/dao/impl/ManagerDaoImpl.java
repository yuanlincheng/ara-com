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
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("managerDao")
public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao {

	@Override
	public boolean checkExist(String obj, int id) {
        StringBuffer hql = new StringBuffer("from Manager where account = :account ");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account", obj);
		if(0 != id){
            hql.append(" and id != :id ");
            paramMap.put("id", id);
		}
		List<Manager> list = find(hql.toString(), paramMap);
        if(list != null && list.size() > 0){
            return true;
        }else{
            return false;
        }
	}

	@Override
	public boolean checkRoleExist(int roleId) {
        StringBuffer hql = new StringBuffer("from Manager where role.id = :roleId ");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("roleId", roleId);
		List<Manager> list = find(hql.toString(), paramMap);
        if(list != null && list.size() > 0){
            return true;
        }else{
            return false;
        }
	}

	@Override
	public boolean checkExist(int id, Object... values) {
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
		if(list != null){
			Iterator<Manager> i = list.iterator();
			while(i.hasNext()){
				//更新最近登录时间
				Manager managerTemp = i.next();
				managerTemp.setLastLogin(TimeUtil.getFormatDate());
				save(managerTemp);
				return true;
			}
		}
		return false;
	}


	@Override
	public List<Manager> getNormalManager(PageVO page, Object... values){
		StringBuffer hql = new StringBuffer("from Manager where isRoot != 'Y' ");
		List<Manager> managerlist = new ArrayList<Manager>();

        //若为条件查询，构造查询数据
        Map<String, Object> paramMap = new HashMap<>();
        if (values != null && values.length > 0 && values[0] instanceof String[]) {

        }
		//模型参数构造
		List<Manager> managerListTemp = null;
		if(page != null){
			managerListTemp = findPage(hql.toString(),page,paramMap);
		}else{
			managerListTemp = find(hql.toString(),paramMap);
		}
		if(null != managerListTemp && managerListTemp.size() > 0){
			for(Manager managerTemp : managerListTemp){
				try {
					managerlist.add(Manager.convert(managerTemp));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return managerlist;
	}


	@Override
	public Manager getObjByObj(String param, Object value) {
		StringBuffer hql = new StringBuffer("from Manager where 1 = 1 ");

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