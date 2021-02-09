package com.jack.api.service.ucenter.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jack.api.common.constant.FormatterDateTime;
import com.jack.api.common.exceptions.CommonException;
import com.jack.api.common.request.ucenter.ModifyPasswordReq;
import com.jack.api.common.utils.MD5Util;
import com.jack.api.dao.entity.User;
import com.jack.api.dao.mapper.UserMapper;
import com.jack.api.service.ucenter.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean saveTo(User user) {
        ZonedDateTime zdt = ZonedDateTime.now();
        user.setPassword(MD5Util.crypt(user.getPassword().trim()));
        user.setCreateTime(DateTimeFormatter.ofPattern(FormatterDateTime.formatter).format(zdt));
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", user.getName());
        User user1 = userMapper.selectOne(wrapper);
        if (user1 == null){
            int count = userMapper.insert(user);
            return count != 0;
        }
        log.info("用户不存在, {}", JSON.toJSONString(user1));
        throw new CommonException(500, "用户已存在");
    }

    @Override
    public boolean modifyPassword(ModifyPasswordReq req) {
        if (!req.getNewPassword().trim().equals(req.getRepeatPassword().trim())){
            log.error("修改密码不一致, {}", JSON.toJSONString(req));
            throw new CommonException(500, "修改密码不一致");
        }
        ZonedDateTime zdt = ZonedDateTime.now();
        User user = userMapper.selectById(req.getId());
        if (user != null){
            if (MD5Util.crypt(req.getPassword().trim()).equals(user.getPassword())){
                user.setPassword(MD5Util.crypt(req.getNewPassword().trim()));
                user.setUpdateTime(DateTimeFormatter.ofPattern(FormatterDateTime.formatter).format(zdt));
                user.setVersion(user.getVersion() + 1);
                int count = userMapper.updateById(user);
                return count != 0;
            }
            throw new CommonException(500, "原密码错误");
        }
        log.error("用户id不存在, {}", req.getId());
        throw new CommonException(500, "用户已存在");
    }
}
