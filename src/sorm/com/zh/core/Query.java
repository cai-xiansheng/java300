package sorm.com.zh.core;

import java.util.List;

/**
 * @author cai-xiansheng
 * @Description 负责对外提供服务的核心类
 * @create 2020-08-10 9:23
 */
@SuppressWarnings("all")
public interface Query {

    /**
     * 执行一个DML语句
     *
     * @param sql    sql语句
     * @param params 参数
     * @return
     */
    public int executeDML(String sql, Object[] params);


    /**
     * 将一个对象存储到数据库中
     *
     * @param object 要存储的对象
     */
    public void insert(Object object);

    /**
     * 删除clazz表示类对应的表中的记录（指定主键值id的记录）
     *
     * @param clazz 跟表对应的类的Class对象
     * @param id    主键的值
     * @return
     * @instance delete from User where id = 2;
     */
    public int delete(Class clazz, int id);


    /**
     * 删除对象在数据库中对应的记录（对象所在的类对应到表，对象的主键的值对应到记录）
     *
     * @param object
     */
    public void delete(Object object);


    /**
     * 更新对象对应的记录，并且只更新指定的字段的值
     *
     * @param object     索要更新的对象
     * @param fieldNames 更新的属性列表
     * @return 执行sql语句后影响记录的行数
     */
    public int update(Object object, String[] fieldNames);


    /**
     * 查询返回多行记录，并将每行记录封装到clazz指定类的对象中
     *
     * @param sql    查询语句
     * @param clazz  封装数据的javabean类的Class对象
     * @param params sql的参数
     * @return 查询到的结果
     */
    public List queryRows(String sql, Class clazz, Object[] params);

    /**
     * 查询返回一行记录，并将每行记录封装到clazz指定类的对象中
     *
     * @param sql    查询语句
     * @param clazz  封装数据的javabean类的Class对象
     * @param params sql的参数
     * @return 查询到的结果
     */
    public Object queryUniqueRow(String sql, Class clazz, Object[] params);

    /**
     * 查询返回一个值（一行一列），并将该值返回
     *
     * @param sql    查询语句
     * @param params sql的参数
     * @return 查询到的结果
     */
    public Object queryValue(String sql, Object[] params);


    /**
     * 查询返回一个值（一行一列），并将该值返回
     *
     * @param sql    查询语句
     * @param params sql的参数
     * @return 查询到的数字
     */
    public Number queryNumber(String sql, Object[] params);

}
