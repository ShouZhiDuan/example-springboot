package com.example.dsz.auto_environment_load;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.YamlJsonParser;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Map;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/5 15:51
 * @Description:
 */
@Slf4j
public class YamlPropertySourceDetector extends AbstractPropertySourceDetector {

    private static final JsonParser YAML_PARSER = new YamlJsonParser();

    @Override
    public String[] getFileExtensions() {
        return new String[]{"yaml", "yml"};
    }

    @Override
    public void load(ConfigurableEnvironment environment, String name, Resource resource) throws IOException {
        try {
            Map<String, Object> map = YAML_PARSER.parseMap(getContentStringFromResource(resource));
            Map<String, Object> target = flatten(map);
            addPropertySource(environment, new MapPropertySource(name, target));
        } catch (Exception e) {
            log.warn("加载Yaml文件属性到环境变量失败,name = {},resource = {}", name, resource);
        }
    }
}
