package com.suncaper.demo.controller;

import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.entity.Dictionary;
import com.suncaper.demo.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;
    //获取数据字典的值
    @RequestMapping(value = "getDictionary",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getDictionary(Dictionary dictionary){
        return JsonResult.ok(dictionaryService.getDictionary(dictionary)) ;
    }
}
