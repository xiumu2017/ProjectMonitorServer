package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用餐记录查询参数
 *
 * @author Paradise
 */
@ApiModel(value = "用餐记录查询参数")
@Data
@EqualsAndHashCode(callSuper = true)
public class DayMealRecordQuery extends BaseQuery {
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty("日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    /**
     * 吃什么
     */
    @ApiModelProperty(value = "吃什么")
    private String what;

    /**
     * 在哪儿吃
     */
    @ApiModelProperty(value = "在哪儿吃")
    private String place;

    /**
     * 花了多少
     */
    @ApiModelProperty(value = "花了多少")
    private Integer cost;

    /**
     * 支付方式
     */
    @ApiModelProperty(value = "支付方式")
    private Integer payType;
}