package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.DaySleepRecordBody;
import com.paradise.core.dto.query.DaySleepRecordQuery;
import com.paradise.core.example.DaySleepRecordExample;
import com.paradise.core.mapper.DaySleepRecordMapper;
import com.paradise.core.model.DaySleepRecord;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 睡眠记录表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class DaySleepRecordService {
    private final DaySleepRecordMapper daySleepRecordMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.daySleepRecordMapper.deleteByPrimaryKey(id);
    }

    public int insert(DaySleepRecordBody record) {
        DaySleepRecord daySleepRecord = new DaySleepRecord();
        BeanUtils.copyProperties(record, daySleepRecord);
        return this.daySleepRecordMapper.insert(daySleepRecord);
    }

    public int insertSelective(DaySleepRecordBody record) {
        DaySleepRecord daySleepRecord = new DaySleepRecord();
        BeanUtils.copyProperties(record, daySleepRecord);
        return this.daySleepRecordMapper.insertSelective(daySleepRecord);
    }

    public DaySleepRecord selectByPrimaryKey(Long id) {
        return this.daySleepRecordMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(DaySleepRecordBody record) {
        DaySleepRecord daySleepRecord = new DaySleepRecord();
        BeanUtils.copyProperties(record, daySleepRecord);
        return this.daySleepRecordMapper.updateByPrimaryKeySelective(daySleepRecord);
    }

    public int updateByPrimaryKey(Long id, DaySleepRecordBody record) {
        DaySleepRecord daySleepRecord = new DaySleepRecord();
        BeanUtils.copyProperties(record, daySleepRecord);
        return this.daySleepRecordMapper.updateByPrimaryKey(daySleepRecord);
    }

    public List<DaySleepRecord> selectByPage(DaySleepRecordQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.daySleepRecordMapper.selectByExample(new DaySleepRecordExample());
    }
}