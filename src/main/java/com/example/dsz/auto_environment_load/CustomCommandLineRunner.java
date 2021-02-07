package com.example.dsz.auto_environment_load;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/5 15:54
 * @Description:
 */
//@Slf4j
//@Component
//public class CustomCommandLineRunner implements CommandLineRunner {
//
//    @Value("${mq-name}")
//    String mqName;
//    @Value("${auto.profile.name}")
//    String autoProfileName;
//    @Autowired
//    ConfigurableEnvironment configurableEnvironment;
//
//    @Override
//    public void run(String... args) {
//        log.info("mqName = {},autoProfileName = {}", mqName, autoProfileName);
//    }
//}
