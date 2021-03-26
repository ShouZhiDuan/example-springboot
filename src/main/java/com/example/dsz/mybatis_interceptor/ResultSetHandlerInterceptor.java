package com.example.dsz.mybatis_interceptor;

import com.example.dsz.vo.ExperimentExecutionDataViewVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/25 11:05
 * @Description:
 */

@Slf4j
@Intercepts({ @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })
public class ResultSetHandlerInterceptor implements Interceptor {

    /**
     * 拦截返回结果集处理 常见的JSON串映射到对象的属性字段
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("ResultSetHandlerInterceptor");
        DefaultResultSetHandler defaultResultSetHandler = (DefaultResultSetHandler) invocation.getTarget();
        Field field = defaultResultSetHandler.getClass().getDeclaredField("mappedStatement");
        field.setAccessible(true);
        MappedStatement mappedStatement = (MappedStatement) field.get(defaultResultSetHandler);
        Class<?> type = mappedStatement.getResultMaps().get(0).getType();
        if(type.getName().equals(ExperimentExecutionDataViewVO.class.getName())){
            //返回的结果集
            List<ExperimentExecutionDataViewVO> dataViewVOList = new ArrayList<>();
            Object[] args = invocation.getArgs();
            Statement stmt = (Statement) args[0];
            ResultSet resultSet = stmt.getResultSet();
            if(resultSet != null){
                while (resultSet.next()) {
                    //类似原生JDBC处理
                    dataViewVOList.add(new ExperimentExecutionDataViewVO());
                }
            }
            return dataViewVOList;
        }else {
            return invocation.proceed();
        }
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) { }

}
