package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 项目监控数据库信息查询参数
 *
 * @author Paradise
 */
@ApiModel(value = "项目监控数据库信息查询参数")
@Data
@EqualsAndHashCode(callSuper = true)
public class PmDbQuery extends BaseQuery {
    /**
     * 数据库类型
     */
    @ApiModelProperty(value = "数据库类型")
    private String type;

    /**
     * 数据库版本
     */
    @ApiModelProperty(value = "数据库版本")
    private String version;

    /**
     * 内网IP地址
     */
    @ApiModelProperty(value = "内网IP地址")
    private String ipAddr;

    /**
     * 公网IP地址
     */
    @ApiModelProperty(value = "公网IP地址")
    private String ipAddrPublic;

    /**
     * 是否开放外网
     */
    @ApiModelProperty(value = "是否开放外网")
    private Integer isPublic;

    /**
     * SSH-Server ID
     */
    @ApiModelProperty(value = "SSH-Server ID")
    private Long serverId;

    /**
     * 域名访问地址
     */
    @ApiModelProperty(value = "域名访问地址")
    private String domainAddr;

    /**
     * 端口号
     */
    @ApiModelProperty(value = "端口号")
    private Integer port;

    /**
     * JDBC连接URL
     */
    @ApiModelProperty(value = "JDBC连接URL")
    private String url;

    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用")
    private Integer enable;
}