package com.jack.api.common.request.ucenter;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ModifyPasswordReq {
    @NotNull(message = "用户id不能为空")
    private Long id;

    @NotNull(message = "旧密码不能为空")
    private String password;

    @NotNull(message = "新密码不能为空")
    private String newPassword;

    @NotNull(message = "重复密码不能为空")
    private String repeatPassword;
}
