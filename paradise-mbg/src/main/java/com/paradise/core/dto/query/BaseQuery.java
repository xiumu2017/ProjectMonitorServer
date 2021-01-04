package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 基础查询参数
 *
 * @author Paradise
 */
@Getter
@Setter
public class BaseQuery {
    @ApiModelProperty(value = "分页参数", required = true, example = "1")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "分页参数", required = true, example = "10")
    private Integer pageSize = 10;
    @ApiModelProperty("是否启用")
    private Integer enable;
}
