package com.ldf.easy.domain.enums;

import lombok.Getter;

/**
 * @author ldf
 * @date 2020/6/27 18:47
 **/
@Getter
public enum  ResultCode {

    /**
     *
     */

    SUCCESS(200, "操作成功"),

    WARN(300, "提醒"),

    VALIDATE_FAILED(400, "参数校验失败"),

    ERROR(500, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
