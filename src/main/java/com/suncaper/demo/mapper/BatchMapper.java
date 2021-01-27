package com.suncaper.demo.mapper;

import com.suncaper.demo.entity.Batch;
import com.suncaper.demo.entity.BatchExample;
import java.util.List;

import com.suncaper.demo.mapper.exend.BatchExtendMapper;
import org.apache.ibatis.annotations.Param;

public interface BatchMapper extends BatchExtendMapper {
    long countByExample(BatchExample example);

    int deleteByExample(BatchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Batch record);

    int insertSelective(Batch record);

    List<Batch> selectByExample(BatchExample example);

    Batch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Batch record, @Param("example") BatchExample example);

    int updateByExample(@Param("record") Batch record, @Param("example") BatchExample example);

    int updateByPrimaryKeySelective(Batch record);

    int updateByPrimaryKey(Batch record);
}