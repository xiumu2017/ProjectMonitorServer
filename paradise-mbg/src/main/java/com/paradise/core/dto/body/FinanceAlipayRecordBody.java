package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 支付宝账单Body
 *
 * @author Paradise
 */
@ApiModel(value = "支付宝账单Body")
@Data
public class FinanceAlipayRecordBody {
    /**
     * 交易号
     */
    @ApiModelProperty(value = "交易号", required = true, example = "null")
    @NotEmpty(message = "交易号不能为空!")
    private String orderSn;

    /**
     * 商家订单号
     */
    @ApiModelProperty(value = "商家订单号")
    private String outTradeNo;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;

    /**
     * 付款时间
     */
    @ApiModelProperty(value = "付款时间")
    private java.util.Date payTime;

    /**
     * 最近修改时间
     */
    @ApiModelProperty(value = "最近修改时间")
    private java.util.Date updateTime;

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
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 资金状态
     */
    @ApiModelProperty(value = "资金状态")
    private String moneyStatus;

    /**
     * 支付宝账号
     */
    @ApiModelProperty(value = "支付宝账号", required = true, example = "null")
    @NotEmpty(message = "支付宝账号不能为空!")
    private String account;
}