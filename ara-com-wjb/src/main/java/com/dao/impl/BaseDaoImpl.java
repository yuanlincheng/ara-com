/**
 * @author: tree
 * @version: 1.0
 * date: 2017/8/23 14:07
 * @description:
 * own: Aratek
 */
package com.dao.impl;

import com.dao.BaseDao;
import com.vo.PageVO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Repository("baseDao")
@Transactional(rollbackFor=Exception.class)
public class BaseDaoImpl<T>  implements BaseDao<T> {

    private Class<T> entityClass;

    public BaseDaoImpl() {
        entityClass = GenericsUtils.getSuperClassGenricType(getClass());
    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void delete(T t) {
        getCurrentSession().delete(t);
    }

    public void update(T t) {
        getCurrentSession().update(t);
    }

    @Override
    public void updateMulti(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            update(list.get(i));
            if(i%50==0) {
                getCurrentSession().flush();
                getCurrentSession().clear();
            }
        }
    }

    public void merge(T t) {
        getCurrentSession().merge(t);
    }

    @Override
    public List<T> find(String hql, Map<String,Object> params) {
        Query query = getCurrentSession().createQuery(hql);
        setQueryParams(query, params);
        return query.list();
    }

    @Override
    public T findOne(String hql, Map<String,Object> params) {
        Query query = getCurrentSession().createQuery(hql);
        setQueryParams(query, params);
        return (T) query.uniqueResult();
    }

    @Override
    public T findTopOne(String hql, Map<String,Object> params) {
        Query query = getCurrentSession().createQuery(hql);
        setQueryParams(query,params);
        return (T) query.setFirstResult(0).setMaxResults(1).uniqueResult();
    }

    @Override
    public List<T> findPage(String hql, PageVO page, Map<String,Object> params) {
        Query query = getCurrentSession().createQuery(hql);
        setQueryParams(query,params);
        page.setTotalResult(count(hql,params));
        return query.setFirstResult(page.getStart()).setMaxResults(page.getPageSize()).list();
    }

    @Override
    public List<T> findAll() {
        String hql = "from " + entityClass.getSimpleName();
        return find(hql,null);
    }

    public T findById(Serializable id) {
        return getCurrentSession().get(entityClass, id);
    }

    @Override
    public T queryOneNewSession(String hql, Map<String,Object> params) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        setQueryParams(query,params);
        T t = (T) query.setFirstResult(0).setMaxResults(1).uniqueResult();
        session.flush();
        session.close();
        return t;
    }

    public void save(T t) {
        getCurrentSession().save(t);
    }

    @Override
    public void saveMulti(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            save(list.get(i));
            if(i%50==0) {
                getCurrentSession().flush();
                getCurrentSession().clear();
            }
        }
    }

    protected List<T> findListBySql(String sql, Object... params) {
        Query query = getCurrentSession().createSQLQuery(sql);
        setQueryParams(query, params);
        return query.list();
    }

    @Override
    public long count(T t) {
        return findAll().size();
    }

    @Override
    public long count(String fromHql, Map<String, Object> params) {
        String hql = " SELECT COUNT(1) " + fromHql;
        Query query = getCurrentSession().createQuery(hql);
        setQueryParams(query,params);
        return (long)query.list().get(0);
    }

    public long count(Query query) {
        return query.list().size();
    }

    private void setQueryParams(Query query,Map<String,Object> params) {
        if (null == params || params.size() < 1) {
            return;
        }
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
    }

    private void setQueryParams(Query query, Object[] params) {
        if (null == params) {
            return;
        }
        for (int i = 0; i < params.length; i++) {
            query.setParameter(""+i, params[i]);
        }
    }
}

class GenericsUtils {
	private GenericsUtils() {
	}

	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	public static Class getSuperClassGenricType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

}