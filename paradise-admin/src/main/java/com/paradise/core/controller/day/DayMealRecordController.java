package com.paradise.core.controller.day;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.DayMealRecordBody;
import com.paradise.core.dto.query.DayMealRecordQuery;
import com.paradise.core.dto.statistics.DayMealRecordChartData;
import com.paradise.core.dto.statistics.DayMealRecordMonthData;
import com.paradise.core.model.DayMealRecord;
import com.paradise.core.service.impl.DayMealRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.hutool.core.collection.CollUtil.newArrayList;

/**
 * 用餐记录表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "用餐记录相关接口")
@RequestMapping("/dayMealRecord")
public class DayMealRecordController {
    private final DayMealRecordService dayMealRecordService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<DayMealRecord>> selectByPage(DayMealRecordQuery query) {
        List<DayMealRecord> list = this.dayMealRecordService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated DayMealRecordBody record) {
        int count = this.dayMealRecordService.insertSelective(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Long id, @RequestBody @Validated DayMealRecordBody record) {
        int count = this.dayMealRecordService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<DayMealRecord> selectByPrimaryKey(@PathVariable("id") Long id) {
        DayMealRecord dayMealRecord = this.dayMealRecordService.selectByPrimaryKey(id);
        return Result.success(dayMealRecord);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.dayMealRecordService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation("类别列表")
    @GetMapping("/types")
    public Result<List<String>> types() {
        return Result.success(newArrayList("零食", "早饭", "午饭", "晚饭", "夜宵"));
    }

    @ApiOperationSupport(order = 7)
    @ApiOperation("支付方式类别列表")
    @GetMapping("/payTypes")
    public Result<List<String>> patTypes() {
        return Result.success(newArrayList("微信支付", "支付宝支付", "现金", "银行卡", "其它"));
    }

    @ApiOperationSupport(order = 8)
    @ApiOperation("查询统计数据")
    @GetMapping("/statistics")
    public Result<DayMealRecordChartData> chartData(DayMealRecordQuery query) {
        return Result.success(dayMealRecordService.chartData(query));
    }

    @ApiOperationSupport(order = 9)
    @ApiOperation("查询统计数据-月度汇总")
    @GetMapping("/statistics/month")
    public Result<List<DayMealRecordMonthData>> monthData() {
        return Result.success(dayMealRecordService.monthData());
    }
}