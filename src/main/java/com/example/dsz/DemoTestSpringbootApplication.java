package com.example.dsz;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoTestSpringbootApplication {

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

    /**
     * SpringBoot启动类
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoTestSpringbootApplication.class, args);
    }

}
