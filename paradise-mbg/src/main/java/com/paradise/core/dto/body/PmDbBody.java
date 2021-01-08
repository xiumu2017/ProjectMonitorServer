package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 项目监控数据库信息Body
 *
 * @author Paradise
 */
@ApiModel(value = "项目监控数据库信息Body")
@Data
public class PmDbBody {
    /**
     * 数据库类型
     */
    @ApiModelProperty(value = "数据库类型", required = true, example = "MySQL")
    @NotEmpty(message = "数据库类型不能为空!")
    private String type;

    /**
     * 数据库版本
     */
    @ApiModelProperty(value = "数据库版本", required = true, example = "mysql8.0")
    @NotEmpty(message = "数据库版本不能为空!")
    private String version;

    /**
     * 内网IP地址
     */
    @ApiModelProperty(value = "内网IP地址", required = true, example = "")
    @NotEmpty(message = "内网IP地址不能为空!")
    private String ipAddr;

    /**
     * 公网IP地址
     */
    @ApiModelProperty(value = "公网IP地址", required = true, example = "")
    @NotEmpty(message = "公网IP地址不能为空!")
    private String ipAddrPublic;

    /**
     * 是否开放外网
     */
    @ApiModelProperty(value = "是否开放外网", required = true, example = "0")
    @NotNull(message = "是否开放外网不能为空!")
    private Integer isPublic;

    /**
     * SSH-Server ID
     */
    @ApiModelProperty(value = "SSH-Server ID", required = true, example = "0")
    @NotNull(message = "SSH-Server ID不能为空!")
    private Long serverId;

    /**
     * 域名访问地址
     */
    @ApiModelProperty(value = "域名访问地址", required = true, example = "")
    @NotEmpty(message = "域名访问地址不能为空!")
    private String domainAddr;

    /**
     * 端口号
     */
    @ApiModelProperty(value = "端口号", required = true, example = "3306")
    @NotNull(message = "端口号不能为空!")
    private Integer port;

    /**
     * JDBC连接URL
     */
    @ApiModelProperty(value = "JDBC连接URL", required = true, example = "")
    @NotEmpty(message = "JDBC连接URL不能为空!")
    private String url;

    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名", required = true, example = "root")
    @NotEmpty(message = "登录名不能为空!")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true, example = "root")
    @NotEmpty(message = "密码不能为空!")
    private String password;

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