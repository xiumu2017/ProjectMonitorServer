package com.paradise.core.service.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.DaySleepRecordBody;
import com.paradise.core.dto.query.DaySleepRecordQuery;
import com.paradise.core.example.DaySleepRecordExample;
import com.paradise.core.mapper.DaySleepRecordMapper;
import com.paradise.core.model.DaySleepRecord;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        dealRecord(record, daySleepRecord);
        daySleepRecord.setCreateAt(new Date());
        daySleepRecord.setUpdateAt(new Date());
        return this.daySleepRecordMapper.insertSelective(daySleepRecord);
    }

    private Integer cal(DaySleepRecordBody record) {
        long mis = record.getWakeTime() - record.getSleepTime();
        return Math.toIntExact(mis / (1_000));
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
        daySleepRecord.setId(id);
        dealRecord(record, daySleepRecord);
        return this.daySleepRecordMapper.updateByPrimaryKeySelective(daySleepRecord);
    }

    private void dealRecord(DaySleepRecordBody record, DaySleepRecord daySleepRecord) {
        daySleepRecord.setDate(new Date(record.getDate()));
        daySleepRecord.setBedTime(new Date(record.getBedTime()));
        daySleepRecord.setSleepTime(new Date(record.getSleepTime()));
        daySleepRecord.setWakeTime(new Date(record.getWakeTime()));
        daySleepRecord.setUpTime(new Date(record.getUpTime()));
        // 计算睡眠时长
        daySleepRecord.setDuration(cal(record));
    }

    public List<DaySleepRecord> selectByPage(DaySleepRecordQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.daySleepRecordMapper.selectByExample(new DaySleepRecordExample()
                .createCriteria().example().orderBy(DaySleepRecord.Column.date.desc()));
    }

    public List<List<String>> statistics() {
        List<DaySleepRecord> list =
                this.daySleepRecordMapper.selectByExampleSelective(new DaySleepRecordExample()
                                .createCriteria()
                                .andDateGreaterThanOrEqualTo(DateUtil.offsetDay(new Date(), -15))
                                .example().orderBy(DaySleepRecord.Column.date.asc()),
                        DaySleepRecord.Column.date, DaySleepRecord.Column.duration);
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> dateList = new ArrayList<>();
        ArrayList<String> durationList = new ArrayList<>();
        for (DaySleepRecord daySleepRecord : list) {
            dateList.add(DateUtil.formatDate(daySleepRecord.getDate()));
            durationList.add(new BigDecimal(daySleepRecord.getDuration()).divide(
                    new BigDecimal("3600"), 4, BigDecimal.ROUND_HALF_UP).toString());
        }
        result.add(dateList);
        result.add(durationList);
        return result;
    }
}