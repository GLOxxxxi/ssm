package com.suncaper.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsersnIsNull() {
            addCriterion("userSn is null");
            return (Criteria) this;
        }

        public Criteria andUsersnIsNotNull() {
            addCriterion("userSn is not null");
            return (Criteria) this;
        }

        public Criteria andUsersnEqualTo(String value) {
            addCriterion("userSn =", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnNotEqualTo(String value) {
            addCriterion("userSn <>", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnGreaterThan(String value) {
            addCriterion("userSn >", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnGreaterThanOrEqualTo(String value) {
            addCriterion("userSn >=", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnLessThan(String value) {
            addCriterion("userSn <", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnLessThanOrEqualTo(String value) {
            addCriterion("userSn <=", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnLike(String value) {
            addCriterion("userSn like", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnNotLike(String value) {
            addCriterion("userSn not like", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnIn(List<String> values) {
            addCriterion("userSn in", values, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnNotIn(List<String> values) {
            addCriterion("userSn not in", values, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnBetween(String value1, String value2) {
            addCriterion("userSn between", value1, value2, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnNotBetween(String value1, String value2) {
            addCriterion("userSn not between", value1, value2, "usersn");
            return (Criteria) this;
        }

        public Criteria andOrganizationidIsNull() {
            addCriterion("organizationId is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationidIsNotNull() {
            addCriterion("organizationId is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationidEqualTo(Long value) {
            addCriterion("organizationId =", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidNotEqualTo(Long value) {
            addCriterion("organizationId <>", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidGreaterThan(Long value) {
            addCriterion("organizationId >", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidGreaterThanOrEqualTo(Long value) {
            addCriterion("organizationId >=", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidLessThan(Long value) {
            addCriterion("organizationId <", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidLessThanOrEqualTo(Long value) {
            addCriterion("organizationId <=", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidIn(List<Long> values) {
            addCriterion("organizationId in", values, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidNotIn(List<Long> values) {
            addCriterion("organizationId not in", values, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidBetween(Long value1, Long value2) {
            addCriterion("organizationId between", value1, value2, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidNotBetween(Long value1, Long value2) {
            addCriterion("organizationId not between", value1, value2, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameIsNull() {
            addCriterion("organizationName is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameIsNotNull() {
            addCriterion("organizationName is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameEqualTo(String value) {
            addCriterion("organizationName =", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameNotEqualTo(String value) {
            addCriterion("organizationName <>", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameGreaterThan(String value) {
            addCriterion("organizationName >", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameGreaterThanOrEqualTo(String value) {
            addCriterion("organizationName >=", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameLessThan(String value) {
            addCriterion("organizationName <", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameLessThanOrEqualTo(String value) {
            addCriterion("organizationName <=", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameLike(String value) {
            addCriterion("organizationName like", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameNotLike(String value) {
            addCriterion("organizationName not like", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameIn(List<String> values) {
            addCriterion("organizationName in", values, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameNotIn(List<String> values) {
            addCriterion("organizationName not in", values, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameBetween(String value1, String value2) {
            addCriterion("organizationName between", value1, value2, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameNotBetween(String value1, String value2) {
            addCriterion("organizationName not between", value1, value2, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnIsNull() {
            addCriterion("organizationSN is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnIsNotNull() {
            addCriterion("organizationSN is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnEqualTo(String value) {
            addCriterion("organizationSN =", value, "organizationsn");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnNotEqualTo(String value) {
            addCriterion("organizationSN <>", value, "organizationsn");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnGreaterThan(String value) {
            addCriterion("organizationSN >", value, "organizationsn");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnGreaterThanOrEqualTo(String value) {
            addCriterion("organizationSN >=", value, "organizationsn");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnLessThan(String value) {
            addCriterion("organizationSN <", value, "organizationsn");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnLessThanOrEqualTo(String value) {
            addCriterion("organizationSN <=", value, "organizationsn");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnLike(String value) {
            addCriterion("organizationSN like", value, "organizationsn");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnNotLike(String value) {
            addCriterion("organizationSN not like", value, "organizationsn");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnIn(List<String> values) {
            addCriterion("organizationSN in", values, "organizationsn");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnNotIn(List<String> values) {
            addCriterion("organizationSN not in", values, "organizationsn");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnBetween(String value1, String value2) {
            addCriterion("organizationSN between", value1, value2, "organizationsn");
            return (Criteria) this;
        }

        public Criteria andOrganizationsnNotBetween(String value1, String value2) {
            addCriterion("organizationSN not between", value1, value2, "organizationsn");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNull() {
            addCriterion("roleId is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleId is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(Long value) {
            addCriterion("roleId =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(Long value) {
            addCriterion("roleId <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(Long value) {
            addCriterion("roleId >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(Long value) {
            addCriterion("roleId >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(Long value) {
            addCriterion("roleId <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(Long value) {
            addCriterion("roleId <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<Long> values) {
            addCriterion("roleId in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<Long> values) {
            addCriterion("roleId not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(Long value1, Long value2) {
            addCriterion("roleId between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(Long value1, Long value2) {
            addCriterion("roleId not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRolenameIsNull() {
            addCriterion("roleName is null");
            return (Criteria) this;
        }

        public Criteria andRolenameIsNotNull() {
            addCriterion("roleName is not null");
            return (Criteria) this;
        }

        public Criteria andRolenameEqualTo(String value) {
            addCriterion("roleName =", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotEqualTo(String value) {
            addCriterion("roleName <>", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameGreaterThan(String value) {
            addCriterion("roleName >", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameGreaterThanOrEqualTo(String value) {
            addCriterion("roleName >=", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLessThan(String value) {
            addCriterion("roleName <", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLessThanOrEqualTo(String value) {
            addCriterion("roleName <=", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLike(String value) {
            addCriterion("roleName like", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotLike(String value) {
            addCriterion("roleName not like", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameIn(List<String> values) {
            addCriterion("roleName in", values, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotIn(List<String> values) {
            addCriterion("roleName not in", values, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameBetween(String value1, String value2) {
            addCriterion("roleName between", value1, value2, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotBetween(String value1, String value2) {
            addCriterion("roleName not between", value1, value2, "rolename");
            return (Criteria) this;
        }

        public Criteria andOrganizationtypeIsNull() {
            addCriterion("organizationType is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationtypeIsNotNull() {
            addCriterion("organizationType is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationtypeEqualTo(Byte value) {
            addCriterion("organizationType =", value, "organizationtype");
            return (Criteria) this;
        }

        public Criteria andOrganizationtypeNotEqualTo(Byte value) {
            addCriterion("organizationType <>", value, "organizationtype");
            return (Criteria) this;
        }

        public Criteria andOrganizationtypeGreaterThan(Byte value) {
            addCriterion("organizationType >", value, "organizationtype");
            return (Criteria) this;
        }

        public Criteria andOrganizationtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("organizationType >=", value, "organizationtype");
            return (Criteria) this;
        }

        public Criteria andOrganizationtypeLessThan(Byte value) {
            addCriterion("organizationType <", value, "organizationtype");
            return (Criteria) this;
        }

        public Criteria andOrganizationtypeLessThanOrEqualTo(Byte value) {
            addCriterion("organizationType <=", value, "organizationtype");
            return (Criteria) this;
        }

        public Criteria andOrganizationtypeIn(List<Byte> values) {
            addCriterion("organizationType in", values, "organizationtype");
            return (Criteria) this;
        }

        public Criteria andOrganizationtypeNotIn(List<Byte> values) {
            addCriterion("organizationType not in", values, "organizationtype");
            return (Criteria) this;
        }

        public Criteria andOrganizationtypeBetween(Byte value1, Byte value2) {
            addCriterion("organizationType between", value1, value2, "organizationtype");
            return (Criteria) this;
        }

        public Criteria andOrganizationtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("organizationType not between", value1, value2, "organizationtype");
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