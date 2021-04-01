package com.paradise.core.app.service;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.DayTimelineBody;
import com.paradise.core.dto.query.DayTimelineQuery;
import com.paradise.core.example.DayTimelineExample;
import com.paradise.core.mapper.DayTimelineMapper;
import com.paradise.core.model.DayTimeline;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MpTimelineService {
    private final DayTimelineMapper dayTimelineMapper;

    public List<DayTimeline> queryByPage(DayTimelineQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return dayTimelineMapper.selectByExample(new DayTimelineExample().createCriteria()
                .example().orderBy(DayTimeline.Column.startTime.desc()));
    }

    public int insertSelective(DayTimelineBody record) {
        DayTimeline dayTimeline = new DayTimeline();
        BeanUtils.copyProperties(record, dayTimeline);
        dayTimeline.setUserId(0L);
        return this.dayTimelineMapper.insertSelective(dayTimeline);
    }
}
