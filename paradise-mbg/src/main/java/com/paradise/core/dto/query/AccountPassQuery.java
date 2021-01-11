package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 网络账号资产查询参数
 *
 * @author Paradise
 */
@ApiModel(value = "网络账号资产查询参数")
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountPassQuery extends BaseQuery {
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private Integer type;

    /**
     * 网站地址
     */
    @ApiModelProperty(value = "网站地址")
    private String address;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String telephone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 重要性
     */
    @ApiModelProperty(value = "重要性")
    private Integer importance;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 助记词
     */
    @ApiModelProperty(value = "助记词")
    private String mnemonics;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;
}