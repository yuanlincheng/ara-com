/*
 * 文件名：${ManagerService}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.21}
 * 修改：
 * 描述：管理员  Service接口层
 *
 *
 * 版权：亚略特
 */
package com.services;


import com.model.Manager;

public interface ManagerService extends CommonService<Manager> {
	/**
	 * 校验管理员是否存在
	 * @param name,password（管理员账户和密码））
	 * @return boolean
	 */
	boolean checkLogin(String name, String password);

}