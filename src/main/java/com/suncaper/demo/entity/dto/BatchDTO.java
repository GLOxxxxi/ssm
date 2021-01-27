package com.suncaper.demo.entity.dto;

import com.suncaper.demo.entity.Batch;
import lombok.Data;

@Data
public class BatchDTO extends Batch {
    private Integer pageNum;
    private Integer pageSize;

}
