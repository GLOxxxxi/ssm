package com.suncaper.demo.service;

import com.suncaper.demo.entity.Image;
import com.suncaper.demo.entity.ImageExample;

import java.util.List;

public interface ImageService {
    void insert(List<Image> images);

    List<Image> listByProductId(Long id);

    void deleteByExample(ImageExample imgExample);
}
