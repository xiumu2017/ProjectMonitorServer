package com.paradise.core.app.service;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.query.DaySleepRecordQuery;
import com.paradise.core.example.DaySleepRecordExample;
import com.paradise.core.mapper.DaySleepRecordMapper;
import com.paradise.core.model.DaySleepRecord;
import lombok.AllArgsConstructor;
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

    public Integer createByType(int type) {
        // 查询睡眠记录
        // 判断当前时间是否在 0 点之前
        Date date;
        int hour = DateUtil.hour(new Date(), true);
        if (hour < 6) {
            date = new Date();
        } else {
            date = DateUtil.offsetDay(new Date(), 1);
        }
        DaySleepRecord daySleepRecord = daySleepRecordMapper.selectOneByExample(new DaySleepRecordExample()
                .createCriteria().andDateEqualTo(DateUtil.beginOfDay(date)).example());
        // 记录 上床时间
        if (type == 1) {
            if (daySleepRecord == null) {
                daySleepRecord = DaySleepRecord.builder().createAt(new Date())
                        .bedTime(new Date())
                        .build();
                return daySleepRecordMapper.insertSelective(daySleepRecord);
            } else {
                daySleepRecord.setBedTime(new Date());
                return daySleepRecordMapper.updateByPrimaryKeySelective(daySleepRecord, DaySleepRecord.Column.bedTime);
            }
        } else {
            // 记录 起床时间
            if (daySleepRecord == null) {
                daySleepRecord = DaySleepRecord.builder().createAt(new Date())
                        .upTime(new Date())
                        .build();
                return daySleepRecordMapper.insertSelective(daySleepRecord);
            } else {
                daySleepRecord.setUpTime(new Date());
                return daySleepRecordMapper.updateByPrimaryKeySelective(daySleepRecord, DaySleepRecord.Column.bedTime);
            }
        }

    }

}
