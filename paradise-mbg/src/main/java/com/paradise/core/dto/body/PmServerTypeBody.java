package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 服务器类别Body
 *
 * @author Paradise
 */
@ApiModel(value = "服务器类别Body")
@Data
public class PmServerTypeBody {
    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称", required = true, example = "")
    @NotEmpty(message = "类别名称不能为空!")
    private String typeName;

    /**
     * 类别编码
     */
    @ApiModelProperty(value = "类别编码", required = true, example = "")
    @NotEmpty(message = "类别编码不能为空!")
    private String typeCode;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息", required = true, example = "")
    @NotEmpty(message = "备注信息不能为空!")
    private String remark;
}