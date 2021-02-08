package com.jack.api.common.enums;

import lombok.Getter;

@Getter
public enum CommonCode {
    /**
     * 成功
     */
    SUCCESS(200, "success"),

    /**
     * 未授权
     */
    UNAUTHORIZED(401, "Unauthoried"),

    /**
     * 无权限
     */
    FORBIDDEN(403, "Forbidden"),

    /**
     * 未找到
     */
    NOT_FOUND(404, "Not Found"),

    /**
     * 系统错误
     */
    SYS_ERROR(500, "system error"),

    /**
     * 上游服务错误
     */
    BAD_GATEWAY(502, "Bad Gateway"),

    /**
     * 参数错误
     */
    PARAM_ERROR(600, "Param Error"),

    /**
     * 解密失败
     */
    PRECONDITION_FAILED(601, "param decrypt failed");

    private final int code;
    private final String message;

    CommonCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CommonCode parseCode(int code){
        CommonCode[] codes = values();
        int var3 = codes.length;

        for (int var4 = 0; var4 < var3; ++var4){
            CommonCode c = codes[var4];
            if (c.getCode() == code){
                return c;
            }
        }
        return null;
    }
}
