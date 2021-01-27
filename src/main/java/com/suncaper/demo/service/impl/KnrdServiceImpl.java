package com.suncaper.demo.service.impl;

import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.entity.Knrd;
import com.suncaper.demo.entity.KnrdExample;
import com.suncaper.demo.entity.User;
import com.suncaper.demo.mapper.KnrdMapper;
import com.suncaper.demo.service.KnrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnrdServiceImpl implements KnrdService {
    @Autowired
    private KnrdMapper knrdMapper;
    @Override
    public Knrd selectByUsert(User user) {
        KnrdExample knrdExample = new KnrdExample();
        knrdExample.createCriteria().andStudentIdEqualTo(user.getSn());
        List<Knrd> knrds = knrdMapper.selectByExample(knrdExample);
        return knrds.size()>0?knrds.get(0):null;
    }

    @Override
    public List<Knrd> selectGrade() {
        List<Knrd> knrds = knrdMapper.selectGrade();
        return knrds.size()==0?null:knrds;
    }

    @Override
    public String selectGradeBySn(String sn) {
        return knrdMapper.selectGradeBySn(sn);
    }

}
