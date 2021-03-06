package com.paradise.core.app.service;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.DaySleepRecordAppBody;
import com.paradise.core.dto.body.DaySleepRecordBody;
import com.paradise.core.dto.query.DaySleepRecordQuery;
import com.paradise.core.example.DaySleepRecordExample;
import com.paradise.core.mapper.DaySleepRecordMapper;
import com.paradise.core.model.DaySleepRecord;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class MpSleepRecordService {
    private final DaySleepRecordMapper daySleepRecordMapper;

    public List<DaySleepRecord> selectByPage(DaySleepRecordQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.daySleepRecordMapper.selectByExample(new DaySleepRecordExample()
                .createCriteria().example().orderBy(DaySleepRecord.Column.date.desc()));
    }

    /**
     * 创建 or 更新睡眠记录，核心是时间节点
     *
     * @param type 1 上床 2 醒来 3 起床
     * @return 更新结果
     */
    public Integer createByType(Integer type) {
        // 查询睡眠记录
        // 判断当前时间是否在 0 点之前
        Date now = new Date();
        DaySleepRecord daySleepRecord = new DaySleepRecord();
        daySleepRecord.setUpdateAt(now);
        // 记录 上床时间
        if (type == 1) {
            int hour = DateUtil.hour(now, true);
            // 理论上上床时间不会早于晚上6点
            Date date;
            if (hour > 18) {
                date = DateUtil.beginOfDay(DateUtil.offsetDay(new Date(), 1));
                // 判断是否已经打卡，已经打卡，则更新打卡时间
            } else {
                // 超过零点才睡
                date = DateUtil.beginOfDay(now);
            }
            daySleepRecord.setDate(date);
            daySleepRecord.setBedTime(now);
            daySleepRecord.setCreateAt(now);
            DaySleepRecord record = daySleepRecordMapper.selectOneByExample(new DaySleepRecordExample().createCriteria().andDateEqualTo(date).example());
            if (record == null) {
                return daySleepRecordMapper.insertSelective(daySleepRecord);
            } else {
                record.setBedTime(now);
                record.setUpdateAt(now);
                return daySleepRecordMapper.updateByPrimaryKeySelective(record, DaySleepRecord.Column.bedTime, DaySleepRecord.Column.updateAt);
            }
        } else if (type == 2) {
            // 记录 醒来时间
            daySleepRecord.setWakeTime(now);
        } else {
            // 记录 起床时间
            daySleepRecord.setUpTime(now);
        }
        return daySleepRecordMapper.updateByExampleSelective(daySleepRecord,
                new DaySleepRecordExample().createCriteria().andDateEqualTo(DateUtil.beginOfDay(now)).example());
    }

    public int updateByPrimaryKey(Long id, DaySleepRecordAppBody record) {
        DaySleepRecord daySleepRecord = new DaySleepRecord();
        BeanUtils.copyProperties(record, daySleepRecord);
        daySleepRecord.setId(id);
        dealRecord(record, daySleepRecord);
        return this.daySleepRecordMapper.updateByPrimaryKeySelective(daySleepRecord);
    }

    private void dealRecord(DaySleepRecordAppBody record, DaySleepRecord daySleepRecord) {
        // 计算睡眠时长
        daySleepRecord.setDuration(cal(record));
    }

    private Integer cal(DaySleepRecordAppBody record) {
        long mis = record.getWakeTime().getTime() - record.getSleepTime().getTime();
        return Math.toIntExact(mis / (1_000));
    }

    public int insert(DaySleepRecordBody record) {
        DaySleepRecord daySleepRecord = new DaySleepRecord();
        BeanUtils.copyProperties(record, daySleepRecord);
        dealRecord(record, daySleepRecord);
        daySleepRecord.setCreateAt(new Date());
        daySleepRecord.setUpdateAt(new Date());
        return this.daySleepRecordMapper.insertSelective(daySleepRecord);
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

    private Integer cal(DaySleepRecordBody record) {
        long mis = record.getWakeTime() - record.getSleepTime();
        return Math.toIntExact(mis / (1_000));
    }
}
