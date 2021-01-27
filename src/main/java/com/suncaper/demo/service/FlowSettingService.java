package com.suncaper.demo.service;

import com.suncaper.demo.entity.FlowSetting;

public interface FlowSettingService {
    String getNameByCode(Integer currentNodeCode);

    FlowSetting getNextNode(Integer currentNodeCode);
}
