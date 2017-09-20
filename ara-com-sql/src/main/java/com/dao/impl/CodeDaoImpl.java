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
import com.util.CommonObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository("codeDao")
public class CodeDaoImpl extends BaseDaoImpl<Code> implements CodeDao {

	@Override
	public boolean checkExist(String obj, Object id) {
		StringBuilder hql = new StringBuilder("from Code where code = :code ");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("code", obj);
        if(StringUtils.isNotBlank((String)id)){
			hql.append(" and id != :id ");
            paramMap.put("id", id);
		}
		List<Code> list = find(hql.toString(), paramMap);
        return list != null && list.size() > 0;
	}

	@Override
	public boolean checkExist(Object id, Object... values) {
		StringBuilder hql = new StringBuilder("from Code where code = :code and type = :type");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("code", values[0]);
        paramMap.put("type", values[1]);
		if(StringUtils.isNotBlank((String)id)){
            hql.append(" and id != :id ");
            paramMap.put("id", id);
		}
        List<Code> list = find(hql.toString(), paramMap);
        return list != null && list.size() > 0;
	}

	@Override
	public List<Code> getCodePage(PageVO page, Object... values) {
		StringBuilder hql = new StringBuilder("from Code where 1 = 1 ");
		//若为条件查询，构造查询数据
        Map<String, Object> paramMap = new HashMap<>();
		if (Optional.ofNullable(values).isPresent() && values.length > 0 && Optional.ofNullable(values[0]).isPresent() && values[0] instanceof String[]) {
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
		List<Code> codelist;
		if(page != null){            //判别是否需要分页查询
            codelist = findPage(hql.toString(),page,paramMap);
		}else{
            codelist = find(hql.toString(),paramMap);
		}
        if(Optional.ofNullable(codelist).isPresent()){
            codelist.forEach(CommonObjectUtil::convert);
        }
		return codelist;
	}


	@Override
	public List<Code> getAllCodeByType(int type) {
		String hql = "from Code where type = ?0  and isbase = 'N' and statu = 'Active' ";
        //模型参数构造
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("type", type);
		List<Code> codelist = find(hql,paramMap);
        if(Optional.ofNullable(codelist).isPresent()){
            codelist.forEach(CommonObjectUtil::convert);
        }
		return codelist;
	}


	@Override
	public List<Code> getAllBaseCode() {
		String hql = "from Code where isbase = 'Y' ";
		//模型参数构造
		List<Code> codelist = find(hql,null);
        if(Optional.ofNullable(codelist).isPresent()){
            codelist.forEach(CommonObjectUtil::convert);
        }
		return codelist;
	}


	@Override
	public Code getBaseCodeType(int type) {
		String hql = "from Code where type = :type and isbase = 'Y'";
		//模型参数构造
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("type", type);
		List<Code> codeListTemp = find(hql,paramMap);
		return codeListTemp!=null&&codeListTemp.size()>0?codeListTemp.get(0):null;
	}


}