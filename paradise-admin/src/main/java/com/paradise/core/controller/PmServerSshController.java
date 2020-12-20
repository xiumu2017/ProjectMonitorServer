package com.paradise.core.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.model.PmServerSsh;
import com.paradise.core.service.PmServerSshService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目监控服务器信息表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "2.2 服务器管理")
@RequestMapping("/pm-server")
public class PmServerSshController {
    private final PmServerSshService pmServerSshService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/page")
    public Result<CommonPage<PmServerSsh>> selectByPage(Integer pageNum, Integer pageSize) {
        List<PmServerSsh> result = this.pmServerSshService.selectByPage(pageNum, pageSize);
        return Result.success(CommonPage.restPage(result));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping(value = "/create")
    public Result<Integer> insert(@RequestBody @Validated PmServerSsh record) {
        int count = this.pmServerSshService.insert(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PostMapping(value = "/update")
    public Result<Integer> updateByPrimaryKey(PmServerSsh record) {
        int count = this.pmServerSshService.updateByPrimaryKey(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/detail/{id}")
    public Result<PmServerSsh> selectByPrimaryKey(@PathVariable("id") Long id) {
        PmServerSsh pmServerSsh = this.pmServerSshService.selectByPrimaryKey(id);
        return Result.success(pmServerSsh);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @PostMapping(value = "/delete/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.pmServerSshService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    /**
     * 服务器连接测试
     */
    @ApiOperationSupport(order = 6)
    @ApiOperation("连接测试")
    @RequestMapping("/test-connect/{id}")
    public Result<String> serverConnectTest(@PathVariable("id") Long id) {
        return pmServerSshService.serverConnectTest(id);
    }
}