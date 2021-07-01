package com.paradise.core.app.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.app.service.BingImageService;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.query.DayBingImageQuery;
import com.paradise.core.model.DayBingImage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 每日bing壁纸表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "每日bing壁纸相关接口")
@RequestMapping("/bingImage")
public class BingImageController {
    private final BingImageService bingImageService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<String>> selectUrlByPage(DayBingImageQuery query) {
        List<String> list = bingImageService.selectUrlByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/ss")
    public Result<CommonPage<DayBingImage>> selectByPage(DayBingImageQuery query) {
        List<DayBingImage> list = bingImageService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

//    @ApiOperationSupport(order = 4)
//    @ApiOperation("详情")
//    @GetMapping(value = "/{id}")
//    public Result<DayBingImage> selectByPrimaryKey(@PathVariable("id") Long id) {
//        DayBingImage dayBingImage = this.dayBingImageService.selectByPrimaryKey(id);
//        return Result.success(dayBingImage);
//    }
}