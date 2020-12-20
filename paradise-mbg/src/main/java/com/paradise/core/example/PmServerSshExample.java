package com.paradise.core.example;

import com.paradise.core.model.PmServerSsh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PmServerSshExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmServerSshExample() {
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

    public PmServerSshExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public PmServerSshExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static Criteria newAndCreateCriteria() {
        PmServerSshExample example = new PmServerSshExample();
        return example.createCriteria();
    }

    public PmServerSshExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public PmServerSshExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
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

        public Criteria andIpAddrIsNull() {
            addCriterion("ip_addr is null");
            return (Criteria) this;
        }

        public Criteria andIpAddrIsNotNull() {
            addCriterion("ip_addr is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddrEqualTo(String value) {
            addCriterion("ip_addr =", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("ip_addr = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIpAddrNotEqualTo(String value) {
            addCriterion("ip_addr <>", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("ip_addr <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIpAddrGreaterThan(String value) {
            addCriterion("ip_addr >", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("ip_addr > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIpAddrGreaterThanOrEqualTo(String value) {
            addCriterion("ip_addr >=", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("ip_addr >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIpAddrLessThan(String value) {
            addCriterion("ip_addr <", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("ip_addr < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIpAddrLessThanOrEqualTo(String value) {
            addCriterion("ip_addr <=", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("ip_addr <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIpAddrLike(String value) {
            addCriterion("ip_addr like", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotLike(String value) {
            addCriterion("ip_addr not like", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrIn(List<String> values) {
            addCriterion("ip_addr in", values, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotIn(List<String> values) {
            addCriterion("ip_addr not in", values, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrBetween(String value1, String value2) {
            addCriterion("ip_addr between", value1, value2, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotBetween(String value1, String value2) {
            addCriterion("ip_addr not between", value1, value2, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicIsNull() {
            addCriterion("ip_addr_public is null");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicIsNotNull() {
            addCriterion("ip_addr_public is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicEqualTo(String value) {
            addCriterion("ip_addr_public =", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("ip_addr_public = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicNotEqualTo(String value) {
            addCriterion("ip_addr_public <>", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("ip_addr_public <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicGreaterThan(String value) {
            addCriterion("ip_addr_public >", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("ip_addr_public > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicGreaterThanOrEqualTo(String value) {
            addCriterion("ip_addr_public >=", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("ip_addr_public >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicLessThan(String value) {
            addCriterion("ip_addr_public <", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("ip_addr_public < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicLessThanOrEqualTo(String value) {
            addCriterion("ip_addr_public <=", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("ip_addr_public <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicLike(String value) {
            addCriterion("ip_addr_public like", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicNotLike(String value) {
            addCriterion("ip_addr_public not like", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicIn(List<String> values) {
            addCriterion("ip_addr_public in", values, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicNotIn(List<String> values) {
            addCriterion("ip_addr_public not in", values, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicBetween(String value1, String value2) {
            addCriterion("ip_addr_public between", value1, value2, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicNotBetween(String value1, String value2) {
            addCriterion("ip_addr_public not between", value1, value2, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andDomainAddrIsNull() {
            addCriterion("domain_addr is null");
            return (Criteria) this;
        }

        public Criteria andDomainAddrIsNotNull() {
            addCriterion("domain_addr is not null");
            return (Criteria) this;
        }

        public Criteria andDomainAddrEqualTo(String value) {
            addCriterion("domain_addr =", value, "domainAddr");
            return (Criteria) this;
        }

        public Criteria andDomainAddrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("domain_addr = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDomainAddrNotEqualTo(String value) {
            addCriterion("domain_addr <>", value, "domainAddr");
            return (Criteria) this;
        }

        public Criteria andDomainAddrNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("domain_addr <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDomainAddrGreaterThan(String value) {
            addCriterion("domain_addr >", value, "domainAddr");
            return (Criteria) this;
        }

        public Criteria andDomainAddrGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("domain_addr > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDomainAddrGreaterThanOrEqualTo(String value) {
            addCriterion("domain_addr >=", value, "domainAddr");
            return (Criteria) this;
        }

        public Criteria andDomainAddrGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("domain_addr >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDomainAddrLessThan(String value) {
            addCriterion("domain_addr <", value, "domainAddr");
            return (Criteria) this;
        }

        public Criteria andDomainAddrLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("domain_addr < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDomainAddrLessThanOrEqualTo(String value) {
            addCriterion("domain_addr <=", value, "domainAddr");
            return (Criteria) this;
        }

        public Criteria andDomainAddrLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("domain_addr <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDomainAddrLike(String value) {
            addCriterion("domain_addr like", value, "domainAddr");
            return (Criteria) this;
        }

        public Criteria andDomainAddrNotLike(String value) {
            addCriterion("domain_addr not like", value, "domainAddr");
            return (Criteria) this;
        }

        public Criteria andDomainAddrIn(List<String> values) {
            addCriterion("domain_addr in", values, "domainAddr");
            return (Criteria) this;
        }

        public Criteria andDomainAddrNotIn(List<String> values) {
            addCriterion("domain_addr not in", values, "domainAddr");
            return (Criteria) this;
        }

        public Criteria andDomainAddrBetween(String value1, String value2) {
            addCriterion("domain_addr between", value1, value2, "domainAddr");
            return (Criteria) this;
        }

        public Criteria andDomainAddrNotBetween(String value1, String value2) {
            addCriterion("domain_addr not between", value1, value2, "domainAddr");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("port = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("port <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("port > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("port >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("port < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("port <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("user_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("user_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("user_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("user_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("user_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("user_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`password` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`password` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`password` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`password` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`password` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`password` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andServerTypeIsNull() {
            addCriterion("server_type is null");
            return (Criteria) this;
        }

        public Criteria andServerTypeIsNotNull() {
            addCriterion("server_type is not null");
            return (Criteria) this;
        }

        public Criteria andServerTypeEqualTo(Integer value) {
            addCriterion("server_type =", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("server_type = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andServerTypeNotEqualTo(Integer value) {
            addCriterion("server_type <>", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("server_type <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andServerTypeGreaterThan(Integer value) {
            addCriterion("server_type >", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("server_type > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andServerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("server_type >=", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("server_type >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andServerTypeLessThan(Integer value) {
            addCriterion("server_type <", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("server_type < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andServerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("server_type <=", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("server_type <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andServerTypeIn(List<Integer> values) {
            addCriterion("server_type in", values, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotIn(List<Integer> values) {
            addCriterion("server_type not in", values, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeBetween(Integer value1, Integer value2) {
            addCriterion("server_type between", value1, value2, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("server_type not between", value1, value2, "serverType");
            return (Criteria) this;
        }

        public Criteria andOsIsNull() {
            addCriterion("os is null");
            return (Criteria) this;
        }

        public Criteria andOsIsNotNull() {
            addCriterion("os is not null");
            return (Criteria) this;
        }

        public Criteria andOsEqualTo(String value) {
            addCriterion("os =", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("os = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOsNotEqualTo(String value) {
            addCriterion("os <>", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("os <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOsGreaterThan(String value) {
            addCriterion("os >", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("os > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOsGreaterThanOrEqualTo(String value) {
            addCriterion("os >=", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("os >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOsLessThan(String value) {
            addCriterion("os <", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("os < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOsLessThanOrEqualTo(String value) {
            addCriterion("os <=", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("os <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOsLike(String value) {
            addCriterion("os like", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotLike(String value) {
            addCriterion("os not like", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsIn(List<String> values) {
            addCriterion("os in", values, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotIn(List<String> values) {
            addCriterion("os not in", values, "os");
            return (Criteria) this;
        }

        public Criteria andOsBetween(String value1, String value2) {
            addCriterion("os between", value1, value2, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotBetween(String value1, String value2) {
            addCriterion("os not between", value1, value2, "os");
            return (Criteria) this;
        }

        public Criteria andOsVersionIsNull() {
            addCriterion("os_version is null");
            return (Criteria) this;
        }

        public Criteria andOsVersionIsNotNull() {
            addCriterion("os_version is not null");
            return (Criteria) this;
        }

        public Criteria andOsVersionEqualTo(String value) {
            addCriterion("os_version =", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("os_version = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOsVersionNotEqualTo(String value) {
            addCriterion("os_version <>", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("os_version <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOsVersionGreaterThan(String value) {
            addCriterion("os_version >", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("os_version > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOsVersionGreaterThanOrEqualTo(String value) {
            addCriterion("os_version >=", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("os_version >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOsVersionLessThan(String value) {
            addCriterion("os_version <", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("os_version < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOsVersionLessThanOrEqualTo(String value) {
            addCriterion("os_version <=", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("os_version <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOsVersionLike(String value) {
            addCriterion("os_version like", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotLike(String value) {
            addCriterion("os_version not like", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionIn(List<String> values) {
            addCriterion("os_version in", values, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotIn(List<String> values) {
            addCriterion("os_version not in", values, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionBetween(String value1, String value2) {
            addCriterion("os_version between", value1, value2, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotBetween(String value1, String value2) {
            addCriterion("os_version not between", value1, value2, "osVersion");
            return (Criteria) this;
        }

        public Criteria andMemoryIsNull() {
            addCriterion("memory is null");
            return (Criteria) this;
        }

        public Criteria andMemoryIsNotNull() {
            addCriterion("memory is not null");
            return (Criteria) this;
        }

        public Criteria andMemoryEqualTo(Integer value) {
            addCriterion("memory =", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("memory = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemoryNotEqualTo(Integer value) {
            addCriterion("memory <>", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("memory <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemoryGreaterThan(Integer value) {
            addCriterion("memory >", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("memory > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("memory >=", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("memory >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemoryLessThan(Integer value) {
            addCriterion("memory <", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("memory < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemoryLessThanOrEqualTo(Integer value) {
            addCriterion("memory <=", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("memory <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemoryIn(List<Integer> values) {
            addCriterion("memory in", values, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotIn(List<Integer> values) {
            addCriterion("memory not in", values, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryBetween(Integer value1, Integer value2) {
            addCriterion("memory between", value1, value2, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotBetween(Integer value1, Integer value2) {
            addCriterion("memory not between", value1, value2, "memory");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("`enable` is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("`enable` is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("`enable` =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`enable` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("`enable` <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`enable` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("`enable` >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`enable` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("`enable` >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`enable` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("`enable` <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`enable` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("`enable` <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`enable` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("`enable` in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("`enable` not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("`enable` between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("`enable` not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andServerStatusIsNull() {
            addCriterion("server_status is null");
            return (Criteria) this;
        }

        public Criteria andServerStatusIsNotNull() {
            addCriterion("server_status is not null");
            return (Criteria) this;
        }

        public Criteria andServerStatusEqualTo(Integer value) {
            addCriterion("server_status =", value, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("server_status = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andServerStatusNotEqualTo(Integer value) {
            addCriterion("server_status <>", value, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("server_status <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andServerStatusGreaterThan(Integer value) {
            addCriterion("server_status >", value, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("server_status > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andServerStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("server_status >=", value, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("server_status >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andServerStatusLessThan(Integer value) {
            addCriterion("server_status <", value, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("server_status < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andServerStatusLessThanOrEqualTo(Integer value) {
            addCriterion("server_status <=", value, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("server_status <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andServerStatusIn(List<Integer> values) {
            addCriterion("server_status in", values, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusNotIn(List<Integer> values) {
            addCriterion("server_status not in", values, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusBetween(Integer value1, Integer value2) {
            addCriterion("server_status between", value1, value2, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("server_status not between", value1, value2, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`name` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`name` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`name` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`name` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`name` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("`name` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("remark = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("remark <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("remark > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("remark >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("remark < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("remark <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("create_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("create_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("create_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("create_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("create_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("create_at <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Date value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("update_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Date value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("update_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Date value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("update_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("update_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Date value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("update_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("update_at <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Date> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Date> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Date value1, Date value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("create_by = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("create_by <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("create_by > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("create_by >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("create_by < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("create_by <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Long value1, Long value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Long value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("update_by = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Long value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("update_by <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Long value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("update_by > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("update_by >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Long value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("update_by < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Long value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualToColumn(PmServerSsh.Column column) {
            addCriterion(new StringBuilder("update_by <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Long> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Long> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Long value1, Long value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Long value1, Long value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private PmServerSshExample example;

        protected Criteria(PmServerSshExample example) {
            super();
            this.example = example;
        }

        public PmServerSshExample example() {
            return this.example;
        }

        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria add);
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

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(com.paradise.core.example.PmServerSshExample example);
    }
}