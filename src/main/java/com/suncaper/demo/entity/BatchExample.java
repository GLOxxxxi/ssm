package com.suncaper.demo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BatchExample() {
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

        public Criteria andApplicationStartDateIsNull() {
            addCriterion("application_start_date is null");
            return (Criteria) this;
        }

        public Criteria andApplicationStartDateIsNotNull() {
            addCriterion("application_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationStartDateEqualTo(LocalDate value) {
            addCriterion("application_start_date =", value, "applicationStartDate");
            return (Criteria) this;
        }

        public Criteria andApplicationStartDateNotEqualTo(LocalDate value) {
            addCriterion("application_start_date <>", value, "applicationStartDate");
            return (Criteria) this;
        }

        public Criteria andApplicationStartDateGreaterThan(LocalDate value) {
            addCriterion("application_start_date >", value, "applicationStartDate");
            return (Criteria) this;
        }

        public Criteria andApplicationStartDateGreaterThanOrEqualTo(LocalDate value) {
            addCriterion("application_start_date >=", value, "applicationStartDate");
            return (Criteria) this;
        }

        public Criteria andApplicationStartDateLessThan(LocalDate value) {
            addCriterion("application_start_date <", value, "applicationStartDate");
            return (Criteria) this;
        }

        public Criteria andApplicationStartDateLessThanOrEqualTo(LocalDate value) {
            addCriterion("application_start_date <=", value, "applicationStartDate");
            return (Criteria) this;
        }

        public Criteria andApplicationStartDateIn(List<LocalDate> values) {
            addCriterion("application_start_date in", values, "applicationStartDate");
            return (Criteria) this;
        }

        public Criteria andApplicationStartDateNotIn(List<LocalDate> values) {
            addCriterion("application_start_date not in", values, "applicationStartDate");
            return (Criteria) this;
        }

        public Criteria andApplicationStartDateBetween(LocalDate value1, LocalDate value2) {
            addCriterion("application_start_date between", value1, value2, "applicationStartDate");
            return (Criteria) this;
        }

        public Criteria andApplicationStartDateNotBetween(LocalDate value1, LocalDate value2) {
            addCriterion("application_start_date not between", value1, value2, "applicationStartDate");
            return (Criteria) this;
        }

        public Criteria andApplicationEndDateIsNull() {
            addCriterion("application_end_date is null");
            return (Criteria) this;
        }

        public Criteria andApplicationEndDateIsNotNull() {
            addCriterion("application_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationEndDateEqualTo(LocalDate value) {
            addCriterion("application_end_date =", value, "applicationEndDate");
            return (Criteria) this;
        }

        public Criteria andApplicationEndDateNotEqualTo(LocalDate value) {
            addCriterion("application_end_date <>", value, "applicationEndDate");
            return (Criteria) this;
        }

        public Criteria andApplicationEndDateGreaterThan(LocalDate value) {
            addCriterion("application_end_date >", value, "applicationEndDate");
            return (Criteria) this;
        }

        public Criteria andApplicationEndDateGreaterThanOrEqualTo(LocalDate value) {
            addCriterion("application_end_date >=", value, "applicationEndDate");
            return (Criteria) this;
        }

        public Criteria andApplicationEndDateLessThan(LocalDate value) {
            addCriterion("application_end_date <", value, "applicationEndDate");
            return (Criteria) this;
        }

        public Criteria andApplicationEndDateLessThanOrEqualTo(LocalDate value) {
            addCriterion("application_end_date <=", value, "applicationEndDate");
            return (Criteria) this;
        }

        public Criteria andApplicationEndDateIn(List<LocalDate> values) {
            addCriterion("application_end_date in", values, "applicationEndDate");
            return (Criteria) this;
        }

        public Criteria andApplicationEndDateNotIn(List<LocalDate> values) {
            addCriterion("application_end_date not in", values, "applicationEndDate");
            return (Criteria) this;
        }

        public Criteria andApplicationEndDateBetween(LocalDate value1, LocalDate value2) {
            addCriterion("application_end_date between", value1, value2, "applicationEndDate");
            return (Criteria) this;
        }

        public Criteria andApplicationEndDateNotBetween(LocalDate value1, LocalDate value2) {
            addCriterion("application_end_date not between", value1, value2, "applicationEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterStartDateIsNull() {
            addCriterion("register_start_date is null");
            return (Criteria) this;
        }

        public Criteria andRegisterStartDateIsNotNull() {
            addCriterion("register_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterStartDateEqualTo(LocalDate value) {
            addCriterion("register_start_date =", value, "registerStartDate");
            return (Criteria) this;
        }

        public Criteria andRegisterStartDateNotEqualTo(LocalDate value) {
            addCriterion("register_start_date <>", value, "registerStartDate");
            return (Criteria) this;
        }

        public Criteria andRegisterStartDateGreaterThan(LocalDate value) {
            addCriterion("register_start_date >", value, "registerStartDate");
            return (Criteria) this;
        }

        public Criteria andRegisterStartDateGreaterThanOrEqualTo(LocalDate value) {
            addCriterion("register_start_date >=", value, "registerStartDate");
            return (Criteria) this;
        }

        public Criteria andRegisterStartDateLessThan(LocalDate value) {
            addCriterion("register_start_date <", value, "registerStartDate");
            return (Criteria) this;
        }

        public Criteria andRegisterStartDateLessThanOrEqualTo(LocalDate value) {
            addCriterion("register_start_date <=", value, "registerStartDate");
            return (Criteria) this;
        }

        public Criteria andRegisterStartDateIn(List<LocalDate> values) {
            addCriterion("register_start_date in", values, "registerStartDate");
            return (Criteria) this;
        }

        public Criteria andRegisterStartDateNotIn(List<LocalDate> values) {
            addCriterion("register_start_date not in", values, "registerStartDate");
            return (Criteria) this;
        }

        public Criteria andRegisterStartDateBetween(LocalDate value1, LocalDate value2) {
            addCriterion("register_start_date between", value1, value2, "registerStartDate");
            return (Criteria) this;
        }

        public Criteria andRegisterStartDateNotBetween(LocalDate value1, LocalDate value2) {
            addCriterion("register_start_date not between", value1, value2, "registerStartDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateIsNull() {
            addCriterion("register_end_date is null");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateIsNotNull() {
            addCriterion("register_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateEqualTo(LocalDate value) {
            addCriterion("register_end_date =", value, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateNotEqualTo(LocalDate value) {
            addCriterion("register_end_date <>", value, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateGreaterThan(LocalDate value) {
            addCriterion("register_end_date >", value, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateGreaterThanOrEqualTo(LocalDate value) {
            addCriterion("register_end_date >=", value, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateLessThan(LocalDate value) {
            addCriterion("register_end_date <", value, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateLessThanOrEqualTo(LocalDate value) {
            addCriterion("register_end_date <=", value, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateIn(List<LocalDate> values) {
            addCriterion("register_end_date in", values, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateNotIn(List<LocalDate> values) {
            addCriterion("register_end_date not in", values, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateBetween(LocalDate value1, LocalDate value2) {
            addCriterion("register_end_date between", value1, value2, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateNotBetween(LocalDate value1, LocalDate value2) {
            addCriterion("register_end_date not between", value1, value2, "registerEndDate");
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

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Integer value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Integer value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Integer value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Integer value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Integer> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Integer> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Integer value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Integer value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Integer value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Integer value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Integer value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Integer> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Integer> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Integer value1, Integer value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("active not between", value1, value2, "active");
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