package com.suncaper.demo.entity;

import com.suncaper.demo.entity.extend.BatchExtend;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class Batch extends BatchExtend {
    private Long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate applicationStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate applicationEndDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registerStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registerEndDate;
    private String difficultyLevel;

    private Integer isDeleted;

    private Integer active;

    private Date gmtCreated;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public LocalDate getApplicationStartDate() {
        return applicationStartDate;
    }

    public void setApplicationStartDate(LocalDate applicationStartDate) {
        this.applicationStartDate = applicationStartDate;
    }

    public LocalDate getApplicationEndDate() {
        return applicationEndDate;
    }

    public void setApplicationEndDate(LocalDate applicationEndDate) {
        this.applicationEndDate = applicationEndDate;
    }

    public LocalDate getRegisterStartDate() {
        return registerStartDate;
    }

    public void setRegisterStartDate(LocalDate registerStartDate) {
        this.registerStartDate = registerStartDate;
    }

    public LocalDate getRegisterEndDate() {
        return registerEndDate;
    }

    public void setRegisterEndDate(LocalDate registerEndDate) {
        this.registerEndDate = registerEndDate;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel == null ? null : difficultyLevel.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}