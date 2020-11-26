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
    @Transactional(propagation=Propagation.MANDATORY)
    public void test2() {
        System.out.println("com.example.dsz.spring_transaction.Impl.TransactionTwoServiceImpl#test2");
    }
}
