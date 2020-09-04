package com.example.dsz.base;

import java.util.HashMap;

public class SkadiResult<T> {

    private int code;

    private String message;

    private T data;

    public SkadiResult(int code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static <T> SkadiResult<T> ok() {
        return new Builder<T>().build();
    }

    public static <T> SkadiResult<T> ok(T data) {
        return new Builder<T>().data(data).build();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean success() {
        return this.code == 0;
    }

    public boolean error() {
        return !success();
    }

    public static class Builder<T> {

        SkadiResult<T> result;

        public Builder() {
            result = new SkadiResult<T>(0, "", (T) new HashMap());
        }

        public Builder<T> code(int code) {
            result.code = code;
            return this;
        }

        public Builder<T> msg(String msg) {
            result.message = msg;
            return this;
        }

        public Builder<T> data(T data) {
            result.data = data;
            return this;
        }

        public SkadiResult<T> build() {
            return result;
        }
    }
}
