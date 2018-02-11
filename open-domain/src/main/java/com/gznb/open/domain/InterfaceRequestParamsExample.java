package com.gznb.open.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InterfaceRequestParamsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InterfaceRequestParamsExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdIsNull() {
            addCriterion("interface_id is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdIsNotNull() {
            addCriterion("interface_id is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdEqualTo(Integer value) {
            addCriterion("interface_id =", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotEqualTo(Integer value) {
            addCriterion("interface_id <>", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdGreaterThan(Integer value) {
            addCriterion("interface_id >", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("interface_id >=", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdLessThan(Integer value) {
            addCriterion("interface_id <", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdLessThanOrEqualTo(Integer value) {
            addCriterion("interface_id <=", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdIn(List<Integer> values) {
            addCriterion("interface_id in", values, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotIn(List<Integer> values) {
            addCriterion("interface_id not in", values, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdBetween(Integer value1, Integer value2) {
            addCriterion("interface_id between", value1, value2, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("interface_id not between", value1, value2, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNull() {
            addCriterion("param_name is null");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNotNull() {
            addCriterion("param_name is not null");
            return (Criteria) this;
        }

        public Criteria andParamNameEqualTo(String value) {
            addCriterion("param_name =", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotEqualTo(String value) {
            addCriterion("param_name <>", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThan(String value) {
            addCriterion("param_name >", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("param_name >=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThan(String value) {
            addCriterion("param_name <", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThanOrEqualTo(String value) {
            addCriterion("param_name <=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLike(String value) {
            addCriterion("param_name like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotLike(String value) {
            addCriterion("param_name not like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameIn(List<String> values) {
            addCriterion("param_name in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotIn(List<String> values) {
            addCriterion("param_name not in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameBetween(String value1, String value2) {
            addCriterion("param_name between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotBetween(String value1, String value2) {
            addCriterion("param_name not between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameCnIsNull() {
            addCriterion("param_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andParamNameCnIsNotNull() {
            addCriterion("param_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andParamNameCnEqualTo(String value) {
            addCriterion("param_name_cn =", value, "paramNameCn");
            return (Criteria) this;
        }

        public Criteria andParamNameCnNotEqualTo(String value) {
            addCriterion("param_name_cn <>", value, "paramNameCn");
            return (Criteria) this;
        }

        public Criteria andParamNameCnGreaterThan(String value) {
            addCriterion("param_name_cn >", value, "paramNameCn");
            return (Criteria) this;
        }

        public Criteria andParamNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("param_name_cn >=", value, "paramNameCn");
            return (Criteria) this;
        }

        public Criteria andParamNameCnLessThan(String value) {
            addCriterion("param_name_cn <", value, "paramNameCn");
            return (Criteria) this;
        }

        public Criteria andParamNameCnLessThanOrEqualTo(String value) {
            addCriterion("param_name_cn <=", value, "paramNameCn");
            return (Criteria) this;
        }

        public Criteria andParamNameCnLike(String value) {
            addCriterion("param_name_cn like", value, "paramNameCn");
            return (Criteria) this;
        }

        public Criteria andParamNameCnNotLike(String value) {
            addCriterion("param_name_cn not like", value, "paramNameCn");
            return (Criteria) this;
        }

        public Criteria andParamNameCnIn(List<String> values) {
            addCriterion("param_name_cn in", values, "paramNameCn");
            return (Criteria) this;
        }

        public Criteria andParamNameCnNotIn(List<String> values) {
            addCriterion("param_name_cn not in", values, "paramNameCn");
            return (Criteria) this;
        }

        public Criteria andParamNameCnBetween(String value1, String value2) {
            addCriterion("param_name_cn between", value1, value2, "paramNameCn");
            return (Criteria) this;
        }

        public Criteria andParamNameCnNotBetween(String value1, String value2) {
            addCriterion("param_name_cn not between", value1, value2, "paramNameCn");
            return (Criteria) this;
        }

        public Criteria andParamTypeIsNull() {
            addCriterion("param_type is null");
            return (Criteria) this;
        }

        public Criteria andParamTypeIsNotNull() {
            addCriterion("param_type is not null");
            return (Criteria) this;
        }

        public Criteria andParamTypeEqualTo(String value) {
            addCriterion("param_type =", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotEqualTo(String value) {
            addCriterion("param_type <>", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeGreaterThan(String value) {
            addCriterion("param_type >", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("param_type >=", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLessThan(String value) {
            addCriterion("param_type <", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLessThanOrEqualTo(String value) {
            addCriterion("param_type <=", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLike(String value) {
            addCriterion("param_type like", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotLike(String value) {
            addCriterion("param_type not like", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeIn(List<String> values) {
            addCriterion("param_type in", values, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotIn(List<String> values) {
            addCriterion("param_type not in", values, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeBetween(String value1, String value2) {
            addCriterion("param_type between", value1, value2, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotBetween(String value1, String value2) {
            addCriterion("param_type not between", value1, value2, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamRequiredIsNull() {
            addCriterion("param_required is null");
            return (Criteria) this;
        }

        public Criteria andParamRequiredIsNotNull() {
            addCriterion("param_required is not null");
            return (Criteria) this;
        }

        public Criteria andParamRequiredEqualTo(Boolean value) {
            addCriterion("param_required =", value, "paramRequired");
            return (Criteria) this;
        }

        public Criteria andParamRequiredNotEqualTo(Boolean value) {
            addCriterion("param_required <>", value, "paramRequired");
            return (Criteria) this;
        }

        public Criteria andParamRequiredGreaterThan(Boolean value) {
            addCriterion("param_required >", value, "paramRequired");
            return (Criteria) this;
        }

        public Criteria andParamRequiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("param_required >=", value, "paramRequired");
            return (Criteria) this;
        }

        public Criteria andParamRequiredLessThan(Boolean value) {
            addCriterion("param_required <", value, "paramRequired");
            return (Criteria) this;
        }

        public Criteria andParamRequiredLessThanOrEqualTo(Boolean value) {
            addCriterion("param_required <=", value, "paramRequired");
            return (Criteria) this;
        }

        public Criteria andParamRequiredIn(List<Boolean> values) {
            addCriterion("param_required in", values, "paramRequired");
            return (Criteria) this;
        }

        public Criteria andParamRequiredNotIn(List<Boolean> values) {
            addCriterion("param_required not in", values, "paramRequired");
            return (Criteria) this;
        }

        public Criteria andParamRequiredBetween(Boolean value1, Boolean value2) {
            addCriterion("param_required between", value1, value2, "paramRequired");
            return (Criteria) this;
        }

        public Criteria andParamRequiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("param_required not between", value1, value2, "paramRequired");
            return (Criteria) this;
        }

        public Criteria andParamTestValueIsNull() {
            addCriterion("param_test_value is null");
            return (Criteria) this;
        }

        public Criteria andParamTestValueIsNotNull() {
            addCriterion("param_test_value is not null");
            return (Criteria) this;
        }

        public Criteria andParamTestValueEqualTo(String value) {
            addCriterion("param_test_value =", value, "paramTestValue");
            return (Criteria) this;
        }

        public Criteria andParamTestValueNotEqualTo(String value) {
            addCriterion("param_test_value <>", value, "paramTestValue");
            return (Criteria) this;
        }

        public Criteria andParamTestValueGreaterThan(String value) {
            addCriterion("param_test_value >", value, "paramTestValue");
            return (Criteria) this;
        }

        public Criteria andParamTestValueGreaterThanOrEqualTo(String value) {
            addCriterion("param_test_value >=", value, "paramTestValue");
            return (Criteria) this;
        }

        public Criteria andParamTestValueLessThan(String value) {
            addCriterion("param_test_value <", value, "paramTestValue");
            return (Criteria) this;
        }

        public Criteria andParamTestValueLessThanOrEqualTo(String value) {
            addCriterion("param_test_value <=", value, "paramTestValue");
            return (Criteria) this;
        }

        public Criteria andParamTestValueLike(String value) {
            addCriterion("param_test_value like", value, "paramTestValue");
            return (Criteria) this;
        }

        public Criteria andParamTestValueNotLike(String value) {
            addCriterion("param_test_value not like", value, "paramTestValue");
            return (Criteria) this;
        }

        public Criteria andParamTestValueIn(List<String> values) {
            addCriterion("param_test_value in", values, "paramTestValue");
            return (Criteria) this;
        }

        public Criteria andParamTestValueNotIn(List<String> values) {
            addCriterion("param_test_value not in", values, "paramTestValue");
            return (Criteria) this;
        }

        public Criteria andParamTestValueBetween(String value1, String value2) {
            addCriterion("param_test_value between", value1, value2, "paramTestValue");
            return (Criteria) this;
        }

        public Criteria andParamTestValueNotBetween(String value1, String value2) {
            addCriterion("param_test_value not between", value1, value2, "paramTestValue");
            return (Criteria) this;
        }

        public Criteria andParamStatusIsNull() {
            addCriterion("param_status is null");
            return (Criteria) this;
        }

        public Criteria andParamStatusIsNotNull() {
            addCriterion("param_status is not null");
            return (Criteria) this;
        }

        public Criteria andParamStatusEqualTo(String value) {
            addCriterion("param_status =", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusNotEqualTo(String value) {
            addCriterion("param_status <>", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusGreaterThan(String value) {
            addCriterion("param_status >", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusGreaterThanOrEqualTo(String value) {
            addCriterion("param_status >=", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusLessThan(String value) {
            addCriterion("param_status <", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusLessThanOrEqualTo(String value) {
            addCriterion("param_status <=", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusLike(String value) {
            addCriterion("param_status like", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusNotLike(String value) {
            addCriterion("param_status not like", value, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusIn(List<String> values) {
            addCriterion("param_status in", values, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusNotIn(List<String> values) {
            addCriterion("param_status not in", values, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusBetween(String value1, String value2) {
            addCriterion("param_status between", value1, value2, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andParamStatusNotBetween(String value1, String value2) {
            addCriterion("param_status not between", value1, value2, "paramStatus");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andParamTreeIsNull() {
            addCriterion("param_tree is null");
            return (Criteria) this;
        }

        public Criteria andParamTreeIsNotNull() {
            addCriterion("param_tree is not null");
            return (Criteria) this;
        }

        public Criteria andParamTreeEqualTo(String value) {
            addCriterion("param_tree =", value, "paramTree");
            return (Criteria) this;
        }

        public Criteria andParamTreeNotEqualTo(String value) {
            addCriterion("param_tree <>", value, "paramTree");
            return (Criteria) this;
        }

        public Criteria andParamTreeGreaterThan(String value) {
            addCriterion("param_tree >", value, "paramTree");
            return (Criteria) this;
        }

        public Criteria andParamTreeGreaterThanOrEqualTo(String value) {
            addCriterion("param_tree >=", value, "paramTree");
            return (Criteria) this;
        }

        public Criteria andParamTreeLessThan(String value) {
            addCriterion("param_tree <", value, "paramTree");
            return (Criteria) this;
        }

        public Criteria andParamTreeLessThanOrEqualTo(String value) {
            addCriterion("param_tree <=", value, "paramTree");
            return (Criteria) this;
        }

        public Criteria andParamTreeLike(String value) {
            addCriterion("param_tree like", value, "paramTree");
            return (Criteria) this;
        }

        public Criteria andParamTreeNotLike(String value) {
            addCriterion("param_tree not like", value, "paramTree");
            return (Criteria) this;
        }

        public Criteria andParamTreeIn(List<String> values) {
            addCriterion("param_tree in", values, "paramTree");
            return (Criteria) this;
        }

        public Criteria andParamTreeNotIn(List<String> values) {
            addCriterion("param_tree not in", values, "paramTree");
            return (Criteria) this;
        }

        public Criteria andParamTreeBetween(String value1, String value2) {
            addCriterion("param_tree between", value1, value2, "paramTree");
            return (Criteria) this;
        }

        public Criteria andParamTreeNotBetween(String value1, String value2) {
            addCriterion("param_tree not between", value1, value2, "paramTree");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andCommonFlagIsNull() {
            addCriterion("common_flag is null");
            return (Criteria) this;
        }

        public Criteria andCommonFlagIsNotNull() {
            addCriterion("common_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCommonFlagEqualTo(String value) {
            addCriterion("common_flag =", value, "commonFlag");
            return (Criteria) this;
        }

        public Criteria andCommonFlagNotEqualTo(String value) {
            addCriterion("common_flag <>", value, "commonFlag");
            return (Criteria) this;
        }

        public Criteria andCommonFlagGreaterThan(String value) {
            addCriterion("common_flag >", value, "commonFlag");
            return (Criteria) this;
        }

        public Criteria andCommonFlagGreaterThanOrEqualTo(String value) {
            addCriterion("common_flag >=", value, "commonFlag");
            return (Criteria) this;
        }

        public Criteria andCommonFlagLessThan(String value) {
            addCriterion("common_flag <", value, "commonFlag");
            return (Criteria) this;
        }

        public Criteria andCommonFlagLessThanOrEqualTo(String value) {
            addCriterion("common_flag <=", value, "commonFlag");
            return (Criteria) this;
        }

        public Criteria andCommonFlagLike(String value) {
            addCriterion("common_flag like", value, "commonFlag");
            return (Criteria) this;
        }

        public Criteria andCommonFlagNotLike(String value) {
            addCriterion("common_flag not like", value, "commonFlag");
            return (Criteria) this;
        }

        public Criteria andCommonFlagIn(List<String> values) {
            addCriterion("common_flag in", values, "commonFlag");
            return (Criteria) this;
        }

        public Criteria andCommonFlagNotIn(List<String> values) {
            addCriterion("common_flag not in", values, "commonFlag");
            return (Criteria) this;
        }

        public Criteria andCommonFlagBetween(String value1, String value2) {
            addCriterion("common_flag between", value1, value2, "commonFlag");
            return (Criteria) this;
        }

        public Criteria andCommonFlagNotBetween(String value1, String value2) {
            addCriterion("common_flag not between", value1, value2, "commonFlag");
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