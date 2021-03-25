package com.paradise.core.dao;

import com.paradise.core.dto.DayMealRecordGroupData;

import java.util.List;

public interface DayMealRecordDao {
    /**
     * 按月汇总查询
     *
     * @return {@link DayMealRecordGroupData}
     */
    List<DayMealRecordGroupData> queryByMonth();
}
