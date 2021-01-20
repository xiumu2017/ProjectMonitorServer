package com.paradise.core.mapper;

import com.paradise.core.example.PmServerTypeExample;
import com.paradise.core.model.PmServerType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmServerTypeMapper {
    long countByExample(PmServerTypeExample example);

    int deleteByExample(PmServerTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmServerType record);

    int insertSelective(@Param("record") PmServerType record, @Param("selective") PmServerType.Column... selective);

    PmServerType selectOneByExample(PmServerTypeExample example);

    PmServerType selectOneByExampleSelective(@Param("example") PmServerTypeExample example, @Param("selective") PmServerType.Column... selective);

    List<PmServerType> selectByExampleSelective(@Param("example") PmServerTypeExample example, @Param("selective") PmServerType.Column... selective);

    List<PmServerType> selectByExample(PmServerTypeExample example);

    PmServerType selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") PmServerType.Column... selective);

    PmServerType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmServerType record, @Param("example") PmServerTypeExample example, @Param("selective") PmServerType.Column... selective);

    int updateByExample(@Param("record") PmServerType record, @Param("example") PmServerTypeExample example);

    int updateByPrimaryKeySelective(@Param("record") PmServerType record, @Param("selective") PmServerType.Column... selective);

    int updateByPrimaryKey(PmServerType record);

    int batchInsert(@Param("list") List<PmServerType> list);

    int batchInsertSelective(@Param("list") List<PmServerType> list, @Param("selective") PmServerType.Column... selective);
}