package com.gznb.open.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessPlatformChannelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessPlatformChannelExample() {
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

        public Criteria andBusMerchantIdIsNull() {
            addCriterion("bus_merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andBusMerchantIdIsNotNull() {
            addCriterion("bus_merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusMerchantIdEqualTo(Integer value) {
            addCriterion("bus_merchant_id =", value, "busMerchantId");
            return (Criteria) this;
        }

        public Criteria andBusMerchantIdNotEqualTo(Integer value) {
            addCriterion("bus_merchant_id <>", value, "busMerchantId");
            return (Criteria) this;
        }

        public Criteria andBusMerchantIdGreaterThan(Integer value) {
            addCriterion("bus_merchant_id >", value, "busMerchantId");
            return (Criteria) this;
        }

        public Criteria andBusMerchantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bus_merchant_id >=", value, "busMerchantId");
            return (Criteria) this;
        }

        public Criteria andBusMerchantIdLessThan(Integer value) {
            addCriterion("bus_merchant_id <", value, "busMerchantId");
            return (Criteria) this;
        }

        public Criteria andBusMerchantIdLessThanOrEqualTo(Integer value) {
            addCriterion("bus_merchant_id <=", value, "busMerchantId");
            return (Criteria) this;
        }

        public Criteria andBusMerchantIdIn(List<Integer> values) {
            addCriterion("bus_merchant_id in", values, "busMerchantId");
            return (Criteria) this;
        }

        public Criteria andBusMerchantIdNotIn(List<Integer> values) {
            addCriterion("bus_merchant_id not in", values, "busMerchantId");
            return (Criteria) this;
        }

        public Criteria andBusMerchantIdBetween(Integer value1, Integer value2) {
            addCriterion("bus_merchant_id between", value1, value2, "busMerchantId");
            return (Criteria) this;
        }

        public Criteria andBusMerchantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bus_merchant_id not between", value1, value2, "busMerchantId");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoIsNull() {
            addCriterion("bus_channel_no is null");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoIsNotNull() {
            addCriterion("bus_channel_no is not null");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoEqualTo(String value) {
            addCriterion("bus_channel_no =", value, "busChannelNo");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoNotEqualTo(String value) {
            addCriterion("bus_channel_no <>", value, "busChannelNo");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoGreaterThan(String value) {
            addCriterion("bus_channel_no >", value, "busChannelNo");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoGreaterThanOrEqualTo(String value) {
            addCriterion("bus_channel_no >=", value, "busChannelNo");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoLessThan(String value) {
            addCriterion("bus_channel_no <", value, "busChannelNo");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoLessThanOrEqualTo(String value) {
            addCriterion("bus_channel_no <=", value, "busChannelNo");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoLike(String value) {
            addCriterion("bus_channel_no like", value, "busChannelNo");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoNotLike(String value) {
            addCriterion("bus_channel_no not like", value, "busChannelNo");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoIn(List<String> values) {
            addCriterion("bus_channel_no in", values, "busChannelNo");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoNotIn(List<String> values) {
            addCriterion("bus_channel_no not in", values, "busChannelNo");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoBetween(String value1, String value2) {
            addCriterion("bus_channel_no between", value1, value2, "busChannelNo");
            return (Criteria) this;
        }

        public Criteria andBusChannelNoNotBetween(String value1, String value2) {
            addCriterion("bus_channel_no not between", value1, value2, "busChannelNo");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameIsNull() {
            addCriterion("bus_channel_name is null");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameIsNotNull() {
            addCriterion("bus_channel_name is not null");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameEqualTo(String value) {
            addCriterion("bus_channel_name =", value, "busChannelName");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameNotEqualTo(String value) {
            addCriterion("bus_channel_name <>", value, "busChannelName");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameGreaterThan(String value) {
            addCriterion("bus_channel_name >", value, "busChannelName");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("bus_channel_name >=", value, "busChannelName");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameLessThan(String value) {
            addCriterion("bus_channel_name <", value, "busChannelName");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameLessThanOrEqualTo(String value) {
            addCriterion("bus_channel_name <=", value, "busChannelName");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameLike(String value) {
            addCriterion("bus_channel_name like", value, "busChannelName");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameNotLike(String value) {
            addCriterion("bus_channel_name not like", value, "busChannelName");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameIn(List<String> values) {
            addCriterion("bus_channel_name in", values, "busChannelName");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameNotIn(List<String> values) {
            addCriterion("bus_channel_name not in", values, "busChannelName");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameBetween(String value1, String value2) {
            addCriterion("bus_channel_name between", value1, value2, "busChannelName");
            return (Criteria) this;
        }

        public Criteria andBusChannelNameNotBetween(String value1, String value2) {
            addCriterion("bus_channel_name not between", value1, value2, "busChannelName");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeIsNull() {
            addCriterion("bus_channel_type is null");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeIsNotNull() {
            addCriterion("bus_channel_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeEqualTo(String value) {
            addCriterion("bus_channel_type =", value, "busChannelType");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeNotEqualTo(String value) {
            addCriterion("bus_channel_type <>", value, "busChannelType");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeGreaterThan(String value) {
            addCriterion("bus_channel_type >", value, "busChannelType");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bus_channel_type >=", value, "busChannelType");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeLessThan(String value) {
            addCriterion("bus_channel_type <", value, "busChannelType");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeLessThanOrEqualTo(String value) {
            addCriterion("bus_channel_type <=", value, "busChannelType");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeLike(String value) {
            addCriterion("bus_channel_type like", value, "busChannelType");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeNotLike(String value) {
            addCriterion("bus_channel_type not like", value, "busChannelType");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeIn(List<String> values) {
            addCriterion("bus_channel_type in", values, "busChannelType");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeNotIn(List<String> values) {
            addCriterion("bus_channel_type not in", values, "busChannelType");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeBetween(String value1, String value2) {
            addCriterion("bus_channel_type between", value1, value2, "busChannelType");
            return (Criteria) this;
        }

        public Criteria andBusChannelTypeNotBetween(String value1, String value2) {
            addCriterion("bus_channel_type not between", value1, value2, "busChannelType");
            return (Criteria) this;
        }

        public Criteria andChannelStatusIsNull() {
            addCriterion("channel_status is null");
            return (Criteria) this;
        }

        public Criteria andChannelStatusIsNotNull() {
            addCriterion("channel_status is not null");
            return (Criteria) this;
        }

        public Criteria andChannelStatusEqualTo(String value) {
            addCriterion("channel_status =", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotEqualTo(String value) {
            addCriterion("channel_status <>", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusGreaterThan(String value) {
            addCriterion("channel_status >", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusGreaterThanOrEqualTo(String value) {
            addCriterion("channel_status >=", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusLessThan(String value) {
            addCriterion("channel_status <", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusLessThanOrEqualTo(String value) {
            addCriterion("channel_status <=", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusLike(String value) {
            addCriterion("channel_status like", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotLike(String value) {
            addCriterion("channel_status not like", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusIn(List<String> values) {
            addCriterion("channel_status in", values, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotIn(List<String> values) {
            addCriterion("channel_status not in", values, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusBetween(String value1, String value2) {
            addCriterion("channel_status between", value1, value2, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotBetween(String value1, String value2) {
            addCriterion("channel_status not between", value1, value2, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andEnvFlagIsNull() {
            addCriterion("env_flag is null");
            return (Criteria) this;
        }

        public Criteria andEnvFlagIsNotNull() {
            addCriterion("env_flag is not null");
            return (Criteria) this;
        }

        public Criteria andEnvFlagEqualTo(String value) {
            addCriterion("env_flag =", value, "envFlag");
            return (Criteria) this;
        }

        public Criteria andEnvFlagNotEqualTo(String value) {
            addCriterion("env_flag <>", value, "envFlag");
            return (Criteria) this;
        }

        public Criteria andEnvFlagGreaterThan(String value) {
            addCriterion("env_flag >", value, "envFlag");
            return (Criteria) this;
        }

        public Criteria andEnvFlagGreaterThanOrEqualTo(String value) {
            addCriterion("env_flag >=", value, "envFlag");
            return (Criteria) this;
        }

        public Criteria andEnvFlagLessThan(String value) {
            addCriterion("env_flag <", value, "envFlag");
            return (Criteria) this;
        }

        public Criteria andEnvFlagLessThanOrEqualTo(String value) {
            addCriterion("env_flag <=", value, "envFlag");
            return (Criteria) this;
        }

        public Criteria andEnvFlagLike(String value) {
            addCriterion("env_flag like", value, "envFlag");
            return (Criteria) this;
        }

        public Criteria andEnvFlagNotLike(String value) {
            addCriterion("env_flag not like", value, "envFlag");
            return (Criteria) this;
        }

        public Criteria andEnvFlagIn(List<String> values) {
            addCriterion("env_flag in", values, "envFlag");
            return (Criteria) this;
        }

        public Criteria andEnvFlagNotIn(List<String> values) {
            addCriterion("env_flag not in", values, "envFlag");
            return (Criteria) this;
        }

        public Criteria andEnvFlagBetween(String value1, String value2) {
            addCriterion("env_flag between", value1, value2, "envFlag");
            return (Criteria) this;
        }

        public Criteria andEnvFlagNotBetween(String value1, String value2) {
            addCriterion("env_flag not between", value1, value2, "envFlag");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdIsNull() {
            addCriterion("channel_app_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdIsNotNull() {
            addCriterion("channel_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdEqualTo(String value) {
            addCriterion("channel_app_id =", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotEqualTo(String value) {
            addCriterion("channel_app_id <>", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdGreaterThan(String value) {
            addCriterion("channel_app_id >", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_app_id >=", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdLessThan(String value) {
            addCriterion("channel_app_id <", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdLessThanOrEqualTo(String value) {
            addCriterion("channel_app_id <=", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdLike(String value) {
            addCriterion("channel_app_id like", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotLike(String value) {
            addCriterion("channel_app_id not like", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdIn(List<String> values) {
            addCriterion("channel_app_id in", values, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotIn(List<String> values) {
            addCriterion("channel_app_id not in", values, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdBetween(String value1, String value2) {
            addCriterion("channel_app_id between", value1, value2, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotBetween(String value1, String value2) {
            addCriterion("channel_app_id not between", value1, value2, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeIsNull() {
            addCriterion("channel_encrypt_type is null");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeIsNotNull() {
            addCriterion("channel_encrypt_type is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeEqualTo(String value) {
            addCriterion("channel_encrypt_type =", value, "channelEncryptType");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeNotEqualTo(String value) {
            addCriterion("channel_encrypt_type <>", value, "channelEncryptType");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeGreaterThan(String value) {
            addCriterion("channel_encrypt_type >", value, "channelEncryptType");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeGreaterThanOrEqualTo(String value) {
            addCriterion("channel_encrypt_type >=", value, "channelEncryptType");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeLessThan(String value) {
            addCriterion("channel_encrypt_type <", value, "channelEncryptType");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeLessThanOrEqualTo(String value) {
            addCriterion("channel_encrypt_type <=", value, "channelEncryptType");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeLike(String value) {
            addCriterion("channel_encrypt_type like", value, "channelEncryptType");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeNotLike(String value) {
            addCriterion("channel_encrypt_type not like", value, "channelEncryptType");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeIn(List<String> values) {
            addCriterion("channel_encrypt_type in", values, "channelEncryptType");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeNotIn(List<String> values) {
            addCriterion("channel_encrypt_type not in", values, "channelEncryptType");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeBetween(String value1, String value2) {
            addCriterion("channel_encrypt_type between", value1, value2, "channelEncryptType");
            return (Criteria) this;
        }

        public Criteria andChannelEncryptTypeNotBetween(String value1, String value2) {
            addCriterion("channel_encrypt_type not between", value1, value2, "channelEncryptType");
            return (Criteria) this;
        }

        public Criteria andCertPathIsNull() {
            addCriterion("cert_path is null");
            return (Criteria) this;
        }

        public Criteria andCertPathIsNotNull() {
            addCriterion("cert_path is not null");
            return (Criteria) this;
        }

        public Criteria andCertPathEqualTo(String value) {
            addCriterion("cert_path =", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathNotEqualTo(String value) {
            addCriterion("cert_path <>", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathGreaterThan(String value) {
            addCriterion("cert_path >", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathGreaterThanOrEqualTo(String value) {
            addCriterion("cert_path >=", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathLessThan(String value) {
            addCriterion("cert_path <", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathLessThanOrEqualTo(String value) {
            addCriterion("cert_path <=", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathLike(String value) {
            addCriterion("cert_path like", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathNotLike(String value) {
            addCriterion("cert_path not like", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathIn(List<String> values) {
            addCriterion("cert_path in", values, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathNotIn(List<String> values) {
            addCriterion("cert_path not in", values, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathBetween(String value1, String value2) {
            addCriterion("cert_path between", value1, value2, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathNotBetween(String value1, String value2) {
            addCriterion("cert_path not between", value1, value2, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPasswordIsNull() {
            addCriterion("cert_password is null");
            return (Criteria) this;
        }

        public Criteria andCertPasswordIsNotNull() {
            addCriterion("cert_password is not null");
            return (Criteria) this;
        }

        public Criteria andCertPasswordEqualTo(String value) {
            addCriterion("cert_password =", value, "certPassword");
            return (Criteria) this;
        }

        public Criteria andCertPasswordNotEqualTo(String value) {
            addCriterion("cert_password <>", value, "certPassword");
            return (Criteria) this;
        }

        public Criteria andCertPasswordGreaterThan(String value) {
            addCriterion("cert_password >", value, "certPassword");
            return (Criteria) this;
        }

        public Criteria andCertPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("cert_password >=", value, "certPassword");
            return (Criteria) this;
        }

        public Criteria andCertPasswordLessThan(String value) {
            addCriterion("cert_password <", value, "certPassword");
            return (Criteria) this;
        }

        public Criteria andCertPasswordLessThanOrEqualTo(String value) {
            addCriterion("cert_password <=", value, "certPassword");
            return (Criteria) this;
        }

        public Criteria andCertPasswordLike(String value) {
            addCriterion("cert_password like", value, "certPassword");
            return (Criteria) this;
        }

        public Criteria andCertPasswordNotLike(String value) {
            addCriterion("cert_password not like", value, "certPassword");
            return (Criteria) this;
        }

        public Criteria andCertPasswordIn(List<String> values) {
            addCriterion("cert_password in", values, "certPassword");
            return (Criteria) this;
        }

        public Criteria andCertPasswordNotIn(List<String> values) {
            addCriterion("cert_password not in", values, "certPassword");
            return (Criteria) this;
        }

        public Criteria andCertPasswordBetween(String value1, String value2) {
            addCriterion("cert_password between", value1, value2, "certPassword");
            return (Criteria) this;
        }

        public Criteria andCertPasswordNotBetween(String value1, String value2) {
            addCriterion("cert_password not between", value1, value2, "certPassword");
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

        public Criteria andChannelMerIdIsNull() {
            addCriterion("channel_mer_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdIsNotNull() {
            addCriterion("channel_mer_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdEqualTo(String value) {
            addCriterion("channel_mer_id =", value, "channelMerId");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdNotEqualTo(String value) {
            addCriterion("channel_mer_id <>", value, "channelMerId");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdGreaterThan(String value) {
            addCriterion("channel_mer_id >", value, "channelMerId");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_mer_id >=", value, "channelMerId");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdLessThan(String value) {
            addCriterion("channel_mer_id <", value, "channelMerId");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdLessThanOrEqualTo(String value) {
            addCriterion("channel_mer_id <=", value, "channelMerId");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdLike(String value) {
            addCriterion("channel_mer_id like", value, "channelMerId");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdNotLike(String value) {
            addCriterion("channel_mer_id not like", value, "channelMerId");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdIn(List<String> values) {
            addCriterion("channel_mer_id in", values, "channelMerId");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdNotIn(List<String> values) {
            addCriterion("channel_mer_id not in", values, "channelMerId");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdBetween(String value1, String value2) {
            addCriterion("channel_mer_id between", value1, value2, "channelMerId");
            return (Criteria) this;
        }

        public Criteria andChannelMerIdNotBetween(String value1, String value2) {
            addCriterion("channel_mer_id not between", value1, value2, "channelMerId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdIsNull() {
            addCriterion("channel_open_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdIsNotNull() {
            addCriterion("channel_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdEqualTo(String value) {
            addCriterion("channel_open_id =", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdNotEqualTo(String value) {
            addCriterion("channel_open_id <>", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdGreaterThan(String value) {
            addCriterion("channel_open_id >", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_open_id >=", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdLessThan(String value) {
            addCriterion("channel_open_id <", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdLessThanOrEqualTo(String value) {
            addCriterion("channel_open_id <=", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdLike(String value) {
            addCriterion("channel_open_id like", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdNotLike(String value) {
            addCriterion("channel_open_id not like", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdIn(List<String> values) {
            addCriterion("channel_open_id in", values, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdNotIn(List<String> values) {
            addCriterion("channel_open_id not in", values, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdBetween(String value1, String value2) {
            addCriterion("channel_open_id between", value1, value2, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdNotBetween(String value1, String value2) {
            addCriterion("channel_open_id not between", value1, value2, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoIsNull() {
            addCriterion("bus_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoIsNotNull() {
            addCriterion("bus_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoEqualTo(String value) {
            addCriterion("bus_merchant_no =", value, "busMerchantNo");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoNotEqualTo(String value) {
            addCriterion("bus_merchant_no <>", value, "busMerchantNo");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoGreaterThan(String value) {
            addCriterion("bus_merchant_no >", value, "busMerchantNo");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("bus_merchant_no >=", value, "busMerchantNo");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoLessThan(String value) {
            addCriterion("bus_merchant_no <", value, "busMerchantNo");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("bus_merchant_no <=", value, "busMerchantNo");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoLike(String value) {
            addCriterion("bus_merchant_no like", value, "busMerchantNo");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoNotLike(String value) {
            addCriterion("bus_merchant_no not like", value, "busMerchantNo");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoIn(List<String> values) {
            addCriterion("bus_merchant_no in", values, "busMerchantNo");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoNotIn(List<String> values) {
            addCriterion("bus_merchant_no not in", values, "busMerchantNo");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoBetween(String value1, String value2) {
            addCriterion("bus_merchant_no between", value1, value2, "busMerchantNo");
            return (Criteria) this;
        }

        public Criteria andBusMerchantNoNotBetween(String value1, String value2) {
            addCriterion("bus_merchant_no not between", value1, value2, "busMerchantNo");
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