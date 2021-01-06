package com.paradise.core.mapper;

import com.paradise.core.example.DayBingImageExample;
import com.paradise.core.model.DayBingImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DayBingImageMapper {
    long countByExample(DayBingImageExample example);

    int deleteByExample(DayBingImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DayBingImage record);

    int insertSelective(@Param("record") DayBingImage record, @Param("selective") DayBingImage.Column... selective);

    DayBingImage selectOneByExample(DayBingImageExample example);

    DayBingImage selectOneByExampleSelective(@Param("example") DayBingImageExample example, @Param("selective") DayBingImage.Column... selective);

    List<DayBingImage> selectByExampleSelective(@Param("example") DayBingImageExample example, @Param("selective") DayBingImage.Column... selective);

    List<DayBingImage> selectByExample(DayBingImageExample example);

    DayBingImage selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") DayBingImage.Column... selective);

    DayBingImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DayBingImage record, @Param("example") DayBingImageExample example, @Param("selective") DayBingImage.Column... selective);

    int updateByExample(@Param("record") DayBingImage record, @Param("example") DayBingImageExample example);

    int updateByPrimaryKeySelective(@Param("record") DayBingImage record, @Param("selective") DayBingImage.Column... selective);

    int updateByPrimaryKey(DayBingImage record);

    int batchInsert(@Param("list") List<DayBingImage> list);

    int batchInsertSelective(@Param("list") List<DayBingImage> list, @Param("selective") DayBingImage.Column... selective);
}