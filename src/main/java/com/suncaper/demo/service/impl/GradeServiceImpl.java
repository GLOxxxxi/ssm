package com.suncaper.demo.service.impl;

import com.suncaper.demo.entity.Batch;
import com.suncaper.demo.entity.Grade;
import com.suncaper.demo.entity.GradeExample;
import com.suncaper.demo.mapper.GradeMapper;
import com.suncaper.demo.service.BatchService;
import com.suncaper.demo.service.GradeService;
import com.suncaper.demo.service.KnrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private KnrdService knrdService;
    @Autowired
    private BatchService batchService;
    @Override
    public void gradeInsert(List<Grade> grades) {
         gradeMapper.insertGrade(grades);
    }

    @Override
    public List<Grade> selectById(Long id) {
         List<Grade> grades= gradeMapper.selectById(id);
        return grades;

    }

    @Override
    public String selectGradeBySn(String sn) {

        return knrdService.selectGradeBySn(sn);
    }

    @Override
    public List<Grade> selectByBatchId(Long batchId) {
        GradeExample example = new GradeExample();
        example.createCriteria().andBatchIdEqualTo(batchId);
        return  gradeMapper.selectByExample(example);

    }

    @Override
    public List<Grade> selectAllGradeBySn() {
        Batch curBatch = batchService.getCurBatch();
        GradeExample example = new GradeExample();
        example.createCriteria().andBatchIdEqualTo(curBatch.getId());
        List<Grade> grades = gradeMapper.selectByExample(example);
        return grades;
    }
}
