package com.jack.api.common.response;

import lombok.Data;

@Data
public class ResponseSimpleRes {
    private Long id;
    private String method;
    private String url;
    private Integer statusCode;
}
