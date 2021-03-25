package com.paradise.core.dto.statistics;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DayMealRecordMonthData {
    private String month;
    private Integer breakfast;
    private Integer lunch;
    private Integer dinner;
    private Integer supper;
    private Integer snacks;
}
