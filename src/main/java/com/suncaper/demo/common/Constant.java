package com.suncaper.demo.common;

public interface Constant {
    //
    Integer FLAG_TRUE=1;
    //批次状态确认激活
    Integer ACTIVE_FLAG_TRUE=1;
    //批次状态确认注销
    Integer ACTIVE_FLAG_FALSE=0;
    //逻辑未删除 0
    Integer IS_DELETED_0=0;
    //数据字典：困难等级类型
    String DIFFICULTY_TYPE="DIFFICULTY";
    //数据字典：性别
    String GENDER_TYPE="GENDER";
    //数据字典：审核状态
    String STATUS_TYPE="STATUS";
    //分页初始化
    Integer PAGENUM_INIT=1;
    Integer PAGESIZE_INIT=5;

    //学生权限id
    Long ROLE_ID_SUTDENT=1L;
    Long ROLE_ID_TEACHER=4L;
    Long ROLE_ID_COLLEGE=3L;
    Long ROLE_ID_SCHOOL=2L;
    //困难等级
    String DIFFICUTY_BKN="不困难";
    String DIFFICUTY_YBKN="一般困难";
    String DIFFICUTY_TSKN="特殊困难";
    //学生性别
    String GENDER_MALE="男性";
    String GENDER_FAMALE="女性";
    String GENDER_MAN="M";
    String GENDER_FAMAN="F";
    String GENDER_MAN_AND_FAMAN="MF";
    //审核节点
    Integer ROLE_NODE_1=1;
    Integer ROLE_NODE_2=2;
    Integer ROLE_NODE_3=3;
    Integer ROLE_NODE_4=4;
    //审核状态--待审核,通过，不通过
    String STATUS_DSH="DSH";
    String STATUS_TG="TG";
    String STATUS_BTG="BTG";

    //每次减少库存的常量
    Integer STOCK_CONSTANT = 1;

}
