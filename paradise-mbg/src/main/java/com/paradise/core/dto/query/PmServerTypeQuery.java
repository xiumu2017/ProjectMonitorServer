package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 服务器类别查询参数
 *
 * @author Paradise
 */
@ApiModel(value = "服务器类别查询参数")
@Data
@EqualsAndHashCode(callSuper = true)
public class PmServerTypeQuery extends BaseQuery {
    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称")
    private String typeName;

    /**
     * 类别编码
     */
    @ApiModelProperty(value = "类别编码")
    private String typeCode;
}