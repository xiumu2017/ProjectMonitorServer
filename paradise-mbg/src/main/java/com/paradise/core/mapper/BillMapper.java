package com.paradise.core.mapper;

import com.paradise.core.example.BillExample;
import com.paradise.core.model.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {
    long countByExample(BillExample example);

    int deleteByExample(BillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Bill record);

    int insertSelective(@Param("record") Bill record, @Param("selective") Bill.Column... selective);

    Bill selectOneByExample(BillExample example);

    Bill selectOneByExampleSelective(@Param("example") BillExample example, @Param("selective") Bill.Column... selective);

    List<Bill> selectByExampleSelective(@Param("example") BillExample example, @Param("selective") Bill.Column... selective);

    List<Bill> selectByExample(BillExample example);

    Bill selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") Bill.Column... selective);

    Bill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Bill record, @Param("example") BillExample example, @Param("selective") Bill.Column... selective);

    int updateByExample(@Param("record") Bill record, @Param("example") BillExample example);

    int updateByPrimaryKeySelective(@Param("record") Bill record, @Param("selective") Bill.Column... selective);

    int updateByPrimaryKey(Bill record);

    int batchInsert(@Param("list") List<Bill> list);

    int batchInsertSelective(@Param("list") List<Bill> list, @Param("selective") Bill.Column... selective);
}