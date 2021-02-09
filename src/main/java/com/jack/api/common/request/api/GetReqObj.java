package com.jack.api.common.request.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@ApiModel("GET请求实体")
public class GetReqObj {
    @NotNull(message = "url不能为空")
    @ApiModelProperty("url")
    private String url;

    @ApiModelProperty("请求参数")
    private Map<String, Object> params;

    @ApiModelProperty("请求消息头")
    private Map<String, Object> headers;
}
