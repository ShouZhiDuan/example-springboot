package com.example.dsz.mybatis_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/26 13:57
 * @Description:
 */
@Slf4j
@Intercepts(value = {
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class StatementHandlerInterceptor implements Interceptor {

    /**
     * 拦截改写SQL
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("StatementHandlerInterceptor");
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        String newSQL = sql;//可以基于这行改写原有的sql
        Field field = boundSql.getClass().getDeclaredField("sql");
        field.setAccessible(true);
        field.set(boundSql, newSQL);//设置当前实例boundSql的sql属性字段值为newSQL
        log.info("增强后的SQL：{}", newSQL);
        return invocation.proceed();
    }

    /**
     * 通过反射，拦截方法上带有自定义@InterceptAnnotation注解的方法，并增强sql
     *
     * @param id             方法全路径
     * @param sqlCommandType sql类型
     * @param sql            所执行的sql语句
     */
    private String sqlAnnotationEnhance(String id, String sqlCommandType, String sql) throws ClassNotFoundException {
        // 通过类全路径获取Class对象
        Class<?> classType = Class.forName(id.substring(0, id.lastIndexOf(".")));
        // 获取当前所拦截的方法名称
        String mName = id.substring(id.lastIndexOf(".") + 1);
        // 遍历类中所有方法名称，并if匹配上当前所拦截的方法
        for (Method method : classType.getDeclaredMethods()) {
            if (mName.equals(method.getName())) {
                // 判断方法上是否带有自定义@InterceptAnnotation注解
//                InterceptAnnotation interceptorAnnotation = method.getAnnotation(InterceptAnnotation.class);
//                if (interceptorAnnotation.flag()) {
//                    if ("SELECT".equals(sqlCommandType)) {
//                        // 增强sql
//                        return sql + " limit 2";
//                        // select * from scenario_storage limit 2
//                    }
//                }
            }
        }
        return sql;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
