package com.paradise.core.dto.statistics;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel("每日用餐统计数据")
public class DayMealRecordChartData {
    /**
     * 日期数据
     */
    private List<String> dateList;
    /**
     * 早饭数据
     */
    private List<String> breakfast;
    /**
     * 午饭数据
     */
    private List<String> lunch;
    /**
     * 晚饭数据
     */
    private List<String> dinner;
    /**
     * 每日合计数据
     */
    private List<String> total;
}
