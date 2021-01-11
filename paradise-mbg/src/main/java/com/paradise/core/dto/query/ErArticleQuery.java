package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Paradise
 */
@Getter
@Setter
@ApiModel("文章查询")
public class ErArticleQuery extends BaseQuery {
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("分类名称")
    private String categoryName;
    @ApiModelProperty("类别ID")
    private Long categoryId;
}
