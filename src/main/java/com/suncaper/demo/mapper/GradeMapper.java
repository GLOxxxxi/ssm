package com.suncaper.demo.mapper;

import com.suncaper.demo.entity.Grade;
import com.suncaper.demo.entity.GradeExample;
import java.util.List;

import com.suncaper.demo.mapper.exend.GradeExtendMapper;
import org.apache.ibatis.annotations.Param;

public interface GradeMapper extends GradeExtendMapper {
    long countByExample(GradeExample example);

    int deleteByExample(GradeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Grade record);

    int insertSelective(Grade record);

    List<Grade> selectByExample(GradeExample example);

    Grade selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByExample(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}