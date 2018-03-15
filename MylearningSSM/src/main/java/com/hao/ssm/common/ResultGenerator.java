package com.hao.ssm.common;


import com.hao.ssm.enums.ResultCodeEnum;

/**
 * @author : hao
 * @description : 返回结果构造器 JSON格式的
 * @time : 2018/3/9 16:09
 */
public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";

    public static Result genSuccessResult() {
        Result result = new Result();
        result.setResultCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }
    public static Result genSuccessResult(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static Result genFailResult(String message) {
        Result result = new Result();
        result.setResultCode(ResultCodeEnum.RESULT_CODE_FAUL.getCode());
        if (message == null || message.length() < 1) {
            message = DEFAULT_FAIL_MESSAGE;
        }
        result.setMessage(message);
        result.setData("Data is null");
        return result;
    }
}


