package com.example.dsz.chain_demo;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/3 17:23
 * @Description:
 */
public class Teacher2Auth extends Thread implements IVacateAuth {
    //阻塞队列
    LinkedBlockingQueue<Vacate> deque=new LinkedBlockingQueue<>();

    private IVacateAuth iVacateAuth;

    public Teacher2Auth(IVacateAuth iVacateAuth){
        this.iVacateAuth = iVacateAuth;
    }

    public Teacher2Auth(){

    }

    @SneakyThrows
    @Override
    public void run() {
          while (true){
              Vacate take = deque.take();
              take.setDesc("======2号老师审批，不同意======");
              take.setTxt("======我要请假回家======");
              take.setResult(false);
              take.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
              System.out.println("我的请假条：" + JSON.toJSONString(take));
              if(null != iVacateAuth){
                  iVacateAuth.next(take);
              }
          }
    }

    @Override
    public void next(Vacate vacate) {
        this.deque.add(vacate);
    }
}
