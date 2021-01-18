package com.paradise.core.common.domain.oss;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qcloud.cos.model.COSObjectSummary;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 对象信息
 *
 * @author Paradise
 */
@Getter
@Setter
@ApiModel("对象信息")
public class OssInfo {
    /**
     * The name of the bucket in which this object is stored
     */
    private String bucketName;

    /**
     * The key under which this object is stored
     */
    private String key;

    /**
     * Hex encoded MD5 hash of this object's contents, as computed by Qcloud COS
     */
    private String eTag;

    /**
     * The size of this object, in bytes
     */
    private long size;

    /**
     * The date, according to Qcloud COS, when this object was last modified
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModified;

    /**
     * The class of storage used by Qcloud COS to store this object
     */
    private String storageClass;

    private String url;

    public OssInfo() {
    }

    public OssInfo(COSObjectSummary summary) {
        this.bucketName = summary.getBucketName();
        this.key = summary.getKey();
        this.eTag = summary.getETag();
        this.size = summary.getSize();
        this.lastModified = summary.getLastModified();
        this.storageClass = summary.getStorageClass();
        this.url = "https://paradise-1256237186.cos.ap-nanjing.myqcloud.com/" + this.key;
    }
}
