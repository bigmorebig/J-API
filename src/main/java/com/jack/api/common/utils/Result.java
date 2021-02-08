package com.jack.api.common.utils;

import com.alibaba.fastjson.JSON;
import com.jack.api.common.enums.CommonCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

@Data
public class Result<T> implements Serializable {
    private boolean ret;
    private int code;
    private String message;
    private T data;

    public Result(){
    }

    public Result(T data) {
        this.ret = true;
        this.code = CommonCode.SUCCESS.getCode();
        this.message = CommonCode.SUCCESS.toString();
        this.data = data;
    }

    public Result(List<T> data){
        this.ret = true;
        this.code = CommonCode.SUCCESS.getCode();
        this.message = CommonCode.SUCCESS.toString();
        this.data = (T) JSON.toJSON(data);
    }

    public Result(int code, String message) {
        this.ret = false;
        this.code = code;
        CommonCode ccode = CommonCode.parseCode(code);
        if (null != ccode && StringUtils.isEmpty(message)){
            this.message = ccode.toString();
        }else {
            this.message = message;
        }
    }
}
