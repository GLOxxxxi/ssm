package com.suncaper.demo.mapper;

import com.suncaper.demo.entity.Knrd;
import com.suncaper.demo.entity.KnrdExample;
import java.util.List;

import com.suncaper.demo.mapper.exend.KnrdExtendMapper;
import org.apache.ibatis.annotations.Param;

public interface KnrdMapper extends KnrdExtendMapper {
    long countByExample(KnrdExample example);

    int deleteByExample(KnrdExample example);

    int insert(Knrd record);

    int insertSelective(Knrd record);

    List<Knrd> selectByExample(KnrdExample example);

    int updateByExampleSelective(@Param("record") Knrd record, @Param("example") KnrdExample example);

    int updateByExample(@Param("record") Knrd record, @Param("example") KnrdExample example);
}