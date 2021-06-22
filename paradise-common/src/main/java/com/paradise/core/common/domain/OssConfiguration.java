package com.paradise.core.common.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Paradise
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "oss")
@Component
public class OssConfiguration {

    private String secretId;
    private String secretKey;
    private String appId;
    private String regionName;
    private String bucketName;

    @Override
    public String toString() {
        return "OssConfiguration{" +
                "secretId='" + secretId + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", appId='" + appId + '\'' +
                ", regionName='" + regionName + '\'' +
                ", bucketName='" + bucketName + '\'' +
                '}';
    }
}
