package com.example.dsz.transaction;

import com.example.dsz.mapper.TxTestMapper;
import com.example.dsz.model.TxTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/4/25 16:51
 * @Description:
 */
@Service
public class TxOneService {

    @Autowired
    private TxTestMapper txTestMapper;

    @Autowired
    private TxTwoService txTwoService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void testTx(){
         Example example = new Example(TxTest.class);
         example.createCriteria().andEqualTo("age",2);
         txTestMapper.deleteByExample(example);
         List<Integer> ages = new ArrayList<>();
         ages.add(5);
         ages.add(6);
         ages.parallelStream().forEach(age -> {
             TxTest txTestAdd = new TxTest();
             txTestAdd.setAge(age);
             txTestAdd.setName("name" + age);
             txTwoService.insert(txTestAdd,txTestMapper);
         });
    }





}
