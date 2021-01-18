package com.paradise.core.controller;

import com.paradise.core.common.api.Result;
import com.paradise.core.common.domain.MinioUploadDto;
import com.paradise.core.common.domain.oss.OssInfo;
import com.paradise.core.common.service.impl.MinIoService;
import com.paradise.core.common.service.impl.QCloudOssService;
import com.paradise.core.common.utils.GeneratorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    private final MinIoService minIoService;
    private final QCloudOssService ossService;

    public MinioController(MinIoService minIoService, QCloudOssService ossService) {
        this.minIoService = minIoService;
        this.ossService = ossService;
    }

    @ApiOperation("文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result<MinioUploadDto> upload(@RequestParam("file") MultipartFile file) {
        try {
            return minIoService.upload(file);
        } catch (Exception e) {
            log.info("上传发生错误: {}！", e.getMessage(), e);
        }
        return Result.failed();
    }

    @ApiOperation("文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Object> delete(@RequestParam("objectName") String objectName) {
        return minIoService.delete(objectName);
    }


    @ApiOperation("文件上传")
    @RequestMapping(value = "/oss/upload", method = RequestMethod.POST)
    public Result<MinioUploadDto> uploadByOss(@RequestParam("file") MultipartFile file) {
        try {
            return ossService.upload(file, GeneratorUtil.generateFileName(file.getOriginalFilename()));
        } catch (Exception e) {
            log.info("Oss 上传发生错误: {}！", e.getMessage(), e);
        }
        return Result.failed();
    }

    @ApiOperation("Oss 文件列表")
    @GetMapping(value = "/oss/list")
    public Result<List<OssInfo>> ossInfos() {
        try {
            return Result.success(ossService.list());
        } catch (Exception e) {
            log.info("Oss 文件列表发生错误: {}！", e.getMessage(), e);
        }
        return Result.failed();
    }

    @ApiOperation("Oss 删除文件")
    @DeleteMapping(value = "/oss/{key}")
    public Result<Boolean> del(@PathVariable String key) {
        try {
            return Result.success(ossService.delete(null, key));
        } catch (Exception e) {
            log.info("Oss 删除错误: {}！", e.getMessage(), e);
        }
        return Result.failed();
    }


}
