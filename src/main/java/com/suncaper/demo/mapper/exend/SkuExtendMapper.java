package com.suncaper.demo.mapper.exend;

import com.suncaper.demo.entity.Sku;
import com.suncaper.demo.mapper.SkuMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuExtendMapper  {
    void batchInsert(@Param("skus") List<Sku> skus);

    Long selectIdByName(@Param("skuName") String x,@Param("productId") Long productId);
}
