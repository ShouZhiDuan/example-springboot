package com.example.dsz.auto_environment_load;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/5 15:53
 * @Description:
 */
public class PropertySourceDetectorConfiguration implements ImportBeanDefinitionRegistrar {

    private static final String PATH_PREFIX = "profiles";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) registry;
        ConfigurableEnvironment environment = beanFactory.getBean(ConfigurableEnvironment.class);
        List<AbstractPropertySourceDetector> propertySourceDetectors = new ArrayList<>();
        configurePropertySourceDetectors(propertySourceDetectors, beanFactory);
        PropertySourceDetectorComposite propertySourceDetectorComposite = new PropertySourceDetectorComposite();
        propertySourceDetectorComposite.addPropertySourceDetectors(propertySourceDetectors);
        String[] activeProfiles = environment.getActiveProfiles();
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try {
            for (String profile : activeProfiles) {
                String location = PATH_PREFIX + File.separator + profile + File.separator + "*";
                Resource[] resources = resourcePatternResolver.getResources(location);
                for (Resource resource : resources) {
                    propertySourceDetectorComposite.load(environment, resource.getFilename(), resource);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private void configurePropertySourceDetectors(List<AbstractPropertySourceDetector> propertySourceDetectors,
                                                  DefaultListableBeanFactory beanFactory) {
        Map<String, AbstractPropertySourceDetector> beansOfType = beanFactory.getBeansOfType(AbstractPropertySourceDetector.class);
        for (Map.Entry<String, AbstractPropertySourceDetector> entry : beansOfType.entrySet()) {
            propertySourceDetectors.add(entry.getValue());
        }
        propertySourceDetectors.add(new JsonPropertySourceDetector());
        propertySourceDetectors.add(new YamlPropertySourceDetector());
        propertySourceDetectors.add(new PropertiesPropertySourceDetector());
    }
}
