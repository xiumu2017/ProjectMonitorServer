package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 每日时间轴Body
 *
 * @author Paradise
 */
@ApiModel(value = "每日时间轴Body")
@Data
public class DayTimelineBody {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", required = true, example = "null")
    private Long userId;

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期", required = true, example = "null")
    @NotNull(message = "日期不能为空!")
    private java.util.Date date;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间", required = true, example = "CURRENT_TIMESTAMP")
    @NotNull(message = "开始时间不能为空!")
    private java.util.Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间", required = true, example = "CURRENT_TIMESTAMP")
    @NotNull(message = "结束时间不能为空!")
    private java.util.Date endTime;

    /**
     * 什么事
     */
    @ApiModelProperty(value = "什么事", required = true, example = "")
    @NotEmpty(message = "什么事不能为空!")
    private String things;

    /**
     * 位置
     */
    @ApiModelProperty(value = "位置", required = true, example = "")
    @NotEmpty(message = "位置不能为空!")
    private String location;

    /**
     * 标签
     */
    @ApiModelProperty(value = "标签", required = true, example = "")
    @NotEmpty(message = "标签不能为空!")
    private String label;

    /**
     * 图片信息
     */
    @ApiModelProperty(value = "图片信息", required = true, example = "")
    private String photos;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息", required = true, example = "")
    @NotEmpty(message = "备注信息不能为空!")
    private String remark;
}