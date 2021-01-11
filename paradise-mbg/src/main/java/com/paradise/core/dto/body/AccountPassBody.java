package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 网络账号资产Body
 *
 * @author Paradise
 */
@ApiModel(value = "网络账号资产Body")
@Data
public class AccountPassBody {
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", required = true, example = "")
    @NotEmpty(message = "名称不能为空!")
    private String name;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", required = true, example = "0")
    @NotNull(message = "类型不能为空!")
    private Integer type;

    /**
     * 网站地址
     */
    @ApiModelProperty(value = "网站地址", required = true, example = "")
    @NotEmpty(message = "网站地址不能为空!")
    private String address;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true, example = "")
    @NotEmpty(message = "用户名不能为空!")
    private String username;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", required = true, example = "")
    @NotEmpty(message = "手机号不能为空!")
    private String telephone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", required = true, example = "")
    @NotEmpty(message = "邮箱不能为空!")
    private String email;

    /**
     * 重要性
     */
    @ApiModelProperty(value = "重要性", required = true, example = "0")
    @NotNull(message = "重要性不能为空!")
    private Integer importance;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true, example = "")
    @NotEmpty(message = "密码不能为空!")
    private String password;

    /**
     * 助记词
     */
    @ApiModelProperty(value = "助记词", required = true, example = "")
    @NotEmpty(message = "助记词不能为空!")
    private String mnemonics;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息", required = true, example = "")
    @NotEmpty(message = "备注信息不能为空!")
    private String remark;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", required = true, example = "0")
    private Long userId;
}