package com.jack.api.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("users")
public class User extends BaseEntity {
    private String name;
    private String email;
    private String phone;
    private String password;
}
