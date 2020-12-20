package com.paradise.core.controller;

import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.model.PmDingTalkGroup;
import com.paradise.core.service.PmDingTalkGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 钉钉群组管理控制器 
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags="com.paradise.core.model.PmDingTalkGroup")
@RequestMapping("/pmDingTalkGroups")
public class PmDingTalkGroupController {
    private final PmDingTalkGroupService pmDingTalkGroupService;

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/page")
    public Result<CommonPage<PmDingTalkGroup>> selectByPage(Integer pageNum, Integer pageSize) {
        List<PmDingTalkGroup> result = this.pmDingTalkGroupService.selectByPage(pageNum,pageSize);
        return Result.success(CommonPage.restPage(result));
    }

    @ApiOperation("添加")
    @PostMapping(value = "/create")
    public Result<Integer> insert(@RequestBody @Validated PmDingTalkGroup record) {
        int count = this.pmDingTalkGroupService.insert(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("修改")
    @PostMapping(value = "/update")
    public Result<Integer> updateByPrimaryKey(PmDingTalkGroup record) {
        int count = this.pmDingTalkGroupService.updateByPrimaryKey(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("详情")
    @GetMapping(value = "/detail/{id}")
    public Result<PmDingTalkGroup> selectByPrimaryKey(@PathVariable("id") Long id) {
        PmDingTalkGroup pmDingTalkGroup = this.pmDingTalkGroupService.selectByPrimaryKey(id);
        return Result.success(pmDingTalkGroup);
    }

    @ApiOperation("删除")
    @PostMapping(value = "/delete/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.pmDingTalkGroupService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}