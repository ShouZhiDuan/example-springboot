package com.example.dsz;

import com.example.dsz.mapper.DszTestMapper;
import com.example.dsz.model.DszTest;
import com.example.dsz.mybatis.type_handler.UserStatus;
import com.example.dsz.spring_transaction.service.TransactionOneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoTestSpringbootApplication.class)
public class DemoTestSpringbootApplicationTests {

    @Autowired
    private TransactionOneService transactionOneService;

    @Autowired
    private DszTestMapper dszTestMapper;

    @Test
    public void  test1(){
        DszTest test = new DszTest();
        test.setTes("setTes");
        test.setName("setName");
        test.setAge(31);
        test.setAddr("{}");
        test.setStatus(UserStatus.one);
        dszTestMapper.insert(test);
    }

    @Test
    public void  test2(){
        DszTest dszTest = dszTestMapper.selectByPrimaryKey(13);
        System.out.println(dszTest);
    }






}
