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
 * 后台用户表
 *
 * @author Paradise
 */
@ApiModel(value="后台用户")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsAdmin implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="用户名")
    private String username;

    @ApiModelProperty(value="密码")
    private String password;

    @ApiModelProperty(value="头像")
    private String icon;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="昵称")
    private String nickName;

    @ApiModelProperty(value="真实姓名")
    private String realName;

    @ApiModelProperty(value="手机号码")
    private String phone;

    @ApiModelProperty(value="备注信息")
    private String remark;

    @ApiModelProperty(value="最后登录时间")
    private Date loginTime;

    @ApiModelProperty(value="帐号启用状态：0->禁用；1->启用")
    private Integer status;

    @ApiModelProperty(value="是否启用")
    private Integer enable;

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
        username("username", "username", "VARCHAR", false),
        password("password", "password", "VARCHAR", true),
        icon("icon", "icon", "VARCHAR", false),
        email("email", "email", "VARCHAR", false),
        nickName("nick_name", "nickName", "VARCHAR", false),
        realName("real_name", "realName", "VARCHAR", false),
        phone("phone", "phone", "VARCHAR", false),
        remark("remark", "remark", "VARCHAR", false),
        loginTime("login_time", "loginTime", "TIMESTAMP", false),
        status("status", "status", "INTEGER", true),
        enable("enable", "enable", "INTEGER", true),
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