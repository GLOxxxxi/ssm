package com.suncaper.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicationExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andBatchIdIsNull() {
            addCriterion("batch_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNotNull() {
            addCriterion("batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchIdEqualTo(Long value) {
            addCriterion("batch_id =", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotEqualTo(Long value) {
            addCriterion("batch_id <>", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThan(Long value) {
            addCriterion("batch_id >", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThanOrEqualTo(Long value) {
            addCriterion("batch_id >=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThan(Long value) {
            addCriterion("batch_id <", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThanOrEqualTo(Long value) {
            addCriterion("batch_id <=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIn(List<Long> values) {
            addCriterion("batch_id in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotIn(List<Long> values) {
            addCriterion("batch_id not in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdBetween(Long value1, Long value2) {
            addCriterion("batch_id between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotBetween(Long value1, Long value2) {
            addCriterion("batch_id not between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(Long value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Long value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Long value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Long value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Long value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<Long> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<Long> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Long value1, Long value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Long value1, Long value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("sn is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("sn is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("sn like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("sn not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("sn not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNull() {
            addCriterion("apply_date is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(Date value) {
            addCriterionForJDBCDate("apply_date =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("apply_date <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(Date value) {
            addCriterionForJDBCDate("apply_date >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("apply_date >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(Date value) {
            addCriterionForJDBCDate("apply_date <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("apply_date <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<Date> values) {
            addCriterionForJDBCDate("apply_date in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("apply_date not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("apply_date between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("apply_date not between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andCollegeSnIsNull() {
            addCriterion("college_sn is null");
            return (Criteria) this;
        }

        public Criteria andCollegeSnIsNotNull() {
            addCriterion("college_sn is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeSnEqualTo(String value) {
            addCriterion("college_sn =", value, "collegeSn");
            return (Criteria) this;
        }

        public Criteria andCollegeSnNotEqualTo(String value) {
            addCriterion("college_sn <>", value, "collegeSn");
            return (Criteria) this;
        }

        public Criteria andCollegeSnGreaterThan(String value) {
            addCriterion("college_sn >", value, "collegeSn");
            return (Criteria) this;
        }

        public Criteria andCollegeSnGreaterThanOrEqualTo(String value) {
            addCriterion("college_sn >=", value, "collegeSn");
            return (Criteria) this;
        }

        public Criteria andCollegeSnLessThan(String value) {
            addCriterion("college_sn <", value, "collegeSn");
            return (Criteria) this;
        }

        public Criteria andCollegeSnLessThanOrEqualTo(String value) {
            addCriterion("college_sn <=", value, "collegeSn");
            return (Criteria) this;
        }

        public Criteria andCollegeSnLike(String value) {
            addCriterion("college_sn like", value, "collegeSn");
            return (Criteria) this;
        }

        public Criteria andCollegeSnNotLike(String value) {
            addCriterion("college_sn not like", value, "collegeSn");
            return (Criteria) this;
        }

        public Criteria andCollegeSnIn(List<String> values) {
            addCriterion("college_sn in", values, "collegeSn");
            return (Criteria) this;
        }

        public Criteria andCollegeSnNotIn(List<String> values) {
            addCriterion("college_sn not in", values, "collegeSn");
            return (Criteria) this;
        }

        public Criteria andCollegeSnBetween(String value1, String value2) {
            addCriterion("college_sn between", value1, value2, "collegeSn");
            return (Criteria) this;
        }

        public Criteria andCollegeSnNotBetween(String value1, String value2) {
            addCriterion("college_sn not between", value1, value2, "collegeSn");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIsNull() {
            addCriterion("college_name is null");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIsNotNull() {
            addCriterion("college_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeNameEqualTo(String value) {
            addCriterion("college_name =", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotEqualTo(String value) {
            addCriterion("college_name <>", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameGreaterThan(String value) {
            addCriterion("college_name >", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameGreaterThanOrEqualTo(String value) {
            addCriterion("college_name >=", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLessThan(String value) {
            addCriterion("college_name <", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLessThanOrEqualTo(String value) {
            addCriterion("college_name <=", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLike(String value) {
            addCriterion("college_name like", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotLike(String value) {
            addCriterion("college_name not like", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIn(List<String> values) {
            addCriterion("college_name in", values, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotIn(List<String> values) {
            addCriterion("college_name not in", values, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameBetween(String value1, String value2) {
            addCriterion("college_name between", value1, value2, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotBetween(String value1, String value2) {
            addCriterion("college_name not between", value1, value2, "collegeName");
            return (Criteria) this;
        }

        public Criteria andMajorSnIsNull() {
            addCriterion("major_sn is null");
            return (Criteria) this;
        }

        public Criteria andMajorSnIsNotNull() {
            addCriterion("major_sn is not null");
            return (Criteria) this;
        }

        public Criteria andMajorSnEqualTo(String value) {
            addCriterion("major_sn =", value, "majorSn");
            return (Criteria) this;
        }

        public Criteria andMajorSnNotEqualTo(String value) {
            addCriterion("major_sn <>", value, "majorSn");
            return (Criteria) this;
        }

        public Criteria andMajorSnGreaterThan(String value) {
            addCriterion("major_sn >", value, "majorSn");
            return (Criteria) this;
        }

        public Criteria andMajorSnGreaterThanOrEqualTo(String value) {
            addCriterion("major_sn >=", value, "majorSn");
            return (Criteria) this;
        }

        public Criteria andMajorSnLessThan(String value) {
            addCriterion("major_sn <", value, "majorSn");
            return (Criteria) this;
        }

        public Criteria andMajorSnLessThanOrEqualTo(String value) {
            addCriterion("major_sn <=", value, "majorSn");
            return (Criteria) this;
        }

        public Criteria andMajorSnLike(String value) {
            addCriterion("major_sn like", value, "majorSn");
            return (Criteria) this;
        }

        public Criteria andMajorSnNotLike(String value) {
            addCriterion("major_sn not like", value, "majorSn");
            return (Criteria) this;
        }

        public Criteria andMajorSnIn(List<String> values) {
            addCriterion("major_sn in", values, "majorSn");
            return (Criteria) this;
        }

        public Criteria andMajorSnNotIn(List<String> values) {
            addCriterion("major_sn not in", values, "majorSn");
            return (Criteria) this;
        }

        public Criteria andMajorSnBetween(String value1, String value2) {
            addCriterion("major_sn between", value1, value2, "majorSn");
            return (Criteria) this;
        }

        public Criteria andMajorSnNotBetween(String value1, String value2) {
            addCriterion("major_sn not between", value1, value2, "majorSn");
            return (Criteria) this;
        }

        public Criteria andMajorNameIsNull() {
            addCriterion("major_name is null");
            return (Criteria) this;
        }

        public Criteria andMajorNameIsNotNull() {
            addCriterion("major_name is not null");
            return (Criteria) this;
        }

        public Criteria andMajorNameEqualTo(String value) {
            addCriterion("major_name =", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotEqualTo(String value) {
            addCriterion("major_name <>", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameGreaterThan(String value) {
            addCriterion("major_name >", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameGreaterThanOrEqualTo(String value) {
            addCriterion("major_name >=", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLessThan(String value) {
            addCriterion("major_name <", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLessThanOrEqualTo(String value) {
            addCriterion("major_name <=", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLike(String value) {
            addCriterion("major_name like", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotLike(String value) {
            addCriterion("major_name not like", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameIn(List<String> values) {
            addCriterion("major_name in", values, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotIn(List<String> values) {
            addCriterion("major_name not in", values, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameBetween(String value1, String value2) {
            addCriterion("major_name between", value1, value2, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotBetween(String value1, String value2) {
            addCriterion("major_name not between", value1, value2, "majorName");
            return (Criteria) this;
        }

        public Criteria andClassSnIsNull() {
            addCriterion("class_sn is null");
            return (Criteria) this;
        }

        public Criteria andClassSnIsNotNull() {
            addCriterion("class_sn is not null");
            return (Criteria) this;
        }

        public Criteria andClassSnEqualTo(String value) {
            addCriterion("class_sn =", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnNotEqualTo(String value) {
            addCriterion("class_sn <>", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnGreaterThan(String value) {
            addCriterion("class_sn >", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnGreaterThanOrEqualTo(String value) {
            addCriterion("class_sn >=", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnLessThan(String value) {
            addCriterion("class_sn <", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnLessThanOrEqualTo(String value) {
            addCriterion("class_sn <=", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnLike(String value) {
            addCriterion("class_sn like", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnNotLike(String value) {
            addCriterion("class_sn not like", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnIn(List<String> values) {
            addCriterion("class_sn in", values, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnNotIn(List<String> values) {
            addCriterion("class_sn not in", values, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnBetween(String value1, String value2) {
            addCriterion("class_sn between", value1, value2, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnNotBetween(String value1, String value2) {
            addCriterion("class_sn not between", value1, value2, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelIsNull() {
            addCriterion("difficulty_level is null");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelIsNotNull() {
            addCriterion("difficulty_level is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelEqualTo(String value) {
            addCriterion("difficulty_level =", value, "difficultyLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelNotEqualTo(String value) {
            addCriterion("difficulty_level <>", value, "difficultyLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelGreaterThan(String value) {
            addCriterion("difficulty_level >", value, "difficultyLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelGreaterThanOrEqualTo(String value) {
            addCriterion("difficulty_level >=", value, "difficultyLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelLessThan(String value) {
            addCriterion("difficulty_level <", value, "difficultyLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelLessThanOrEqualTo(String value) {
            addCriterion("difficulty_level <=", value, "difficultyLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelLike(String value) {
            addCriterion("difficulty_level like", value, "difficultyLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelNotLike(String value) {
            addCriterion("difficulty_level not like", value, "difficultyLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelIn(List<String> values) {
            addCriterion("difficulty_level in", values, "difficultyLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelNotIn(List<String> values) {
            addCriterion("difficulty_level not in", values, "difficultyLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelBetween(String value1, String value2) {
            addCriterion("difficulty_level between", value1, value2, "difficultyLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultyLevelNotBetween(String value1, String value2) {
            addCriterion("difficulty_level not between", value1, value2, "difficultyLevel");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonIsNull() {
            addCriterion("application_reason is null");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonIsNotNull() {
            addCriterion("application_reason is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonEqualTo(String value) {
            addCriterion("application_reason =", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonNotEqualTo(String value) {
            addCriterion("application_reason <>", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonGreaterThan(String value) {
            addCriterion("application_reason >", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonGreaterThanOrEqualTo(String value) {
            addCriterion("application_reason >=", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonLessThan(String value) {
            addCriterion("application_reason <", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonLessThanOrEqualTo(String value) {
            addCriterion("application_reason <=", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonLike(String value) {
            addCriterion("application_reason like", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonNotLike(String value) {
            addCriterion("application_reason not like", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonIn(List<String> values) {
            addCriterion("application_reason in", values, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonNotIn(List<String> values) {
            addCriterion("application_reason not in", values, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonBetween(String value1, String value2) {
            addCriterion("application_reason between", value1, value2, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonNotBetween(String value1, String value2) {
            addCriterion("application_reason not between", value1, value2, "applicationReason");
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

        public Criteria andCurrentNodeCodeIsNull() {
            addCriterion("current_node_code is null");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeCodeIsNotNull() {
            addCriterion("current_node_code is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeCodeEqualTo(Integer value) {
            addCriterion("current_node_code =", value, "currentNodeCode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeCodeNotEqualTo(Integer value) {
            addCriterion("current_node_code <>", value, "currentNodeCode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeCodeGreaterThan(Integer value) {
            addCriterion("current_node_code >", value, "currentNodeCode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_node_code >=", value, "currentNodeCode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeCodeLessThan(Integer value) {
            addCriterion("current_node_code <", value, "currentNodeCode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeCodeLessThanOrEqualTo(Integer value) {
            addCriterion("current_node_code <=", value, "currentNodeCode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeCodeIn(List<Integer> values) {
            addCriterion("current_node_code in", values, "currentNodeCode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeCodeNotIn(List<Integer> values) {
            addCriterion("current_node_code not in", values, "currentNodeCode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeCodeBetween(Integer value1, Integer value2) {
            addCriterion("current_node_code between", value1, value2, "currentNodeCode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("current_node_code not between", value1, value2, "currentNodeCode");
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