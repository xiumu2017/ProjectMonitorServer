package com.paradise.core.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.Result;
import com.paradise.core.model.DayBingImage;
import com.paradise.core.service.impl.DayBingImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@Api("首页接口")
@AllArgsConstructor
public class HomeController {
    private final DayBingImageService bingImageService;

    @ApiOperationSupport(order = 1)
    @ApiOperation("每日Bing壁纸")
    @GetMapping("/bing/image")
    public Result<DayBingImage> bingImage() {
        return Result.success(bingImageService.todayImage());
    }

}
