package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 每日时间轴查询参数
 *
 * @author Paradise
 */
@ApiModel(value = "每日时间轴查询参数")
@Data
@EqualsAndHashCode(callSuper = true)
public class DayTimelineQuery extends BaseQuery {

    @ApiModelProperty("日期")
    private Date date;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 什么事
     */
    @ApiModelProperty(value = "什么事")
    private String things;

    /**
     * 位置
     */
    @ApiModelProperty(value = "位置")
    private String location;

    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private String label;

    /**
     * 图片信息
     */
    @ApiModelProperty(value = "图片信息")
    private String photos;
}