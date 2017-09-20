/*
 * 文件名：${CodeServiceImpl}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.27}
 * 修改：
 * 描述：字典  Service实现层
 *
 *
 * 版权：亚略特
 */
package com.services.impl;

import com.dao.CodeDao;
import com.exception.ServiceException;
import com.model.Code;
import com.vo.PageVO;
import com.services.CodeService;
import com.time.TimeUtil;
import com.util.CommonObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("codeService")
public class CodeServiceImpl  implements CodeService {

	@Autowired
	private CodeDao codeDao;

	@Override
	public void saveObj(Code obj, String operator, Object... values)
			throws ServiceException {
		//判别添加的字典是否已存在   0 标示增加
		if(!codeDao.checkExist("",obj.getCode(),obj.getType())){
			obj.setCreateOn(TimeUtil.getFormatDate());

			//保存字典对象
			codeDao.save(obj);
		}else{
			throw new ServiceException("此字典编码已经存在!");
		}
	}

	@Override
	public void updateObj(Code obj, String operator, Object id, Object... values)
			throws ServiceException {
		//判别添加的字典编号是否已存在
		if(!codeDao.checkExist(obj.getCode(),id)){
			obj.setId((String)id);
			Code codeTemp = codeDao.findById((String)id);
			//code持久对象构造
			if(null != codeTemp){
				CommonObjectUtil.Copy(codeTemp, obj);
			}

			//保存字典对象
			codeDao.merge(obj);
		}else{
			throw new ServiceException("此字典编码已经存在!");
		}
	}

	@Override
	public void delObj(Object id, Object... values) throws ServiceException {
		Code codeTemp = getObj(id);
		if(null != codeTemp){
			codeDao.delete(codeTemp);
		}
	}

	@Override
	public List<Code> getObjListPage(PageVO page, int queryType, Object... values) {
		return codeDao.getCodePage(page, values);
	}

	@Override
	public List<Code> getObjList(Object... values) {
		return codeDao.getCodePage(null, values);
	}

	@Override
	public Code getObj(Object id) {
		return codeDao.findById((String)id);
	}

	@Override
	public List<Code> getAllCodeByType(int type) {
		return codeDao.getAllCodeByType(type);
	}

	@Override
	public Code getNextCodeType() {
		Code code = new Code();
		List<Code> codelist = codeDao.getAllBaseCode();
		if(null != codelist && codelist.size() > 0){
			int max = -1;
			for(Code codeTemp : codelist){
				if(codeTemp.getType() > max){
					max = codeTemp.getType();
				}
			}
			code.setType(max + 1);
		}else{
			code.setType(1);
		}
		return code;
	}

	@Override
	public List<Code> getAllBaseCode() {
		return codeDao.getAllBaseCode();
	}

	@Override
	public Code getBaseCodeType(int type) {
		return codeDao.getBaseCodeType(type);
	}


	@Override
	public Code getObjByObj(String param, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
}