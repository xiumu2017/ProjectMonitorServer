package com.paradise.core.controller.day;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.DaySleepRecordBody;
import com.paradise.core.dto.query.DaySleepRecordQuery;
import com.paradise.core.model.DaySleepRecord;
import com.paradise.core.service.impl.DaySleepRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 睡眠记录表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "睡眠记录相关接口")
@RequestMapping("/daySleepRecord")
public class DaySleepRecordController {
    private final DaySleepRecordService daySleepRecordService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<DaySleepRecord>> selectByPage(DaySleepRecordQuery query) {
        List<DaySleepRecord> list = this.daySleepRecordService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated DaySleepRecordBody record) {
        int count = this.daySleepRecordService.insert(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Long id, @RequestBody @Validated DaySleepRecordBody record) {
        int count = this.daySleepRecordService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<DaySleepRecord> selectByPrimaryKey(@PathVariable("id") Long id) {
        DaySleepRecord daySleepRecord = this.daySleepRecordService.selectByPrimaryKey(id);
        return Result.success(daySleepRecord);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.daySleepRecordService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation("睡眠时长统计数据")
    @GetMapping("/statistics")
    public Result<List<List<String>>> statistics() {
        return Result.success(daySleepRecordService.statistics());
    }
}