package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付宝账单查询参数
 *
 * @author Paradise
 */
@ApiModel(value = "支付宝账单查询参数")
@Data
@EqualsAndHashCode(callSuper = true)
public class FinanceAlipayRecordQuery extends BaseQuery {
    /**
     * 交易号
     */
    @ApiModelProperty(value = "交易号")
    private String orderSn;

    /**
     * 商家订单号
     */
    @ApiModelProperty(value = "商家订单号")
    private String outTradeNo;

    /**
     * 交易来源
     */
    @ApiModelProperty(value = "交易来源")
    private String source;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;

    /**
     * 交易对方
     */
    @ApiModelProperty(value = "交易对方")
    private String txTarget;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String productName;

    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private java.math.BigDecimal amount;

    /**
     * 收/支
     */
    @ApiModelProperty(value = "收/支")
    private String direction;

    /**
     * 交易状态
     */
    @ApiModelProperty(value = "交易状态")
    private String status;

    /**
     * 服务费
     */
    @ApiModelProperty(value = "服务费")
    private String serviceFee;

    /**
     * 成功退款
     */
    @ApiModelProperty(value = "成功退款")
    private java.math.BigDecimal refundAmount;

    /**
     * 资金状态
     */
    @ApiModelProperty(value = "资金状态")
    private String moneyStatus;

    /**
     * 支付宝账号
     */
    @ApiModelProperty(value = "支付宝账号")
    private String account;
}