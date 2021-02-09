package com.jack.api.service.ucenter;

import com.jack.api.common.request.ucenter.ModifyPasswordReq;
import com.jack.api.dao.entity.User;

public interface RegisterService {
    boolean saveTo(User user);

    boolean modifyPassword(ModifyPasswordReq req);
}
