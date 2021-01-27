package com.suncaper.demo.mapper;

import com.suncaper.demo.entity.AuditHistory;
import com.suncaper.demo.entity.AuditHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuditHistoryMapper {
    long countByExample(AuditHistoryExample example);

    int deleteByExample(AuditHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuditHistory record);

    int insertSelective(AuditHistory record);

    List<AuditHistory> selectByExample(AuditHistoryExample example);

    AuditHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuditHistory record, @Param("example") AuditHistoryExample example);

    int updateByExample(@Param("record") AuditHistory record, @Param("example") AuditHistoryExample example);

    int updateByPrimaryKeySelective(AuditHistory record);

    int updateByPrimaryKey(AuditHistory record);
}