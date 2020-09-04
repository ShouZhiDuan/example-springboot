package com.example.dsz.test.test_2;

import com.example.dsz.utils.DszBeanUtils;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/8/20 16:52
 * @Description:
 */
@Data
public class BeanCopy {

    private Integer id;

    private String name;

    private Integer age;

    public static void main(String[] args) {
        BeanCopy copy1 = new BeanCopy();
        copy1.setId(1);
        copy1.setAge(10);
        copy1.setName("test");


        BeanCopy copy2 = new BeanCopy();
        copy2.setAge(100);
        copy2.setName("test-new");

        //BeanUtils.copyProperties(copy2,copy1);
        DszBeanUtils.copyPropertiesIgnoreNull(copy2,copy1);
        System.out.println();

    }

}
