package com.ldf.easy.domain;

import com.ldf.easy.domain.enums.ResultCode;
import lombok.Getter;

/**
 * @author ldf
 * @date 2020/6/27 18:45
 **/
@Getter
public class ResultVO<T> {

    /**
     * 状态码，比如200代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS.getCode(), "请求成功", data);
    }


    public ResultVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultVO ok(Object t){
        return new ResultVO<>(
                ResultCode.SUCCESS.getCode(),
                ResultCode.SUCCESS.getMsg(),
                t);
    }

    public static ResultVO warn(String msg){
        return new ResultVO<>(
                ResultCode.WARN.getCode(),
                msg,
                "");
    }

    public static ResultVO fail(String msg){
        return new ResultVO<>(
                ResultCode.ERROR.getCode(),
                msg,
                "");
    }



}
