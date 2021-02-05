package com.example.dsz.auto_environment_load;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/5 15:44
 * @Description:
 */
public interface PropertySourceDetector {
    /**
     * 获取支持的文件后缀数组
     *
     * @return String[]
     */
    String[] getFileExtensions();

    /**
     * 加载目标文件属性到环境中
     *
     * @param environment environment
     * @param name        name
     * @param resource    resource
     * @throws IOException IOException
     */
    void load(ConfigurableEnvironment environment, String name, Resource resource) throws IOException;
}
