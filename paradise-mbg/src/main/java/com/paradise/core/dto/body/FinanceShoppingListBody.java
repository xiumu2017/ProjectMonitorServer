package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 购物清单Body
 *
 * @author Paradise
 */
@ApiModel(value = "购物清单Body")
@Data
public class FinanceShoppingListBody {
    /**
     * 购买时间
     */
    @ApiModelProperty(value = "购买时间")
    private java.util.Date purchaseTime;

    /**
     * 来源
     */
    @ApiModelProperty(value = "来源")
    private String source;

    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号")
    private String orderNo;

    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private String labels;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String productName;

    /**
     * 名称详细
     */
    @ApiModelProperty(value = "名称详细")
    private String detailName;

    /**
     * 链接
     */
    @ApiModelProperty(value = "链接")
    private String orderLink;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private java.math.BigDecimal price;

    /**
     * 支付方式
     */
    @ApiModelProperty(value = "支付方式")
    private String payType;

    /**
     * 满意度
     */
    @ApiModelProperty(value = "满意度")
    private String rate;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
}