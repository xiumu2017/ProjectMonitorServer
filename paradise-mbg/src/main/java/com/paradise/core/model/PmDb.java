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
 * 项目监控数据库信息表
 *
 * @author Paradise
 */
@ApiModel(value="项目监控数据库信息")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmDb implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="数据库类型")
    private String type;

    @ApiModelProperty(value="数据库版本")
    private String version;

    @ApiModelProperty(value="内网IP地址")
    private String ipAddr;

    @ApiModelProperty(value="公网IP地址")
    private String ipAddrPublic;

    @ApiModelProperty(value="是否开放外网")
    private Integer isPublic;

    @ApiModelProperty(value="SSH-Server ID")
    private Long serverId;

    @ApiModelProperty(value="域名访问地址")
    private String domainAddr;

    @ApiModelProperty(value="端口号")
    private Integer port;

    @ApiModelProperty(value="JDBC连接URL")
    private String url;

    @ApiModelProperty(value="登录名")
    private String userName;

    @ApiModelProperty(value="密码")
    private String password;

    @ApiModelProperty(value="是否启用")
    private Integer enable;

    @ApiModelProperty(value="备注")
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
        type("type", "type", "CHAR", true),
        version("version", "version", "VARCHAR", false),
        ipAddr("ip_addr", "ipAddr", "CHAR", false),
        ipAddrPublic("ip_addr_public", "ipAddrPublic", "CHAR", false),
        isPublic("is_public", "isPublic", "INTEGER", false),
        serverId("server_id", "serverId", "BIGINT", false),
        domainAddr("domain_addr", "domainAddr", "VARCHAR", false),
        port("port", "port", "INTEGER", false),
        url("url", "url", "VARCHAR", false),
        userName("user_name", "userName", "CHAR", false),
        password("password", "password", "CHAR", true),
        enable("enable", "enable", "INTEGER", true),
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
}