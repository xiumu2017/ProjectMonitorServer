package com.paradise.core.controller.finance;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.BillBody;
import com.paradise.core.dto.query.BillQuery;
import com.paradise.core.model.Bill;
import com.paradise.core.service.impl.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 账单表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "账单相关接口")
@RequestMapping("/bill")
public class BillController {
    private final BillService billService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<Bill>> selectByPage(BillQuery query) {
        List<Bill> list = this.billService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated BillBody record) {
        int count = this.billService.insertSelective(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Long id, @RequestBody @Validated BillBody record) {
        int count = this.billService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<Bill> selectByPrimaryKey(@PathVariable("id") Long id) {
        Bill bill = this.billService.selectByPrimaryKey(id);
        return Result.success(bill);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        int count = this.billService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}