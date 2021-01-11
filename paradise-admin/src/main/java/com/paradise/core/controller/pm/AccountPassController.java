package com.paradise.core.controller.pm;

import cn.hutool.core.collection.CollectionUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.AccountPassBody;
import com.paradise.core.dto.query.AccountPassQuery;
import com.paradise.core.model.AccountPass;
import com.paradise.core.service.impl.AccountPassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 网络账号资产表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "网络账号资产相关接口")
@RequestMapping("/accountPass")
public class AccountPassController {
    private final AccountPassService accountPassService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<AccountPass>> selectByPage(AccountPassQuery query) {
        List<AccountPass> list = this.accountPassService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated AccountPassBody record) {
        int count = this.accountPassService.insertSelective(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Long id, @RequestBody @Validated AccountPassBody record) {
        int count = this.accountPassService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<AccountPass> selectByPrimaryKey(@PathVariable("id") Long id) {
        AccountPass accountPass = this.accountPassService.selectByPrimaryKey(id);
        return Result.success(accountPass);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.accountPassService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation("获取类别列表")
    @GetMapping(value = "/types")
    public Result<List<String>> types() {
        return Result.success(CollectionUtil.newArrayList("编程", "社交", "工具", "其它"));
    }
}