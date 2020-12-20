package com.paradise.core.mapper;

import com.paradise.core.example.PmDingTalkRobotExample;
import com.paradise.core.model.PmDingTalkRobot;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmDingTalkRobotMapper {
    long countByExample(PmDingTalkRobotExample example);

    int deleteByExample(PmDingTalkRobotExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmDingTalkRobot record);

    int insertSelective(@Param("record") PmDingTalkRobot record, @Param("selective") PmDingTalkRobot.Column ... selective);

    PmDingTalkRobot selectOneByExample(PmDingTalkRobotExample example);

    PmDingTalkRobot selectOneByExampleSelective(@Param("example") PmDingTalkRobotExample example, @Param("selective") PmDingTalkRobot.Column ... selective);

    List<PmDingTalkRobot> selectByExampleSelective(@Param("example") PmDingTalkRobotExample example, @Param("selective") PmDingTalkRobot.Column ... selective);

    List<PmDingTalkRobot> selectByExample(PmDingTalkRobotExample example);

    PmDingTalkRobot selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") PmDingTalkRobot.Column ... selective);

    PmDingTalkRobot selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmDingTalkRobot record, @Param("example") PmDingTalkRobotExample example, @Param("selective") PmDingTalkRobot.Column ... selective);

    int updateByExample(@Param("record") PmDingTalkRobot record, @Param("example") PmDingTalkRobotExample example);

    int updateByPrimaryKeySelective(@Param("record") PmDingTalkRobot record, @Param("selective") PmDingTalkRobot.Column ... selective);

    int updateByPrimaryKey(PmDingTalkRobot record);

    int batchInsert(@Param("list") List<PmDingTalkRobot> list);

    int batchInsertSelective(@Param("list") List<PmDingTalkRobot> list, @Param("selective") PmDingTalkRobot.Column ... selective);
}