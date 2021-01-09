package com.paradise.core.mapper;

import com.paradise.core.example.DayTimelineExample;
import com.paradise.core.model.DayTimeline;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DayTimelineMapper {
    long countByExample(DayTimelineExample example);

    int deleteByExample(DayTimelineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DayTimeline record);

    int insertSelective(@Param("record") DayTimeline record, @Param("selective") DayTimeline.Column... selective);

    DayTimeline selectOneByExample(DayTimelineExample example);

    DayTimeline selectOneByExampleSelective(@Param("example") DayTimelineExample example, @Param("selective") DayTimeline.Column... selective);

    List<DayTimeline> selectByExampleSelective(@Param("example") DayTimelineExample example, @Param("selective") DayTimeline.Column... selective);

    List<DayTimeline> selectByExample(DayTimelineExample example);

    DayTimeline selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") DayTimeline.Column... selective);

    DayTimeline selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DayTimeline record, @Param("example") DayTimelineExample example, @Param("selective") DayTimeline.Column... selective);

    int updateByExample(@Param("record") DayTimeline record, @Param("example") DayTimelineExample example);

    int updateByPrimaryKeySelective(@Param("record") DayTimeline record, @Param("selective") DayTimeline.Column... selective);

    int updateByPrimaryKey(DayTimeline record);

    int batchInsert(@Param("list") List<DayTimeline> list);

    int batchInsertSelective(@Param("list") List<DayTimeline> list, @Param("selective") DayTimeline.Column... selective);
}