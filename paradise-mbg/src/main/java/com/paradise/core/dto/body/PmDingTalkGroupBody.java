package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 钉钉群组管理Body
 *
 * @author Paradise
 */
@ApiModel(value = "钉钉群组管理Body")
@Data
public class PmDingTalkGroupBody {
    /**
     * 钉钉群组名称
     */
    @ApiModelProperty(value = "钉钉群组名称", required = true, example = "")
    @NotEmpty(message = "钉钉群组名称不能为空!")
    private String name;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", required = true, example = "1")
    @NotNull(message = "是否启用不能为空!")
    private Integer enable;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", required = true, example = "")
    @NotEmpty(message = "备注不能为空!")
    private String remark;
}