package com.gznb.open.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemInterfaceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemInterfaceExample() {
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

        public Criteria andPlatformIdIsNull() {
            addCriterion("platform_id is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIsNotNull() {
            addCriterion("platform_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdEqualTo(Integer value) {
            addCriterion("platform_id =", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotEqualTo(Integer value) {
            addCriterion("platform_id <>", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdGreaterThan(Integer value) {
            addCriterion("platform_id >", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform_id >=", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdLessThan(Integer value) {
            addCriterion("platform_id <", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdLessThanOrEqualTo(Integer value) {
            addCriterion("platform_id <=", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIn(List<Integer> values) {
            addCriterion("platform_id in", values, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotIn(List<Integer> values) {
            addCriterion("platform_id not in", values, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdBetween(Integer value1, Integer value2) {
            addCriterion("platform_id between", value1, value2, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotBetween(Integer value1, Integer value2) {
            addCriterion("platform_id not between", value1, value2, "platformId");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNull() {
            addCriterion("module_id is null");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNotNull() {
            addCriterion("module_id is not null");
            return (Criteria) this;
        }

        public Criteria andModuleIdEqualTo(Integer value) {
            addCriterion("module_id =", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotEqualTo(Integer value) {
            addCriterion("module_id <>", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThan(Integer value) {
            addCriterion("module_id >", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("module_id >=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThan(Integer value) {
            addCriterion("module_id <", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("module_id <=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdIn(List<Integer> values) {
            addCriterion("module_id in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotIn(List<Integer> values) {
            addCriterion("module_id not in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdBetween(Integer value1, Integer value2) {
            addCriterion("module_id between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("module_id not between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIsNull() {
            addCriterion("interface_name is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIsNotNull() {
            addCriterion("interface_name is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameEqualTo(String value) {
            addCriterion("interface_name =", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotEqualTo(String value) {
            addCriterion("interface_name <>", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameGreaterThan(String value) {
            addCriterion("interface_name >", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameGreaterThanOrEqualTo(String value) {
            addCriterion("interface_name >=", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLessThan(String value) {
            addCriterion("interface_name <", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLessThanOrEqualTo(String value) {
            addCriterion("interface_name <=", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLike(String value) {
            addCriterion("interface_name like", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotLike(String value) {
            addCriterion("interface_name not like", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIn(List<String> values) {
            addCriterion("interface_name in", values, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotIn(List<String> values) {
            addCriterion("interface_name not in", values, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameBetween(String value1, String value2) {
            addCriterion("interface_name between", value1, value2, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotBetween(String value1, String value2) {
            addCriterion("interface_name not between", value1, value2, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlIsNull() {
            addCriterion("interface_url is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlIsNotNull() {
            addCriterion("interface_url is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlEqualTo(String value) {
            addCriterion("interface_url =", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlNotEqualTo(String value) {
            addCriterion("interface_url <>", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlGreaterThan(String value) {
            addCriterion("interface_url >", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("interface_url >=", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlLessThan(String value) {
            addCriterion("interface_url <", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlLessThanOrEqualTo(String value) {
            addCriterion("interface_url <=", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlLike(String value) {
            addCriterion("interface_url like", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlNotLike(String value) {
            addCriterion("interface_url not like", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlIn(List<String> values) {
            addCriterion("interface_url in", values, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlNotIn(List<String> values) {
            addCriterion("interface_url not in", values, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlBetween(String value1, String value2) {
            addCriterion("interface_url between", value1, value2, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlNotBetween(String value1, String value2) {
            addCriterion("interface_url not between", value1, value2, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andRequestModeIsNull() {
            addCriterion("request_mode is null");
            return (Criteria) this;
        }

        public Criteria andRequestModeIsNotNull() {
            addCriterion("request_mode is not null");
            return (Criteria) this;
        }

        public Criteria andRequestModeEqualTo(String value) {
            addCriterion("request_mode =", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeNotEqualTo(String value) {
            addCriterion("request_mode <>", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeGreaterThan(String value) {
            addCriterion("request_mode >", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeGreaterThanOrEqualTo(String value) {
            addCriterion("request_mode >=", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeLessThan(String value) {
            addCriterion("request_mode <", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeLessThanOrEqualTo(String value) {
            addCriterion("request_mode <=", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeLike(String value) {
            addCriterion("request_mode like", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeNotLike(String value) {
            addCriterion("request_mode not like", value, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeIn(List<String> values) {
            addCriterion("request_mode in", values, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeNotIn(List<String> values) {
            addCriterion("request_mode not in", values, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeBetween(String value1, String value2) {
            addCriterion("request_mode between", value1, value2, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestModeNotBetween(String value1, String value2) {
            addCriterion("request_mode not between", value1, value2, "requestMode");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatIsNull() {
            addCriterion("request_param_format is null");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatIsNotNull() {
            addCriterion("request_param_format is not null");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatEqualTo(String value) {
            addCriterion("request_param_format =", value, "requestParamFormat");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatNotEqualTo(String value) {
            addCriterion("request_param_format <>", value, "requestParamFormat");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatGreaterThan(String value) {
            addCriterion("request_param_format >", value, "requestParamFormat");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatGreaterThanOrEqualTo(String value) {
            addCriterion("request_param_format >=", value, "requestParamFormat");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatLessThan(String value) {
            addCriterion("request_param_format <", value, "requestParamFormat");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatLessThanOrEqualTo(String value) {
            addCriterion("request_param_format <=", value, "requestParamFormat");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatLike(String value) {
            addCriterion("request_param_format like", value, "requestParamFormat");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatNotLike(String value) {
            addCriterion("request_param_format not like", value, "requestParamFormat");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatIn(List<String> values) {
            addCriterion("request_param_format in", values, "requestParamFormat");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatNotIn(List<String> values) {
            addCriterion("request_param_format not in", values, "requestParamFormat");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatBetween(String value1, String value2) {
            addCriterion("request_param_format between", value1, value2, "requestParamFormat");
            return (Criteria) this;
        }

        public Criteria andRequestParamFormatNotBetween(String value1, String value2) {
            addCriterion("request_param_format not between", value1, value2, "requestParamFormat");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusIsNull() {
            addCriterion("interface_status is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusIsNotNull() {
            addCriterion("interface_status is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusEqualTo(String value) {
            addCriterion("interface_status =", value, "interfaceStatus");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusNotEqualTo(String value) {
            addCriterion("interface_status <>", value, "interfaceStatus");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusGreaterThan(String value) {
            addCriterion("interface_status >", value, "interfaceStatus");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("interface_status >=", value, "interfaceStatus");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusLessThan(String value) {
            addCriterion("interface_status <", value, "interfaceStatus");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusLessThanOrEqualTo(String value) {
            addCriterion("interface_status <=", value, "interfaceStatus");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusLike(String value) {
            addCriterion("interface_status like", value, "interfaceStatus");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusNotLike(String value) {
            addCriterion("interface_status not like", value, "interfaceStatus");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusIn(List<String> values) {
            addCriterion("interface_status in", values, "interfaceStatus");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusNotIn(List<String> values) {
            addCriterion("interface_status not in", values, "interfaceStatus");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusBetween(String value1, String value2) {
            addCriterion("interface_status between", value1, value2, "interfaceStatus");
            return (Criteria) this;
        }

        public Criteria andInterfaceStatusNotBetween(String value1, String value2) {
            addCriterion("interface_status not between", value1, value2, "interfaceStatus");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionIsNull() {
            addCriterion("interface_version is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionIsNotNull() {
            addCriterion("interface_version is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionEqualTo(String value) {
            addCriterion("interface_version =", value, "interfaceVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionNotEqualTo(String value) {
            addCriterion("interface_version <>", value, "interfaceVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionGreaterThan(String value) {
            addCriterion("interface_version >", value, "interfaceVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionGreaterThanOrEqualTo(String value) {
            addCriterion("interface_version >=", value, "interfaceVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionLessThan(String value) {
            addCriterion("interface_version <", value, "interfaceVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionLessThanOrEqualTo(String value) {
            addCriterion("interface_version <=", value, "interfaceVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionLike(String value) {
            addCriterion("interface_version like", value, "interfaceVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionNotLike(String value) {
            addCriterion("interface_version not like", value, "interfaceVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionIn(List<String> values) {
            addCriterion("interface_version in", values, "interfaceVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionNotIn(List<String> values) {
            addCriterion("interface_version not in", values, "interfaceVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionBetween(String value1, String value2) {
            addCriterion("interface_version between", value1, value2, "interfaceVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceVersionNotBetween(String value1, String value2) {
            addCriterion("interface_version not between", value1, value2, "interfaceVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceSortIsNull() {
            addCriterion("interface_sort is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceSortIsNotNull() {
            addCriterion("interface_sort is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceSortEqualTo(Integer value) {
            addCriterion("interface_sort =", value, "interfaceSort");
            return (Criteria) this;
        }

        public Criteria andInterfaceSortNotEqualTo(Integer value) {
            addCriterion("interface_sort <>", value, "interfaceSort");
            return (Criteria) this;
        }

        public Criteria andInterfaceSortGreaterThan(Integer value) {
            addCriterion("interface_sort >", value, "interfaceSort");
            return (Criteria) this;
        }

        public Criteria andInterfaceSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("interface_sort >=", value, "interfaceSort");
            return (Criteria) this;
        }

        public Criteria andInterfaceSortLessThan(Integer value) {
            addCriterion("interface_sort <", value, "interfaceSort");
            return (Criteria) this;
        }

        public Criteria andInterfaceSortLessThanOrEqualTo(Integer value) {
            addCriterion("interface_sort <=", value, "interfaceSort");
            return (Criteria) this;
        }

        public Criteria andInterfaceSortIn(List<Integer> values) {
            addCriterion("interface_sort in", values, "interfaceSort");
            return (Criteria) this;
        }

        public Criteria andInterfaceSortNotIn(List<Integer> values) {
            addCriterion("interface_sort not in", values, "interfaceSort");
            return (Criteria) this;
        }

        public Criteria andInterfaceSortBetween(Integer value1, Integer value2) {
            addCriterion("interface_sort between", value1, value2, "interfaceSort");
            return (Criteria) this;
        }

        public Criteria andInterfaceSortNotBetween(Integer value1, Integer value2) {
            addCriterion("interface_sort not between", value1, value2, "interfaceSort");
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

        public Criteria andResponseParamFormatIsNull() {
            addCriterion("response_param_format is null");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatIsNotNull() {
            addCriterion("response_param_format is not null");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatEqualTo(String value) {
            addCriterion("response_param_format =", value, "responseParamFormat");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatNotEqualTo(String value) {
            addCriterion("response_param_format <>", value, "responseParamFormat");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatGreaterThan(String value) {
            addCriterion("response_param_format >", value, "responseParamFormat");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatGreaterThanOrEqualTo(String value) {
            addCriterion("response_param_format >=", value, "responseParamFormat");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatLessThan(String value) {
            addCriterion("response_param_format <", value, "responseParamFormat");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatLessThanOrEqualTo(String value) {
            addCriterion("response_param_format <=", value, "responseParamFormat");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatLike(String value) {
            addCriterion("response_param_format like", value, "responseParamFormat");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatNotLike(String value) {
            addCriterion("response_param_format not like", value, "responseParamFormat");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatIn(List<String> values) {
            addCriterion("response_param_format in", values, "responseParamFormat");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatNotIn(List<String> values) {
            addCriterion("response_param_format not in", values, "responseParamFormat");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatBetween(String value1, String value2) {
            addCriterion("response_param_format between", value1, value2, "responseParamFormat");
            return (Criteria) this;
        }

        public Criteria andResponseParamFormatNotBetween(String value1, String value2) {
            addCriterion("response_param_format not between", value1, value2, "responseParamFormat");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeIsNull() {
            addCriterion("req_param_wrapper_type is null");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeIsNotNull() {
            addCriterion("req_param_wrapper_type is not null");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeEqualTo(String value) {
            addCriterion("req_param_wrapper_type =", value, "reqParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeNotEqualTo(String value) {
            addCriterion("req_param_wrapper_type <>", value, "reqParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeGreaterThan(String value) {
            addCriterion("req_param_wrapper_type >", value, "reqParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("req_param_wrapper_type >=", value, "reqParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeLessThan(String value) {
            addCriterion("req_param_wrapper_type <", value, "reqParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeLessThanOrEqualTo(String value) {
            addCriterion("req_param_wrapper_type <=", value, "reqParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeLike(String value) {
            addCriterion("req_param_wrapper_type like", value, "reqParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeNotLike(String value) {
            addCriterion("req_param_wrapper_type not like", value, "reqParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeIn(List<String> values) {
            addCriterion("req_param_wrapper_type in", values, "reqParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeNotIn(List<String> values) {
            addCriterion("req_param_wrapper_type not in", values, "reqParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeBetween(String value1, String value2) {
            addCriterion("req_param_wrapper_type between", value1, value2, "reqParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andReqParamWrapperTypeNotBetween(String value1, String value2) {
            addCriterion("req_param_wrapper_type not between", value1, value2, "reqParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andReqSignDescIsNull() {
            addCriterion("req_sign_desc is null");
            return (Criteria) this;
        }

        public Criteria andReqSignDescIsNotNull() {
            addCriterion("req_sign_desc is not null");
            return (Criteria) this;
        }

        public Criteria andReqSignDescEqualTo(String value) {
            addCriterion("req_sign_desc =", value, "reqSignDesc");
            return (Criteria) this;
        }

        public Criteria andReqSignDescNotEqualTo(String value) {
            addCriterion("req_sign_desc <>", value, "reqSignDesc");
            return (Criteria) this;
        }

        public Criteria andReqSignDescGreaterThan(String value) {
            addCriterion("req_sign_desc >", value, "reqSignDesc");
            return (Criteria) this;
        }

        public Criteria andReqSignDescGreaterThanOrEqualTo(String value) {
            addCriterion("req_sign_desc >=", value, "reqSignDesc");
            return (Criteria) this;
        }

        public Criteria andReqSignDescLessThan(String value) {
            addCriterion("req_sign_desc <", value, "reqSignDesc");
            return (Criteria) this;
        }

        public Criteria andReqSignDescLessThanOrEqualTo(String value) {
            addCriterion("req_sign_desc <=", value, "reqSignDesc");
            return (Criteria) this;
        }

        public Criteria andReqSignDescLike(String value) {
            addCriterion("req_sign_desc like", value, "reqSignDesc");
            return (Criteria) this;
        }

        public Criteria andReqSignDescNotLike(String value) {
            addCriterion("req_sign_desc not like", value, "reqSignDesc");
            return (Criteria) this;
        }

        public Criteria andReqSignDescIn(List<String> values) {
            addCriterion("req_sign_desc in", values, "reqSignDesc");
            return (Criteria) this;
        }

        public Criteria andReqSignDescNotIn(List<String> values) {
            addCriterion("req_sign_desc not in", values, "reqSignDesc");
            return (Criteria) this;
        }

        public Criteria andReqSignDescBetween(String value1, String value2) {
            addCriterion("req_sign_desc between", value1, value2, "reqSignDesc");
            return (Criteria) this;
        }

        public Criteria andReqSignDescNotBetween(String value1, String value2) {
            addCriterion("req_sign_desc not between", value1, value2, "reqSignDesc");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeIsNull() {
            addCriterion("resp_param_wrapper_type is null");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeIsNotNull() {
            addCriterion("resp_param_wrapper_type is not null");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeEqualTo(String value) {
            addCriterion("resp_param_wrapper_type =", value, "respParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeNotEqualTo(String value) {
            addCriterion("resp_param_wrapper_type <>", value, "respParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeGreaterThan(String value) {
            addCriterion("resp_param_wrapper_type >", value, "respParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("resp_param_wrapper_type >=", value, "respParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeLessThan(String value) {
            addCriterion("resp_param_wrapper_type <", value, "respParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeLessThanOrEqualTo(String value) {
            addCriterion("resp_param_wrapper_type <=", value, "respParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeLike(String value) {
            addCriterion("resp_param_wrapper_type like", value, "respParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeNotLike(String value) {
            addCriterion("resp_param_wrapper_type not like", value, "respParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeIn(List<String> values) {
            addCriterion("resp_param_wrapper_type in", values, "respParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeNotIn(List<String> values) {
            addCriterion("resp_param_wrapper_type not in", values, "respParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeBetween(String value1, String value2) {
            addCriterion("resp_param_wrapper_type between", value1, value2, "respParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andRespParamWrapperTypeNotBetween(String value1, String value2) {
            addCriterion("resp_param_wrapper_type not between", value1, value2, "respParamWrapperType");
            return (Criteria) this;
        }

        public Criteria andRespSignDescIsNull() {
            addCriterion("resp_sign_desc is null");
            return (Criteria) this;
        }

        public Criteria andRespSignDescIsNotNull() {
            addCriterion("resp_sign_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRespSignDescEqualTo(String value) {
            addCriterion("resp_sign_desc =", value, "respSignDesc");
            return (Criteria) this;
        }

        public Criteria andRespSignDescNotEqualTo(String value) {
            addCriterion("resp_sign_desc <>", value, "respSignDesc");
            return (Criteria) this;
        }

        public Criteria andRespSignDescGreaterThan(String value) {
            addCriterion("resp_sign_desc >", value, "respSignDesc");
            return (Criteria) this;
        }

        public Criteria andRespSignDescGreaterThanOrEqualTo(String value) {
            addCriterion("resp_sign_desc >=", value, "respSignDesc");
            return (Criteria) this;
        }

        public Criteria andRespSignDescLessThan(String value) {
            addCriterion("resp_sign_desc <", value, "respSignDesc");
            return (Criteria) this;
        }

        public Criteria andRespSignDescLessThanOrEqualTo(String value) {
            addCriterion("resp_sign_desc <=", value, "respSignDesc");
            return (Criteria) this;
        }

        public Criteria andRespSignDescLike(String value) {
            addCriterion("resp_sign_desc like", value, "respSignDesc");
            return (Criteria) this;
        }

        public Criteria andRespSignDescNotLike(String value) {
            addCriterion("resp_sign_desc not like", value, "respSignDesc");
            return (Criteria) this;
        }

        public Criteria andRespSignDescIn(List<String> values) {
            addCriterion("resp_sign_desc in", values, "respSignDesc");
            return (Criteria) this;
        }

        public Criteria andRespSignDescNotIn(List<String> values) {
            addCriterion("resp_sign_desc not in", values, "respSignDesc");
            return (Criteria) this;
        }

        public Criteria andRespSignDescBetween(String value1, String value2) {
            addCriterion("resp_sign_desc between", value1, value2, "respSignDesc");
            return (Criteria) this;
        }

        public Criteria andRespSignDescNotBetween(String value1, String value2) {
            addCriterion("resp_sign_desc not between", value1, value2, "respSignDesc");
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