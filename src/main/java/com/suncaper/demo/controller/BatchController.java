package com.suncaper.demo.controller;

import com.github.pagehelper.PageInfo;
import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.entity.Batch;
import com.suncaper.demo.entity.dto.BatchDTO;
import com.suncaper.demo.entity.extend.BatchExtend;
import com.suncaper.demo.entity.vo.BatchVO;
import com.suncaper.demo.mapper.BatchMapper;
import com.suncaper.demo.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    private BatchService batchService;
    @RequestMapping("toBatchList")
    public String batchList(){
        return "batchList";
    }

    /**
     * 查询是否存在已激活的批次
     * @return 存在激活的批次的实体或者null
     */
    @RequestMapping("getActiveBatch")
    @ResponseBody
    public JsonResult getActiveBatch(Batch batch){
        List<Batch> batches = batchService.getActiveBatch(batch);
        if(!batches.isEmpty()){
            return JsonResult.ok(batchService.getActiveBatch(batch).get(0));
        }
       return JsonResult.ok(null);

    }

    /**
     * 遍历批次列表
     * @param batchDTO
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(BatchDTO batchDTO, Model model){
        PageInfo<Batch> pageInfo = batchService.list(batchDTO);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("batch",batchDTO);
//        model.addAttribute("active",batchDTO.getActive());
//        model.addAttribute("difficultyLevel",batchDTO.getDifficultyLevel());
        return "batchList";
    }

    /**
     * 新建批次
     * @param batch
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public String save(Batch batch){
        if(batchService.save(batch)!=0){
            return "succ";
        }
        return "fail";
    }
    @RequestMapping("end")
    @ResponseBody
    public JsonResult end(Long id){
        batchService.end(id);
        return JsonResult.ok(true);
    }

    /**
     * 批次删除
     * @param ids
     * @return json
     */
    @RequestMapping(value = "deletes",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult deletes(@RequestParam("ids[]") List<Long> ids){
        System.out.println(ids);
        batchService.deletes(ids);
        return JsonResult.ok(true);
    }

    @RequestMapping(value = "listByAjax",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult listByAjax(){
        List<Batch> list=batchService.lilistByAjax();
        return JsonResult.ok(list);
    }
}
