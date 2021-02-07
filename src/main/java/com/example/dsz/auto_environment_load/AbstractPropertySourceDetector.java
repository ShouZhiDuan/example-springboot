package com.example.dsz.auto_environment_load;

import lombok.Setter;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.context.support.StandardServletEnvironment;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/5 15:45
 * @Description:
 */
@Service("abstractPropertySourceDetector")
public abstract class AbstractPropertySourceDetector implements PropertySourceDetector {

    private static final String SERVLET_ENVIRONMENT_CLASS = "org.springframework.web."
            + "context.support.StandardServletEnvironment";

    public boolean support(String fileExtension) {
        String[] fileExtensions = getFileExtensions();
        return null != fileExtensions &&
                Arrays.stream(fileExtensions).anyMatch(extension -> extension.equals(fileExtension));
    }

    private String findPropertySource(MutablePropertySources sources) {
        if (
                ClassUtils.isPresent(SERVLET_ENVIRONMENT_CLASS, null)
                &&
                sources.contains(StandardServletEnvironment.JNDI_PROPERTY_SOURCE_NAME)
        ) {
            return StandardServletEnvironment.JNDI_PROPERTY_SOURCE_NAME;
        }
        return StandardEnvironment.SYSTEM_PROPERTIES_PROPERTY_SOURCE_NAME;
    }

    protected void addPropertySource(ConfigurableEnvironment environment, PropertySource<?> source) {
        MutablePropertySources sources = environment.getPropertySources();
        String name = findPropertySource(sources);
        if (sources.contains(name)) {
            sources.addBefore(name, source);
        } else {
            sources.addFirst(source);
        }
    }

    protected Map<String, Object> flatten(Map<String, Object> map) {
        Map<String, Object> result = new LinkedHashMap<>();
        flatten(null, result, map);
        return result;
    }

    private void flatten(String prefix, Map<String, Object> result, Map<String, Object> map) {
        String namePrefix = (prefix != null ? prefix + "." : "");
        map.forEach((key, value) -> extract(namePrefix + key, result, value));
    }

    @SuppressWarnings("unchecked")
    private void extract(String name, Map<String, Object> result, Object value) {
        if (value instanceof Map) {
            flatten(name, result, (Map<String, Object>) value);
        } else if (value instanceof Collection) {
            int index = 0;
            for (Object object : (Collection<Object>) value) {
                extract(name + "[" + index + "]", result, object);
                index++;
            }
        } else {
            result.put(name, value);
        }
    }

    protected String getContentStringFromResource(Resource resource) throws IOException {
        //直接将文件资源转换成字符串
        return StreamUtils.copyToString(resource.getInputStream(), Charset.forName("UTF-8"));
    }
}
