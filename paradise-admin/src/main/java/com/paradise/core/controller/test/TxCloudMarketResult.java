package com.paradise.core.controller.test;

import lombok.Data;

@Data
public class TxCloudMarketResult {

    private String success = "true";

    private AppInfo appInfo;

    /**
     * 实例标识 ID，服务商提供的唯一标识。不可为空，长度最长为11位。当为"0"时，系统会认为是异步发货。
     */
    private String signId;

    /**
     * 自定义数据，会显示在实例详情中。格式为[{"name":"","value":""}]
     */
    private String additionalInfo;

    private String echoback;

    public TxCloudMarketResult(String success) {
        this.success = success;
    }

    public TxCloudMarketResult() {
    }

    public static TxCloudMarketResult success() {
        return new TxCloudMarketResult();
    }

    public static TxCloudMarketResult fail() {
        return new TxCloudMarketResult("false");
    }

}
