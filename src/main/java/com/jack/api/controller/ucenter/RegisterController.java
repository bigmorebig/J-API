package com.jack.api.controller.ucenter;

import com.jack.api.common.request.ucenter.RegisterReq;
import com.jack.api.common.utils.BeanCopyUtil;
import com.jack.api.common.utils.Result;
import com.jack.api.dao.entity.User;
import com.jack.api.service.ucenter.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody @Valid RegisterReq req){
        User user = BeanCopyUtil.copyProperties(req, User::new);
        boolean isSuccess = registerService.saveTo(user);
        return new Result<>(isSuccess);
    }
}
