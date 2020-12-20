package com.paradise.core.mapper;

import com.paradise.core.example.PmDbExample;
import com.paradise.core.model.PmDb;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmDbMapper {
    long countByExample(PmDbExample example);

    int deleteByExample(PmDbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmDb record);

    int insertSelective(@Param("record") PmDb record, @Param("selective") PmDb.Column ... selective);

    PmDb selectOneByExample(PmDbExample example);

    PmDb selectOneByExampleSelective(@Param("example") PmDbExample example, @Param("selective") PmDb.Column ... selective);

    List<PmDb> selectByExampleSelective(@Param("example") PmDbExample example, @Param("selective") PmDb.Column ... selective);

    List<PmDb> selectByExample(PmDbExample example);

    PmDb selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") PmDb.Column ... selective);

    PmDb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmDb record, @Param("example") PmDbExample example, @Param("selective") PmDb.Column ... selective);

    int updateByExample(@Param("record") PmDb record, @Param("example") PmDbExample example);

    int updateByPrimaryKeySelective(@Param("record") PmDb record, @Param("selective") PmDb.Column ... selective);

    int updateByPrimaryKey(PmDb record);

    int batchInsert(@Param("list") List<PmDb> list);

    int batchInsertSelective(@Param("list") List<PmDb> list, @Param("selective") PmDb.Column ... selective);
}