package com.example.dsz.transaction;

import com.example.dsz.mapper.TxTestMapper;
import com.example.dsz.model.TxTest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/4/25 16:51
 * @Description:
 */
@Service
public class TxTwoService {

    @Transactional(propagation = Propagation.NEVER)
    public void  insert(TxTest txTestAdd, TxTestMapper txTestMapper){
        txTestMapper.insert(txTestAdd);
    }

}
