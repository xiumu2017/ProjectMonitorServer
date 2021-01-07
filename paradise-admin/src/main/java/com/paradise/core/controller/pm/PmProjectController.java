package com.paradise.core.controller.pm;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.PmProjectBody;
import com.paradise.core.dto.query.PmProjectQuery;
import com.paradise.core.model.PmProject;
import com.paradise.core.service.impl.PmProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目监控项目表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "项目监控项目相关接口")
@RequestMapping("/project")
public class PmProjectController {
    private final PmProjectService pmProjectService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<PmProject>> selectByPage(PmProjectQuery query) {
        List<PmProject> list = this.pmProjectService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated PmProjectBody record) {
        int count = this.pmProjectService.insert(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Long id, @RequestBody @Validated PmProjectBody record) {
        int count = this.pmProjectService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<PmProject> selectByPrimaryKey(@PathVariable("id") Long id) {
        PmProject pmProject = this.pmProjectService.selectByPrimaryKey(id);
        return Result.success(pmProject);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.pmProjectService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}