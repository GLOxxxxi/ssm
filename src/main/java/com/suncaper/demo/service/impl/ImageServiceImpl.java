package com.suncaper.demo.service.impl;

import com.suncaper.demo.entity.Image;
import com.suncaper.demo.entity.ImageExample;
import com.suncaper.demo.mapper.ImageMapper;
import com.suncaper.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;
    @Override
    public void insert(List<Image> images) {
        images.stream().forEach(x->imageMapper.insertSelective(x));
    }

    @Override
    public List<Image> listByProductId(Long id) {
        ImageExample example = new ImageExample();
        example.createCriteria().andProductIdEqualTo(id);

        return imageMapper.selectByExample(example);
    }

    @Override
    public void deleteByExample(ImageExample imgExample) {
        imageMapper.deleteByExample(imgExample);
    }
}
