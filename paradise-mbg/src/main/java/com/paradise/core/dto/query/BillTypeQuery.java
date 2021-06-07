package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 账单分类查询参数
 *
 * @author Paradise
 */
@ApiModel(value = "账单分类查询参数")
@Data
@EqualsAndHashCode(callSuper = true)
public class BillTypeQuery extends BaseQuery {
    /**
     * 上级分类ID
     */
    @ApiModelProperty(value = "上级分类ID")
    private Long parentId;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String name;

    /**
     * 图标URL
     */
    @ApiModelProperty(value = "图标URL")
    private String icon;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用")
    private Integer enable;

}