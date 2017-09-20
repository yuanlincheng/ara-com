/*
 * 文件名：${RoleDao}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.21}
 * 修改：
 * 描述：角色    dao层
 *
 *
 * 版权：亚略特
 */
package com.dao;

import com.model.Role;
import com.vo.PageVO;

import java.util.List;


public interface RoleDao extends BaseDao<Role>,CommonDao<Role> {

	/**
	 * 分页获取角色
	 * @param page（分页对象）
	 * @param values（查询条件）
	 * @return 角色list
	 */
	List<Role> getRole(PageVO page, Object... values);

}