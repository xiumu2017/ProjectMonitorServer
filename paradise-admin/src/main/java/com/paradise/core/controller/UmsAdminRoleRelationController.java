package com.paradise.core.controller;

import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.model.UmsAdminRoleRelation;
import com.paradise.core.service.UmsAdminRoleRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台用户和角色关系表控制器 
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags="com.paradise.core.model.UmsAdminRoleRelation")
@RequestMapping("/umsAdminRoleRelations")
public class UmsAdminRoleRelationController {
    private final UmsAdminRoleRelationService umsAdminRoleRelationService;

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/page")
    public Result<CommonPage<UmsAdminRoleRelation>> selectByPage(Integer pageNum, Integer pageSize) {
        List<UmsAdminRoleRelation> result = this.umsAdminRoleRelationService.selectByPage(pageNum,pageSize);
        return Result.success(CommonPage.restPage(result));
    }

    @ApiOperation("添加")
    @PostMapping(value = "/create")
    public Result<Integer> insert(@RequestBody @Validated UmsAdminRoleRelation record) {
        int count = this.umsAdminRoleRelationService.insert(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("修改")
    @PostMapping(value = "/update")
    public Result<Integer> updateByPrimaryKey(UmsAdminRoleRelation record) {
        int count = this.umsAdminRoleRelationService.updateByPrimaryKey(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("详情")
    @GetMapping(value = "/detail/{id}")
    public Result<UmsAdminRoleRelation> selectByPrimaryKey(@PathVariable("id") Long id) {
        UmsAdminRoleRelation umsAdminRoleRelation = this.umsAdminRoleRelationService.selectByPrimaryKey(id);
        return Result.success(umsAdminRoleRelation);
    }

    @ApiOperation("删除")
    @PostMapping(value = "/delete/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.umsAdminRoleRelationService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}