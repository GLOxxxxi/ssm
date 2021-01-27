package com.suncaper.demo.controller;

import com.github.pagehelper.PageInfo;
import com.suncaper.demo.common.Constant;
import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.entity.Application;
import com.suncaper.demo.entity.AuditHistory;
import com.suncaper.demo.entity.Stock;
import com.suncaper.demo.entity.StockExample;
import com.suncaper.demo.entity.dto.ApplicationDTO;
import com.suncaper.demo.service.ApplicationService;
import com.suncaper.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private StockService stockService;

    @RequestMapping("toApplicationAdd")
    public String toApplicationAdd(){
        return "applicationAdd";
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult insert (Application application){

        //判断当前批次该用户已有申请
        Boolean flag = applicationService.getCurApp();
        if(flag){
            //存在申请
            return JsonResult.ok(flag);
        }else{
            //不存在历史申请插入数据
            applicationService.insert(application);
            return JsonResult.ok(flag);
        }

    }
    @RequestMapping("listBySn")
    public String listBySn(ApplicationDTO applicationDTO, Model model){
        //根据当前用户sn查询获取所有申请
        //分页初始化
        if((applicationDTO.getPageNum()==null||applicationDTO.getPageNum()<0)||(applicationDTO.getPageSize()==null||applicationDTO.getPageSize()<0)){
            applicationDTO.setPageNum(Constant.PAGENUM_INIT);
            applicationDTO.setPageSize(Constant.PAGESIZE_INIT);
        }
        PageInfo<Application> pageInfo = applicationService.listBySn(applicationDTO);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("apps",applicationDTO);
        return "applicationHistory";
    }

    @RequestMapping("waitAudit")
    public String waitAudit(Model model,ApplicationDTO applicationDTO){
        //获取待审核
        //分页初始化
        applicationDTO.setPageNum(Constant.PAGENUM_INIT);
        applicationDTO.setPageSize(Constant.PAGESIZE_INIT);
        PageInfo<Application> pageInfo = applicationService.waitAudit(applicationDTO);
        model.addAttribute("pageInfo",pageInfo);
        return "waitAudit";
    }

    @RequestMapping("audit")
    @ResponseBody
    private JsonResult audit(AuditHistory auditHistory){
        applicationService.audit(auditHistory);
        return JsonResult.ok(true);
    }

    @RequestMapping("details")
    @ResponseBody
    private JsonResult details (Long id){
        return applicationService.details(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public JsonResult update(Application application) {
        //得到两个值   skuId productId
        applicationService.update(application);
        //获取当前编码的库存
        List<Stock> stocks = stockService.getCurStock(application.getSkuId());
        Integer curStock = stocks.get(0).getCurStock();
        Stock stock =new Stock();
        curStock=curStock-Constant.STOCK_CONSTANT;
        stock.setCurStock(curStock);
        stock.setSkuId(application.getSkuId());
        stockService.updateStockById(stock);
        return JsonResult.ok(true);
    }

    //导出
    @RequestMapping("export")
    @ResponseBody
    public void export(HttpServletResponse response) {
        applicationService.export(response);
    }
}
