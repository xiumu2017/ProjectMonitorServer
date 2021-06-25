package com.paradise.core.app.controller;

import com.paradise.core.common.api.Result;
import com.paradise.core.common.service.impl.QCloudOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * MinIO对象存储管理
 *
 * @author Paradise
 * @date 2019/12/25
 */
@Slf4j
@Api(tags = "MinIO对象存储管理")
@RestController
@RequestMapping("/minio")
public class MinioController {

    private final QCloudOssService ossService;

    public MinioController(QCloudOssService ossService) {
        this.ossService = ossService;
    }

    @ApiOperation("获取临时秘钥")
    @GetMapping("/credential")
    public Result<Map<String, Object>> getCredential() {
        return Result.success(ossService.getCredential());
    }

}
