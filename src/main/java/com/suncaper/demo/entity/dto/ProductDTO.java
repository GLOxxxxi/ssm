package com.suncaper.demo.entity.dto;

import com.suncaper.demo.entity.Product;
import lombok.Data;

import java.util.List;
@Data
public class ProductDTO extends Product {
    private List<String> skuName;
    private Integer pageNum;
    private Integer pageSize;
    private List<String> oldImg;
    private List<Integer> skuTotal;
    private List<Integer>curStock;
}
