package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 项目监控项目Body
 *
 * @author Paradise
 */
@ApiModel(value = "项目监控项目Body")
@Data
public class PmProjectBody {
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称", required = true, example = "")
    @NotEmpty(message = "项目名称不能为空!")
    private String projectName;

    /**
     * 监测地址
     */
    @ApiModelProperty(value = "监测地址", required = true, example = "")
    @NotEmpty(message = "监测地址不能为空!")
    private String serviceUrl;

    /**
     * 重要性（一星到三星）
     */
    @ApiModelProperty(value = "重要性（一星到三星）", required = true, example = "0")
    @NotNull(message = "重要性（一星到三星）不能为空!")
    private Integer importance;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true, example = "")
    @NotEmpty(message = "用户名不能为空!")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true, example = "")
    @NotEmpty(message = "密码不能为空!")
    private String password;

    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码", required = true, example = "200")
    @NotNull(message = "状态码不能为空!")
    private Integer statusCode;

    /**
     * 项目状态(1:可用 0:禁用)
     */
    @ApiModelProperty(value = "项目状态(1:可用 0:禁用)", required = true, example = "1")
    @NotNull(message = "项目状态(1:可用 0:禁用)不能为空!")
    private Integer status;

    /**
     * 项目类型
     */
    @ApiModelProperty(value = "项目类型", required = true, example = "")
    @NotEmpty(message = "项目类型不能为空!")
    private String type;

    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id", required = true, example = "0")
    private Long companyId;

    /**
     * 最大通知限制
     */
    @ApiModelProperty(value = "最大通知限制", required = true, example = "1")
    @NotNull(message = "最大通知限制不能为空!")
    private Integer maxAlert;

    /**
     * 异常数量
     */
    @ApiModelProperty(value = "异常数量")
    private Integer errorCount;

    /**
     * 项目开始时间
     */
    @ApiModelProperty(value = "项目开始时间", required = true, example = "null")
    @NotNull(message = "项目开始时间不能为空!")
    private java.util.Date startTime;

    /**
     * 项目结束时间
     */
    @ApiModelProperty(value = "项目结束时间", required = true, example = "null")
    @NotNull(message = "项目结束时间不能为空!")
    private java.util.Date endTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", required = true, example = "")
    @NotEmpty(message = "备注不能为空!")
    private String remark;

    /**
     * 项目信息资料链接地址
     */
    @ApiModelProperty(value = "项目信息资料链接地址", required = true, example = "")
    @NotEmpty(message = "项目信息资料链接地址不能为空!")
    private String projectInfoLink;
}