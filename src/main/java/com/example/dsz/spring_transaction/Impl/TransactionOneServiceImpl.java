package com.example.dsz.spring_transaction.Impl;

import com.example.dsz.spring_transaction.service.TransactionOneService;
import com.example.dsz.spring_transaction.service.TransactionTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/11/26 10:55
 * @Description:
 */
@Service
public class TransactionOneServiceImpl implements TransactionOneService {

    @Autowired
    private  TransactionOneService transactionOneService;

    @Autowired
    private TransactionTwoService transactionTwoService;

    @Override
    public void test1() {
        System.out.println("test1");
        //transactionOneService.test2();
        transactionTwoService.test2();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void test2() {
        System.out.println("com.example.dsz.spring_transaction.Impl.TransactionOneServiceImpl#test2");
    }
}
