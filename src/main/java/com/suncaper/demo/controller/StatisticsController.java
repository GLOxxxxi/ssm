package com.suncaper.demo.controller;

import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.entity.Application;
import com.suncaper.demo.entity.Knrd;
import com.suncaper.demo.entity.vo.StatisticsVO;
import com.suncaper.demo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private ApplicationService applicationService;
    @RequestMapping("list")
    public String statistics(Model model, Application application){
        StatisticsVO statisticsVO=applicationService.statistics(application);
        model.addAttribute("msg",statisticsVO);
        model.addAttribute("applications",application);
        return "statistics";
    }
    @RequestMapping("collegeStatistics")
    @ResponseBody
    private JsonResult collegeStatistics(){
        return JsonResult.ok(applicationService.collegeStatistics());
    }
    @RequestMapping("getStatisticsVO")
    @ResponseBody
    public JsonResult getStatisticsVO(Application application) {
        return JsonResult.ok(applicationService.statistics(application));
    }
}
