package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 用餐记录Body
 *
 * @author Paradise
 */
@ApiModel(value = "用餐记录Body")
@Data
public class DayMealRecordBody {
    @ApiModelProperty(value = "日期", required = true)
    @NotNull(message = "日期不能为空!")
    private Date date;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", required = true, example = "0")
    @NotNull(message = "类型不能为空!")
    private Integer type;

    /**
     * 吃什么
     */
    @ApiModelProperty(value = "吃什么", required = true, example = "")
    @NotEmpty(message = "吃什么不能为空!")
    private String what;

    /**
     * 在哪儿吃
     */
    @ApiModelProperty(value = "在哪儿吃", required = true, example = "")
    @NotEmpty(message = "在哪儿吃不能为空!")
    private String place;

    /**
     * 花了多少
     */
    @ApiModelProperty(value = "花了多少", required = true, example = "0")
    @NotNull(message = "花了多少不能为空!")
    private Integer cost;

    /**
     * 支付方式
     */
    @ApiModelProperty(value = "支付方式", required = true, example = "0")
    @NotNull(message = "支付方式不能为空!")
    private Integer payType;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息", required = true, example = "")
    private String remark;

    @ApiModelProperty(value = "图片信息", example = "https://paradise-113289.qcloud.com/123.jpg")
    private String photos;
}