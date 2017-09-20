/*
 * 文件名：${ManagerServiceImpl}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.21}
 * 修改：
 * 描述：管理员  Service实现层
 *
 *
 * 版权：亚略特
 */
package com.services.impl;

import com.dao.ManagerDao;
import com.exception.ServiceException;
import com.jce.KeyTools;
import com.model.Manager;
import com.vo.PageVO;
import com.services.ManagerService;
import com.time.TimeUtil;
import com.util.CommonObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;

	@Override
	public boolean checkLogin(String name, String password) {
		return managerDao.checkLogin(name, password);
	}


	@Override
	public void saveObj(Manager obj, String operator, Object... values) throws ServiceException {
		//判别添加的管理员账号是否已存在   0 标示增加
		if(!managerDao.checkExist(obj.getAccount(),0)){
			obj.setPassword(KeyTools.GetPasswordMD5(obj.getPassword()));
			obj.setIsRoot("N");
			obj.setCreateOn(TimeUtil.getFormatDate());
			obj.setCreateBy(operator);
			obj.setModifiedBy(operator);
			obj.setModifiedOn(TimeUtil.getFormatDate());

			//保存管理员对象
			managerDao.save(obj);
		}else{
			throw new ServiceException("此管理员账号已经存在!");
		}
	}

	@Override
	public void updateObj(Manager obj, String operator, int id, Object... values) throws ServiceException {
		//判别修改的管理员账号是否已存在
		if(!managerDao.checkExist(obj.getAccount(),id)){
			obj.setId(id);
			obj.setModifiedBy(operator);
			obj.setModifiedOn(TimeUtil.getFormatDate());

			Manager managerTemp = managerDao.findById(id);
			//manager持久对象构造
			if(null != managerTemp){
				CommonObjectUtil.Copy(managerTemp, obj);
			}

			//保存管理员对象
			managerDao.merge(obj);
		}else{
			throw new ServiceException("此管理员账号已经存在!");
		}
	}

	@Override
	public List<Manager> getObjListPage(PageVO page, Object... values) {
		return managerDao.getNormalManager(page, values);
	}

	@Override
	public List<Manager> getObjList(Object... values) {
		//不需要分页，所以设置Page 为null
		return managerDao.getNormalManager(null, values);
	}


	@Override
	public Manager getObj(int id) {
		return managerDao.findById(id);
	}


	@Override
	public void delObj(int id, Object... values) {
		Manager managerTemp = getObj(id);
		if(null != managerTemp){
			managerDao.delete(managerTemp);
		}
	}


	@Override
	public Manager getObjByObj(String param, Object value) {
		return managerDao.getObjByObj(param, value);
	}

}