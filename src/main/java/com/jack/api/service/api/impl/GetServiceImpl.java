package com.jack.api.service.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jack.api.common.constant.FormatterDateTime;
import com.jack.api.common.request.api.GetReqObj;
import com.jack.api.common.response.ResponseRes;
import com.jack.api.dao.entity.OperateLog;
import com.jack.api.dao.mapper.OperateLogMapper;
import com.jack.api.service.api.GetService;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

@Service
public class GetServiceImpl implements GetService {
    @Autowired
    private OperateLogMapper operateLogMapper;

    public ResponseRes doGet(GetReqObj params) {
        // 执行请求
        Response response = given().
                params(params.getParams()).
                headers(params.getHeaders()).
                get(params.getUrl());

        // 记录日志
        ZonedDateTime zdt = ZonedDateTime.now();
        OperateLog operateLog = new OperateLog();
        operateLog.setMethod("GET");
        operateLog.setUrl(params.getUrl());
        operateLog.setHeaders(JSON.toJSONString(params.getHeaders()));
        operateLog.setParams(JSON.toJSONString(params.getParams()));
        operateLog.setStatusCode(response.getStatusCode());
        operateLog.setCreateTime(DateTimeFormatter.ofPattern(FormatterDateTime.formatter).format(zdt));
        operateLog.setVersion(1);
        operateLog.setDeleted(0);
        operateLog.setTime(response.getTime());
        operateLogMapper.insert(operateLog);

        return ResponseRes.builder().
                statusCode(response.getStatusCode()).
                body(response.getBody().asString()).
                cookies(response.getCookies()).
                headers(response.getHeaders()).
                time(response.getTime()).build();
    }
}
