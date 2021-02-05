package com.paradise.core.controller.finance;

import cn.hutool.core.collection.CollectionUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.FinanceShoppingListBody;
import com.paradise.core.dto.query.FinanceShoppingListQuery;
import com.paradise.core.model.FinanceShoppingList;
import com.paradise.core.service.impl.FinanceShoppingListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 购物清单表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "购物清单相关接口")
@RequestMapping("/finance/shopping-list")
public class FinanceShoppingListController {
    private final FinanceShoppingListService financeShoppingListService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<FinanceShoppingList>> selectByPage(FinanceShoppingListQuery query) {
        List<FinanceShoppingList> list = this.financeShoppingListService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated FinanceShoppingListBody record) {
        int count = this.financeShoppingListService.insertSelective(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Integer id, @RequestBody @Validated FinanceShoppingListBody record) {
        int count = this.financeShoppingListService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<FinanceShoppingList> selectByPrimaryKey(@PathVariable("id") Integer id) {
        FinanceShoppingList financeShoppingList = this.financeShoppingListService.selectByPrimaryKey(id);
        return Result.success(financeShoppingList);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int count = this.financeShoppingListService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation("支付方式列表")
    @GetMapping(value = "/payTypes")
    public Result<List<String>> payTypes() {
        return Result.success(CollectionUtil.newArrayList("微信支付", "支付宝支付", "京东在线支付", "京东白条支付", "现金", "银行卡", "其它"));
    }

    @ApiOperationSupport(order = 7)
    @ApiOperation("来源平台列表")
    @GetMapping(value = "/sources")
    public Result<List<String>> sources() {
        return Result.success(CollectionUtil.newArrayList("京东", "淘宝", "拼多多", "线下", "其它"));
    }
}