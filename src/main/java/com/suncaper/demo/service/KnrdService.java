package com.suncaper.demo.service;

import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.entity.Knrd;
import com.suncaper.demo.entity.User;

import java.util.List;

public interface KnrdService {
    Knrd selectByUsert(User user);

    List<Knrd> selectGrade();

    String selectGradeBySn(String sn);
}
