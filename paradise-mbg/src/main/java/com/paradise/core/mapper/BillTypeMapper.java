package com.paradise.core.mapper;

import com.paradise.core.example.BillTypeExample;
import com.paradise.core.model.BillType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillTypeMapper {
    long countByExample(BillTypeExample example);

    int deleteByExample(BillTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BillType record);

    int insertSelective(@Param("record") BillType record, @Param("selective") BillType.Column... selective);

    BillType selectOneByExample(BillTypeExample example);

    BillType selectOneByExampleSelective(@Param("example") BillTypeExample example, @Param("selective") BillType.Column... selective);

    List<BillType> selectByExampleSelective(@Param("example") BillTypeExample example, @Param("selective") BillType.Column... selective);

    List<BillType> selectByExample(BillTypeExample example);

    BillType selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") BillType.Column... selective);

    BillType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BillType record, @Param("example") BillTypeExample example, @Param("selective") BillType.Column... selective);

    int updateByExample(@Param("record") BillType record, @Param("example") BillTypeExample example);

    int updateByPrimaryKeySelective(@Param("record") BillType record, @Param("selective") BillType.Column... selective);

    int updateByPrimaryKey(BillType record);

    int batchInsert(@Param("list") List<BillType> list);

    int batchInsertSelective(@Param("list") List<BillType> list, @Param("selective") BillType.Column... selective);
}