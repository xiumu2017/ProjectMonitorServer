package com.paradise.core.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 睡眠记录表
 *
 * @author Paradise
 */
@ApiModel(value="睡眠记录")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DaySleepRecord implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="日期")
    private Date date;

    @ApiModelProperty(value="上床时间")
    private Date bedTime;

    @ApiModelProperty(value="入睡时间")
    private Date sleepTime;

    @ApiModelProperty(value="醒来时间")
    private Date wakeTime;

    @ApiModelProperty(value="起床时间")
    private Date upTime;

    @ApiModelProperty(value="睡眠时长")
    private Integer duration;

    @ApiModelProperty(value="睡眠质量")
    private Integer sleepQuality;

    @ApiModelProperty(value="auto_sleep_data")
    private String appData;

    @ApiModelProperty(value="睡前回忆")
    private String memory;

    @ApiModelProperty(value="熬夜原因")
    private String lateReason;

    @ApiModelProperty(value="今日最佳")
    private String bestTime;

    @ApiModelProperty(value="备注信息")
    private String remark;

    @ApiModelProperty(value="创建时间")
    private Date createAt;

    @ApiModelProperty(value="更新时间")
    private Date updateAt;

    @ApiModelProperty(value="创建ID")
    private Long createBy;

    @ApiModelProperty(value="更新ID")
    private Long updateBy;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        date("date", "date", "TIMESTAMP", true),
        bedTime("bed_time", "bedTime", "TIMESTAMP", false),
        sleepTime("sleep_time", "sleepTime", "TIMESTAMP", false),
        wakeTime("wake_time", "wakeTime", "TIMESTAMP", false),
        upTime("up_time", "upTime", "TIMESTAMP", false),
        duration("duration", "duration", "INTEGER", false),
        sleepQuality("sleep_quality", "sleepQuality", "INTEGER", false),
        appData("app_data", "appData", "VARCHAR", false),
        memory("memory", "memory", "VARCHAR", false),
        lateReason("late_reason", "lateReason", "VARCHAR", false),
        bestTime("best_time", "bestTime", "VARCHAR", false),
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