package com.suncaper.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuditHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuditHistoryExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNull() {
            addCriterion("application_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNotNull() {
            addCriterion("application_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdEqualTo(Long value) {
            addCriterion("application_id =", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotEqualTo(Long value) {
            addCriterion("application_id <>", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThan(Long value) {
            addCriterion("application_id >", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("application_id >=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThan(Long value) {
            addCriterion("application_id <", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThanOrEqualTo(Long value) {
            addCriterion("application_id <=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIn(List<Long> values) {
            addCriterion("application_id in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotIn(List<Long> values) {
            addCriterion("application_id not in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdBetween(Long value1, Long value2) {
            addCriterion("application_id between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotBetween(Long value1, Long value2) {
            addCriterion("application_id not between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andAuditByIsNull() {
            addCriterion("audit_by is null");
            return (Criteria) this;
        }

        public Criteria andAuditByIsNotNull() {
            addCriterion("audit_by is not null");
            return (Criteria) this;
        }

        public Criteria andAuditByEqualTo(String value) {
            addCriterion("audit_by =", value, "auditBy");
            return (Criteria) this;
        }

        public Criteria andAuditByNotEqualTo(String value) {
            addCriterion("audit_by <>", value, "auditBy");
            return (Criteria) this;
        }

        public Criteria andAuditByGreaterThan(String value) {
            addCriterion("audit_by >", value, "auditBy");
            return (Criteria) this;
        }

        public Criteria andAuditByGreaterThanOrEqualTo(String value) {
            addCriterion("audit_by >=", value, "auditBy");
            return (Criteria) this;
        }

        public Criteria andAuditByLessThan(String value) {
            addCriterion("audit_by <", value, "auditBy");
            return (Criteria) this;
        }

        public Criteria andAuditByLessThanOrEqualTo(String value) {
            addCriterion("audit_by <=", value, "auditBy");
            return (Criteria) this;
        }

        public Criteria andAuditByLike(String value) {
            addCriterion("audit_by like", value, "auditBy");
            return (Criteria) this;
        }

        public Criteria andAuditByNotLike(String value) {
            addCriterion("audit_by not like", value, "auditBy");
            return (Criteria) this;
        }

        public Criteria andAuditByIn(List<String> values) {
            addCriterion("audit_by in", values, "auditBy");
            return (Criteria) this;
        }

        public Criteria andAuditByNotIn(List<String> values) {
            addCriterion("audit_by not in", values, "auditBy");
            return (Criteria) this;
        }

        public Criteria andAuditByBetween(String value1, String value2) {
            addCriterion("audit_by between", value1, value2, "auditBy");
            return (Criteria) this;
        }

        public Criteria andAuditByNotBetween(String value1, String value2) {
            addCriterion("audit_by not between", value1, value2, "auditBy");
            return (Criteria) this;
        }

        public Criteria andAuditorNameIsNull() {
            addCriterion("auditor_name is null");
            return (Criteria) this;
        }

        public Criteria andAuditorNameIsNotNull() {
            addCriterion("auditor_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorNameEqualTo(String value) {
            addCriterion("auditor_name =", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameNotEqualTo(String value) {
            addCriterion("auditor_name <>", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameGreaterThan(String value) {
            addCriterion("auditor_name >", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameGreaterThanOrEqualTo(String value) {
            addCriterion("auditor_name >=", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameLessThan(String value) {
            addCriterion("auditor_name <", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameLessThanOrEqualTo(String value) {
            addCriterion("auditor_name <=", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameLike(String value) {
            addCriterion("auditor_name like", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameNotLike(String value) {
            addCriterion("auditor_name not like", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameIn(List<String> values) {
            addCriterion("auditor_name in", values, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameNotIn(List<String> values) {
            addCriterion("auditor_name not in", values, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameBetween(String value1, String value2) {
            addCriterion("auditor_name between", value1, value2, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameNotBetween(String value1, String value2) {
            addCriterion("auditor_name not between", value1, value2, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditCommentIsNull() {
            addCriterion("audit_comment is null");
            return (Criteria) this;
        }

        public Criteria andAuditCommentIsNotNull() {
            addCriterion("audit_comment is not null");
            return (Criteria) this;
        }

        public Criteria andAuditCommentEqualTo(String value) {
            addCriterion("audit_comment =", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotEqualTo(String value) {
            addCriterion("audit_comment <>", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentGreaterThan(String value) {
            addCriterion("audit_comment >", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentGreaterThanOrEqualTo(String value) {
            addCriterion("audit_comment >=", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentLessThan(String value) {
            addCriterion("audit_comment <", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentLessThanOrEqualTo(String value) {
            addCriterion("audit_comment <=", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentLike(String value) {
            addCriterion("audit_comment like", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotLike(String value) {
            addCriterion("audit_comment not like", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentIn(List<String> values) {
            addCriterion("audit_comment in", values, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotIn(List<String> values) {
            addCriterion("audit_comment not in", values, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentBetween(String value1, String value2) {
            addCriterion("audit_comment between", value1, value2, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotBetween(String value1, String value2) {
            addCriterion("audit_comment not between", value1, value2, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditNodeCodeIsNull() {
            addCriterion("audit_node_code is null");
            return (Criteria) this;
        }

        public Criteria andAuditNodeCodeIsNotNull() {
            addCriterion("audit_node_code is not null");
            return (Criteria) this;
        }

        public Criteria andAuditNodeCodeEqualTo(Integer value) {
            addCriterion("audit_node_code =", value, "auditNodeCode");
            return (Criteria) this;
        }

        public Criteria andAuditNodeCodeNotEqualTo(Integer value) {
            addCriterion("audit_node_code <>", value, "auditNodeCode");
            return (Criteria) this;
        }

        public Criteria andAuditNodeCodeGreaterThan(Integer value) {
            addCriterion("audit_node_code >", value, "auditNodeCode");
            return (Criteria) this;
        }

        public Criteria andAuditNodeCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_node_code >=", value, "auditNodeCode");
            return (Criteria) this;
        }

        public Criteria andAuditNodeCodeLessThan(Integer value) {
            addCriterion("audit_node_code <", value, "auditNodeCode");
            return (Criteria) this;
        }

        public Criteria andAuditNodeCodeLessThanOrEqualTo(Integer value) {
            addCriterion("audit_node_code <=", value, "auditNodeCode");
            return (Criteria) this;
        }

        public Criteria andAuditNodeCodeIn(List<Integer> values) {
            addCriterion("audit_node_code in", values, "auditNodeCode");
            return (Criteria) this;
        }

        public Criteria andAuditNodeCodeNotIn(List<Integer> values) {
            addCriterion("audit_node_code not in", values, "auditNodeCode");
            return (Criteria) this;
        }

        public Criteria andAuditNodeCodeBetween(Integer value1, Integer value2) {
            addCriterion("audit_node_code between", value1, value2, "auditNodeCode");
            return (Criteria) this;
        }

        public Criteria andAuditNodeCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_node_code not between", value1, value2, "auditNodeCode");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameIsNull() {
            addCriterion("audit_node_name is null");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameIsNotNull() {
            addCriterion("audit_node_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameEqualTo(String value) {
            addCriterion("audit_node_name =", value, "auditNodeName");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameNotEqualTo(String value) {
            addCriterion("audit_node_name <>", value, "auditNodeName");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameGreaterThan(String value) {
            addCriterion("audit_node_name >", value, "auditNodeName");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("audit_node_name >=", value, "auditNodeName");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameLessThan(String value) {
            addCriterion("audit_node_name <", value, "auditNodeName");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameLessThanOrEqualTo(String value) {
            addCriterion("audit_node_name <=", value, "auditNodeName");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameLike(String value) {
            addCriterion("audit_node_name like", value, "auditNodeName");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameNotLike(String value) {
            addCriterion("audit_node_name not like", value, "auditNodeName");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameIn(List<String> values) {
            addCriterion("audit_node_name in", values, "auditNodeName");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameNotIn(List<String> values) {
            addCriterion("audit_node_name not in", values, "auditNodeName");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameBetween(String value1, String value2) {
            addCriterion("audit_node_name between", value1, value2, "auditNodeName");
            return (Criteria) this;
        }

        public Criteria andAuditNodeNameNotBetween(String value1, String value2) {
            addCriterion("audit_node_name not between", value1, value2, "auditNodeName");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}