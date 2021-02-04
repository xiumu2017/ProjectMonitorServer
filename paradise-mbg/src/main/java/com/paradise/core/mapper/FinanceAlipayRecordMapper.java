package com.paradise.core.mapper;

import com.paradise.core.example.FinanceAlipayRecordExample;
import com.paradise.core.model.FinanceAlipayRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinanceAlipayRecordMapper {
    long countByExample(FinanceAlipayRecordExample example);

    int deleteByExample(FinanceAlipayRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FinanceAlipayRecord record);

    int insertSelective(@Param("record") FinanceAlipayRecord record, @Param("selective") FinanceAlipayRecord.Column... selective);

    FinanceAlipayRecord selectOneByExample(FinanceAlipayRecordExample example);

    FinanceAlipayRecord selectOneByExampleSelective(@Param("example") FinanceAlipayRecordExample example, @Param("selective") FinanceAlipayRecord.Column... selective);

    List<FinanceAlipayRecord> selectByExampleSelective(@Param("example") FinanceAlipayRecordExample example, @Param("selective") FinanceAlipayRecord.Column... selective);

    List<FinanceAlipayRecord> selectByExample(FinanceAlipayRecordExample example);

    FinanceAlipayRecord selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") FinanceAlipayRecord.Column... selective);

    FinanceAlipayRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FinanceAlipayRecord record, @Param("example") FinanceAlipayRecordExample example, @Param("selective") FinanceAlipayRecord.Column... selective);

    int updateByExample(@Param("record") FinanceAlipayRecord record, @Param("example") FinanceAlipayRecordExample example);

    int updateByPrimaryKeySelective(@Param("record") FinanceAlipayRecord record, @Param("selective") FinanceAlipayRecord.Column... selective);

    int updateByPrimaryKey(FinanceAlipayRecord record);

    int batchInsert(@Param("list") List<FinanceAlipayRecord> list);

    int batchInsertSelective(@Param("list") List<FinanceAlipayRecord> list, @Param("selective") FinanceAlipayRecord.Column... selective);
}