package com.paradise.core.controller.ums;

import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.model.UmsMenu;
import com.paradise.core.model.UmsPermission;
import com.paradise.core.model.UmsResource;
import com.paradise.core.model.UmsRole;
import com.paradise.core.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台用户角色管理
 *
 * @author Paradise
 * @date 2018/9/30
 */
@Api(tags = "1.5 UMS-后台用户角色管理")
@RestController
@RequestMapping("/role")
public class UmsRoleController {
    private final UmsRoleService roleService;

    public UmsRoleController(UmsRoleService roleService) {
        this.roleService = roleService;
    }

    @ApiOperation("添加角色")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsRole role) {
        int count = roleService.create(role);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("修改角色")
    @PutMapping(value = "/{id}")
    public Result<Integer> update(@PathVariable Long id, @RequestBody UmsRole role) {
        int count = roleService.update(id, role);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("批量删除角色")
    @DeleteMapping
    public Result<Integer> delete(@RequestParam("ids") List<Long> ids) {
        int count = roleService.delete(ids);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("获取相应角色权限")
    @GetMapping(value = "/permission/{roleId}")
    public Result<List<UmsPermission>> getPermissionList(@PathVariable Long roleId) {
        List<UmsPermission> permissionList = roleService.getPermissionList(roleId);
        return Result.success(permissionList);
    }

    @ApiOperation("修改角色权限")
    @PutMapping(value = "/permission/{roleId}")
    public Result<Integer> updatePermission(@PathVariable Long roleId,
                                            @RequestParam("permissionIds") List<Long> permissionIds) {
        int count = roleService.updatePermission(roleId, permissionIds);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("获取所有角色")
    @GetMapping(value = "/all")
    public Result<List<UmsRole>> listAll() {
        List<UmsRole> roleList = roleService.list();
        return Result.success(roleList);
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @GetMapping(value = "/s")
    public Result<CommonPage<UmsRole>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsRole> roleList = roleService.list(keyword, pageSize, pageNum);
        return Result.success(CommonPage.restPage(roleList));
    }

    @ApiOperation("修改角色状态")
    @PutMapping(value = "/status/{id}")
    public Result<Integer> updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsRole umsRole = new UmsRole();
        umsRole.setEnable(status);
        int count = roleService.update(id, umsRole);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("获取角色相关菜单")
    @GetMapping(value = "/menu/{roleId}")
    public Result<List<UmsMenu>> listMenu(@PathVariable Long roleId) {
        List<UmsMenu> roleList = roleService.listMenu(roleId);
        return Result.success(roleList);
    }

    @ApiOperation("获取角色相关资源")
    @GetMapping(value = "/resource/{roleId}")
    public Result<List<UmsResource>> listResource(@PathVariable Long roleId) {
        List<UmsResource> roleList = roleService.listResource(roleId);
        return Result.success(roleList);
    }

    @ApiOperation("给角色分配菜单")
    @PostMapping(value = "/menu/{roleId}")
    public Result<Integer> allocMenu(@PathVariable Long roleId, @RequestParam List<Long> menuIds) {
        int count = roleService.allocMenu(roleId, menuIds);
        return Result.success(count);
    }

    @ApiOperation("给角色分配资源")
    @PostMapping(value = "/resource/{roleId}")
    public Result<Integer> allocResource(@PathVariable Long roleId, @RequestParam List<Long> resourceIds) {
        int count = roleService.allocResource(roleId, resourceIds);
        return Result.success(count);
    }

}
