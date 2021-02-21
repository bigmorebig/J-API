package com.jack.api.controller.api;

import com.jack.api.common.request.api.GetReqObj;
import com.jack.api.common.response.ResponseRes;
import com.jack.api.common.utils.BeanCopyUtil;
import com.jack.api.common.utils.Result;
import com.jack.api.dao.entity.OperateLog;
import com.jack.api.service.api.GetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/get")
@Slf4j
@Api(tags = "api")
public class GetController {
    @Autowired
    private GetService getService;

    @PostMapping("/doGet")
    @ResponseBody
    @ApiOperation("get请求接口")
    public Result<Object> getNoParams(@RequestBody @Valid GetReqObj params){
        ResponseRes response = getService.doGet(params);
        return new Result<>(response);
    }
}
