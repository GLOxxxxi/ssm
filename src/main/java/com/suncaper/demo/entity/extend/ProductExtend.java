package com.suncaper.demo.entity.extend;

import com.suncaper.demo.entity.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
@Data
@Accessors(chain = true)//表示实体支持链式写法
public class ProductExtend  {
    private List<Image> images;
    private List<Sku> skus;
    private Batch batch;
    private String sexValue;
    private List<Grade> gradeName;
    private List<Stock> stocks;
}
