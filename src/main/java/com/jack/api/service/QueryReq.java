package com.jack.api.service;

import com.jack.api.common.response.ResponseSimpleRes;
import com.jack.api.dao.entity.OperateLog;

import java.util.List;

public interface QueryReq {
    /**
     * 获取请求详情
     * @return
     */
    OperateLog getReqDetail(Long id);

    /**
     * 批量获取请求
     * @return
     */
    List<ResponseSimpleRes> getReqBatch();
}
