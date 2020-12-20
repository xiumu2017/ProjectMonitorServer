package com.paradise.core.mapper;

import com.paradise.core.example.PmDingTalkGroupExample;
import com.paradise.core.model.PmDingTalkGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmDingTalkGroupMapper {
    long countByExample(PmDingTalkGroupExample example);

    int deleteByExample(PmDingTalkGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmDingTalkGroup record);

    int insertSelective(@Param("record") PmDingTalkGroup record, @Param("selective") PmDingTalkGroup.Column ... selective);

    PmDingTalkGroup selectOneByExample(PmDingTalkGroupExample example);

    PmDingTalkGroup selectOneByExampleSelective(@Param("example") PmDingTalkGroupExample example, @Param("selective") PmDingTalkGroup.Column ... selective);

    List<PmDingTalkGroup> selectByExampleSelective(@Param("example") PmDingTalkGroupExample example, @Param("selective") PmDingTalkGroup.Column ... selective);

    List<PmDingTalkGroup> selectByExample(PmDingTalkGroupExample example);

    PmDingTalkGroup selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") PmDingTalkGroup.Column ... selective);

    PmDingTalkGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmDingTalkGroup record, @Param("example") PmDingTalkGroupExample example, @Param("selective") PmDingTalkGroup.Column ... selective);

    int updateByExample(@Param("record") PmDingTalkGroup record, @Param("example") PmDingTalkGroupExample example);

    int updateByPrimaryKeySelective(@Param("record") PmDingTalkGroup record, @Param("selective") PmDingTalkGroup.Column ... selective);

    int updateByPrimaryKey(PmDingTalkGroup record);

    int batchInsert(@Param("list") List<PmDingTalkGroup> list);

    int batchInsertSelective(@Param("list") List<PmDingTalkGroup> list, @Param("selective") PmDingTalkGroup.Column ... selective);
}