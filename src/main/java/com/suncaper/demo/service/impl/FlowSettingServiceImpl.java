package com.suncaper.demo.service.impl;

import com.suncaper.demo.entity.FlowSetting;
import com.suncaper.demo.entity.FlowSettingExample;
import com.suncaper.demo.mapper.FlowSettingMapper;
import com.suncaper.demo.service.FlowSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowSettingServiceImpl implements FlowSettingService {
    @Autowired
    private FlowSettingMapper flowSettingMapper;
    @Override
    public String getNameByCode(Integer currentNodeCode) {
        //根据code获取当前节点
        FlowSettingExample example = new FlowSettingExample();
        example.createCriteria().andNodeCodeEqualTo(currentNodeCode);
        List<FlowSetting> flowSettings = flowSettingMapper.selectByExample(example);
        return flowSettings.size()==0?null:flowSettings.get(0).getNodeName();
    }

    @Override
    public FlowSetting getNextNode(Integer currentNodeCode) {
        //根据code获取当前节点 kenengwei 0 de code
        FlowSetting nodeByCode = this.getNodeByCode(currentNodeCode);
        if(nodeByCode != null){
            //根据当前节点的下一个节点值获取下一个节点
            FlowSetting nextNode = this.getNodeByCode(nodeByCode.getNextNode());
            return nextNode;
        }
        return null;
    }
    public FlowSetting getNodeByCode(Integer code){
        FlowSettingExample example = new FlowSettingExample();
        example.createCriteria().andNodeCodeEqualTo(code);
        List<FlowSetting> flowSettings = flowSettingMapper.selectByExample(example);
        return flowSettings.size() == 0?null:flowSettings.get(0);
    }
}
