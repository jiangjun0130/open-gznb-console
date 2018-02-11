package com.gznb.open.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemPlatformExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemPlatformExample() {
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

        public Criteria andPlatformNameIsNull() {
            addCriterion("platform_name is null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIsNotNull() {
            addCriterion("platform_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameEqualTo(String value) {
            addCriterion("platform_name =", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotEqualTo(String value) {
            addCriterion("platform_name <>", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThan(String value) {
            addCriterion("platform_name >", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThanOrEqualTo(String value) {
            addCriterion("platform_name >=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThan(String value) {
            addCriterion("platform_name <", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThanOrEqualTo(String value) {
            addCriterion("platform_name <=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLike(String value) {
            addCriterion("platform_name like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotLike(String value) {
            addCriterion("platform_name not like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIn(List<String> values) {
            addCriterion("platform_name in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotIn(List<String> values) {
            addCriterion("platform_name not in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameBetween(String value1, String value2) {
            addCriterion("platform_name between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotBetween(String value1, String value2) {
            addCriterion("platform_name not between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIsNull() {
            addCriterion("encrypt_type is null");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIsNotNull() {
            addCriterion("encrypt_type is not null");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeEqualTo(String value) {
            addCriterion("encrypt_type =", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeNotEqualTo(String value) {
            addCriterion("encrypt_type <>", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeGreaterThan(String value) {
            addCriterion("encrypt_type >", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeGreaterThanOrEqualTo(String value) {
            addCriterion("encrypt_type >=", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeLessThan(String value) {
            addCriterion("encrypt_type <", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeLessThanOrEqualTo(String value) {
            addCriterion("encrypt_type <=", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeLike(String value) {
            addCriterion("encrypt_type like", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeNotLike(String value) {
            addCriterion("encrypt_type not like", value, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeIn(List<String> values) {
            addCriterion("encrypt_type in", values, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeNotIn(List<String> values) {
            addCriterion("encrypt_type not in", values, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeBetween(String value1, String value2) {
            addCriterion("encrypt_type between", value1, value2, "encryptType");
            return (Criteria) this;
        }

        public Criteria andEncryptTypeNotBetween(String value1, String value2) {
            addCriterion("encrypt_type not between", value1, value2, "encryptType");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusIsNull() {
            addCriterion("platform_status is null");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusIsNotNull() {
            addCriterion("platform_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusEqualTo(String value) {
            addCriterion("platform_status =", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotEqualTo(String value) {
            addCriterion("platform_status <>", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusGreaterThan(String value) {
            addCriterion("platform_status >", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusGreaterThanOrEqualTo(String value) {
            addCriterion("platform_status >=", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusLessThan(String value) {
            addCriterion("platform_status <", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusLessThanOrEqualTo(String value) {
            addCriterion("platform_status <=", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusLike(String value) {
            addCriterion("platform_status like", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotLike(String value) {
            addCriterion("platform_status not like", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusIn(List<String> values) {
            addCriterion("platform_status in", values, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotIn(List<String> values) {
            addCriterion("platform_status not in", values, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusBetween(String value1, String value2) {
            addCriterion("platform_status between", value1, value2, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotBetween(String value1, String value2) {
            addCriterion("platform_status not between", value1, value2, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformImageIsNull() {
            addCriterion("platform_image is null");
            return (Criteria) this;
        }

        public Criteria andPlatformImageIsNotNull() {
            addCriterion("platform_image is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformImageEqualTo(String value) {
            addCriterion("platform_image =", value, "platformImage");
            return (Criteria) this;
        }

        public Criteria andPlatformImageNotEqualTo(String value) {
            addCriterion("platform_image <>", value, "platformImage");
            return (Criteria) this;
        }

        public Criteria andPlatformImageGreaterThan(String value) {
            addCriterion("platform_image >", value, "platformImage");
            return (Criteria) this;
        }

        public Criteria andPlatformImageGreaterThanOrEqualTo(String value) {
            addCriterion("platform_image >=", value, "platformImage");
            return (Criteria) this;
        }

        public Criteria andPlatformImageLessThan(String value) {
            addCriterion("platform_image <", value, "platformImage");
            return (Criteria) this;
        }

        public Criteria andPlatformImageLessThanOrEqualTo(String value) {
            addCriterion("platform_image <=", value, "platformImage");
            return (Criteria) this;
        }

        public Criteria andPlatformImageLike(String value) {
            addCriterion("platform_image like", value, "platformImage");
            return (Criteria) this;
        }

        public Criteria andPlatformImageNotLike(String value) {
            addCriterion("platform_image not like", value, "platformImage");
            return (Criteria) this;
        }

        public Criteria andPlatformImageIn(List<String> values) {
            addCriterion("platform_image in", values, "platformImage");
            return (Criteria) this;
        }

        public Criteria andPlatformImageNotIn(List<String> values) {
            addCriterion("platform_image not in", values, "platformImage");
            return (Criteria) this;
        }

        public Criteria andPlatformImageBetween(String value1, String value2) {
            addCriterion("platform_image between", value1, value2, "platformImage");
            return (Criteria) this;
        }

        public Criteria andPlatformImageNotBetween(String value1, String value2) {
            addCriterion("platform_image not between", value1, value2, "platformImage");
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

        public Criteria andTestUrlIsNull() {
            addCriterion("test_url is null");
            return (Criteria) this;
        }

        public Criteria andTestUrlIsNotNull() {
            addCriterion("test_url is not null");
            return (Criteria) this;
        }

        public Criteria andTestUrlEqualTo(String value) {
            addCriterion("test_url =", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlNotEqualTo(String value) {
            addCriterion("test_url <>", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlGreaterThan(String value) {
            addCriterion("test_url >", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlGreaterThanOrEqualTo(String value) {
            addCriterion("test_url >=", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlLessThan(String value) {
            addCriterion("test_url <", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlLessThanOrEqualTo(String value) {
            addCriterion("test_url <=", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlLike(String value) {
            addCriterion("test_url like", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlNotLike(String value) {
            addCriterion("test_url not like", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlIn(List<String> values) {
            addCriterion("test_url in", values, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlNotIn(List<String> values) {
            addCriterion("test_url not in", values, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlBetween(String value1, String value2) {
            addCriterion("test_url between", value1, value2, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlNotBetween(String value1, String value2) {
            addCriterion("test_url not between", value1, value2, "testUrl");
            return (Criteria) this;
        }

        public Criteria andPreUrlIsNull() {
            addCriterion("pre_url is null");
            return (Criteria) this;
        }

        public Criteria andPreUrlIsNotNull() {
            addCriterion("pre_url is not null");
            return (Criteria) this;
        }

        public Criteria andPreUrlEqualTo(String value) {
            addCriterion("pre_url =", value, "preUrl");
            return (Criteria) this;
        }

        public Criteria andPreUrlNotEqualTo(String value) {
            addCriterion("pre_url <>", value, "preUrl");
            return (Criteria) this;
        }

        public Criteria andPreUrlGreaterThan(String value) {
            addCriterion("pre_url >", value, "preUrl");
            return (Criteria) this;
        }

        public Criteria andPreUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pre_url >=", value, "preUrl");
            return (Criteria) this;
        }

        public Criteria andPreUrlLessThan(String value) {
            addCriterion("pre_url <", value, "preUrl");
            return (Criteria) this;
        }

        public Criteria andPreUrlLessThanOrEqualTo(String value) {
            addCriterion("pre_url <=", value, "preUrl");
            return (Criteria) this;
        }

        public Criteria andPreUrlLike(String value) {
            addCriterion("pre_url like", value, "preUrl");
            return (Criteria) this;
        }

        public Criteria andPreUrlNotLike(String value) {
            addCriterion("pre_url not like", value, "preUrl");
            return (Criteria) this;
        }

        public Criteria andPreUrlIn(List<String> values) {
            addCriterion("pre_url in", values, "preUrl");
            return (Criteria) this;
        }

        public Criteria andPreUrlNotIn(List<String> values) {
            addCriterion("pre_url not in", values, "preUrl");
            return (Criteria) this;
        }

        public Criteria andPreUrlBetween(String value1, String value2) {
            addCriterion("pre_url between", value1, value2, "preUrl");
            return (Criteria) this;
        }

        public Criteria andPreUrlNotBetween(String value1, String value2) {
            addCriterion("pre_url not between", value1, value2, "preUrl");
            return (Criteria) this;
        }

        public Criteria andPrdUrlIsNull() {
            addCriterion("prd_url is null");
            return (Criteria) this;
        }

        public Criteria andPrdUrlIsNotNull() {
            addCriterion("prd_url is not null");
            return (Criteria) this;
        }

        public Criteria andPrdUrlEqualTo(String value) {
            addCriterion("prd_url =", value, "prdUrl");
            return (Criteria) this;
        }

        public Criteria andPrdUrlNotEqualTo(String value) {
            addCriterion("prd_url <>", value, "prdUrl");
            return (Criteria) this;
        }

        public Criteria andPrdUrlGreaterThan(String value) {
            addCriterion("prd_url >", value, "prdUrl");
            return (Criteria) this;
        }

        public Criteria andPrdUrlGreaterThanOrEqualTo(String value) {
            addCriterion("prd_url >=", value, "prdUrl");
            return (Criteria) this;
        }

        public Criteria andPrdUrlLessThan(String value) {
            addCriterion("prd_url <", value, "prdUrl");
            return (Criteria) this;
        }

        public Criteria andPrdUrlLessThanOrEqualTo(String value) {
            addCriterion("prd_url <=", value, "prdUrl");
            return (Criteria) this;
        }

        public Criteria andPrdUrlLike(String value) {
            addCriterion("prd_url like", value, "prdUrl");
            return (Criteria) this;
        }

        public Criteria andPrdUrlNotLike(String value) {
            addCriterion("prd_url not like", value, "prdUrl");
            return (Criteria) this;
        }

        public Criteria andPrdUrlIn(List<String> values) {
            addCriterion("prd_url in", values, "prdUrl");
            return (Criteria) this;
        }

        public Criteria andPrdUrlNotIn(List<String> values) {
            addCriterion("prd_url not in", values, "prdUrl");
            return (Criteria) this;
        }

        public Criteria andPrdUrlBetween(String value1, String value2) {
            addCriterion("prd_url between", value1, value2, "prdUrl");
            return (Criteria) this;
        }

        public Criteria andPrdUrlNotBetween(String value1, String value2) {
            addCriterion("prd_url not between", value1, value2, "prdUrl");
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

        public Criteria andPlatformManagerIsNull() {
            addCriterion("platform_manager is null");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerIsNotNull() {
            addCriterion("platform_manager is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerEqualTo(String value) {
            addCriterion("platform_manager =", value, "platformManager");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerNotEqualTo(String value) {
            addCriterion("platform_manager <>", value, "platformManager");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerGreaterThan(String value) {
            addCriterion("platform_manager >", value, "platformManager");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerGreaterThanOrEqualTo(String value) {
            addCriterion("platform_manager >=", value, "platformManager");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerLessThan(String value) {
            addCriterion("platform_manager <", value, "platformManager");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerLessThanOrEqualTo(String value) {
            addCriterion("platform_manager <=", value, "platformManager");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerLike(String value) {
            addCriterion("platform_manager like", value, "platformManager");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerNotLike(String value) {
            addCriterion("platform_manager not like", value, "platformManager");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerIn(List<String> values) {
            addCriterion("platform_manager in", values, "platformManager");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerNotIn(List<String> values) {
            addCriterion("platform_manager not in", values, "platformManager");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerBetween(String value1, String value2) {
            addCriterion("platform_manager between", value1, value2, "platformManager");
            return (Criteria) this;
        }

        public Criteria andPlatformManagerNotBetween(String value1, String value2) {
            addCriterion("platform_manager not between", value1, value2, "platformManager");
            return (Criteria) this;
        }

        public Criteria andPlatformNoIsNull() {
            addCriterion("platform_no is null");
            return (Criteria) this;
        }

        public Criteria andPlatformNoIsNotNull() {
            addCriterion("platform_no is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformNoEqualTo(String value) {
            addCriterion("platform_no =", value, "platformNo");
            return (Criteria) this;
        }

        public Criteria andPlatformNoNotEqualTo(String value) {
            addCriterion("platform_no <>", value, "platformNo");
            return (Criteria) this;
        }

        public Criteria andPlatformNoGreaterThan(String value) {
            addCriterion("platform_no >", value, "platformNo");
            return (Criteria) this;
        }

        public Criteria andPlatformNoGreaterThanOrEqualTo(String value) {
            addCriterion("platform_no >=", value, "platformNo");
            return (Criteria) this;
        }

        public Criteria andPlatformNoLessThan(String value) {
            addCriterion("platform_no <", value, "platformNo");
            return (Criteria) this;
        }

        public Criteria andPlatformNoLessThanOrEqualTo(String value) {
            addCriterion("platform_no <=", value, "platformNo");
            return (Criteria) this;
        }

        public Criteria andPlatformNoLike(String value) {
            addCriterion("platform_no like", value, "platformNo");
            return (Criteria) this;
        }

        public Criteria andPlatformNoNotLike(String value) {
            addCriterion("platform_no not like", value, "platformNo");
            return (Criteria) this;
        }

        public Criteria andPlatformNoIn(List<String> values) {
            addCriterion("platform_no in", values, "platformNo");
            return (Criteria) this;
        }

        public Criteria andPlatformNoNotIn(List<String> values) {
            addCriterion("platform_no not in", values, "platformNo");
            return (Criteria) this;
        }

        public Criteria andPlatformNoBetween(String value1, String value2) {
            addCriterion("platform_no between", value1, value2, "platformNo");
            return (Criteria) this;
        }

        public Criteria andPlatformNoNotBetween(String value1, String value2) {
            addCriterion("platform_no not between", value1, value2, "platformNo");
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