package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.DayMealRecordBody;
import com.paradise.core.dto.query.DayMealRecordQuery;
import com.paradise.core.example.DayMealRecordExample;
import com.paradise.core.mapper.DayMealRecordMapper;
import com.paradise.core.model.DayMealRecord;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用餐记录表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class DayMealRecordService {
    private final DayMealRecordMapper dayMealRecordMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.dayMealRecordMapper.deleteByPrimaryKey(id);
    }

    public int insert(DayMealRecordBody record) {
        DayMealRecord dayMealRecord = new DayMealRecord();
        BeanUtils.copyProperties(record, dayMealRecord);
        return this.dayMealRecordMapper.insert(dayMealRecord);
    }

    public int insertSelective(DayMealRecordBody record) {
        DayMealRecord dayMealRecord = new DayMealRecord();
        BeanUtils.copyProperties(record, dayMealRecord);
        return this.dayMealRecordMapper.insertSelective(dayMealRecord);
    }

    public DayMealRecord selectByPrimaryKey(Long id) {
        return this.dayMealRecordMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(DayMealRecordBody record) {
        DayMealRecord dayMealRecord = new DayMealRecord();
        BeanUtils.copyProperties(record, dayMealRecord);
        return this.dayMealRecordMapper.updateByPrimaryKeySelective(dayMealRecord);
    }

    public int updateByPrimaryKey(Long id, DayMealRecordBody record) {
        DayMealRecord dayMealRecord = new DayMealRecord();
        BeanUtils.copyProperties(record, dayMealRecord);
        return this.dayMealRecordMapper.updateByPrimaryKey(dayMealRecord);
    }

    public List<DayMealRecord> selectByPage(DayMealRecordQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.dayMealRecordMapper.selectByExample(new DayMealRecordExample()
                .createCriteria()
                .when(query.getType() != null, criteria -> criteria.andTypeEqualTo(query.getType()))
                .when(query.getDate() != null, criteria -> criteria.andDateEqualTo(query.getDate()))
                .when(query.getPayType() != null, criteria -> criteria.andPayTypeEqualTo(query.getPayType()))
                .example().orderBy(DayMealRecord.Column.date.desc()));
    }
}