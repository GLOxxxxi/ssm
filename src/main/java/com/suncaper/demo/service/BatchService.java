package com.suncaper.demo.service;

import com.github.pagehelper.PageInfo;
import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.entity.Batch;
import com.suncaper.demo.entity.dto.BatchDTO;
import com.suncaper.demo.entity.vo.BatchVO;

import java.util.List;

public interface BatchService {
    List<Batch> getActiveBatch(Batch batch);

    PageInfo<Batch> list(BatchDTO batch);

    Integer save(Batch batch);

    void end(Long id);

    void deletes(List<Long> ids);

    List<Batch> lilistByAjax();

    Batch selectByPrimaryKey(Long batchId);
    //获取当前批次
    Batch getCurBatch();
}
