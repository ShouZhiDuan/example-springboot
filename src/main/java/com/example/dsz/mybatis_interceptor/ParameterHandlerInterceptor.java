package com.example.dsz.mybatis_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.*;

import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/26 15:22
 * @Description:
 */
@Slf4j
@Intercepts(value = {
        @Signature(type = ParameterHandler.class, method = "getParameterObject", args = {}),
        @Signature(type = ParameterHandler.class, method = "setParameters", args = { PreparedStatement.class })
})
public class ParameterHandlerInterceptor implements Interceptor {

    /**
     *  SQL执行参数处理
     *  to see https://blog.csdn.net/yangbo787827967/article/details/81562476
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("ParameterHandlerInterceptor");

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
