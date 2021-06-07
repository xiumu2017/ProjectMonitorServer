package com.paradise.core.dto.detail;

import com.paradise.core.model.Bill;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
@EqualsAndHashCode(callSuper = true)
public class BillDto extends Bill {
    @ApiModelProperty("类别名称")
    private String typeName;
    @ApiModelProperty("类别图标")
    private String typeIcon;
}
