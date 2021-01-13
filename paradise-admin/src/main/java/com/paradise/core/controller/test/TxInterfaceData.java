package com.paradise.core.controller.test;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TxInterfaceData {
    /**
     * createInstance/renewInstance/
     */
    private String action;
    /**
     * 随机字符串
     */
    private String echoback;
    /**
     * 订单 ID
     */
    private String orderId;
    /**
     * 购买者账号 ID
     */
    private String accountId;
    /**
     * 用户在腾讯云开放平台的标识，此标识对于同一服务商是相同的，
     * 对于不同服务商是不同的，长度为32位。
     * 如果没有接入开放平台，此字段为空
     */
    private String openId;
    /**
     * 云市场产品 ID
     */
    private String productId;
    /**
     * 接口请求的 ID
     */
    private String requestId;
    /**
     * 产品信息
     */
    private ProductInfo productInfo;
    /**
     * 订单扩展信息，通常情况下为空
     */
    private String extendInfo;

    /**
     * renewInstance
     * modifyInstance
     * 实例标识 ID
     */
    private String signId;

    /**
     * renewInstance
     * modifyInstance
     * 新的实例到期时间（yyyy-MM-dd HH:mm:ss）
     * 新的实例到期时间，仅在试用版转为正式购买时传递
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date instanceExpireTime;

    /**
     * modifyInstance
     * 实例新规格
     */
    private String spec;
    /**
     * modifyInstance
     * 购买时长，仅在试用版转为正式购买时传递
     */
    private Integer timeSpan;
    /**
     * modifyInstance
     * 购买时长单位（y、m、d、h、t 分别代表年、月、日、时、次），是试用时为空
     */
    private String timeUnit;

}

