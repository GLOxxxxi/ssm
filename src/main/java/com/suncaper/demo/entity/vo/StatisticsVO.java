package com.suncaper.demo.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StatisticsVO {
    private Integer allCount;
    private Integer passCount;
    private Integer noPassCount;
    private Integer waitCount;
}
