package com.suncaper.demo.entity;

import java.util.Date;

public class AuditHistory {
    private Long id;

    private Long applicationId;

    private String auditBy;

    private String auditorName;

    private String auditComment;

    private Integer auditNodeCode;

    private String auditNodeName;

    private Boolean isDeleted;

    private String status;

    private Date gmtCreated;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getAuditBy() {
        return auditBy;
    }

    public void setAuditBy(String auditBy) {
        this.auditBy = auditBy == null ? null : auditBy.trim();
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName == null ? null : auditorName.trim();
    }

    public String getAuditComment() {
        return auditComment;
    }

    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment == null ? null : auditComment.trim();
    }

    public Integer getAuditNodeCode() {
        return auditNodeCode;
    }

    public void setAuditNodeCode(Integer auditNodeCode) {
        this.auditNodeCode = auditNodeCode;
    }

    public String getAuditNodeName() {
        return auditNodeName;
    }

    public void setAuditNodeName(String auditNodeName) {
        this.auditNodeName = auditNodeName == null ? null : auditNodeName.trim();
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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