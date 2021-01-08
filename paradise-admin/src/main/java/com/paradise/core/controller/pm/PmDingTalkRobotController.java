package com.paradise.core.controller.pm;

import cn.hutool.core.collection.CollectionUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.PmDingTalkRobotBody;
import com.paradise.core.dto.query.PmDingTalkRobotQuery;
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
@Api(tags = "钉钉群组管理相关接口")
@RequestMapping("/dingTalkRobot")
public class PmDingTalkRobotController {
    private final PmDingTalkRobotService pmDingTalkRobotService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<PmDingTalkRobot>> selectByPage(PmDingTalkRobotQuery query) {
        List<PmDingTalkRobot> list = this.pmDingTalkRobotService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated PmDingTalkRobotBody record) {
        int count = this.pmDingTalkRobotService.insertSelective(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Long id, @RequestBody @Validated PmDingTalkRobotBody record) {
        int count = this.pmDingTalkRobotService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<PmDingTalkRobot> selectByPrimaryKey(@PathVariable("id") Long id) {
        PmDingTalkRobot pmDingTalkRobot = this.pmDingTalkRobotService.selectByPrimaryKey(id);
        return Result.success(pmDingTalkRobot);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.pmDingTalkRobotService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation("详情")
    @GetMapping(value = "types")
    public Result<List<String>> types() {
        return Result.success(CollectionUtil.newArrayList("GitHub", "GitLab", "JIRA", "Travis",
                "心知天气",
                "自定义机器人-运维告警",
                "自定义机器人-信息通知",
                "自定义机器人-消息订阅",
                "自定义机器人-其它"));
    }
}