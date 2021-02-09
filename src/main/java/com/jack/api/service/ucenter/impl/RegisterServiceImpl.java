package com.jack.api.service.ucenter.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jack.api.common.constant.FormatterDateTime;
import com.jack.api.common.exceptions.CommonException;
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

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public boolean saveTo(User user) {
        ZonedDateTime zdt = ZonedDateTime.now();
        user.setPassword(MD5Util.crypt(user.getPassword()));
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
}
