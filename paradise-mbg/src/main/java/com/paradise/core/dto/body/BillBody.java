package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 账单Body
 *
 * @author Paradise
 */
@ApiModel(value = "账单Body")
@Data
public class BillBody {
    /**
     * 账单方向（0划转；1收入；2支出）
     */
    @ApiModelProperty(value = "账单方向（0划转；1收入；2支出）", required = true, example = "1")
    @NotNull(message = "账单方向（0划转；1收入；2支出）不能为空!")
    private Integer direction;

    /**
     * 分类ID
     */
    @ApiModelProperty(value = "分类ID", required = true, example = "0")
    @NotNull(message = "分类ID不能为空!")
    private Long typeId;

    /**
     * 金额
     */
    @ApiModelProperty(value = "金额", required = true, example = "0")
    @NotNull(message = "金额不能为空!")
    private Integer amount;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", required = true, example = "null")
    @NotEmpty(message = "名称不能为空!")
    private String name;

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期", required = true, example = "null")
    @NotNull(message = "日期不能为空!")
    private java.util.Date date;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除", required = true, example = "0")
    @NotNull(message = "是否删除不能为空!")
    private Integer deleted;

    /**
     * 标签
     */
    @ApiModelProperty(value = "标签", required = true, example = "")
    @NotEmpty(message = "标签不能为空!")
    private String labels;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息", required = true, example = "")
    @NotEmpty(message = "备注信息不能为空!")
    private String remark;
}