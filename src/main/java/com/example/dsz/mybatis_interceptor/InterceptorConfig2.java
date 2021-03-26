package com.example.dsz.mybatis_interceptor;

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
public class InterceptorConfig2 {

    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @PostConstruct
    public void addMySqlInterceptor() {
        sqlSessionFactoryList.stream().forEach(
                sqlSessionFactory -> sqlSessionFactory.getConfiguration()
                        .addInterceptor(new ForDataViewQueryInterceptor())
        );
    }
}
