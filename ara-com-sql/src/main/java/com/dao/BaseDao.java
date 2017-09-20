/*
 * 文件名：${BaseDao}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.12}
 * 修改：
 * 描述：dao 基础层
 *
 *
 * 版权：亚略特
 */
package com.dao;

import com.vo.PageVO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T>{

    /**
     * 保存对象
     * @param t（对象）
     * @return
     */
    void save(T t);

    /**
     * 批量保存对象
     * @param list（对象列表）
     * @return
     */
    void saveMulti(List<T> list);

    /**
     * 批量保存对象
     * @param t（列表）
     * @return
     */
    void delete(T t);

    /**
     * 更新对象
     * @param t（对象）
     * @return
     */
    void update(T t);

    /**
     * 批量更新对象
     * @param list（对象列表）
     * @return
     */
    void updateMulti(List<T> list);

    /**
     * 修改对象
     * @param t（对象）
     * @return
     */
    void merge(T t);

    /**
     * 计数对象
     * @param t（对象）
     * @return
     */
    long count(T t);

    /**
     * 计数对象
     * @param fromHql（From开头的查询语句）
     * @param params（参数）
     * @return
     */
    long count(String fromHql, Map<String, Object> params);

    /**
     * 查询对象列表
     * @param hql（查询语句）
     * @param params（参数）
     * @return
     */
    List<T> find(String hql, Map<String, Object> params);

    /**
     * 查询制定对象
     * @param hql（查询语句）
     * @param params（参数）
     * @return
     */
    T findOne(String hql, Map<String, Object> params);

    /**
     * 查询列表中第一个对象
     * @param hql（查询语句）
     * @param params（参数）
     * @return
     */
    public T findTopOne(String hql, Map<String, Object> params);

    /**
     * 分页查询对象数据
     * @param hql（查询语句）
     * @param page（分页对象）
     * @param params（参数）
     * @return
     */
    List<T> findPage(String hql, PageVO page, Map<String, Object> params);


    /**
     * 查询对象所有数据
     * @return
     */
    List<T> findAll();

    /**
     * 根据ID查询对象数据
     * @param id（对象ID）
     * @return
     */
    T findById(Serializable id);

    T queryOneNewSession(String hql, Map<String, Object> params);
}