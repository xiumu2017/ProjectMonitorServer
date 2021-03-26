package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.DayTimelineBody;
import com.paradise.core.dto.query.DayTimelineQuery;
import com.paradise.core.example.DayTimelineExample;
import com.paradise.core.mapper.DayTimelineMapper;
import com.paradise.core.model.DayTimeline;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 每日时间轴表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class DayTimelineService {
    private final DayTimelineMapper dayTimelineMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.dayTimelineMapper.deleteByPrimaryKey(id);
    }

    public int insert(DayTimelineBody record) {
        DayTimeline dayTimeline = new DayTimeline();
        BeanUtils.copyProperties(record, dayTimeline);
        return this.dayTimelineMapper.insert(dayTimeline);
    }

    public int insertSelective(DayTimelineBody record) {
        DayTimeline dayTimeline = new DayTimeline();
        BeanUtils.copyProperties(record, dayTimeline);
        dayTimeline.setUserId(0L);
        return this.dayTimelineMapper.insertSelective(dayTimeline);
    }

    public DayTimeline selectByPrimaryKey(Long id) {
        return this.dayTimelineMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(DayTimelineBody record) {
        DayTimeline dayTimeline = new DayTimeline();
        BeanUtils.copyProperties(record, dayTimeline);
        return this.dayTimelineMapper.updateByPrimaryKeySelective(dayTimeline);
    }

    public int updateByPrimaryKey(Long id, DayTimelineBody record) {
        DayTimeline dayTimeline = new DayTimeline();
        BeanUtils.copyProperties(record, dayTimeline);
        dayTimeline.setId(id);
        return this.dayTimelineMapper.updateByPrimaryKeySelective(dayTimeline);
    }

    public List<DayTimeline> selectByPage(DayTimelineQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.dayTimelineMapper.selectByExample(new DayTimelineExample().orderBy(DayTimeline.Column.startTime.desc()));
    }

    public List<DayTimeline> selectByDate(DayTimelineQuery query) {
        return this.dayTimelineMapper.selectByExample(new DayTimelineExample().createCriteria()
                .andDateEqualTo(query.getDate()).example().orderBy(DayTimeline.Column.startTime.asc()));
    }
}