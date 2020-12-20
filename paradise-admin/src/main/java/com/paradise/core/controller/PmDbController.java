package com.paradise.core.controller;

import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.model.PmDb;
import com.paradise.core.service.PmDbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目监控数据库信息表控制器 
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags="com.paradise.core.model.PmDb")
@RequestMapping("/pmDbs")
public class PmDbController {
    private final PmDbService pmDbService;

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/page")
    public Result<CommonPage<PmDb>> selectByPage(Integer pageNum, Integer pageSize) {
        List<PmDb> result = this.pmDbService.selectByPage(pageNum,pageSize);
        return Result.success(CommonPage.restPage(result));
    }

    @ApiOperation("添加")
    @PostMapping(value = "/create")
    public Result<Integer> insert(@RequestBody @Validated PmDb record) {
        int count = this.pmDbService.insert(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("修改")
    @PostMapping(value = "/update")
    public Result<Integer> updateByPrimaryKey(PmDb record) {
        int count = this.pmDbService.updateByPrimaryKey(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("详情")
    @GetMapping(value = "/detail/{id}")
    public Result<PmDb> selectByPrimaryKey(@PathVariable("id") Long id) {
        PmDb pmDb = this.pmDbService.selectByPrimaryKey(id);
        return Result.success(pmDb);
    }

    @ApiOperation("删除")
    @PostMapping(value = "/delete/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.pmDbService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}