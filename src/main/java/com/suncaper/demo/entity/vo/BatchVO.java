package com.suncaper.demo.entity.vo;

import com.suncaper.demo.entity.Batch;

public class BatchVO extends Batch {
    private String difficultyValue;//将TSKN-->转为特殊困难

    public BatchVO(Batch batch){
        super.setApplicationStartDate(batch.getApplicationStartDate());
        super.setApplicationEndDate(batch.getApplicationEndDate());
        super.setRegisterStartDate(batch.getRegisterStartDate());
        super.setRegisterEndDate(batch.getRegisterEndDate());
        super.setName(batch.getName());
        super.setActive(batch.getActive());
    }
    public String getDifficultyValue() {
        return difficultyValue;
    }

    public void setDifficultyValue(String difficultyValue) {
        this.difficultyValue = difficultyValue;
    }
}
