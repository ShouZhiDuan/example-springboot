package com.example.dsz;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@Slf4j
@MapperScan("com.example.dsz.mapper")
@SpringBootApplication
public class DemoTestSpringbootApplication {
    public static void main(String[] args) {
        log.info("主程序参数列表：" + JSON.toJSONString(args));
        SpringApplication.run(DemoTestSpringbootApplication.class, args);
    }
}

/**
 * https配置
 */
//下面是2.0的配置，1.x请搜索对应的设置
//    @Bean
//    public ServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addAdditionalTomcatConnectors(createHTTPConnector());
//        return tomcat;
//    }
//
//    private Connector createHTTPConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        //同时启用http（80）、https（443）两个端口
//        connector.setScheme("http");
//        connector.setSecure(false);
//        connector.setPort(80);
//        connector.setRedirectPort(443);
//        return connector;
//    }