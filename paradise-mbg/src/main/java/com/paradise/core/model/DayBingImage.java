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
 * 每日bing壁纸表
 *
 * @author Paradise
 */
@ApiModel(value = "每日bing壁纸")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DayBingImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "自增主键")
    private Long id;
    @ApiModelProperty(value = "图片地址")
    private String url;
    @ApiModelProperty(value = "版权信息")
    private String copyright;
    @ApiModelProperty(value = "版权链接")
    private String copyrightLink;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "英文标题")
    private String titleEn;
    @ApiModelProperty(value = "作者")
    private String author;
    @ApiModelProperty(value = "日期")
    private Date date;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public enum Column {
        id("id", "id", "BIGINT", false),
        url("url", "url", "VARCHAR", false),
        copyright("copyright", "copyright", "VARCHAR", false),
        copyrightLink("copyright_link", "copyrightLink", "VARCHAR", false),
        title("title", "title", "VARCHAR", false),
        titleEn("title_en", "titleEn", "VARCHAR", false),
        author("author", "author", "VARCHAR", false),
        date("date_", "date", "DATE", false),
        createTime("create_time", "createTime", "TIMESTAMP", false);

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