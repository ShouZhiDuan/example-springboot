package com.example.dsz.auto_config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/8 17:51
 * @Description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "dsz")
public class DszProperties {
    private String name;
    private int age;
}
