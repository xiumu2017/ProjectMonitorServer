package com.paradise.core.app.service;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.DayMealRecordBody;
import com.paradise.core.dto.query.DayMealRecordQuery;
import com.paradise.core.example.DayMealRecordExample;
import com.paradise.core.mapper.DayMealRecordMapper;
import com.paradise.core.model.DayMealRecord;
import com.paradise.core.model.DaySleepRecord;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class MpMealRecordService {
    private final DayMealRecordMapper dayMealRecordMapper;

    public List<DayMealRecord> selectByPage(DayMealRecordQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.dayMealRecordMapper.selectByExample(new DayMealRecordExample()
                .createCriteria().example().orderBy(DaySleepRecord.Column.date.desc(), DayMealRecord.Column.type.desc()));
    }

    public int create(DayMealRecordBody body) {
        DayMealRecord dayMealRecord = new DayMealRecord();
        BeanUtils.copyProperties(body, dayMealRecord);
        dayMealRecord.setCreateAt(new Date());
        return dayMealRecordMapper.insertSelective(dayMealRecord);
    }

}
