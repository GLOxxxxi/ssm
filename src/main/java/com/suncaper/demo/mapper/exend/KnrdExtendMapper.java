package com.suncaper.demo.mapper.exend;

import com.suncaper.demo.entity.Knrd;

import java.util.List;

public interface KnrdExtendMapper {
    List<Knrd> selectGrade();

    String selectGradeBySn(String sn);
}
