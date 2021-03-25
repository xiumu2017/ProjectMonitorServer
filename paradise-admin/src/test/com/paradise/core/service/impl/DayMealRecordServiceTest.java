package com.paradise.core.service.impl;

import com.paradise.core.BaseTest;
import com.paradise.core.dto.statistics.DayMealRecordMonthData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
class DayMealRecordServiceTest extends BaseTest {

    @Autowired
    private DayMealRecordService dayMealRecordService;

    @Test
    void monthData() {
        final List<DayMealRecordMonthData> dataList = dayMealRecordService.monthData();
        Assertions.assertNotNull(dataList);
        for (DayMealRecordMonthData monthData : dataList) {
            log.info(monthData.toString());
        }
    }
}