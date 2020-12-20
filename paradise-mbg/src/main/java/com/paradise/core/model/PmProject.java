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
 * 项目监控项目表
 *
 * @author Paradise
 */
@ApiModel(value="项目监控项目")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmProject implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="项目名称")
    private String projectName;

    @ApiModelProperty(value="监测地址")
    private String serviceUrl;

    @ApiModelProperty(value="重要性（一星到三星）")
    private Integer importance;

    @ApiModelProperty(value="用户名")
    private String username;

    @ApiModelProperty(value="密码")
    private String password;

    @ApiModelProperty(value="状态码")
    private Integer statusCode;

    @ApiModelProperty(value="项目状态(1:可用 0:禁用)")
    private Integer status;

    @ApiModelProperty(value="项目类型")
    private String type;

    @ApiModelProperty(value="单位id")
    private Long companyId;

    @ApiModelProperty(value="最大通知限制")
    private Integer maxAlert;

    @ApiModelProperty(value="异常数量")
    private Integer errorCount;

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
        projectName("project_name", "projectName", "VARCHAR", false),
        serviceUrl("service_url", "serviceUrl", "VARCHAR", false),
        importance("importance", "importance", "INTEGER", false),
        username("username", "username", "VARCHAR", false),
        password("password", "password", "VARCHAR", true),
        statusCode("status_code", "statusCode", "INTEGER", false),
        status("status", "status", "INTEGER", true),
        type("type", "type", "VARCHAR", true),
        companyId("company_id", "companyId", "BIGINT", false),
        maxAlert("max_alert", "maxAlert", "INTEGER", false),
        errorCount("error_count", "errorCount", "INTEGER", false),
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