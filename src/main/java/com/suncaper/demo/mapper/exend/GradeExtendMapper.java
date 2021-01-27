package com.suncaper.demo.mapper.exend;

import com.suncaper.demo.entity.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeExtendMapper {
    void insertGrade(@Param("grades") List<Grade> grades);

    List<Grade> selectById(Long id);

    List<String> selectByBatchId(Long batchId);
}
