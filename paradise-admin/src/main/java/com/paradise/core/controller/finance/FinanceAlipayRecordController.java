package com.paradise.core.controller.finance;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.FinanceAlipayRecordBody;
import com.paradise.core.dto.query.FinanceAlipayRecordQuery;
import com.paradise.core.model.FinanceAlipayRecord;
import com.paradise.core.service.impl.FinanceAlipayRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 支付宝账单表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "支付宝账单相关接口")
@RequestMapping("/finance/alipay/record")
public class FinanceAlipayRecordController {
    private final FinanceAlipayRecordService financeAlipayRecordService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<FinanceAlipayRecord>> selectByPage(FinanceAlipayRecordQuery query) {
        List<FinanceAlipayRecord> list = this.financeAlipayRecordService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated FinanceAlipayRecordBody record) {
        int count = this.financeAlipayRecordService.insertSelective(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Integer id, @RequestBody @Validated FinanceAlipayRecordBody record) {
        int count = this.financeAlipayRecordService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<FinanceAlipayRecord> selectByPrimaryKey(@PathVariable("id") Integer id) {
        FinanceAlipayRecord financeAlipayRecord = this.financeAlipayRecordService.selectByPrimaryKey(id);
        return Result.success(financeAlipayRecord);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int count = this.financeAlipayRecordService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}