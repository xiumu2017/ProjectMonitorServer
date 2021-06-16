package com.paradise.core.common.oss;

import com.paradise.core.common.domain.OssConfiguration;
import com.tencent.cloud.CosStsClient;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class CosStsClientUtils {

    public static Map<String, Object> getCredential(OssConfiguration ossConfiguration) {
        TreeMap<String, Object> config = new TreeMap<>();

        try {
            // 云 api 密钥 SecretId
            config.put("secretId", ossConfiguration.getSecretId());
            // 云 api 密钥 SecretKey
            config.put("secretKey", ossConfiguration.getSecretKey());
            // 设置域名
            //config.put("host", "www.zdzy.xyz");

            // 临时密钥有效时长，单位是秒
            config.put("durationSeconds", 1800);

            // 换成你的 bucket
            config.put("bucket", ossConfiguration.getBucketName() + "-" + ossConfiguration.getAppId());
            // 换成 bucket 所在地区
            config.put("region", ossConfiguration.getRegionName());

            // 这里改成允许的路径前缀，可以根据自己网站的用户登录态判断允许上传的具体路径，例子： a.jpg 或者 a/* 或者 * (使用通配符*存在重大安全风险, 请谨慎评估使用)
            config.put("allowPrefix", "*");
            // 可以通过 allowPrefixes 指定前缀数组
//            config.put("allowPrefixes", new String[] {
//                    "exampleobject",
//                    "exampleobject2"
//            });

            // 密钥的权限列表。简单上传和分片需要以下的权限，其他权限列表请看 https://cloud.tencent.com/document/product/436/31923
            String[] allowActions = new String[]{
                    // 简单上传
                    "name/cos:PutObject",
                    "name/cos:PostObject",
                    // 分片上传
                    "name/cos:InitiateMultipartUpload",
                    "name/cos:ListMultipartUploads",
                    "name/cos:ListParts",
                    "name/cos:UploadPart",
                    "name/cos:CompleteMultipartUpload"
            };
            config.put("allowActions", allowActions);

            JSONObject credential = CosStsClient.getCredential(config);
            log.info(credential.toString(4));
            return credential.toMap();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new IllegalArgumentException("no valid secret !");
        }
    }
}
