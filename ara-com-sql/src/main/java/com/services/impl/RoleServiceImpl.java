/*
 * 文件名：${RoleServiceImpl}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.21}
 * 修改：
 * 描述：角色  Service实现层
 *
 *
 * 版权：亚略特
 */
package com.services.impl;

import com.dao.ManagerDao;
import com.dao.RoleDao;
import com.exception.ServiceException;
import com.model.Role;
import com.vo.PageVO;
import com.services.RoleService;
import com.util.CommonObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
    @Autowired
	private ManagerDao managerDao;


	@Override
	public void saveObj(Role obj, String operator, Object... values) throws ServiceException {
		//判别添加的角色是否已存在   0 标示增加
		if(!roleDao.checkExist(obj.getName(),"")){
			obj.setIsRoot("N");
			//保存角色对象
			roleDao.save(obj);
		}else{
			throw new ServiceException("此角色名已存在!");
		}
	}

	@Override
	public void updateObj(Role obj, String operator, Object id, Object... values) throws ServiceException {
		//判别修改的角色是否已存在
		if(!roleDao.checkExist(obj.getName(),id)){
			obj.setId((String)id);

			Role roleTemp = roleDao.findById((String)id);
			//role持久对象构造
			if(null != roleTemp){
				CommonObjectUtil.Copy(roleTemp, obj);
			}

			//保存角色对象
			roleDao.merge(obj);
		}else{
			throw new ServiceException("此角色名已存在!");
		}
	}

	@Override
	public List<Role> getObjListPage(PageVO page, int queryType, Object... values) {
		return roleDao.getRole(page, values);
	}

	@Override
	public List<Role> getObjList(Object... values) {
		return roleDao.getRole(null, values);
	}


	@Override
	public Role getObj(Object id) {
		return roleDao.findById((String)id);
	}


	@Override
	public void delObj(Object id, Object... values) throws ServiceException {
        if(!managerDao.checkRoleExist((String)id)){
            Role roleTemp = getObj(id);
            if(null != roleTemp){
                roleDao.delete(roleTemp);
            }
        }else{
            throw new ServiceException("该角色下有管理员存在，无法删除!");
        }
	}

	@Override
	public Role getObjByObj(String param, Object value) {
		return null;
	}
}