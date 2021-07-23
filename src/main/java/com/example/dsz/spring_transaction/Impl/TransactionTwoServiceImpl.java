package com.example.dsz.spring_transaction.Impl;

import com.example.dsz.spring_transaction.service.TransactionTwoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/11/26 10:56
 * @Description:
 */
@Service
public class TransactionTwoServiceImpl implements TransactionTwoService {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void test2() {
        System.out.println("@Transactional(propagation=Propagation.MANDATORY)");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void test3() {
        System.out.println("@Transactional(propagation = Propagation.REQUIRED)");
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void test4() {
        System.out.println("@Transactional(propagation = Propagation.SUPPORTS)");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test5() {
        System.out.println("@Transactional(propagation = Propagation.REQUIRES_NEW)");
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void test6() {
        System.out.println("@Transactional(propagation = Propagation.NOT_SUPPORTED)");
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void test7() {
        System.out.println("@Transactional(propagation = Propagation.NEVER)");
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void test8() {
        System.out.println("@Transactional(propagation = Propagation.NESTED)");
    }
}
