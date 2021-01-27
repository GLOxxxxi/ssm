package com.suncaper.demo.controller;

import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.service.KnrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("knrd")
public class KnrdController {
    @Autowired
    private KnrdService knrdService;
    @RequestMapping("selectGrade")
    @ResponseBody
    public JsonResult selectGrade(){
        return JsonResult.ok(knrdService.selectGrade());
    }
}
