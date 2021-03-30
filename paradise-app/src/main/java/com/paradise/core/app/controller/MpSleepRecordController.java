package com.paradise.core.app.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.app.service.MpMemberService;
import com.paradise.core.app.service.MpSleepRecordService;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.query.DaySleepRecordQuery;
import com.paradise.core.model.DaySleepRecord;
import com.paradise.core.model.UmsMember;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(tags = "睡眠记录接口")
@RestController
@RequestMapping("/sleep-record")
public class MpSleepRecordController {

    private final MpSleepRecordService sleepRecordService;
    private final MpMemberService memberService;

    public MpSleepRecordController(MpSleepRecordService sleepRecordService, MpMemberService memberService) {
        this.sleepRecordService = sleepRecordService;
        this.memberService = memberService;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<DaySleepRecord>> selectByPage(DaySleepRecordQuery query) {
        UmsMember member = memberService.getCurrentMember();
        if (member == null) {
            return Result.success(CommonPage.restPage(new ArrayList<>()));
        }
        if (!member.getId().equals(1L)) {
            return Result.success(CommonPage.restPage(new ArrayList<>()));
        }
        List<DaySleepRecord> list = this.sleepRecordService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperation("")
    @PostMapping("/create")
    public Result<Integer> create(int type) {

        return Result.failed();
    }

}
