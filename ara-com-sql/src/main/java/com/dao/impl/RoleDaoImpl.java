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
import com.util.CommonObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public boolean checkExist(String obj, Object id) {
		StringBuilder hql = new StringBuilder("from Role where name = :name ");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", obj);
		if(StringUtils.isNotBlank((String)id)){
			hql.append(" and id != :id ");
            paramMap.put("id", id);
		}
		List<Role> list = find(hql.toString(), paramMap);
        return list != null && list.size() > 0;
	}



	@Override
	public List<Role> getRole(PageVO page, Object... values){
		StringBuilder hql = new StringBuilder("from Role where isRoot != 'Y' ");
		//若为条件查询，构造查询数据
        Map<String, Object> paramMap = new HashMap<>();
		//模型参数构造
		List<Role> rolelist;
		if(page != null){
            rolelist = findPage(hql.toString(),page,paramMap);
		}else{
            rolelist = find(hql.toString(),paramMap);
		}
        if(Optional.ofNullable(rolelist).isPresent()){
            rolelist.forEach(CommonObjectUtil::convert);
        }
		return rolelist;
	}



	@Override
	public boolean checkExist(Object id, Object... values) {
		// TODO Auto-generated method stub
		return false;
	}

}