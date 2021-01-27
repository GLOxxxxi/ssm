package com.suncaper.demo.service.impl;

import com.suncaper.demo.entity.Stock;
import com.suncaper.demo.entity.StockExample;
import com.suncaper.demo.mapper.StockMapper;
import com.suncaper.demo.service.StockService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    @Override
    public void insert(List<Stock> stocks) {
        stocks.stream().forEach(x->stockMapper.insertSelective(x));
    }

    @Override
    public void updateStock(Stock stock) {
        StockExample example = new StockExample();
        example.createCriteria().andSkuNameEqualTo(stock.getSkuName());
        stockMapper.updateByExampleSelective(stock,example);

    }
    public void updateStockById(Stock stock) {
        StockExample example = new StockExample();
        example.createCriteria().andSkuIdEqualTo(stock.getSkuId());
        stockMapper.updateByExampleSelective(stock,example);
    }


    @Override
    public List<Stock> listByProductId(Long id) {
        StockExample example = new StockExample();
        example.createCriteria().andProductIdEqualTo(id);
        return stockMapper.selectByExample(example);
    }

    @Override
    public List<Stock> getCurStock(Long skuId) {
        StockExample example = new StockExample();
        example.createCriteria().andSkuIdEqualTo(skuId);
        return stockMapper.selectByExample(example);
    }
}
