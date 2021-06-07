package com.paradise.core.controller.finance;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.BillTypeBody;
import com.paradise.core.dto.detail.BillTypeDto;
import com.paradise.core.dto.query.BillTypeQuery;
import com.paradise.core.model.BillType;
import com.paradise.core.service.impl.BillTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 账单分类表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "账单分类相关接口")
@RequestMapping("/billType")
public class BillTypeController {
    private final BillTypeService billTypeService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<BillTypeDto>> selectByPage(BillTypeQuery query) {
        List<BillTypeDto> list = this.billTypeService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated BillTypeBody record) {
        int count = this.billTypeService.insertSelective(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Long id, @RequestBody @Validated BillTypeBody record) {
        int count = this.billTypeService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<BillType> selectByPrimaryKey(@PathVariable("id") Long id) {
        BillType billType = this.billTypeService.selectByPrimaryKey(id);
        return Result.success(billType);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.billTypeService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation("查询全部分类列表")
    @GetMapping(value = "/list")
    public Result<List<BillTypeDto>> queryAll() {
        List<BillTypeDto> billTypeList = this.billTypeService.queryAll();
        return Result.success(billTypeList);
    }
}