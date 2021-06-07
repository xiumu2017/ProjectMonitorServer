package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 账单分类Body
 *
 * @author Paradise
 */
@ApiModel(value = "账单分类Body")
@Data
public class BillTypeBody {
    /**
     * 上级分类ID
     */
    @ApiModelProperty(value = "上级分类ID", required = true, example = "0")
    @NotNull(message = "上级分类ID不能为空!")
    private Long parentId;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称", required = true, example = "服饰")
    @NotEmpty(message = "分类名称不能为空!")
    private String name;

    /**
     * 图标URL
     */
    @ApiModelProperty(value = "图标URL", required = true, example = "")
    @NotEmpty(message = "图标URL不能为空!")
    private String icon;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", required = true, example = "1")
    @NotNull(message = "是否启用不能为空!")
    private Integer enable;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息", required = true, example = "")
    @NotEmpty(message = "备注信息不能为空!")
    private String remark;
}