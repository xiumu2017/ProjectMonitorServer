package com.paradise.core.app.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.app.service.MpMealRecordService;
import com.paradise.core.app.service.MpMemberService;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.DayMealRecordBody;
import com.paradise.core.dto.query.DayMealRecordQuery;
import com.paradise.core.model.DayMealRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.hutool.core.collection.CollUtil.newArrayList;

@Slf4j
@Api(tags = "饮食记录接口")
@RestController
@RequestMapping("/meal-record")
@AllArgsConstructor
public class MpMealRecordController {

    private final MpMealRecordService mealRecordService;
    private final MpMemberService memberService;


    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<DayMealRecord>> selectByPage(DayMealRecordQuery query) {
        List<DayMealRecord> list = this.mealRecordService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("新增记录")
    @PostMapping("/create")
    public Result<Integer> create(@RequestBody @Validated DayMealRecordBody mealRecordBody) {
        int res = this.mealRecordService.create(mealRecordBody);
        if (res == 1) {
            return Result.success(res);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("类别列表")
    @GetMapping("/types")
    public Result<List<String>> types() {
        return Result.success(newArrayList("零食", "早饭", "午饭", "晚饭", "夜宵"));
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("支付方式类别列表")
    @GetMapping("/payTypes")
    public Result<List<String>> patTypes() {
        return Result.success(newArrayList("微信支付", "支付宝支付", "现金", "银行卡", "其它"));
    }


}
