package com.example.dsz.thread.zen_ren_lian_thread;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/3 17:23
 * @Description:
 */
public class Teacher1Auth extends Thread implements IVacateAuth {
    //阻塞队列
    LinkedBlockingQueue<Vacate> deque = new LinkedBlockingQueue<>();

    private IVacateAuth iVacateAuth;

    public Teacher1Auth(IVacateAuth iVacateAuth) {
        this.iVacateAuth = iVacateAuth;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Vacate take = deque.take();
            take.setDesc("======1号老师审批，通过======");
            take.setTxt("======我要请假回家======");
            take.setResult(true);
            take.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            System.out.println("我的请假条：" + JSON.toJSONString(take));
            iVacateAuth.next(take);
        }
    }

    @Override
    public void next(Vacate vacate) {
        this.deque.add(vacate);
    }
}
