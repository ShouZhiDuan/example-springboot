package com.example.dsz.mybatis_interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.autoconfigure.ConfigurationCustomizer;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/26 11:18
 * @Description:
 */
@Configuration
public class InterceptorConfig {

    @Bean
    public ExecutorInterceptor executorInterceptor(){
       return new ExecutorInterceptor();
    }

    @Bean
    public StatementHandlerInterceptor statementHandlerInterceptor(){
        return new StatementHandlerInterceptor();
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return configuration -> {
              configuration.setAggressiveLazyLoading(true);
              configuration.addInterceptor(executorInterceptor());//拦截器1
              configuration.addInterceptor(statementHandlerInterceptor());//拦截器2
        };
    }

}
