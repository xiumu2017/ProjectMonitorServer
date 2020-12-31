package com.paradise.core.controller;

import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.model.UmsAdminLoginLog;
import com.paradise.core.service.impl.UmsAdminLoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台用户登录日志表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "1.2 UMS-登录日志管理")
@RequestMapping("/admin/login-log")
public class UmsAdminLoginLogController {
    private final UmsAdminLoginLogService umsAdminLoginLogService;

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/page")
    public Result<CommonPage<UmsAdminLoginLog>> selectByPage(Integer pageNum, Integer pageSize) {
        List<UmsAdminLoginLog> result = this.umsAdminLoginLogService.selectByPage(pageNum, pageSize);
        return Result.success(CommonPage.restPage(result));
    }


    @ApiOperation("详情")
    @GetMapping(value = "/detail/{id}")
    public Result<UmsAdminLoginLog> selectByPrimaryKey(@PathVariable("id") Long id) {
        UmsAdminLoginLog umsAdminLoginLog = this.umsAdminLoginLogService.selectByPrimaryKey(id);
        return Result.success(umsAdminLoginLog);
    }

    @ApiOperation("删除")
    @PostMapping(value = "/delete/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.umsAdminLoginLogService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}