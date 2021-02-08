package com.jack.api.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class BaseEntity {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String createBy;

    private String createTime;

    private String updateBy;

    private String updateTime;

    private Integer version;

    @TableLogic
    private Integer deleted;
}
