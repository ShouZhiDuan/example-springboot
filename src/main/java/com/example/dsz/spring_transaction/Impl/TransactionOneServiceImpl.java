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
    private TransactionTwoService transactionTwoService;

    @Override
    public void test1() {
        System.out.println("test1");
        transactionTwoService.test2();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void test2() {
        System.out.println("com.example.dsz.spring_transaction.Impl.TransactionOneServiceImpl#test2");
    }


    @Override
    @Transactional//如果这里开启了事务，那么transactionTwoService.test3()将不会开启事务，公用当前的事务管理。反之自己开启事务给自己。
    public void test3() {
        System.out.println("com.example.dsz.spring_transaction.Impl.TransactionOneServiceImpl.test3");
        transactionTwoService.test3();
    }

    @Override
    @Transactional
    public void test4() {
        transactionTwoService.test4();
    }

    @Override
    @Transactional
    public void test5() {
        transactionTwoService.test5();
    }
}
