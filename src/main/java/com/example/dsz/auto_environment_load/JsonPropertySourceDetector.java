package com.example.dsz.auto_environment_load;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Map;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/5 15:47
 * @Description: 解析Json格式文件
 */

@Slf4j
public class JsonPropertySourceDetector extends AbstractPropertySourceDetector {

    private static final JsonParser JSON_PARSER = JsonParserFactory.getJsonParser();

    @Override
    public String[] getFileExtensions() {
        return new String[]{"json"};
    }

    @Override
    public void load(ConfigurableEnvironment environment, String name, Resource resource) throws IOException {
        try {
            Map<String, Object> map = JSON_PARSER.parseMap(getContentStringFromResource(resource));
            Map<String, Object> target = flatten(map);
            addPropertySource(environment, new MapPropertySource(name, target));
        } catch (Exception e) {
            log.warn("加载Json文件属性到环境变量失败,name = {},resource = {}", name, resource);
        }
    }
}
