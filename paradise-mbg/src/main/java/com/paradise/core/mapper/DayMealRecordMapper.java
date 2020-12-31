package com.paradise.core.mapper;

import com.paradise.core.example.DayMealRecordExample;
import com.paradise.core.model.DayMealRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DayMealRecordMapper {
    long countByExample(DayMealRecordExample example);

    int deleteByExample(DayMealRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DayMealRecord record);

    int insertSelective(@Param("record") DayMealRecord record, @Param("selective") DayMealRecord.Column ... selective);

    DayMealRecord selectOneByExample(DayMealRecordExample example);

    DayMealRecord selectOneByExampleSelective(@Param("example") DayMealRecordExample example, @Param("selective") DayMealRecord.Column ... selective);

    List<DayMealRecord> selectByExampleSelective(@Param("example") DayMealRecordExample example, @Param("selective") DayMealRecord.Column ... selective);

    List<DayMealRecord> selectByExample(DayMealRecordExample example);

    DayMealRecord selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") DayMealRecord.Column ... selective);

    DayMealRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DayMealRecord record, @Param("example") DayMealRecordExample example, @Param("selective") DayMealRecord.Column ... selective);

    int updateByExample(@Param("record") DayMealRecord record, @Param("example") DayMealRecordExample example);

    int updateByPrimaryKeySelective(@Param("record") DayMealRecord record, @Param("selective") DayMealRecord.Column ... selective);

    int updateByPrimaryKey(DayMealRecord record);

    int batchInsert(@Param("list") List<DayMealRecord> list);

    int batchInsertSelective(@Param("list") List<DayMealRecord> list, @Param("selective") DayMealRecord.Column ... selective);
}