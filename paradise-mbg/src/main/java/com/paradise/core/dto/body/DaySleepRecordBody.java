package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 睡眠记录Body
 *
 * @author Paradise
 */
@ApiModel(value = "睡眠记录Body")
@Data
public class DaySleepRecordBody {
    /**
     * 睡眠时长
     */
    @ApiModelProperty(value = "睡眠时长", required = true, example = "0")
    @NotNull(message = "睡眠时长不能为空!")
    private Integer duration;

    /**
     * 睡眠质量
     */
    @ApiModelProperty(value = "睡眠质量", required = true, example = "0")
    @NotNull(message = "睡眠质量不能为空!")
    private Integer sleepQuality;

    /**
     * auto_sleep_data
     */
    @ApiModelProperty(value = "auto_sleep_data", required = true, example = "")
    @NotEmpty(message = "auto_sleep_data不能为空!")
    private String appData;

    /**
     * 睡前回忆
     */
    @ApiModelProperty(value = "睡前回忆", required = true, example = "")
    @NotEmpty(message = "睡前回忆不能为空!")
    private String memory;

    /**
     * 熬夜原因
     */
    @ApiModelProperty(value = "熬夜原因", required = true, example = "")
    @NotEmpty(message = "熬夜原因不能为空!")
    private String lateReason;

    /**
     * 今日最佳
     */
    @ApiModelProperty(value = "今日最佳", required = true, example = "")
    @NotEmpty(message = "今日最佳不能为空!")
    private String bestTime;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息", required = true, example = "")
    @NotEmpty(message = "备注信息不能为空!")
    private String remark;
}