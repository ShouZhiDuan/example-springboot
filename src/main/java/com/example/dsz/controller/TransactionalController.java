package com.example.dsz.controller;

import com.example.dsz.spring_transaction.service.TransactionOneService;
import com.example.dsz.spring_transaction.service.TransactionTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/11/26 15:28
 * @Description:
 */
@RestController
@RequestMapping("tran")
public class TransactionalController {
    @Autowired
    private TransactionOneService transactionOneService;

    @GetMapping
    public Object test1(){
        transactionOneService.test1();
        return "success";
    }


}
