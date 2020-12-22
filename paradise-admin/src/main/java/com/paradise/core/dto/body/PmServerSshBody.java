package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 项目监控服务器信息表
 *
 * @author Paradise
 */
@Data
@ApiModel(value = "项目监控服务器信息")
public class PmServerSshBody {

    @ApiModelProperty(value = "内网IP地址")
    private String ipAddr;

    @ApiModelProperty(value = "公网IP地址")
    private String ipAddrPublic;

    @ApiModelProperty(value = "域名地址")
    private String domainAddr;

    @ApiModelProperty(value = "端口")
    private Integer port;

    @ApiModelProperty(value = "登录用户名")
    private String userName;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "服务器类型[unknown(0):未知, ali_cloud(1):阿里云服务器, tx_cloud(2):腾讯云服务器, company_server(3):公司服务器, other(4):其它]")
    private Integer serverType;

    @ApiModelProperty(value = "操作系统类型")
    private String os;

    @ApiModelProperty(value = "操作系统版本")
    private String osVersion;

    @ApiModelProperty(value = "内存大小 G")
    private Integer memory;

    @ApiModelProperty(value = "是否启用")
    private Integer enable;

    @ApiModelProperty(value = "服务器连接状态[fail(0):失败,ok(1):正常]")
    private Integer serverStatus;

    @ApiModelProperty(value = "服务器名称")
    private String name;

    @ApiModelProperty(value = "备注信息")
    private String remark;

}