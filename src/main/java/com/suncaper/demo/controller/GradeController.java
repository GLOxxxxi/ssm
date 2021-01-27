package com.suncaper.demo.controller;

import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.entity.Grade;
import com.suncaper.demo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @RequestMapping("selectById")
    @ResponseBody
    public JsonResult selectById(Long id){
        return JsonResult.ok(gradeService.selectById(id));
    }

    @RequestMapping("selectGradeBySn")
    @ResponseBody
    public JsonResult selectGradeBySn(String sn){
        String grade = gradeService.selectGradeBySn(sn);
        return JsonResult.ok(grade);
    }

    @RequestMapping("selectAllGradeBySn")
    @ResponseBody
    public JsonResult selectAllGradeBySn(){
        List<Grade> grades = gradeService.selectAllGradeBySn();
        return JsonResult.ok(grades);
    }
}
