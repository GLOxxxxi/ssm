package com.suncaper.demo.entity.extend;

import com.suncaper.demo.entity.Grade;
import lombok.Data;

import java.util.List;

@Data
public class BatchExtend  {
    private String difVal;
    private List<String> gradeName;

}
