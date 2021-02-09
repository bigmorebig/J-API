package com.jack.api.controller.api;

import com.jack.api.common.response.ResponseSimpleRes;
import com.jack.api.common.utils.Result;
import com.jack.api.dao.entity.OperateLog;
import com.jack.api.service.api.QueryReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/query")
@Api(tags = "查询请求")
public class QueryReqController {
    @Autowired
    private QueryReq getReq;

    @GetMapping("/detail/{id}")
    @ApiOperation("查询请求详情")
    public Result<OperateLog> queryDetail(@PathVariable("id") Long id){
        return new Result<>(getReq.getReqDetail(id));
    }

    @GetMapping("/batch")
    @ApiOperation("批量查询请求")
    public Result<List<ResponseSimpleRes>> queryBatch(){
        return new Result<List<ResponseSimpleRes>>(getReq.getReqBatch());
    }
}
