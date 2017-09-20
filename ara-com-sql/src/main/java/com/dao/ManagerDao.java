/*
 * 文件名：${ManagerDao}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.21}
 * 修改：
 * 描述：管理员 dao层
 *
 *
 * 版权：亚略特
 */
package com.dao;

import com.model.Manager;
import com.vo.PageVO;

import java.util.List;


public interface ManagerDao extends BaseDao<Manager>,CommonDao<Manager> {
	/**
	 * 校验管理员是否存在
	 * @param name,password（管理员账户和密码）
	 * @return boolean
	 */
	 boolean checkLogin(String name, String password);

    /**
	 * 校验是否有属于此角色的管理员存在
	 * @param roleId（角色标识）
	 * @return boolean
	 */
	 boolean checkRoleExist(String roleId);

	/**
	 * 分页获取普通用户
	 * @param page（分页对象）
	 * @param values（查询条件）
	 * @return 管理员list
	 */
	List<Manager> getNormalManager(PageVO page, Object... values);


	/**
	 * 根据属性以及属性值获取对象
	 * @param param  属性名
	 * @param value  属性值
	 * @return 对象
	 */
	Manager getObjByObj(String param, Object value);
}