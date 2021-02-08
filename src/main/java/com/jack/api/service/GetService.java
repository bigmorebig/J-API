package com.jack.api.service;

import com.jack.api.common.request.GetReqObj;
import com.jack.api.common.response.ResponseRes;

public interface GetService {
    ResponseRes doGet(GetReqObj params);
}
