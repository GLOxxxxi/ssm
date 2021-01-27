package com.suncaper.demo.mapper;

import com.suncaper.demo.entity.Sku;
import com.suncaper.demo.entity.SkuExample;
import java.util.List;

import com.suncaper.demo.mapper.exend.SkuExtendMapper;
import org.apache.ibatis.annotations.Param;

public interface SkuMapper extends SkuExtendMapper{
    long countByExample(SkuExample example);

    int deleteByExample(SkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sku record);

    int insertSelective(Sku record);

    List<Sku> selectByExample(SkuExample example);

    Sku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sku record, @Param("example") SkuExample example);

    int updateByExample(@Param("record") Sku record, @Param("example") SkuExample example);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);
}