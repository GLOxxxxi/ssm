package com.suncaper.demo.service.impl;

import com.suncaper.demo.common.Constant;
import com.suncaper.demo.entity.Batch;
import com.suncaper.demo.entity.Knrd;
import com.suncaper.demo.entity.User;
import com.suncaper.demo.entity.UserExample;
import com.suncaper.demo.mapper.UserMapper;
import com.suncaper.demo.service.BatchService;
import com.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BatchService batchService;
    @Override
    public User login(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andSnEqualTo(user.getSn());
        List<User> users = userMapper.selectByExample(example);
        return users.size()>0?users.get(0):null;
    }

    @Override
    public void insert(User u) {
        userMapper.insertSelective(u);
    }

    @Override
    public boolean conformKnrd(Knrd knrd) {
        Batch curBatch = batchService.getCurBatch();
        //该学生的困难等级
        String povertyLevel = knrd.getPovertyLevel();
        //当前能申请的等级
        String difValue = curBatch.getDifVal();
        if(Constant.DIFFICUTY_BKN.equals(difValue)){
            return true;
        }
        //能申请的等级为一般困难 一般困难 和ts困难都能进
        if(Constant.DIFFICUTY_YBKN.equals(difValue)&&(Constant.DIFFICUTY_YBKN.equals(povertyLevel)||Constant.DIFFICUTY_TSKN.equals(povertyLevel))){
            return true;
        }
        if(Constant.DIFFICUTY_TSKN.equals(difValue)&&Constant.DIFFICUTY_TSKN.equals(povertyLevel)){
            return true;
        }
        return false;
    }
}
