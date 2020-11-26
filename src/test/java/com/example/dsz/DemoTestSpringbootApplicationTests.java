package com.example.dsz;

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

    @Test
    public void  test1(){
        transactionOneService.test1();
    }



}
