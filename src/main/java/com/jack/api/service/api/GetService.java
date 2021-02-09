package com.jack.api.service.api;

import com.jack.api.common.request.api.GetReqObj;
import com.jack.api.common.response.ResponseRes;

public interface GetService {
    ResponseRes doGet(GetReqObj params);
}
