package com.suncaper.demo.mapper;

import com.suncaper.demo.entity.FlowSetting;
import com.suncaper.demo.entity.FlowSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowSettingMapper {
    long countByExample(FlowSettingExample example);

    int deleteByExample(FlowSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlowSetting record);

    int insertSelective(FlowSetting record);

    List<FlowSetting> selectByExample(FlowSettingExample example);

    FlowSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FlowSetting record, @Param("example") FlowSettingExample example);

    int updateByExample(@Param("record") FlowSetting record, @Param("example") FlowSettingExample example);

    int updateByPrimaryKeySelective(FlowSetting record);

    int updateByPrimaryKey(FlowSetting record);
}