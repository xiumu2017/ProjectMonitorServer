package com.paradise.core.dto.statistics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DayMealRecordDayData {
    private String date;
    private Integer breakfast;
    private Integer lunch;
    private Integer dinner;
    private Integer total;
}
