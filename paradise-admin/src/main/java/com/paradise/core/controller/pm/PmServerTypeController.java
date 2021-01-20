package com.paradise.core.controller.pm;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.body.PmServerTypeBody;
import com.paradise.core.dto.query.PmServerTypeQuery;
import com.paradise.core.model.PmServerType;
import com.paradise.core.service.impl.PmServerTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务器类别表控制器
 *
 * @author Paradise
 */
@RestController
@AllArgsConstructor
@Api(tags = "2.3 服务器类别相关接口")
@RequestMapping("/serverType")
public class PmServerTypeController {
    private final PmServerTypeService pmServerTypeService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/s")
    public Result<CommonPage<PmServerType>> selectByPage(PmServerTypeQuery query) {
        List<PmServerType> list = this.pmServerTypeService.selectByPage(query);
        return Result.success(CommonPage.restPage(list));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("添加")
    @PostMapping
    public Result<Integer> insert(@RequestBody @Validated PmServerTypeBody record) {
        int count = this.pmServerTypeService.insertSelective(record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("修改")
    @PutMapping(value = "/{id}")
    public Result<Integer> updateByPrimaryKey(@PathVariable("id") Integer id, @RequestBody @Validated PmServerTypeBody record) {
        int count = this.pmServerTypeService.updateByPrimaryKey(id, record);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    public Result<PmServerType> selectByPrimaryKey(@PathVariable("id") Integer id) {
        PmServerType pmServerType = this.pmServerTypeService.selectByPrimaryKey(id);
        return Result.success(pmServerType);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int count = this.pmServerTypeService.deleteByPrimaryKey(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}