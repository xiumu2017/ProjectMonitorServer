package com.paradise.core.controller.ums;

import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.UmsMenuNode;
import com.paradise.core.model.UmsMenu;
import com.paradise.core.service.UmsMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台菜单管理Controller
 *
 * @author Paradise
 * @date 2020/2/4
 */
@RestController
@Api(tags = "1.3 UMS-后台菜单管理")
@RequestMapping("/menu")
public class UmsMenuController {

    private final UmsMenuService menuService;

    public UmsMenuController(UmsMenuService menuService) {
        this.menuService = menuService;
    }

    @ApiOperation("添加后台菜单")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsMenu umsMenu) {
        int count = menuService.create(umsMenu);
        if (count > 0) {
            return Result.success(count);
        } else {
            return Result.failed();
        }
    }

    @ApiOperation("修改后台菜单")
    @PutMapping(value = "/{id}")
    public Result<Integer> update(@PathVariable Long id,
                                  @RequestBody UmsMenu umsMenu) {
        int count = menuService.update(id, umsMenu);
        if (count > 0) {
            return Result.success(count);
        } else {
            return Result.failed();
        }
    }

    @ApiOperation("根据ID获取菜单详情")
    @GetMapping(value = "/{id}")
    public Result<UmsMenu> getItem(@PathVariable Long id) {
        UmsMenu umsMenu = menuService.getItem(id);
        return Result.success(umsMenu);
    }

    @ApiOperation("根据ID删除后台菜单")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        int count = menuService.delete(id);
        if (count > 0) {
            return Result.success(count);
        } else {
            return Result.failed();
        }
    }

    @ApiOperation("分页查询后台菜单")
    @GetMapping(value = "/page")
    public Result<CommonPage<UmsMenu>> list(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsMenu> menuList = menuService.list(pageSize, pageNum);
        return Result.success(CommonPage.restPage(menuList));
    }

    @ApiOperation("树形结构返回所有菜单列表")
    @GetMapping(value = "/s")
    public Result<List<UmsMenuNode>> treeList() {
        List<UmsMenuNode> list = menuService.treeList();
        return Result.success(list);
    }

    @ApiOperation("查询全部后台菜单")
    @GetMapping(value = "/all")
    public Result<List<UmsMenu>> all() {
        List<UmsMenu> menuList = menuService.list(null, null);
        return Result.success(menuList);
    }
}
