package com.suncaper.demo.entity;

import com.suncaper.demo.entity.extend.ApplicationExtend;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@Accessors(chain = true)//表示实体支持链式写法
public class Application extends ApplicationExtend {
    private Long id;

    private Long batchId;

    private Long skuId;

    private Long productId;

    private String sn;

    private String name;

    private String gender;

    private Date applyDate;

    private String collegeSn;

    private String collegeName;

    private String majorSn;

    private String majorName;

    private String classSn;

    private String className;

    private String difficultyLevel;

    private String applicationReason;

    private String auditComment;

    private Integer currentNodeCode;

    private String status;

    private Date gmtCreated;

    private Date gmtModified;


}