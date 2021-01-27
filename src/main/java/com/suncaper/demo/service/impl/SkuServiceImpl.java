package com.suncaper.demo.service.impl;

import com.suncaper.demo.entity.Image;
import com.suncaper.demo.entity.Sku;
import com.suncaper.demo.entity.SkuExample;
import com.suncaper.demo.mapper.SkuMapper;
import com.suncaper.demo.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuMapper skuMapper;
    @Override
    public void batchInsert(List<Sku> skus) {
        skuMapper.batchInsert(skus);
    }

    @Override
    public List<Sku> listByProductId(Long id) {
        SkuExample example = new SkuExample();
        example.createCriteria().andProductIdEqualTo(id);
        return skuMapper.selectByExample(example);
    }

    @Override
    public void deleteByExample(SkuExample skuExample) {
        skuMapper.deleteByExample(skuExample);
    }

    @Override
    public Long selectIdByName(String x, Long productId) {
        return skuMapper.selectIdByName(x,productId);
    }
}
