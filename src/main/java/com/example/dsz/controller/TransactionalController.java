package com.example.dsz.controller;

import com.example.dsz.mapper.DszTestMapper;
import com.example.dsz.model.DszTest;
import com.example.dsz.spring_transaction.service.TransactionOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/11/26 15:28
 * @Description:
 * to see https://blog.csdn.net/yuanlaishini2010/article/details/45792069
 * 注意：测试spring事务必须要引入数据源，只操作spring-tx是无效的，因为事务是基于数据源connection去做相应代理操作的。
 */
@RestController
@RequestMapping("tran")
public class TransactionalController {
    @Autowired
    private TransactionOneService transactionOneService;

    /**
     * MANDATORY
     * @Transactional(propagation = Propagation.MANDATORY)
     * 用法：
     *  必须在一个事务中运行。也就是说，他只能被一个父事务调用。否则，他就要抛出异常
     */
    @GetMapping("test1")
    public Object test1(){
        transactionOneService.test1();
        return "success";
    }

    /**
     *  REQUIRED
     *  @Transactional(propagation = Propagation.REQUIRED)
     *  用法：
     *   假如当前正要执行的事务不在另外一个事务里，那么就起一个新的事务
     *   比如说，ServiceB.methodB的事务级别定义为PROPAGATION_REQUIRED, 那么由于执行ServiceA.methodA的时候
     *   1、如果ServiceA.methodA已经起了事务，这时调用ServiceB.methodB，ServiceB.methodB看到自己已经运行在ServiceA.methodA的事务内部，就不再起新的事务。
     *   这时只有外部事务并且他们是共用的，所以这时ServiceA.methodA或者ServiceB.methodB无论哪个发生异常methodA和methodB作为一个整体都将一起回滚。
     *   2、如果ServiceA.methodA没有事务，ServiceB.methodB就会为自己分配一个事务。这样，在ServiceA.methodA中是没有事务控制的。
     *   只是在ServiceB.methodB内的任何地方出现异常，ServiceB.methodB将会被回滚，不会引起ServiceA.methodA的回滚
     */
    @GetMapping("test2")
    public Object test2(){
        transactionOneService.test3();
        return "success";
    }

    /**
     *  SUPPORTS
     *  @Transactional(propagation = Propagation.SUPPORTS)
     *  用法：
     *   如果当前在事务中，即以事务的形式运行，如果当前不再一个事务中，那么就以非事务的形式运行
     */
    @GetMapping("test3")
    public Object test3(){
        transactionOneService.test4();
        return "success";
    }

    /**
     *  REQUIRES_NEW
     *  @Transactional(propagation = Propagation.REQUIRES_NEW)
     *  用法：
     *   启动一个新的, 不依赖于环境的 "内部" 事务. 这个事务将被完全 commited 或 rolled back 而不依赖于外部事务,
     *   它拥有自己的隔离范围, 自己的锁, 等等. 当内部事务开始执行时, 外部事务将被挂起, 内务事务结束时, 外部事务将继续执行.
     *   比如我们设计ServiceA.methodA的事务级别为PROPAGATION_REQUIRED，ServiceB.methodB的事务级别为PROPAGATION_REQUIRES_NEW，
     *   那么当执行到ServiceB.methodB的时候，ServiceA.methodA所在的事务就会挂起，ServiceB.methodB会起一个新的事务，
     *   等待ServiceB.methodB的事务完成以后，他才继续执行。他与PROPAGATION_REQUIRED 的事务区别在于事务的回滚程度了。
     *   因为ServiceB.methodB是新起一个事务，那么就是存在两个不同的事务。
     *   1、如果ServiceB.methodB已经提交，那么ServiceA.methodA失败回滚，ServiceB.methodB是不会回滚的。
     *   2、如果ServiceB.methodB失败回滚，如果他抛出的异常被ServiceA.methodA的try..catch捕获并处理，ServiceA.methodA事务仍然可能提交；
     *   如果他抛出的异常未被ServiceA.methodA捕获处理，ServiceA.methodA事务将回滚。
     *  使用场景：
     *   不管业务逻辑的service是否有异常，Log Service都应该能够记录成功，所以Log Service的传播属性可以配为此属性。最下面将会贴出配置代码。
     *  一句话：
     *    我只管自己，但是也影响别人的事务。
     */
    @GetMapping("test4")
    public Object test4(){
        transactionOneService.test5();
        return "success";
    }


    /**
     *  NOT_SUPPORTED
     *  @Transactional(propagation = Propagation.NOT_SUPPORTED)
     *  用法：
     *   当前不支持事务。比如ServiceA.methodA的事务级别是PROPAGATION_REQUIRED ，
     *   而ServiceB.methodB的事务级别是PROPAGATION_NOT_SUPPORTED ，那么当执行到ServiceB.methodB时，
     *   ServiceA.methodA的事务挂起，而他以非事务的状态运行完，再继续ServiceA.methodA的事务。
     */
    @GetMapping("test5")
    public Object test5(){
        transactionOneService.test6();
        return "success";
    }


    /**
     *  NEVER
     *  @Transactional(propagation = Propagation.NEVER)
     *  用法：
     *   不能在事务中运行。假设ServiceA.methodA的事务级别是PROPAGATION_REQUIRED，
     *   而ServiceB.methodB的事务级别是PROPAGATION_NEVER ，那么ServiceB.methodB就要抛出异常了。
     */
    @GetMapping("test6")
    public Object test6(){
        transactionOneService.test7();
        return "success";
    }


    /**
     *  NESTED
     *  @Transactional(propagation = Propagation.NESTED)
     *  用法：
     *   开始一个 "嵌套的" 事务,  它是已经存在事务的一个真正的子事务. 潜套事务开始执行时,  它将取得一个 savepoint.
     *   如果这个嵌套事务失败, 我们将回滚到此 savepoint. 潜套事务是外部事务的一部分, 只有外部事务结束后它才会被提交.
     */
    @GetMapping("test7")
    public Object test7(){
        transactionOneService.test8();
        return "success";
    }

    @Autowired
    private DszTestMapper dszTestMapper;

    /**
     * 测试如果@Transactional放在Controller是否支持事务回滚
     * 也是可以的 所以不一定要接口 应为JDK和CGLIB两种
     */
    @GetMapping("test8")
    @Transactional
    public Object test8(){
        DszTest dszTest = new DszTest();
        dszTest.setAddr("{}");
        dszTest.setAge(30);
        dszTest.setName("段守志2");
        dszTest.setTes("测试数据");
        dszTestMapper.insert(dszTest);
        int i = 1/0;
        return dszTest;
    }






}
