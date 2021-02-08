package com.example.dsz;

import com.alibaba.fastjson.JSON;
import com.example.dsz.auto_environment_load.PropertySourceDetectorConfiguration;
import com.example.dsz.event_listener.EventTest;
import com.example.dsz.java_agent.TimeTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.MutablePropertySources;
import tk.mybatis.spring.annotation.MapperScan;

import javax.swing.*;

@Slf4j
@Import(PropertySourceDetectorConfiguration.class)
@MapperScan("com.example.dsz.mapper")
@SpringBootApplication
public class DemoTestSpringbootApplication {
    public static void main(String[] args) {
//        TimeTest.sayHello();
//        TimeTest.sayHello2("sayHello2");
        log.info("主程序参数列表：" + JSON.toJSONString(args));
        //ConfigurableApplicationContext run = SpringApplication.run(DemoTestSpringbootApplication.class, args);

        /**
         * Environment操作
         */
        SpringApplication springApplication = new SpringApplication(DemoTestSpringbootApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.addListeners(new EventTest());
        //springApplication.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = springApplication.run(args);

        DemoTestSpringbootApplication bean = context.getBean(DemoTestSpringbootApplication.class);


        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
        Object property = propertySources.get("applicationConfig: [classpath:/application.properties]").getProperty("server.port");
        System.out.println(property);


        /**
         * ApplicationArgs
         */
//          SpringApplication application = new SpringApplication(Application.class);
////        ConfigurableApplicationContext context = application.run(args);
////        ApplicationArguments arguments = context.getBean(ApplicationArguments.class);
////        System.out.println(context.getEnvironment().getPropertySources().get("commandLineArgs").getProperty("spring.config.location"));
////        System.out.println("name:"+arguments.getOptionNames()+" , value："+arguments.getOptionValues("spring.config.location"));
////        context.close();



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