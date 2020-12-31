package com.paradise.core.controller;

import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.model.PmDingTalkRobot;
import com.paradise.core.service.impl.PmDingTalkRobotService;
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
@Api(tags = "3.2 钉钉机器人管理")
@RequestMapping("/ding-talk-robot")
public class PmDingTalkRobotController {
    private final PmDingTalkRobotService pmDingTalkRobotService;

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/page")
    public Result<CommonPage<PmDingTalkRobot>> selectByPage(Integer pageNum, Integer pageSize) {
        List<PmDingTalkRobot> result = this.pmDingTalkRobotService.selectByPage(pageNum, pageSize);
        return Result.success(CommonPage.restPage(result));
    }

    @ApiOperation("添加")
    @PostMapping(value = "/create")
    public Result<Integer> insert(@RequestBody @Validated PmDingTalkRobot record) {
        int count = this.pmDingTalkRobotService.insert(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("修改")
    @PostMapping(value = "/update")
    public Result<Integer> updateByPrimaryKey(PmDingTalkRobot record) {
        int count = this.pmDingTalkRobotService.updateByPrimaryKey(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("详情")
    @GetMapping(value = "/detail/{id}")
    public Result<PmDingTalkRobot> selectByPrimaryKey(@PathVariable("id") Long id) {
        PmDingTalkRobot pmDingTalkRobot = this.pmDingTalkRobotService.selectByPrimaryKey(id);
        return Result.success(pmDingTalkRobot);
    }

    @ApiOperation("删除")
    @PostMapping(value = "/delete/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.pmDingTalkRobotService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}