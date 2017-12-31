package com.github.lit.jdbc;

import com.github.lit.jdbc.statement.Delete;
import com.github.lit.jdbc.statement.Insert;
import com.github.lit.jdbc.statement.Select;
import com.github.lit.jdbc.statement.Update;

import java.io.Serializable;

/**
 * User : liulu
 * Date : 2017/6/4 11:13
 * version $Id: JdbcTools.java, v 0.1 Exp $
 */
public interface JdbcTools {

    /**
     * 插入一条记录, 返回这条记录的id
     *
     * @param t   实体对象
     * @param <T> 实体对象类型
     * @return 主键, 自增和序列返回 Long 类型
     */
    <T> Object insert(T t);

    /**
     * 根据实体的 id 删除一条记录
     *
     * @param t   实体对象
     * @param <T> 实体对象类型
     * @return 受影响记录数
     */
    <T> int delete(T t);

    /**
     * 根据 id 删除对应的记录
     *
     * @param clazz 实体对象class
     * @param ids   主键数组
     * @param <T>   实体对象类型
     * @return 受影响记录数
     */
    <T> int deleteByIds(Class<T> clazz, Serializable... ids);

    /**
     * 根据实体 Id 更新一条纪律
     *
     * @param t   实体对象
     * @param <T> 实体对象类型
     * @return 受影响记录数
     */
    <T> int update(T t);

    /**
     * 根据实体 Id 更新一条记录
     *
     * @param t            实体
     * @param isIgnoreNull 是否忽略 null 值
     * @param <T>          实体对象类型
     * @return 受影响记录数
     */
    <T> int update(T t, boolean isIgnoreNull);

    /**
     * 根据 Id 查询一条记录
     *
     * @param clazz 实体对象class
     * @param id    主键
     * @param <T>   实体对象类型
     * @return 实体对象
     */
    <T> T get(Class<T> clazz, Serializable id);

    /**
     * 根据某一属性查询一条记录
     *
     * @param clazz         实体对象class
     * @param propertyName  属性名
     * @param propertyValue 属性值
     * @param <T>           实体对象类型
     * @return 实体对象
     */
    <T> T findByProperty(Class<T> clazz, String propertyName, Object propertyValue);

    /**
     * 根据查询对象查询总数
     *
     * @param clazz 实体对象class
     * @param qo    查询对象
     * @param <T>   实体对象类型
     * @param <Qo>  查询对象类型
     * @return 总记录数
     */
    <T, Qo> int count(Class<T> clazz, Qo qo);


    Insert createInsert(Class<?> clazz);

    Delete createDelete(Class<?> clazz);

    Update createUpdate(Class<?> clazz);

    <T> Select<T> createSelect(Class<T> clazz);
}