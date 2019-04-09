package com.tinklabs.handy.base.vo;

import com.tinklabs.handy.base.exception.BaseErrors;
import com.tinklabs.handy.base.exception.IError;

import java.io.Serializable;

public class ResultTVO<T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    public String getCode() {
        return code;
    }

    public ResultTVO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultTVO setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultTVO setData(T data) {
        this.data = data;
        return this;
    }

    public static ResultTVO SUCCESS() {
        return new ResultTVO()
                .setCode(BaseErrors.SUCCESS.getCode())
                .setMsg(BaseErrors.SUCCESS.getMsg());
    }

    public static <T> ResultTVO<T> SUCCESS(T data) {
        return new ResultTVO()
                .setCode(BaseErrors.SUCCESS.getCode())
                .setMsg(BaseErrors.SUCCESS.getMsg())
                .setData(data);
    }

    public static ResultTVO FAIL(IError error) {
        return new ResultTVO()
                .setCode(error.getCode())
                .setMsg(error.getMsg());
    }

    public static <T> ResultTVO<T> FAIL(IError error, String msg) {
        return new ResultTVO()
                .setCode(error.getCode())
                .setMsg(msg);
    }


}
