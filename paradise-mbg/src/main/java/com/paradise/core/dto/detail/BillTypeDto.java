package com.paradise.core.dto.detail;

import com.paradise.core.model.BillType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
@EqualsAndHashCode(callSuper = true)
public class BillTypeDto extends BillType {
    @ApiModelProperty("上级分类名称")
    private String parentName;
}
