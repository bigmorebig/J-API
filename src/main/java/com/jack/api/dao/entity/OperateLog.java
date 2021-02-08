package com.jack.api.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("request_log")
public class OperateLog extends BaseEntity{
    /**
     * 请求方法
     */
    private String method;

    /**
     * url
     */
    private String url;

    /**
     * 请求头
     */
    private String headers;

    /**
     * 参数
     */
    private String params;

    /**
     * 消息体
     */
    private String body;

    /**
     * 状态码
     */
    private Integer statusCode;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 响应时间
     */
    private Long time;

    private String createBy;
}
