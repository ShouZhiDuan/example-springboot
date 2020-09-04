package com.example.dsz.thread.zen_ren_lian_thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/3 17:17
 * @Description: 请假条
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacate {

    //假条流转时间
    private String time;
    //请假内容
    private String txt;
    //审批结果
    private Boolean result;
    //描述
    private String desc;

}
