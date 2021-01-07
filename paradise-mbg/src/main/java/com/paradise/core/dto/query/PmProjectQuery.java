package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 项目监控项目查询参数
 *
 * @author Paradise
 */
@ApiModel(value = "项目监控项目查询参数")
@Data
@EqualsAndHashCode(callSuper = true)
public class PmProjectQuery extends BaseQuery {
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String projectName;


    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码")
    private Integer statusCode;

    /**
     * 项目状态(1:可用 0:禁用)
     */
    @ApiModelProperty(value = "项目状态(1:可用 0:禁用)")
    private Integer status;

    /**
     * 项目类型
     */
    @ApiModelProperty(value = "项目类型")
    private String type;

    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id")
    private Long companyId;

}