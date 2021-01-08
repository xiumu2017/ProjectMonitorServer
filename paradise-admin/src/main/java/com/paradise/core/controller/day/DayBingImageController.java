package com.paradise.core.controller.day;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.DayBingImageBody;
import com.paradise.core.dto.query.DayBingImageQuery;
import com.paradise.core.model.DayBingImage;
import com.paradise.core.service.impl.DayBingImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
public class DayBingImageController {
    private final DayBingImageService dayBingImageService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<DayBingImage>> selectByPage(DayBingImageQuery query) {
        List<DayBingImage> list = this.dayBingImageService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated DayBingImageBody record) {
        int count = this.dayBingImageService.insertSelective(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Long id, @RequestBody @Validated DayBingImageBody record) {
        int count = this.dayBingImageService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<DayBingImage> selectByPrimaryKey(@PathVariable("id") Long id) {
        DayBingImage dayBingImage = this.dayBingImageService.selectByPrimaryKey(id);
        return Result.success(dayBingImage);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.dayBingImageService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}