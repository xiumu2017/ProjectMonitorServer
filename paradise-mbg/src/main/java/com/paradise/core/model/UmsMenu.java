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
 * 后台菜单表
 *
 * @author Paradise
 */
@ApiModel(value="后台菜单")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsMenu implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="父级ID")
    private Long parentId;

    @ApiModelProperty(value="菜单名称")
    private String title;

    @ApiModelProperty(value="菜单级数")
    private Integer level;

    @ApiModelProperty(value="菜单排序")
    private Integer sort;

    @ApiModelProperty(value="前端名称")
    private String name;

    @ApiModelProperty(value="前端图标")
    private String icon;

    @ApiModelProperty(value="是否隐藏")
    private Integer hidden;

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
        parentId("parent_id", "parentId", "BIGINT", false),
        title("title", "title", "VARCHAR", false),
        level("level", "level", "INTEGER", true),
        sort("sort", "sort", "INTEGER", false),
        name("name", "name", "VARCHAR", true),
        icon("icon", "icon", "VARCHAR", false),
        hidden("hidden", "hidden", "INTEGER", false),
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