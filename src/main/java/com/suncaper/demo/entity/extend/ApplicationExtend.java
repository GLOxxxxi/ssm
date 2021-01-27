package com.suncaper.demo.entity.extend;

import com.suncaper.demo.entity.Batch;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)//表示实体支持链式写法 用链式不能有getset的方法
public class ApplicationExtend {
    private Batch batch;
    private String difValue;
    private String statusValue;
}
