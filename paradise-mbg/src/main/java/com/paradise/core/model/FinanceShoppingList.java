package com.paradise.core.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * 购物清单表
 *
 * @author Paradise
 */
@ApiModel(value = "购物清单")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FinanceShoppingList implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "自增主键")
    private Integer id;
    @ApiModelProperty(value = "购买时间")
    private Date purchaseTime;
    @ApiModelProperty(value = "来源")
    private String source;
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "标签")
    private String labels;
    @ApiModelProperty(value = "类型")
    private String type;
    @ApiModelProperty(value = "名称")
    private String productName;
    @ApiModelProperty(value = "名称详细")
    private String detailName;
    @ApiModelProperty(value = "链接")
    private String orderLink;
    @ApiModelProperty(value = "价格")
    private BigDecimal price;
    @ApiModelProperty(value = "支付方式")
    private String payType;
    @ApiModelProperty(value = "满意度")
    private String rate;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "创建时间")
    private Date createAt;
    @ApiModelProperty(value = "更新时间")
    private Date updateAt;

    public enum Column {
        id("id", "id", "INTEGER", false),
        purchaseTime("purchase_time", "purchaseTime", "TIMESTAMP", false),
        source("source", "source", "VARCHAR", true),
        orderNo("order_no", "orderNo", "VARCHAR", false),
        labels("labels", "labels", "VARCHAR", false),
        type("type", "type", "VARCHAR", true),
        productName("product_name", "productName", "VARCHAR", false),
        detailName("detail_name", "detailName", "VARCHAR", false),
        orderLink("order_link", "orderLink", "VARCHAR", false),
        price("price", "price", "DECIMAL", false),
        payType("pay_type", "payType", "VARCHAR", false),
        rate("rate", "rate", "VARCHAR", false),
        remark("remark", "remark", "VARCHAR", false),
        createAt("create_at", "createAt", "TIMESTAMP", false),
        updateAt("update_at", "updateAt", "TIMESTAMP", false);

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