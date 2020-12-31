package com.paradise.core.mapper;

import com.paradise.core.example.DaySleepRecordExample;
import com.paradise.core.model.DaySleepRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DaySleepRecordMapper {
    long countByExample(DaySleepRecordExample example);

    int deleteByExample(DaySleepRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DaySleepRecord record);

    int insertSelective(@Param("record") DaySleepRecord record, @Param("selective") DaySleepRecord.Column ... selective);

    DaySleepRecord selectOneByExample(DaySleepRecordExample example);

    DaySleepRecord selectOneByExampleSelective(@Param("example") DaySleepRecordExample example, @Param("selective") DaySleepRecord.Column ... selective);

    List<DaySleepRecord> selectByExampleSelective(@Param("example") DaySleepRecordExample example, @Param("selective") DaySleepRecord.Column ... selective);

    List<DaySleepRecord> selectByExample(DaySleepRecordExample example);

    DaySleepRecord selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") DaySleepRecord.Column ... selective);

    DaySleepRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DaySleepRecord record, @Param("example") DaySleepRecordExample example, @Param("selective") DaySleepRecord.Column ... selective);

    int updateByExample(@Param("record") DaySleepRecord record, @Param("example") DaySleepRecordExample example);

    int updateByPrimaryKeySelective(@Param("record") DaySleepRecord record, @Param("selective") DaySleepRecord.Column ... selective);

    int updateByPrimaryKey(DaySleepRecord record);

    int batchInsert(@Param("list") List<DaySleepRecord> list);

    int batchInsertSelective(@Param("list") List<DaySleepRecord> list, @Param("selective") DaySleepRecord.Column ... selective);
}