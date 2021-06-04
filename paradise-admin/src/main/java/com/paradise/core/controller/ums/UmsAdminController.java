package com.paradise.core.controller.ums;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.kaptcha.Kaptcha;
import com.baomidou.kaptcha.exception.KaptchaException;
import com.paradise.core.common.api.CommonPage;
import com.paradise.core.common.api.Result;
import com.paradise.core.dto.UmsAdminLoginParam;
import com.paradise.core.dto.UmsAdminParam;
import com.paradise.core.model.UmsAdmin;
import com.paradise.core.model.UmsPermission;
import com.paradise.core.model.UmsRole;
import com.paradise.core.service.UmsAdminService;
import com.paradise.core.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 后台用户管理
 *
 * @author Paradise
 * @date 2018/4/26
 */
@Slf4j
@Api(tags = "1.1 UMS-后台用户管理")
@RestController
@RequestMapping("/admin")
public class UmsAdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    private final UmsAdminService adminService;
    private final UmsRoleService roleService;
    private final Kaptcha kaptcha;

    public UmsAdminController(UmsAdminService adminService, UmsRoleService roleService, Kaptcha kaptcha) {
        this.adminService = adminService;
        this.roleService = roleService;
        this.kaptcha = kaptcha;
    }

    @ApiIgnore
    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public Result<UmsAdmin> register(@RequestBody UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            Result.failed();
        }
        return Result.success(umsAdmin);
    }

    @ApiIgnore
    @ApiOperation(value = "用户修改密码")
    @PostMapping(value = "/changePass")
    public Result<Integer> changePass(@RequestBody Map<String, String> passParam) {
        Integer res = adminService.changePass(passParam);
        if (res != 1) {
            return Result.failed();
        }
        return Result.success(res);
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    public Result<Map<String, String>> login(@RequestBody UmsAdminLoginParam umsAdminLoginParam,
                                             @ApiIgnore HttpSession httpSession) {
        log.info("Login-Session_id:{}", httpSession.getId());
        try {
            if (!kaptcha.validate(umsAdminLoginParam.getCode())) {
                return Result.failed("验证码不正确");
            }
        } catch (KaptchaException e) {
            log.error("验证码校验失败：{}", e.getMessage());
            return Result.failed("验证码不正确");
        }
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return Result.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>(2);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return Result.success(tokenMap);
    }

    @ApiOperation(value = "刷新token")
    @GetMapping(value = "/refreshToken")
    public Result<Map<String, String>> refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return Result.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return Result.success(tokenMap);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "/info")
    public Result<Map<String, Object>> getAdminInfo(Principal principal) {
        if (principal == null) {
            return Result.unauthorized(null);
        }
        String username = principal.getName();
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        List<UmsRole> roleList = adminService.getRoleList(umsAdmin.getId());
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
            data.put("roles", roles);
        }
        return Result.success(data);
    }

    @ApiOperation(value = "登出功能")
    @PostMapping(value = "/logout")
    public Result<Object> logout() {
        return Result.success(null);
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @GetMapping(value = "/list")
    public Result<CommonPage<UmsAdmin>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                             @RequestParam(value = "enable", required = false) Integer enable,
                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsAdmin> adminList = adminService.list(keyword, pageSize, pageNum, enable);
        return Result.success(CommonPage.restPage(adminList));
    }

    @ApiOperation("获取指定用户信息")
    @GetMapping(value = "/{id}")
    public Result<UmsAdmin> getItem(@PathVariable Long id) {
        UmsAdmin admin = adminService.getItem(id);
        return Result.success(admin);
    }

    @ApiOperation("修改指定用户信息")
    @PutMapping(value = "/{id}")
    public Result<Integer> update(@PathVariable Long id, @RequestBody UmsAdmin admin) {
        int count = adminService.update(id, admin);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("删除指定用户信息")
    @DeleteMapping(value = "/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        int count = adminService.delete(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("给用户分配角色")
    @PostMapping(value = "/role/update")
    public Result<Integer> updateRole(@RequestParam("adminId") Long adminId,
                                      @RequestParam("roleIds") List<Long> roleIds) {
        int count = adminService.updateRole(adminId, roleIds);
        if (count >= 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("获取指定用户的角色")
    @GetMapping(value = "/role/{adminId}")
    public Result<List<UmsRole>> getRoleList(@PathVariable Long adminId) {
        List<UmsRole> roleList = adminService.getRoleList(adminId);
        return Result.success(roleList);
    }

    @ApiOperation("给用户分配+-权限")
    @PostMapping(value = "/permission/update")
    public Result<Integer> updatePermission(@RequestParam Long adminId,
                                            @RequestParam("permissionIds") List<Long> permissionIds) {
        int count = adminService.updatePermission(adminId, permissionIds);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @GetMapping(value = "/permission/{adminId}")
    public Result<List<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return Result.success(permissionList);
    }
}
