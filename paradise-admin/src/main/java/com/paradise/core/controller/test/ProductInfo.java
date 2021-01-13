package com.paradise.core.controller.test;

import lombok.Data;

@Data
public class ProductInfo {
    /**
     * 购买的产品名称
     */
    private String productName;
    /**
     * 是否为试用，true：是，false：否
     */
    private Boolean isTrial;
    /**
     * 产品规格，是试用时为空
     */
    private String spec;
    /**
     * 购买时长，是试用时为空
     */
    private Integer timeSpan;
    /**
     * 购买时长单位（y、m、d、h、t 分别代表年、月、日、时、次），是试用时为空
     */
    private String timeUnit;
}
