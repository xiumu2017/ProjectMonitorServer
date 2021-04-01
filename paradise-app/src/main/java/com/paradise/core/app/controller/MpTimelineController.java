package com.paradise.core.app.controller;

import com.paradise.core.app.service.MpTimelineService;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.DayTimelineBody;
import com.paradise.core.dto.query.DayTimelineQuery;
import com.paradise.core.model.DayTimeline;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@Api(tags = "时间轴接口")
@RequestMapping("/timeline")
public class MpTimelineController {
    private final MpTimelineService timelineService;

    @ApiOperation("分页查询")
    @GetMapping("/s")
    public Result<CommonPage<DayTimeline>> query(DayTimelineQuery query) {
        final List<DayTimeline> dayTimelines = timelineService.queryByPage(query);
        return Result.success(CommonPage.restPage(dayTimelines));
    }

    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated DayTimelineBody record) {
        int count = this.timelineService.insertSelective(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}
