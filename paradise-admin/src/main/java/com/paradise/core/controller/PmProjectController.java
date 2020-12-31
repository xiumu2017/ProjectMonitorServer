package com.paradise.core.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.model.PmProject;
import com.paradise.core.service.impl.PmProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目监控项目-控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "2.1 项目管理接口")
@RequestMapping("/pm-project")
public class PmProjectController {
    private final PmProjectService pmProjectService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/page")
    public Result<CommonPage<PmProject>> selectByPage(Integer pageNum, Integer pageSize) {
        List<PmProject> result = this.pmProjectService.selectByPage(pageNum, pageSize);
        return Result.success(CommonPage.restPage(result));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping(value = "/create")
    public Result<Integer> insert(@RequestBody @Validated PmProject record) {
        int count = this.pmProjectService.insert(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PostMapping(value = "/update")
    public Result<Integer> updateByPrimaryKey(PmProject record) {
        int count = this.pmProjectService.updateByPrimaryKey(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/detail/{id}")
    public Result<PmProject> selectByPrimaryKey(@PathVariable("id") Long id) {
        PmProject pmProject = this.pmProjectService.selectByPrimaryKey(id);
        return Result.success(pmProject);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @PostMapping(value = "/delete/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.pmProjectService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}