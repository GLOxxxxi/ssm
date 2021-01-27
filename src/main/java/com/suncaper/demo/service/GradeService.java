package com.suncaper.demo.service;

import com.suncaper.demo.entity.Grade;

import java.util.List;

public interface GradeService {
    void gradeInsert(List<Grade> grades);

    List<Grade> selectById(Long id);

    String selectGradeBySn(String sn);

    List<Grade> selectByBatchId(Long batchId);

    List<Grade> selectAllGradeBySn();
}
