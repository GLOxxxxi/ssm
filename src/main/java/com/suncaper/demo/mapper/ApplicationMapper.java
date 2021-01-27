package com.suncaper.demo.mapper;

import com.suncaper.demo.entity.Application;
import com.suncaper.demo.entity.ApplicationExample;
import java.util.List;

import com.suncaper.demo.mapper.exend.ApplicationExtendMapper;
import org.apache.ibatis.annotations.Param;

public interface ApplicationMapper extends ApplicationExtendMapper {
    long countByExample(ApplicationExample example);

    int deleteByExample(ApplicationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Application record);

    int insertSelective(Application record);

    List<Application> selectByExample(ApplicationExample example);

    Application selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Application record, @Param("example") ApplicationExample example);

    int updateByExample(@Param("record") Application record, @Param("example") ApplicationExample example);

    int updateByPrimaryKeySelective(Application record);

    int updateByPrimaryKey(Application record);
}