/*
 * 文件名：${RoleDaoImpl}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.21}
 * 修改：
 * 描述：角色  Dao实现层
 *
 *
 * 版权：亚略特
 */
package com.dao.impl;

import com.dao.RoleDao;
import com.model.Role;
import com.vo.PageVO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public boolean checkExist(String obj, int id) {
        StringBuffer hql = new StringBuffer("from Role where name = :name ");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", obj);
		if(0 != id){
            hql.append(" and id != :id ");
            paramMap.put("id", id);
		}
        List<Role> list = find(hql.toString(), paramMap);
        if(list != null && list.size() > 0){
            return true;
        }else{
            return false;
        }
	}



	@Override
	public List<Role> getRole(PageVO page, Object... values){
		StringBuffer hql = new StringBuffer("from Role where isRoot != 'Y' ");
		List<Role> rolelist = new ArrayList<Role>();

        //若为条件查询，构造查询数据
        Map<String, Object> paramMap = new HashMap<>();
        if (values != null && values.length > 0 && values[0] instanceof String[]) {

        }

        //模型参数构造
        List<Role> roleListTemp = null;
        if(page != null){
            roleListTemp = findPage(hql.toString(),page,paramMap);
        }else{
            roleListTemp = find(hql.toString(),paramMap);
        }
        if(null != roleListTemp && roleListTemp.size() > 0){
            for(Role roleTemp : roleListTemp){
                try {
                    rolelist.add(roleTemp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return rolelist;
	}



	@Override
	public boolean checkExist(int id, Object... values) {
		// TODO Auto-generated method stub
		return false;
	}

}