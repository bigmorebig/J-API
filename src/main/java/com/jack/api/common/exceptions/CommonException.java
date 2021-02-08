package com.jack.api.common.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommonException extends RuntimeException {
    private int code;
    private String message;

    public CommonException(){
    }

    public CommonException(int code, String message){
        this.code = code;
        this.message = message;
    }
}
