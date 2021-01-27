package com.suncaper.demo.service;

import com.suncaper.demo.entity.Stock;

import java.util.List;

public interface StockService {
    void insert(List<Stock> stocks);

    void updateStock(Stock stock);

    List<Stock> listByProductId(Long id);

    List<Stock> getCurStock(Long skuId);

    void updateStockById(Stock stock);
}
