package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 睡眠记录查询参数
 *
 * @author Paradise
 */
@ApiModel(value = "睡眠记录查询参数")
@Data
@EqualsAndHashCode(callSuper = true)
public class DaySleepRecordQuery extends BaseQuery {
    /**
     * 睡眠时长
     */
    @ApiModelProperty(value = "睡眠时长")
    private Integer duration;

    /**
     * 睡眠质量
     */
    @ApiModelProperty(value = "睡眠质量")
    private Integer sleepQuality;

    /**
     * auto_sleep_data
     */
    @ApiModelProperty(value = "auto_sleep_data")
    private String appData;

    /**
     * 睡前回忆
     */
    @ApiModelProperty(value = "睡前回忆")
    private String memory;

    /**
     * 熬夜原因
     */
    @ApiModelProperty(value = "熬夜原因")
    private String lateReason;

    /**
     * 今日最佳
     */
    @ApiModelProperty(value = "今日最佳")
    private String bestTime;
}