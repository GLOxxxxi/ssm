package com.suncaper.demo.mapper.exend;

import com.suncaper.demo.entity.Application;
import com.suncaper.demo.entity.vo.StatisticsVO;

import java.util.List;

public interface ApplicationExtendMapper {

    StatisticsVO statistics(String collegeName);

    List<Application> selectCollegeName();

    StatisticsVO statisticsAll();
}
