package com.paradise.core.example;

import com.paradise.core.model.DaySleepRecord;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaySleepRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DaySleepRecordExample() {
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

    public DaySleepRecordExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public DaySleepRecordExample orderBy(String ... orderByClauses) {
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
        DaySleepRecordExample example = new DaySleepRecordExample();
        return example.createCriteria();
    }

    public DaySleepRecordExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public DaySleepRecordExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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

        public Criteria andIdEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(DaySleepRecord.Column column) {
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

        public Criteria andDateIsNull() {
            addCriterion("`date` is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("`date` is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("`date` =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("`date` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("`date` <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("`date` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("`date` >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("`date` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("`date` >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("`date` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("`date` <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("`date` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("`date` <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("`date` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("`date` in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("`date` not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("`date` between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("`date` not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andBedTimeIsNull() {
            addCriterion("bed_time is null");
            return (Criteria) this;
        }

        public Criteria andBedTimeIsNotNull() {
            addCriterion("bed_time is not null");
            return (Criteria) this;
        }

        public Criteria andBedTimeEqualTo(Date value) {
            addCriterion("bed_time =", value, "bedTime");
            return (Criteria) this;
        }

        public Criteria andBedTimeEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("bed_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedTimeNotEqualTo(Date value) {
            addCriterion("bed_time <>", value, "bedTime");
            return (Criteria) this;
        }

        public Criteria andBedTimeNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("bed_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedTimeGreaterThan(Date value) {
            addCriterion("bed_time >", value, "bedTime");
            return (Criteria) this;
        }

        public Criteria andBedTimeGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("bed_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bed_time >=", value, "bedTime");
            return (Criteria) this;
        }

        public Criteria andBedTimeGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("bed_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedTimeLessThan(Date value) {
            addCriterion("bed_time <", value, "bedTime");
            return (Criteria) this;
        }

        public Criteria andBedTimeLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("bed_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedTimeLessThanOrEqualTo(Date value) {
            addCriterion("bed_time <=", value, "bedTime");
            return (Criteria) this;
        }

        public Criteria andBedTimeLessThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("bed_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedTimeIn(List<Date> values) {
            addCriterion("bed_time in", values, "bedTime");
            return (Criteria) this;
        }

        public Criteria andBedTimeNotIn(List<Date> values) {
            addCriterion("bed_time not in", values, "bedTime");
            return (Criteria) this;
        }

        public Criteria andBedTimeBetween(Date value1, Date value2) {
            addCriterion("bed_time between", value1, value2, "bedTime");
            return (Criteria) this;
        }

        public Criteria andBedTimeNotBetween(Date value1, Date value2) {
            addCriterion("bed_time not between", value1, value2, "bedTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeIsNull() {
            addCriterion("sleep_time is null");
            return (Criteria) this;
        }

        public Criteria andSleepTimeIsNotNull() {
            addCriterion("sleep_time is not null");
            return (Criteria) this;
        }

        public Criteria andSleepTimeEqualTo(Date value) {
            addCriterion("sleep_time =", value, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("sleep_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSleepTimeNotEqualTo(Date value) {
            addCriterion("sleep_time <>", value, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("sleep_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSleepTimeGreaterThan(Date value) {
            addCriterion("sleep_time >", value, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("sleep_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSleepTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sleep_time >=", value, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("sleep_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSleepTimeLessThan(Date value) {
            addCriterion("sleep_time <", value, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("sleep_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSleepTimeLessThanOrEqualTo(Date value) {
            addCriterion("sleep_time <=", value, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeLessThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("sleep_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSleepTimeIn(List<Date> values) {
            addCriterion("sleep_time in", values, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeNotIn(List<Date> values) {
            addCriterion("sleep_time not in", values, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeBetween(Date value1, Date value2) {
            addCriterion("sleep_time between", value1, value2, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeNotBetween(Date value1, Date value2) {
            addCriterion("sleep_time not between", value1, value2, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andWakeTimeIsNull() {
            addCriterion("wake_time is null");
            return (Criteria) this;
        }

        public Criteria andWakeTimeIsNotNull() {
            addCriterion("wake_time is not null");
            return (Criteria) this;
        }

        public Criteria andWakeTimeEqualTo(Date value) {
            addCriterion("wake_time =", value, "wakeTime");
            return (Criteria) this;
        }

        public Criteria andWakeTimeEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("wake_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWakeTimeNotEqualTo(Date value) {
            addCriterion("wake_time <>", value, "wakeTime");
            return (Criteria) this;
        }

        public Criteria andWakeTimeNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("wake_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWakeTimeGreaterThan(Date value) {
            addCriterion("wake_time >", value, "wakeTime");
            return (Criteria) this;
        }

        public Criteria andWakeTimeGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("wake_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWakeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wake_time >=", value, "wakeTime");
            return (Criteria) this;
        }

        public Criteria andWakeTimeGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("wake_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWakeTimeLessThan(Date value) {
            addCriterion("wake_time <", value, "wakeTime");
            return (Criteria) this;
        }

        public Criteria andWakeTimeLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("wake_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWakeTimeLessThanOrEqualTo(Date value) {
            addCriterion("wake_time <=", value, "wakeTime");
            return (Criteria) this;
        }

        public Criteria andWakeTimeLessThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("wake_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWakeTimeIn(List<Date> values) {
            addCriterion("wake_time in", values, "wakeTime");
            return (Criteria) this;
        }

        public Criteria andWakeTimeNotIn(List<Date> values) {
            addCriterion("wake_time not in", values, "wakeTime");
            return (Criteria) this;
        }

        public Criteria andWakeTimeBetween(Date value1, Date value2) {
            addCriterion("wake_time between", value1, value2, "wakeTime");
            return (Criteria) this;
        }

        public Criteria andWakeTimeNotBetween(Date value1, Date value2) {
            addCriterion("wake_time not between", value1, value2, "wakeTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeIsNull() {
            addCriterion("up_time is null");
            return (Criteria) this;
        }

        public Criteria andUpTimeIsNotNull() {
            addCriterion("up_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpTimeEqualTo(Date value) {
            addCriterion("up_time =", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("up_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpTimeNotEqualTo(Date value) {
            addCriterion("up_time <>", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("up_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpTimeGreaterThan(Date value) {
            addCriterion("up_time >", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("up_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("up_time >=", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("up_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpTimeLessThan(Date value) {
            addCriterion("up_time <", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("up_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpTimeLessThanOrEqualTo(Date value) {
            addCriterion("up_time <=", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeLessThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("up_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpTimeIn(List<Date> values) {
            addCriterion("up_time in", values, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotIn(List<Date> values) {
            addCriterion("up_time not in", values, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeBetween(Date value1, Date value2) {
            addCriterion("up_time between", value1, value2, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotBetween(Date value1, Date value2) {
            addCriterion("up_time not between", value1, value2, "upTime");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("duration = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("duration <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("duration > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("duration >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("duration < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("duration <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andSleepQualityIsNull() {
            addCriterion("sleep_quality is null");
            return (Criteria) this;
        }

        public Criteria andSleepQualityIsNotNull() {
            addCriterion("sleep_quality is not null");
            return (Criteria) this;
        }

        public Criteria andSleepQualityEqualTo(Integer value) {
            addCriterion("sleep_quality =", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("sleep_quality = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSleepQualityNotEqualTo(Integer value) {
            addCriterion("sleep_quality <>", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("sleep_quality <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSleepQualityGreaterThan(Integer value) {
            addCriterion("sleep_quality >", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("sleep_quality > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSleepQualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("sleep_quality >=", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("sleep_quality >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSleepQualityLessThan(Integer value) {
            addCriterion("sleep_quality <", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("sleep_quality < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSleepQualityLessThanOrEqualTo(Integer value) {
            addCriterion("sleep_quality <=", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityLessThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("sleep_quality <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSleepQualityIn(List<Integer> values) {
            addCriterion("sleep_quality in", values, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityNotIn(List<Integer> values) {
            addCriterion("sleep_quality not in", values, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityBetween(Integer value1, Integer value2) {
            addCriterion("sleep_quality between", value1, value2, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityNotBetween(Integer value1, Integer value2) {
            addCriterion("sleep_quality not between", value1, value2, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andAppDataIsNull() {
            addCriterion("app_data is null");
            return (Criteria) this;
        }

        public Criteria andAppDataIsNotNull() {
            addCriterion("app_data is not null");
            return (Criteria) this;
        }

        public Criteria andAppDataEqualTo(String value) {
            addCriterion("app_data =", value, "appData");
            return (Criteria) this;
        }

        public Criteria andAppDataEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("app_data = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppDataNotEqualTo(String value) {
            addCriterion("app_data <>", value, "appData");
            return (Criteria) this;
        }

        public Criteria andAppDataNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("app_data <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppDataGreaterThan(String value) {
            addCriterion("app_data >", value, "appData");
            return (Criteria) this;
        }

        public Criteria andAppDataGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("app_data > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppDataGreaterThanOrEqualTo(String value) {
            addCriterion("app_data >=", value, "appData");
            return (Criteria) this;
        }

        public Criteria andAppDataGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("app_data >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppDataLessThan(String value) {
            addCriterion("app_data <", value, "appData");
            return (Criteria) this;
        }

        public Criteria andAppDataLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("app_data < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppDataLessThanOrEqualTo(String value) {
            addCriterion("app_data <=", value, "appData");
            return (Criteria) this;
        }

        public Criteria andAppDataLessThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("app_data <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppDataLike(String value) {
            addCriterion("app_data like", value, "appData");
            return (Criteria) this;
        }

        public Criteria andAppDataNotLike(String value) {
            addCriterion("app_data not like", value, "appData");
            return (Criteria) this;
        }

        public Criteria andAppDataIn(List<String> values) {
            addCriterion("app_data in", values, "appData");
            return (Criteria) this;
        }

        public Criteria andAppDataNotIn(List<String> values) {
            addCriterion("app_data not in", values, "appData");
            return (Criteria) this;
        }

        public Criteria andAppDataBetween(String value1, String value2) {
            addCriterion("app_data between", value1, value2, "appData");
            return (Criteria) this;
        }

        public Criteria andAppDataNotBetween(String value1, String value2) {
            addCriterion("app_data not between", value1, value2, "appData");
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

        public Criteria andMemoryEqualTo(String value) {
            addCriterion("memory =", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("memory = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemoryNotEqualTo(String value) {
            addCriterion("memory <>", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("memory <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemoryGreaterThan(String value) {
            addCriterion("memory >", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("memory > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemoryGreaterThanOrEqualTo(String value) {
            addCriterion("memory >=", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("memory >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemoryLessThan(String value) {
            addCriterion("memory <", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("memory < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemoryLessThanOrEqualTo(String value) {
            addCriterion("memory <=", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryLessThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("memory <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemoryLike(String value) {
            addCriterion("memory like", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotLike(String value) {
            addCriterion("memory not like", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryIn(List<String> values) {
            addCriterion("memory in", values, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotIn(List<String> values) {
            addCriterion("memory not in", values, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryBetween(String value1, String value2) {
            addCriterion("memory between", value1, value2, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotBetween(String value1, String value2) {
            addCriterion("memory not between", value1, value2, "memory");
            return (Criteria) this;
        }

        public Criteria andLateReasonIsNull() {
            addCriterion("late_reason is null");
            return (Criteria) this;
        }

        public Criteria andLateReasonIsNotNull() {
            addCriterion("late_reason is not null");
            return (Criteria) this;
        }

        public Criteria andLateReasonEqualTo(String value) {
            addCriterion("late_reason =", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("late_reason = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLateReasonNotEqualTo(String value) {
            addCriterion("late_reason <>", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("late_reason <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLateReasonGreaterThan(String value) {
            addCriterion("late_reason >", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("late_reason > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLateReasonGreaterThanOrEqualTo(String value) {
            addCriterion("late_reason >=", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("late_reason >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLateReasonLessThan(String value) {
            addCriterion("late_reason <", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("late_reason < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLateReasonLessThanOrEqualTo(String value) {
            addCriterion("late_reason <=", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonLessThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("late_reason <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLateReasonLike(String value) {
            addCriterion("late_reason like", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonNotLike(String value) {
            addCriterion("late_reason not like", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonIn(List<String> values) {
            addCriterion("late_reason in", values, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonNotIn(List<String> values) {
            addCriterion("late_reason not in", values, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonBetween(String value1, String value2) {
            addCriterion("late_reason between", value1, value2, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonNotBetween(String value1, String value2) {
            addCriterion("late_reason not between", value1, value2, "lateReason");
            return (Criteria) this;
        }

        public Criteria andBestTimeIsNull() {
            addCriterion("best_time is null");
            return (Criteria) this;
        }

        public Criteria andBestTimeIsNotNull() {
            addCriterion("best_time is not null");
            return (Criteria) this;
        }

        public Criteria andBestTimeEqualTo(String value) {
            addCriterion("best_time =", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("best_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBestTimeNotEqualTo(String value) {
            addCriterion("best_time <>", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("best_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBestTimeGreaterThan(String value) {
            addCriterion("best_time >", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("best_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBestTimeGreaterThanOrEqualTo(String value) {
            addCriterion("best_time >=", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("best_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBestTimeLessThan(String value) {
            addCriterion("best_time <", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("best_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBestTimeLessThanOrEqualTo(String value) {
            addCriterion("best_time <=", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeLessThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("best_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBestTimeLike(String value) {
            addCriterion("best_time like", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeNotLike(String value) {
            addCriterion("best_time not like", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeIn(List<String> values) {
            addCriterion("best_time in", values, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeNotIn(List<String> values) {
            addCriterion("best_time not in", values, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeBetween(String value1, String value2) {
            addCriterion("best_time between", value1, value2, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeNotBetween(String value1, String value2) {
            addCriterion("best_time not between", value1, value2, "bestTime");
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

        public Criteria andRemarkEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("remark = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("remark <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("remark > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("remark >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("remark < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualToColumn(DaySleepRecord.Column column) {
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

        public Criteria andCreateAtEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("create_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("create_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("create_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("create_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("create_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualToColumn(DaySleepRecord.Column column) {
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

        public Criteria andUpdateAtEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("update_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Date value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("update_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Date value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("update_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("update_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Date value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("update_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualToColumn(DaySleepRecord.Column column) {
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

        public Criteria andCreateByEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("create_by = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("create_by <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("create_by > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("create_by >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("create_by < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualToColumn(DaySleepRecord.Column column) {
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

        public Criteria andUpdateByEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("update_by = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Long value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("update_by <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Long value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("update_by > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualToColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("update_by >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Long value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanColumn(DaySleepRecord.Column column) {
            addCriterion(new StringBuilder("update_by < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Long value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualToColumn(DaySleepRecord.Column column) {
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
        private DaySleepRecordExample example;

        protected Criteria(DaySleepRecordExample example) {
            super();
            this.example = example;
        }

        public DaySleepRecordExample example() {
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
        void example(com.paradise.core.example.DaySleepRecordExample example);
    }
}