package com.suncaper.demo.service;

import com.suncaper.demo.entity.Image;
import com.suncaper.demo.entity.Sku;
import com.suncaper.demo.entity.SkuExample;

import java.util.List;

public interface SkuService {
    void batchInsert(List<Sku> skus);

    List<Sku> listByProductId(Long id);

    void deleteByExample(SkuExample skuExample);

    Long selectIdByName(String x, Long id);
}
