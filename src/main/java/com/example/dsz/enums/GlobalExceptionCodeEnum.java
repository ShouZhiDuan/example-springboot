package com.example.dsz.enums;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/1 13:33
 * @Description:
 */
public enum GlobalExceptionCodeEnum {

    TOKEN_EXCEPTION_CODE(401,"token已过期"),
    PARAMS_VALIDATED_CODE(5003,"参数校验异常消息")

    ;

    private Integer code;
    private String msg;

    GlobalExceptionCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public GlobalExceptionCodeEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
