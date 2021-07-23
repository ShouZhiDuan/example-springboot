package com.example.dsz.mybatis_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/26 15:22
 * @Description:
 */
@Slf4j
@Intercepts(value = {
        @Signature(type = ParameterHandler.class, method = "getParameterObject", args = {}),
        @Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class})
})
public class ParameterHandlerInterceptor implements Interceptor {

    private final String PARAM_KEY = "name";

    /**
     * SQL执行参数处理
     * to see https://blog.csdn.net/yangbo787827967/article/details/81562476
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("ParameterHandlerInterceptor");
        ParameterHandler parameterHandler = (ParameterHandler) invocation.getTarget();
        PreparedStatement ps = (PreparedStatement) invocation.getArgs()[0];
        // 反射获取 BoundSql 对象，此对象包含生成的sql和sql的参数map映射
        Field boundSqlField = parameterHandler.getClass().getDeclaredField("boundSql");
        boundSqlField.setAccessible(true);
        BoundSql boundSql = (BoundSql) boundSqlField.get(parameterHandler);
        List<String> paramNames = new ArrayList<>();
        // 若参数映射没有包含的key直接返回
        boolean hasKey = hasParamKey(paramNames, boundSql.getParameterMappings());
//        if (!hasKey) {
//            return invocation.proceed();
//        }
        // 反射获取 参数对像
        Field parameterField = parameterHandler.getClass().getDeclaredField("parameterObject");
        parameterField.setAccessible(true);
        Object parameterObject = parameterField.get(parameterHandler);
        // 改写参数
        parameterObject = processSingle(parameterObject, paramNames);
        // 改写的参数设置到原parameterHandler对象
        parameterField.set(parameterHandler, parameterObject);
        parameterHandler.setParameters(ps);
        return invocation.proceed();
    }

    // 判断已生成sql参数映射中是否包含tenantId
    private boolean hasParamKey(List<String> paramNames, List<ParameterMapping> parameterMappings) {
        boolean hasKey = false;
        for (ParameterMapping parameterMapping : parameterMappings) {
            if (StringUtils.equals(parameterMapping.getProperty(), PARAM_KEY)) {
                hasKey = true;
            } else {
                paramNames.add(parameterMapping.getProperty());
            }
        }
        return hasKey;
    }

    private Object processSingle(Object paramObj, List<String> paramNames) throws Exception {
        Map<String, Object> paramMap = new MapperMethod.ParamMap<>();
        if (paramObj == null) {
            paramMap.put(PARAM_KEY, 1L);
            paramObj = paramMap;
            // 单参数 将 参数转为 map
        } else if (ClassUtils.isPrimitiveOrWrapper(paramObj.getClass())
                || String.class.isAssignableFrom(paramObj.getClass())
                || Number.class.isAssignableFrom(paramObj.getClass())) {
            if (paramNames.size() == 1) {
                paramMap.put(paramNames.iterator().next(), paramObj);
                paramMap.put(PARAM_KEY, 1L);
                paramObj = paramMap;
            }
        } else {
            processParam(paramObj);
        }
        return paramObj;
    }

    private void processParam(Object parameterObject) throws IllegalAccessException, InvocationTargetException {
        // 处理参数对象  如果是 map 且map的key 中没有 tenantId，添加到参数map中
        // 如果参数是bean，反射设置值
        if (parameterObject instanceof Map) {
            ((Map) parameterObject).putIfAbsent(PARAM_KEY, 1L);
        } else {
            PropertyDescriptor ps = BeanUtils.getPropertyDescriptor(parameterObject.getClass(), PARAM_KEY);
            if (ps != null && ps.getReadMethod() != null && ps.getWriteMethod() != null) {
                Object value = ps.getReadMethod().invoke(parameterObject);
                if (value == null) {
                    ps.getWriteMethod().invoke(parameterObject, 1L);
                }
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
