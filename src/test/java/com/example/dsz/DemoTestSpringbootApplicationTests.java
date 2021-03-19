package com.example.dsz;

import com.example.dsz.mapper.DszTestMapper;
import com.example.dsz.mapper.TestMapper;
import com.example.dsz.model.DszTest;
import com.example.dsz.model.DszTest2;
import com.example.dsz.mybatis.type_handler.UserStatus;
import com.example.dsz.spring_transaction.service.TransactionOneService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoTestSpringbootApplication.class)
public class DemoTestSpringbootApplicationTests {

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

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    /**
     * mybatis批量插入
     */
    @Test
    public void test3(){
        long start = System.currentTimeMillis();
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        DszTestMapper mapper = sqlSession.getMapper(DszTestMapper.class);
        for(int i=0; i<= 999; i++){
            DszTest test = new DszTest();
            test.setTes(i+"");
            test.setAddr("{}");
            mapper.insert(test);
        }
        sqlSession.commit();
        sqlSession.close();
        //4273毫秒
        System.out.println(System.currentTimeMillis()  - start);
    }


    @Test
    public void test(){
        long start = System.currentTimeMillis();
        for(int i=0; i<= 999; i++){
            DszTest test = new DszTest();
            test.setTes(i+"");
            test.setAddr("{}");
            dszTestMapper.insert(test);
        }
        //7082毫秒
        System.out.println(System.currentTimeMillis()  - start);
    }


    @Autowired
    private TestMapper testMapper;
    /**
     * 一对一查询
     */
    @Test
    public void testOneToOneQuery(){
        //DszTest2 dszTest = testMapper.queryDetailsById(1);
        DszTest2 dszTest2 = testMapper.queryDetailsById2(1);
        System.out.println(dszTest2);
    }






}
