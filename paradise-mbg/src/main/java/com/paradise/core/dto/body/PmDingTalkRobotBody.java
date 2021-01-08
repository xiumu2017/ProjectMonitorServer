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
public class PmDingTalkRobotBody {
    /**
     * 钉钉群组ID
     */
    @ApiModelProperty(value = "钉钉群组ID", required = true, example = "0")
    @NotNull(message = "钉钉群组ID不能为空!")
    private Long groupId;

    /**
     * 钉钉群组机器人名称
     */
    @ApiModelProperty(value = "钉钉群组机器人名称", required = true, example = "")
    @NotEmpty(message = "钉钉群组机器人名称不能为空!")
    private String name;

    /**
     * 钉钉群组机器人类别
     */
    @ApiModelProperty(value = "钉钉群组机器人类别", required = true, example = "")
    @NotEmpty(message = "钉钉群组机器人类别不能为空!")
    private String type;

    /**
     * Token
     */
    @ApiModelProperty(value = "Token", required = true, example = "")
    @NotEmpty(message = "Token不能为空!")
    private String token;

    /**
     * Secret
     */
    @ApiModelProperty(value = "Secret", required = true, example = "")
    @NotEmpty(message = "Secret不能为空!")
    private String secret;

    /**
     * web-Hook地址
     */
    @ApiModelProperty(value = "web-Hook地址", required = true, example = "")
    @NotEmpty(message = "web-Hook地址不能为空!")
    private String webHook;

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