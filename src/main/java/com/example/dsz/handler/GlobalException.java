package com.example.dsz.handler;

import com.example.dsz.enums.GlobalExceptionCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/1 13:11
 * @Description: 全局异常
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private Integer code;
    private String msg;
    //构建异常实例数据

    public GlobalException(GlobalExceptionCodeEnum globalExceptionCodeEnum) {
        this.code = globalExceptionCodeEnum.getCode();
        this.msg = globalExceptionCodeEnum.getMsg();
    }
}
