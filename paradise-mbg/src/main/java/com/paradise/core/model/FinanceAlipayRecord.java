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
 * 支付宝账单表
 *
 * @author Paradise
 */
@ApiModel(value = "支付宝账单")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FinanceAlipayRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "自增主键")
    private Integer id;
    @ApiModelProperty(value = "交易号")
    private String orderSn;
    @ApiModelProperty(value = "商家订单号")
    private String outTradeNo;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "付款时间")
    private Date payTime;
    @ApiModelProperty(value = "最近修改时间")
    private Date updateTime;
    @ApiModelProperty(value = "交易来源")
    private String source;
    @ApiModelProperty(value = "类型")
    private String type;
    @ApiModelProperty(value = "交易对方")
    private String txTarget;
    @ApiModelProperty(value = "商品名称")
    private String productName;
    @ApiModelProperty(value = "金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "收/支")
    private String direction;
    @ApiModelProperty(value = "交易状态")
    private String status;
    @ApiModelProperty(value = "服务费")
    private String serviceFee;
    @ApiModelProperty(value = "成功退款")
    private BigDecimal refundAmount;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "资金状态")
    private String moneyStatus;
    @ApiModelProperty(value = "支付宝账号")
    private String account;

    public enum Column {
        id("id", "id", "INTEGER", false),
        orderSn("order_sn", "orderSn", "VARCHAR", false),
        outTradeNo("out_trade_no", "outTradeNo", "VARCHAR", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        payTime("pay_time", "payTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        source("source", "source", "VARCHAR", true),
        type("type", "type", "VARCHAR", true),
        txTarget("tx_target", "txTarget", "VARCHAR", false),
        productName("product_name", "productName", "VARCHAR", false),
        amount("amount", "amount", "DECIMAL", false),
        direction("direction", "direction", "VARCHAR", false),
        status("status", "status", "VARCHAR", true),
        serviceFee("service_fee", "serviceFee", "VARCHAR", false),
        refundAmount("refund_amount", "refundAmount", "DECIMAL", false),
        remark("remark", "remark", "VARCHAR", false),
        moneyStatus("money_status", "moneyStatus", "VARCHAR", false),
        account("account", "account", "VARCHAR", false);

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