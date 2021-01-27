package com.suncaper.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suncaper.demo.common.Constant;
import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.entity.Batch;
import com.suncaper.demo.entity.BatchExample;
import com.suncaper.demo.entity.Grade;
import com.suncaper.demo.entity.dto.BatchDTO;
import com.suncaper.demo.entity.vo.BatchVO;
import com.suncaper.demo.mapper.BatchMapper;
import com.suncaper.demo.service.BatchService;
import com.suncaper.demo.service.DictionaryService;
import com.suncaper.demo.service.GradeService;
import com.suncaper.demo.service.KnrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    private BatchMapper batchMapper;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private KnrdService knrdService;
    @Autowired
    private GradeService gradeService;

    @Override
    public List<Batch> getActiveBatch(Batch batch) {
        BatchExample example = new BatchExample();
        example.createCriteria().andNameEqualTo(batch.getName());
        List<Batch> batches = batchMapper.selectByExample(example);
        return batches;
    }

    @Override
    public PageInfo<Batch> list(BatchDTO batch) {
        BatchExample example = new BatchExample();
        BatchExample.Criteria criteria = example.createCriteria();
        //判断是否有条件
        if (batch.getActive() != null && !"".equals(batch.getActive())) {
            criteria.andActiveEqualTo(batch.getActive());
        }

        if (batch.getDifficultyLevel() != null && !"".equals(batch.getDifficultyLevel())) {
            criteria.andDifficultyLevelEqualTo(batch.getDifficultyLevel());
        }
        if (batch.getName() != null && !"".equals(batch.getName())) {
            criteria.andNameLike(batch.getName());
        }
        criteria.andIsDeletedEqualTo(Constant.IS_DELETED_0);
        example.setOrderByClause("id desc");
        PageHelper.startPage(batch.getPageNum(), batch.getPageSize());
        List<Batch> batches = batchMapper.selectByExample(example);
        PageInfo<Batch> pageInfo = new PageInfo<>(batches);
        //       List<BatchVO> batchVOS=new ArrayList<>();
//        for(Batch batch1:batches){
//            BatchVO batchVO=new BatchVO(batch1);
//            batchVO.setDifficultyValue(dictionaryService.getNameByTypeAndValue(Constant.DIFFICULTY_TYPE,batch1.getDifficultyLevel()));
//            batchVOS.add(batchVO);
//        }
        /*---------------------------- */
//        List<BatchVO> collect = batches.stream().map(x -> {
//            BatchVO batchVO = new BatchVO(x);
//            batchVO.setDifficultyValue(dictionaryService.getNameByTypeAndValue(Constant.DIFFICULTY_TYPE, x.getDifficultyLevel()));
//            return batchVO;
//        }).collect(Collectors.toList());
//
        pageInfo.getList().stream().forEach(x ->
                x.setDifVal(dictionaryService.getNameByTypeAndValue(Constant.DIFFICULTY_TYPE, x.getDifficultyLevel()))
        );
        return pageInfo;
    }

    @Override
    public Integer save(Batch batch) {
        batch.setActive(Constant.ACTIVE_FLAG_TRUE);
        batchMapper.insertSelective(batch);
        //添加年级控制
        List<String> gradeName = batch.getGradeName();
        List<Grade> grades=gradeName.stream().map(x->{
            //不调用数据库拿不到batchId
            Grade grade = new Grade();
            grade.setBatchId(batchMapper.selectIdByName(batch.getName()));
            grade.setBatchName(batch.getName());
            grade.setGradeName(x);
            return grade;
        }).collect(Collectors.toList());
        gradeService.gradeInsert(grades);
        return Constant.FLAG_TRUE;
    }

    @Override
    public void end(Long id) {
        Batch batch = new Batch();
        batch.setId(id);
        batch.setActive(Constant.ACTIVE_FLAG_FALSE);
        batchMapper.updateByPrimaryKeySelective(batch);

    }

    @Override
    public void deletes(List<Long> ids) {
        ids.add(-1L);//防止ids容量为0
        batchMapper.deletes(ids);
    }

    @Override
    public List<Batch> lilistByAjax() {
        BatchExample example = new BatchExample();
        BatchExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(Constant.IS_DELETED_0);
        example.setOrderByClause("id desc");
        return batchMapper.selectByExample(example);
    }

    @Override
    public Batch selectByPrimaryKey(Long batchId) {
        return batchMapper.selectByPrimaryKey(batchId);
    }

    @Override
    public Batch getCurBatch() {
        BatchExample example = new BatchExample();
        BatchExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(Constant.IS_DELETED_0).andActiveEqualTo(Constant.ACTIVE_FLAG_TRUE);
        List<Batch> list = batchMapper.selectByExample(example);
        Batch batch = null;
        if(list.size()==0){
            //如果拿不到激活的批次，那最近的批次
            BatchExample exampleLast = new BatchExample();
            exampleLast.createCriteria().andIsDeletedEqualTo(Constant.IS_DELETED_0);
            exampleLast.setOrderByClause("id desc");
            List<Batch> listLast = batchMapper.selectByExample(exampleLast);
            return listLast.size()==0?new Batch():listLast.get(0);
        }
        batch= list.get(0);
        batch.setDifVal(dictionaryService.getNameByTypeAndValue(Constant.DIFFICULTY_TYPE, batch.getDifficultyLevel()));

        return batch;
    }
}
