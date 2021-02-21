package com.jack.api.service.api;

import com.jack.api.common.request.api.GetReqObj;
import com.jack.api.common.response.ResponseRes;
import com.jack.api.dao.entity.OperateLog;

public interface GetService {
    ResponseRes doGet(OperateLog params);
}
