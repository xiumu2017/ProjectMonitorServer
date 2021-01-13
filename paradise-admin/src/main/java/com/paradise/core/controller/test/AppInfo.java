package com.paradise.core.controller.test;

import lombok.Data;

@Data
public class AppInfo {
    /**
     * 可以为服务商的网站
     */
    private String website;
    /**
     * 服务商提供给客户的免登地址
     */
    private String authUrl;
}
