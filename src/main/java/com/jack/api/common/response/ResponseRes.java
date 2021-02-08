package com.jack.api.common.response;

import io.restassured.http.Headers;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ResponseRes {
    /**
     * 状态码
     */
    private Integer statusCode;

    /**
     * 响应实体
     */
    private String body;

    /**
     * cookies
     */
    private Map<String, String> cookies;

    /**
     * 响应消息头
     */
    private Headers headers;

    /**
     * 请求响应时间
     */
    private Long time;
}
