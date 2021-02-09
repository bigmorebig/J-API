package com.jack.api.common.request.ucenter;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class RegisterReq {
    @NotEmpty(message = "名字不能为空")
    private String name;

    @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$", message = "邮箱格式错误")
    private String email;

    @Pattern(regexp = "^(13[4,5,6,7,8,9]|15[0,8,9,1,7]|188|187)\\\\d{8}$", message = "手机号格式错误")
    private String phone;

    @NotEmpty(message = "密码不允许为空")
    private String password;
}
