package com.ldf.easy.domain;

import com.ldf.easy.domain.enums.ResultCode;
import lombok.Getter;

/**
 * @author ldf
 * @date 2020/6/27 18:53
 **/
public class APIException extends RuntimeException{

    private int code;
    private String msg;

    public APIException() {
        this(ResultCode.ERROR.getCode(), "接口错误");
    }

    public APIException(String msg) {
        this(ResultCode.ERROR.getCode(), msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
