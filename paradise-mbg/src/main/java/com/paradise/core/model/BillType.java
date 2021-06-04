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
 * 账单分类表
 *
 * @author Paradise
 */
@ApiModel(value = "账单分类")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillType implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "自增主键")
    private Long id;
    @ApiModelProperty(value = "上级分类ID")
    private Long parentId;
    @ApiModelProperty(value = "分类名称")
    private String name;
    @ApiModelProperty(value = "图标URL")
    private String icon;
    @ApiModelProperty(value = "是否启用")
    private Integer enable;
    @ApiModelProperty(value = "是否删除")
    private Integer deleted;
    @ApiModelProperty(value = "备注信息")
    private String remark;
    @ApiModelProperty(value = "创建时间")
    private Date createAt;
    @ApiModelProperty(value = "更新时间")
    private Date updateAt;
    @ApiModelProperty(value = "创建ID")
    private Long createBy;

    public enum Column {
        id("id", "id", "BIGINT", false),
        parentId("parent_id", "parentId", "BIGINT", false),
        name("name", "name", "VARCHAR", true),
        icon("icon", "icon", "VARCHAR", false),
        enable("enable", "enable", "INTEGER", true),
        deleted("deleted", "deleted", "INTEGER", false),
        remark("remark", "remark", "VARCHAR", false),
        createAt("create_at", "createAt", "TIMESTAMP", false),
        updateAt("update_at", "updateAt", "TIMESTAMP", false),
        createBy("create_by", "createBy", "BIGINT", false);

        private static final String BEGINNING_DELIMITER = "`";

        private static final String ENDING_DELIMITER = "`";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public static Column[] excludes(Column... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

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

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
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