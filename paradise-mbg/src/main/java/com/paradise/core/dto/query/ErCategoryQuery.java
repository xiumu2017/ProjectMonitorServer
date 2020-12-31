package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Paradise
 */
@Getter
@Setter
@ApiModel("文章类别查询参数")
public class ErCategoryQuery extends BaseQuery {
    private String name;
}
