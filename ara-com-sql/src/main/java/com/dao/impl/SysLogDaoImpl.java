/*
 * 文件名：${LogDaoImpl}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.27}
 * 修改：
 * 描述：日志  Dao实现层
 *
 *
 * 版权：亚略特
 */
package com.dao.impl;

import com.dao.SysLogDao;
import com.model.SysLogInfo;
import com.vo.PageVO;
import com.param.ConfigParam;
import com.util.CommonObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.*;

@Repository("logDao")
public class SysLogDaoImpl extends BaseDaoImpl<SysLogInfo> implements SysLogDao {

	@Override
	public List<SysLogInfo> getLogPage(PageVO page, int queryType, Object... values) {
		StringBuilder hql = new StringBuilder(" from SysLogInfo ");
		//若为条件查询，构造查询数据
        Map<String, Object> paramMap = new HashMap<>();
        if (values != null && values.length > 0) {
            hql.append(" where  ");
            switch (queryType) {
                //全字段模糊查询
                case ConfigParam.QUERY_TYPE_ALL:
                    hql.append(" 1 = 2  ");
                    String itemName = (String)values[1];
                    //判断是否筛选策略是全局还是指定
                    if(StringUtils.isNotBlank(itemName)){
                        hql.append(" or ").append(itemName).append(" like :").append(itemName).append(" ");
                        if(StringUtils.isNotBlank((String)values[0])){
                            paramMap.put(itemName, "%"+values[0]+"%");
                        }else {
                            paramMap.put(itemName, values[0]);
                        }
                    }else{
                        Field[] fields = SysLogInfo.class.getDeclaredFields();
                        //利用java的反射机制，轮询元素
                        List likeStrings = Arrays.asList("type", "content", "createOn");
                        Arrays.asList(fields).stream().filter(filed -> likeStrings.contains(filed.getName())).forEach(name -> {
                            hql.append(" or ").append(name.getName()).append(" like :").append(name.getName()).append(" ");
                            if(StringUtils.isNotBlank((String)values[0])){
                                paramMap.put(name.getName(), "%"+values[0]+"%");
                            }else {
                                paramMap.put(itemName, values[0]);
                            }
                        });
                    }
                    break;
                //分条件精确查询
                case ConfigParam.QUERY_TYPE_SOME:
                    // TODO: 2017/5/24 后续增加
                    hql.append(" 1 = 1  ");
                    break;
            }
        }

		//设置排序规则   降序
		hql.append(" order by createOn desc");

		//模型参数构造
		List<SysLogInfo> loglist;
		if(page != null){
            loglist = findPage(hql.toString(),page,paramMap);
		}else{
            loglist = find(hql.toString(),paramMap);
		}
        if(Optional.ofNullable(loglist).isPresent()){
            loglist.forEach(CommonObjectUtil::convert);
        }
		return loglist;
	}

	@Override
	public void truncateTable(String tableName) {
		String sql = "delete from "+tableName;
		SQLQuery d = getCurrentSession().createSQLQuery(sql);
		d.executeUpdate();
	}

	@Override
	public String getTimeArea() {
		String hql="SELECT MIN(createOn),MAX(createOn) FROM LogInfo";
		List<?> list=find(hql,null);
		if(null != list && list.size() == 1){
			Object[] log=(Object[]) list.get(0);
			if(null != log[0]){
				return log[0].toString().substring(0, 10) + "~" + log[1].toString().substring(0, 10);
			}else{
				return "无数据";
			}
		}else{
			return "无数据";
		}
	}

	@Override
	public String getTableSize(String tablename) {
		DecimalFormat df = new DecimalFormat("0.00");
		String sql="SELECT (data_length+INDEX_LENGTH) FROM information_schema.TABLES WHERE TABLE_NAME ='"+tablename+"'";
		SQLQuery d = getCurrentSession().createSQLQuery(sql);
		List<?> list = d.list();
		if(list!=null&&list.size()>0){
			return df.format(Double.parseDouble(list.get(0).toString())/1024/1024) + "MB";
		}else{
			return "0MB";
		}
	}
}