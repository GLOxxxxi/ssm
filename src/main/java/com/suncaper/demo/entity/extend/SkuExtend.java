package com.suncaper.demo.entity.extend;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SkuExtend {
    private Integer skuTotal;
    private Integer curStock;
}
