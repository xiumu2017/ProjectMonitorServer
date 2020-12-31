package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Paradise
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("人员查询")
public class UmsMemberQuery extends BaseQuery {
    @ApiModelProperty("微信昵称")
    private String nickName;
}
