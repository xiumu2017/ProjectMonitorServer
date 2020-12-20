package com.paradise.core.controller;

import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.model.UmsAdminPermissionRelation;
import com.paradise.core.service.UmsAdminPermissionRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台用户额外权限关系表控制器 
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags="com.paradise.core.model.UmsAdminPermissionRelation")
@RequestMapping("/umsAdminPermissionRelations")
public class UmsAdminPermissionRelationController {
    private final UmsAdminPermissionRelationService umsAdminPermissionRelationService;

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/page")
    public Result<CommonPage<UmsAdminPermissionRelation>> selectByPage(Integer pageNum, Integer pageSize) {
        List<UmsAdminPermissionRelation> result = this.umsAdminPermissionRelationService.selectByPage(pageNum,pageSize);
        return Result.success(CommonPage.restPage(result));
    }

    @ApiOperation("添加")
    @PostMapping(value = "/create")
    public Result<Integer> insert(@RequestBody @Validated UmsAdminPermissionRelation record) {
        int count = this.umsAdminPermissionRelationService.insert(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("修改")
    @PostMapping(value = "/update")
    public Result<Integer> updateByPrimaryKey(UmsAdminPermissionRelation record) {
        int count = this.umsAdminPermissionRelationService.updateByPrimaryKey(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("详情")
    @GetMapping(value = "/detail/{id}")
    public Result<UmsAdminPermissionRelation> selectByPrimaryKey(@PathVariable("id") Long id) {
        UmsAdminPermissionRelation umsAdminPermissionRelation = this.umsAdminPermissionRelationService.selectByPrimaryKey(id);
        return Result.success(umsAdminPermissionRelation);
    }

    @ApiOperation("删除")
    @PostMapping(value = "/delete/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.umsAdminPermissionRelationService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}