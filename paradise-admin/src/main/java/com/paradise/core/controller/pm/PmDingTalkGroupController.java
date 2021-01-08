package com.paradise.core.controller.pm;

import cn.hutool.core.collection.CollectionUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.PmDingTalkGroupBody;
import com.paradise.core.dto.query.PmDingTalkGroupQuery;
import com.paradise.core.model.PmDingTalkGroup;
import com.paradise.core.service.impl.PmDingTalkGroupService;
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
@RequestMapping("/dingTalkGroup")
public class PmDingTalkGroupController {
    private final PmDingTalkGroupService pmDingTalkGroupService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<PmDingTalkGroup>> selectByPage(PmDingTalkGroupQuery query) {
        List<PmDingTalkGroup> list = this.pmDingTalkGroupService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated PmDingTalkGroupBody record) {
        int count = this.pmDingTalkGroupService.insertSelective(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Long id, @RequestBody @Validated PmDingTalkGroupBody record) {
        int count = this.pmDingTalkGroupService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<PmDingTalkGroup> selectByPrimaryKey(@PathVariable("id") Long id) {
        PmDingTalkGroup pmDingTalkGroup = this.pmDingTalkGroupService.selectByPrimaryKey(id);
        return Result.success(pmDingTalkGroup);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.pmDingTalkGroupService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation("群组类别")
    @GetMapping(value = "types")
    public Result<List<String>> types() {
        return Result.success(CollectionUtil.newArrayList("个人群组", "公司群组", "项目群组", "公共群组", "其它"));
    }
}