package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 账单查询参数
 *
 * @author Paradise
 */
@ApiModel(value = "账单查询参数")
@Data
@EqualsAndHashCode(callSuper = true)
public class BillQuery extends BaseQuery {
    /**
     * 账单方向（0划转；1收入；2支出）
     */
    @ApiModelProperty(value = "账单方向（0划转；1收入；2支出）")
    private Integer direction;

    /**
     * 分类ID
     */
    @ApiModelProperty(value = "分类ID")
    private Long typeId;

    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private Integer amount;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private String labels;
}