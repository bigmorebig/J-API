package com.jack.api.common.utils;

import com.alibaba.fastjson.JSON;
import com.jack.api.common.enums.CommonCode;

import java.util.Collections;

public class ApiUtil {
    public static String output(Result<Object> result){
        return JSON.toJSONString(result);
    }

    public static Result<Object> genSuccessResult(Object o){
        return genBaseResultDTO(o, CommonCode.SUCCESS, true);
    }

    public static Result<Object> genErrorResult(CommonCode code){
        if (null == code){
            code = CommonCode.SYS_ERROR;
        }
        return genBaseResultDTO(Collections.emptyMap(), code, false);
    }

    public static Result<Object> genErrorResult(Integer code, String message){
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setRet(false);
        result.setData(Collections.emptyList());
        return result;
    }

    public static Result<Object> genBaseResultDTO(Object data, CommonCode code, Boolean ret){
        Result<Object> result = new Result<>();
        result.setCode(code.getCode());
        result.setMessage(code.getMessage());
        result.setData(data);
        result.setRet(ret);
        return result;
    }
}
