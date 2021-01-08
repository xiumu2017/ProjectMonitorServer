package com.paradise.core.controller.pm;

import cn.hutool.core.collection.CollectionUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.PmDbBody;
import com.paradise.core.dto.query.PmDbQuery;
import com.paradise.core.model.PmDb;
import com.paradise.core.service.impl.PmDbService;
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
@Api(tags = "2.3 项目监控数据库信息相关接口")
@RequestMapping("/db")
public class PmDbController {
    private final PmDbService pmDbService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<PmDb>> selectByPage(PmDbQuery query) {
        List<PmDb> list = this.pmDbService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated PmDbBody record) {
        int count = this.pmDbService.insert(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Long id, @RequestBody @Validated PmDbBody record) {
        int count = this.pmDbService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<PmDb> selectByPrimaryKey(@PathVariable("id") Long id) {
        PmDb pmDb = this.pmDbService.selectByPrimaryKey(id);
        return Result.success(pmDb);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.pmDbService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation("查询类别列表")
    @GetMapping("types")
    public Result<List<String>> types() {
        return Result.success(CollectionUtil.newArrayList("Oracle", "MySQL", "MongoDB", "H2", "Others"));
    }
}