package com.paradise.core.mapper;

import com.paradise.core.example.PmServerSshExample;
import com.paradise.core.model.PmServerSsh;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmServerSshMapper {
    long countByExample(PmServerSshExample example);

    int deleteByExample(PmServerSshExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmServerSsh record);

    int insertSelective(@Param("record") PmServerSsh record, @Param("selective") PmServerSsh.Column ... selective);

    PmServerSsh selectOneByExample(PmServerSshExample example);

    PmServerSsh selectOneByExampleSelective(@Param("example") PmServerSshExample example, @Param("selective") PmServerSsh.Column ... selective);

    List<PmServerSsh> selectByExampleSelective(@Param("example") PmServerSshExample example, @Param("selective") PmServerSsh.Column ... selective);

    List<PmServerSsh> selectByExample(PmServerSshExample example);

    PmServerSsh selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") PmServerSsh.Column ... selective);

    PmServerSsh selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmServerSsh record, @Param("example") PmServerSshExample example, @Param("selective") PmServerSsh.Column ... selective);

    int updateByExample(@Param("record") PmServerSsh record, @Param("example") PmServerSshExample example);

    int updateByPrimaryKeySelective(@Param("record") PmServerSsh record, @Param("selective") PmServerSsh.Column ... selective);

    int updateByPrimaryKey(PmServerSsh record);

    int batchInsert(@Param("list") List<PmServerSsh> list);

    int batchInsertSelective(@Param("list") List<PmServerSsh> list, @Param("selective") PmServerSsh.Column ... selective);
}