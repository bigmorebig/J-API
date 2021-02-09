package com.jack.api.service.api.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jack.api.common.response.ResponseSimpleRes;
import com.jack.api.common.utils.BeanCopyUtil;
import com.jack.api.dao.entity.OperateLog;
import com.jack.api.dao.mapper.OperateLogMapper;
import com.jack.api.service.api.QueryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetReqImpl implements QueryReq {
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public OperateLog getReqDetail(Long id) {
        QueryWrapper<OperateLog> wrapper = new QueryWrapper<>();
        wrapper.eq("deleted", 0).eq("id", id);
        return operateLogMapper.selectOne(wrapper);
    }

    @Override
    public List<ResponseSimpleRes> getReqBatch() {
        QueryWrapper<OperateLog> wrapper = new QueryWrapper<>();
        wrapper.eq("deleted", 0).orderByDesc("create_time");
        return BeanCopyUtil.copyListProperties(operateLogMapper.selectList(wrapper), ResponseSimpleRes::new);
    }
}
