package com.paradise.core.controller.day;

import cn.hutool.core.date.DateUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.DayTimelineBody;
import com.paradise.core.dto.query.DayTimelineQuery;
import com.paradise.core.model.DayTimeline;
import com.paradise.core.service.impl.DayTimelineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 每日时间轴表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "每日时间轴相关接口")
@RequestMapping("/dayTimeline")
public class DayTimelineController {
    private final DayTimelineService dayTimelineService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/page")
    public Result<CommonPage<DayTimeline>> pageQuery(DayTimelineQuery query) {
        List<DayTimeline> list = this.dayTimelineService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<List<DayTimeline>> selectByPage(DayTimelineQuery query) {
        if (query.getDate() == null) {
            query.setDate(DateUtil.beginOfDay(new Date()));
        }
        List<DayTimeline> list = this.dayTimelineService.selectByDate(query);
        return Result.success(list);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated DayTimelineBody record) {
        int count = this.dayTimelineService.insertSelective(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Long id, @RequestBody @Validated DayTimelineBody record) {
        int count = this.dayTimelineService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<DayTimeline> selectByPrimaryKey(@PathVariable("id") Long id) {
        DayTimeline dayTimeline = this.dayTimelineService.selectByPrimaryKey(id);
        return Result.success(dayTimeline);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.dayTimelineService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}