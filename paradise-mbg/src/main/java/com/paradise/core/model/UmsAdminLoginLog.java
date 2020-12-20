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
 * 后台用户登录日志表
 *
 * @author Paradise
 */
@ApiModel(value="后台用户登录日志")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsAdminLoginLog implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="管理员ID")
    private Long adminId;

    @ApiModelProperty(value="登录时间")
    private Date loginTime;

    @ApiModelProperty(value="IP地址")
    private String ipAddr;

    @ApiModelProperty(value="浏览器类型")
    private String userAgent;

    @ApiModelProperty(value="登录结果[success(1),fail(0)]")
    private Integer loginStatus;

    @ApiModelProperty(value="登录失败原因")
    private String failReason;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        adminId("admin_id", "adminId", "BIGINT", false),
        loginTime("login_time", "loginTime", "TIMESTAMP", false),
        ipAddr("ip_addr", "ipAddr", "VARCHAR", false),
        userAgent("user_agent", "userAgent", "VARCHAR", false),
        loginStatus("login_status", "loginStatus", "INTEGER", false),
        failReason("fail_reason", "failReason", "CHAR", false);

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