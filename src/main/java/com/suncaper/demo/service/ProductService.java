package com.suncaper.demo.service;

import com.github.pagehelper.PageInfo;
import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.entity.Image;
import com.suncaper.demo.entity.Product;
import com.suncaper.demo.entity.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void insert(ProductDTO product, List<Image> images);

    PageInfo<Product> list(ProductDTO product);

    JsonResult deleteById(Long id);

    JsonResult selectById(Long id);

    void update(ProductDTO product, List<Image> collect);

    PageInfo<Product> myList(ProductDTO productDTO);
}
