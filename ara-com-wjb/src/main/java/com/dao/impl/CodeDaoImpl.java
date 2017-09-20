/*
 * 文件名：${CodeDaoImpl}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.7.8}
 * 修改：
 * 描述：系统字典  Dao实现层
 *
 *
 * 版权：亚略特
 */
package com.dao.impl;

import com.dao.CodeDao;
import com.model.Code;
import com.vo.PageVO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("codeDao")
public class CodeDaoImpl extends BaseDaoImpl<Code> implements CodeDao {

	public boolean checkExist(String obj, int id) {
		StringBuffer hql = new StringBuffer("from Code where code = :code ");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("code", obj);
		if(0 != id){
            hql.append(" and id != :id ");
            paramMap.put("id", id);
		}
		List<Code> list = find(hql.toString(), paramMap);
        if(list != null && list.size() > 0){
            return true;
        }else{
            return false;
        }
	}

	@Override
	public boolean checkExist(int id, Object... values) {
        StringBuffer hql = new StringBuffer("from Code where code = :code and type = :type");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("code", values[0]);
        paramMap.put("type", values[1]);
		if(0 != id){
            hql.append(" and id != :id ");
            paramMap.put("id", id);
		}
		List<Code> list = find(hql.toString(), paramMap);
        if(list != null && list.size() > 0){
            return true;
        }else{
            return false;
        }
	}

	@Override
	public List<Code> getCodePage(PageVO page, Object... values) {
        StringBuffer hql = new StringBuffer("from Code where 1 = 1 ");
		List<Code> codelist = new ArrayList<Code>();
        //若为条件查询，构造查询数据
        Map<String, Object> paramMap = new HashMap<>();
		if (values != null && values.length > 0 && values[0] instanceof String[]) {
			String[] arrTemp = (String[])values[0];
			for(String str : arrTemp){
				if("code".equals(str)){
                    hql.append(" and code = :code ");
                    paramMap.put("code", values[1]);
                }else if("type".equals(str)){
                    hql.append(" and type = :type ");
                    paramMap.put("type", values[2]);
                }
			}
            hql.append(" and isbase = :isbase ");
            if(Boolean.parseBoolean(values[3].toString())){
                paramMap.put("isbase", "Y");
            }else{
                paramMap.put("isbase", "N");
            }
		}else{
            hql.append(" and isbase = :isbase ");
            if(Boolean.parseBoolean(values[0].toString())){
                paramMap.put("isbase", "Y");
            }else{
                paramMap.put("isbase", "N");
            }
		}

		//模型参数构造
		List<Code> codeListTemp = null;
		if(page != null){
			codeListTemp = findPage(hql.toString(),page,paramMap);
		}else{
			codeListTemp = find(hql.toString(),paramMap);
		}
		if(null != codeListTemp && codeListTemp.size() > 0){
			for(Code codeTemp : codeListTemp){
				try {
					codelist.add(Code.convert(codeTemp));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return codelist;
	}


	@Override
	public List<Code> getAllCodeByType(int type) {
		StringBuffer hql = new StringBuffer("from Code where type = ?  and isbase = 'N' and statu = 'Active' ");
		List<Code> codelist = new ArrayList<Code>();
        //模型参数构造
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("type", type);
        List<Code> codeListTemp = find(hql.toString(),paramMap);
		if(null != codeListTemp && codeListTemp.size() > 0){
			for(Code codeTemp : codeListTemp){
				try {
					codelist.add(Code.convert(codeTemp));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return codelist;
	}


	@Override
	public List<Code> getAllBaseCode() {
		StringBuffer hql = new StringBuffer("from Code where isbase = 'Y' ");
		List<Code> codelist = new ArrayList<Code>();
		//模型参数构造
		List<Code> codeListTemp = find(hql.toString(),null);
		if(null != codeListTemp && codeListTemp.size() > 0){
			for(Code codeTemp : codeListTemp){
				try {
					codelist.add(Code.convert(codeTemp));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return codelist;
	}


	@Override
	public Code getBaseCodeType(int type) {
        StringBuffer hql = new StringBuffer("from Code where type = :type and isbase = 'Y'");
        //模型参数构造
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("type", type);
		List<Code> codeListTemp = find(hql.toString(),paramMap);
		return codeListTemp!=null&&codeListTemp.size()>0?codeListTemp.get(0):null;
	}

}