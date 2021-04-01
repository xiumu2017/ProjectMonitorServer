package com.paradise.core.app.controller;

import com.paradise.core.common.api.Result;
import com.paradise.core.common.domain.MinioUploadDto;
import com.paradise.core.common.service.impl.MinIoService;
import com.paradise.core.common.service.impl.QCloudOssService;
import com.paradise.core.common.utils.GeneratorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

/**
 * MinIO对象存储管理
 *
 * @author Paradise
 * @date 2019/12/25
 */
@ApiIgnore
@Slf4j
@Api(tags = "App图片上传服务", hidden = true)
@RestController
@RequestMapping("/oss")
@AllArgsConstructor
public class AppOssController {

    private final MinIoService minIoService;
    private final QCloudOssService ossService;


    @ApiOperation("文件上传")
    @PostMapping(value = "/qc/upload")
    public Result<MinioUploadDto> uploadByOss(@RequestParam("file") MultipartFile file) {
        try {
            return ossService.upload(file, GeneratorUtil.generateFileName(file.getOriginalFilename()));
        } catch (Exception e) {
            log.info("Oss 上传发生错误: {}！", e.getMessage(), e);
        }
        return Result.failed();
    }

    @ApiOperation("文件上传")
    @PostMapping(value = "/upload")
    public Result<MinioUploadDto> upload(@RequestParam("file") MultipartFile file) {
        try {
            return minIoService.upload(file);
        } catch (Exception e) {
            log.info("上传发生错误: {}！", e.getMessage(), e);
        }
        return Result.failed();
    }

    @ApiOperation("文件删除")
    @PostMapping(value = "/delete")
    public Result<Object> delete(@RequestParam("objectName") String objectName) {
        return minIoService.delete(objectName);
    }
}
