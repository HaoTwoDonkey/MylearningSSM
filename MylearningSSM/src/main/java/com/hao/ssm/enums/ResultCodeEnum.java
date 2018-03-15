package com.hao.ssm.enums;

/**
 * @author : hao
 * @description : 通用返回结果的状态码
 * @time : 2018/3/9 16:06
 */
public enum ResultCodeEnum {

    RESULT_CODE_SUCCESS(666),

    RESULT_CODE_FAUL(444);

    private int code;

    ResultCodeEnum(int s) {
        this.code = s;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
