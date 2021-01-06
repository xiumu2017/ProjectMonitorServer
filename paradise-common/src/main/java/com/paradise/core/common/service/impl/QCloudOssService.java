package com.paradise.core.common.service.impl;

import com.paradise.core.common.api.Result;
import com.paradise.core.common.domain.MinioUploadDto;
import com.paradise.core.common.domain.OssConfiguration;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.AnonymousCOSCredentials;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 腾讯云 Oss
 *
 * @author Paradise
 */
@Slf4j
@Service
@EnableConfigurationProperties(OssConfiguration.class)
public class QCloudOssService {

    private final OssConfiguration ossConfiguration;
    private COSClient cosClient;

    public QCloudOssService(OssConfiguration ossConfiguration) {
        this.ossConfiguration = ossConfiguration;
    }

    @PostConstruct
    public void init() {
        COSCredentials cred = new BasicCOSCredentials(ossConfiguration.getSecretId(), ossConfiguration.getSecretKey());
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        // <BucketName-APPID>.cos.ap-nanjing.myqcloud.com
        ClientConfig clientConfig = new ClientConfig(new Region(ossConfiguration.getRegionName()));
        // 3 生成 cos 客户端。
        cosClient = new COSClient(cred, clientConfig);
    }


    /**
     * 创建存储桶
     * 同一用户账号下，可以创建多个存储桶，数量上限是200个（不区分地域）
     * 创建存储桶是低频操作，一般建议在控制台创建 Bucket，在 SDK 进行 Object 的操作
     *
     * @return {@link Bucket}
     */
    public Bucket createBucket(String bucket) {
        if (bucketExist(bucket)) {
            return null;
        }
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucket);
        // 设置 bucket 的权限为 Private(私有读写), 其他可选有公有读私有写, 公有读写
        createBucketRequest.setCannedAcl(CannedAccessControlList.PublicRead);
        try {
            return cosClient.createBucket(createBucketRequest);
        } catch (CosClientException serverException) {
            log.error("腾讯云Oss 创建存储桶出错了:{}", serverException.getLocalizedMessage(), serverException);
        }
        return null;
    }

    private boolean bucketExist(String bucketName) {
        return cosClient.doesBucketExist(bucketName);
    }

    /**
     * 查询存储桶列表
     *
     * @return {@link Bucket}
     */
    public List<Bucket> listBucket() {
        List<Bucket> buckets = cosClient.listBuckets();
        for (Bucket bucketElement : buckets) {
            String bucketName = bucketElement.getName();
            String bucketLocation = bucketElement.getLocation();
        }
        return buckets;
    }

    public PutObjectResult upload(String localFilePath, String bucketName, String key) {
        // 指定要上传的文件
        File localFile = new File(localFilePath);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        return cosClient.putObject(putObjectRequest);
    }

    public Result<MinioUploadDto> upload(MultipartFile multipartFile, String key) throws IOException {
        MinioUploadDto dto = new MinioUploadDto();
        // 指定要上传的文件
        // 指定要上传到的存储桶
        // 指定要上传到 COS 上对象键
        String bucketName = genBucketName(ossConfiguration.getBucketName());
        if (!bucketExist(bucketName)) {
            this.createBucket(bucketName);
        }
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, multipartFile.getInputStream(), null);
        cosClient.putObject(putObjectRequest);
        dto.setName(key);
        dto.setUrl(url(bucketName, key));
        return Result.success(dto);
    }

    public PutObjectResult upload(String bucketName, InputStream inputStream, String key) {
        MinioUploadDto dto = new MinioUploadDto();
        // 指定要上传的文件
        // 指定要上传到的存储桶
        // 指定要上传到 COS 上对象键
        bucketName = genBucketName(bucketName);
        if (!bucketExist(bucketName)) {
            this.createBucket(bucketName);
        }
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, null);
        return cosClient.putObject(putObjectRequest);
    }

    private String genBucketName(String name) {
        return name + "-" + ossConfiguration.getAppId();
    }

    /**
     * 存储桶中的对象列表
     */
    public List<Map<String, String>> list(String bucketName, String prefix, String delimiter) {
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        listObjectsRequest.setBucketName(bucketName);
        // prefix表示列出的object的key以prefix开始
        if (!StringUtils.isNullOrEmpty(prefix)) {
            listObjectsRequest.setPrefix(prefix);
        }
        // delimiter 表示分隔符, 设置为/表示列出当前目录下的object, 设置为空表示列出所有的object
        if (!StringUtils.isNullOrEmpty(delimiter)) {
            listObjectsRequest.setDelimiter(delimiter);
        }
        // 设置最大遍历出多少个对象, 一次 list-object 最大支持1000
        listObjectsRequest.setMaxKeys(1000);
        ObjectListing objectListing;
        do {
            try {
                objectListing = cosClient.listObjects(listObjectsRequest);
            } catch (CosClientException e) {
                log.error(e.getLocalizedMessage(), e);
                return null;
            }
            // common prefix表示表示被delimiter截断的路径, 如 delimiter设置为/, common prefix则表示所有子目录的路径
            List<String> commonPrefix = objectListing.getCommonPrefixes();
            // object summary 表示所有列出的object列表
            List<COSObjectSummary> cosObjectSummaries = objectListing.getObjectSummaries();
            for (COSObjectSummary cosObjectSummary : cosObjectSummaries) {
                // 文件的路径key
                String key = cosObjectSummary.getKey();
                // 文件的etag
                String etag = cosObjectSummary.getETag();
                // 文件的长度
                long fileSize = cosObjectSummary.getSize();
                // 文件的存储类型
                String storageClasses = cosObjectSummary.getStorageClass();
            }
            String nextMarker = objectListing.getNextMarker();
            listObjectsRequest.setMarker(nextMarker);
        } while (objectListing.isTruncated());
        return new ArrayList<>();
    }

    private void download(String bucketName, String key) throws IOException {
        // 方法1 获取下载输入流
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        COSObject cosObject = cosClient.getObject(getObjectRequest);
        COSObjectInputStream cosObjectInput = cosObject.getObjectContent();
        // 下载对象的 CRC64
        String crc64Ecma = cosObject.getObjectMetadata().getCrc64Ecma();
        // 关闭输入流
        cosObjectInput.close();
        // 方法2 下载文件到本地
        String outputFilePath = "exampleobject";
        File downFile = new File(outputFilePath);
        getObjectRequest = new GetObjectRequest(bucketName, key);
        ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, downFile);
    }

    public boolean delete(String bucketName, String key) {
        cosClient.deleteObject(bucketName, key);
        return true;
    }

    public String url(String bucketName, String key) {
        // 生成匿名的请求签名，需要重新初始化一个匿名的 cosClient
        // 初始化用户身份信息, 匿名身份不用传入 SecretId、SecretKey 等密钥信息
        COSCredentials cred = new AnonymousCOSCredentials();
        ClientConfig clientConfig = new ClientConfig(new Region(ossConfiguration.getRegionName()));
        // 生成 cos 客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
        URL url = cosClient.generatePresignedUrl(req);
        cosClient.shutdown();
        return url.toString();
    }

    public String urlPrivate(String bucketName, String key) {
        GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
        // 设置签名过期时间(可选), 若未进行设置, 则默认使用 ClientConfig 中的签名过期时间(1小时)
        // 这里设置签名在半个小时后过期
        Date expirationDate = new Date(System.currentTimeMillis() + 30L * 60L * 1000L);
        req.setExpiration(expirationDate);
        URL url = cosClient.generatePresignedUrl(req);
        cosClient.shutdown();
        return url.toString();
    }
}
