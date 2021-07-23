package com.example.dsz.mybatis.object_factory;

import com.example.dsz.model.DszTest;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/12 18:31
 * @Description:
 */
@Component
@Configuration
public class MyObjectFactory extends DefaultObjectFactory {

    @Override
    public Object create(Class type) {
        if (type.equals(DszTest.class)) {
            DszTest dszTest = (DszTest) super.create(type);
            dszTest.setTes("自定义拦截设置");
            return dszTest;
        }
        Object result = super.create(type);
        return result;
    }

    @Override
    //注意，在DefaultObjectFactory的create(Class type)方法中调用的是
    //create(Class,List<Class> constructorArgTypes,List<Object> constructorArgs)方法，
    //所以，只需要在这个方法中完成自定义初始化逻辑即可。
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T ret = super.create(type, constructorArgTypes, constructorArgs);
        //判断接口类型和执行接口方法。
        if (DszTest.class.isAssignableFrom(type)) {
            DszTest entity = (DszTest) ret;
        }
        return ret;
    }


}
