package com.paradise.core.mapper;

import com.paradise.core.example.PmProjectExample;
import com.paradise.core.model.PmProject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmProjectMapper {
    long countByExample(PmProjectExample example);

    int deleteByExample(PmProjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmProject record);

    int insertSelective(@Param("record") PmProject record, @Param("selective") PmProject.Column ... selective);

    PmProject selectOneByExample(PmProjectExample example);

    PmProject selectOneByExampleSelective(@Param("example") PmProjectExample example, @Param("selective") PmProject.Column ... selective);

    List<PmProject> selectByExampleSelective(@Param("example") PmProjectExample example, @Param("selective") PmProject.Column ... selective);

    List<PmProject> selectByExample(PmProjectExample example);

    PmProject selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") PmProject.Column ... selective);

    PmProject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmProject record, @Param("example") PmProjectExample example, @Param("selective") PmProject.Column ... selective);

    int updateByExample(@Param("record") PmProject record, @Param("example") PmProjectExample example);

    int updateByPrimaryKeySelective(@Param("record") PmProject record, @Param("selective") PmProject.Column ... selective);

    int updateByPrimaryKey(PmProject record);

    int batchInsert(@Param("list") List<PmProject> list);

    int batchInsertSelective(@Param("list") List<PmProject> list, @Param("selective") PmProject.Column ... selective);
}