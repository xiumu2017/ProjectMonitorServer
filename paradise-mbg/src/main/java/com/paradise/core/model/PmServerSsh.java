package com.paradise.core.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * 项目监控服务器信息表
 *
 * @author Paradise
 */
@ApiModel(value="项目监控服务器信息")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmServerSsh implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="内网IP地址")
    private String ipAddr;

    @ApiModelProperty(value="公网IP地址")
    private String ipAddrPublic;

    @ApiModelProperty(value="域名地址")
    private String domainAddr;

    @ApiModelProperty(value="端口")
    private Integer port;

    @ApiModelProperty(value="登录用户名")
    private String userName;

    @ApiModelProperty(value="登录密码")
    private String password;

    @ApiModelProperty(value="服务器类型[unknown(0):未知, ali_cloud(1):阿里云服务器, tx_cloud(2):腾讯云服务器, company_server(3):公司服务器, other(4):其它]")
    private Integer serverType;

    @ApiModelProperty(value="操作系统类型")
    private String os;

    @ApiModelProperty(value="操作系统版本")
    private String osVersion;

    @ApiModelProperty(value="内存大小 G")
    private Integer memory;

    @ApiModelProperty(value="是否启用")
    private Integer enable;

    @ApiModelProperty(value="服务器连接状态[fail(0):失败,ok(1):正常]")
    private Integer serverStatus;

    @ApiModelProperty(value="服务器名称")
    private String name;

    @ApiModelProperty(value="备注信息")
    private String remark;

    @ApiModelProperty(value="创建时间")
    private Date createAt;

    @ApiModelProperty(value="更新时间")
    private Date updateAt;

    @ApiModelProperty(value="创建管理员ID")
    private Long createBy;

    @ApiModelProperty(value="更新管理员ID")
    private Long updateBy;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        ipAddr("ip_addr", "ipAddr", "VARCHAR", false),
        ipAddrPublic("ip_addr_public", "ipAddrPublic", "VARCHAR", false),
        domainAddr("domain_addr", "domainAddr", "VARCHAR", false),
        port("port", "port", "INTEGER", false),
        userName("user_name", "userName", "CHAR", false),
        password("password", "password", "CHAR", true),
        serverType("server_type", "serverType", "INTEGER", false),
        os("os", "os", "VARCHAR", false),
        osVersion("os_version", "osVersion", "VARCHAR", false),
        memory("memory", "memory", "INTEGER", false),
        enable("enable", "enable", "INTEGER", true),
        serverStatus("server_status", "serverStatus", "INTEGER", false),
        name("name", "name", "VARCHAR", true),
        remark("remark", "remark", "VARCHAR", false),
        createAt("create_at", "createAt", "TIMESTAMP", false),
        updateAt("update_at", "updateAt", "TIMESTAMP", false),
        createBy("create_by", "createBy", "BIGINT", false),
        updateBy("update_by", "updateBy", "BIGINT", false);

        private static final String BEGINNING_DELIMITER = "`";

        private static final String ENDING_DELIMITER = "`";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }

    public enum ServerType {
        UNKNOWN(new Integer("0"), "未知"),
        ALI_CLOUD(new Integer("1"), "阿里云服务器"),
        TX_CLOUD(new Integer("2"), "腾讯云服务器"),
        COMPANY_SERVER(new Integer("3"), "公司服务器"),
        OTHER(new Integer("4"), "其它");

        private final Integer value;

        private final String name;

        ServerType(Integer value, String name) {
            this.value = value;
            this.name = name;
        }

        public Integer getValue() {
            return this.value;
        }

        public Integer value() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }

    public enum ServerStatus {
        FAIL(new Integer("0"), "失败"),
        OK(new Integer("1"), "正常");

        private final Integer value;

        private final String name;

        ServerStatus(Integer value, String name) {
            this.value = value;
            this.name = name;
        }

        public Integer getValue() {
            return this.value;
        }

        public Integer value() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }
}