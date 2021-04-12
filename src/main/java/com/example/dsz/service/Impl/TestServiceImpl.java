package com.example.dsz.service.Impl;

import com.example.dsz.mapper.DszTestMapper;
import com.example.dsz.model.DszTest;
import com.example.dsz.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.sound.midi.Soundbank;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/8/12 15:19
 * @Description:
 */
@Slf4j
@Service("tstServiceImpl")
public class TestServiceImpl implements TestService {

    @Autowired
    private DszTestMapper dszTestMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    @Async("asyncServiceExecutor")
    public String testDo(String msg) {
        log.info("执行TestServiceImpl#testDo方法");
        return msg;
    }

    @Override
    //@Transactional(readOnly = true)
    @Transactional
    public DszTest queryTest() {
        //DszTest dszTest = dszTestMapper.selectByPrimaryKey(1);
        String sql = "SELECT * FROM dsz_test WHERE id =1 FOR UPDATE";
        //Object o = sqlSessionTemplate.selectOne(sql,null);
        try {
            SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession();
            PreparedStatement preparedStatement = sqlSession.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
        } catch (SQLException e) {
        }
        return new DszTest();
    }
}










