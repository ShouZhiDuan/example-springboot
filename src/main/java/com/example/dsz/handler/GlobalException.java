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
    private GlobalExceptionCodeEnum globalExceptionCodeEnum;
}
