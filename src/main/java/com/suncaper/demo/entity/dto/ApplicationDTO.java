package com.suncaper.demo.entity.dto;

import com.suncaper.demo.entity.Application;
import lombok.Data;

@Data
public class ApplicationDTO extends Application {
    private Integer pageNum;
    private Integer pageSize;
}
