package com.company.web.role.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.utils.ResultUtils;
import com.company.utils.ResultVo;
import com.company.web.role.pojo.*;
import com.company.web.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName RoleController
 * @company 公司
 * @Description 角色控制器
 * @createTime 2022年02月27日 11:32:32
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 获取角色列表
     */
    @GetMapping("/list")
    public ResultVo list(RoleParm parm){
        IPage<Role> list = roleService.list(parm);
        return ResultUtils.success("查询成功",list);
    }

    /**
     * 新增角色
     */
    @PostMapping
    @PreAuthorize("hasAuthority('sys:role:add')")
    public ResultVo addRole(@RequestBody Role role){
        boolean save = roleService.save(role);
        if(save){
            return ResultUtils.success("新增角色成功!");
        }
        return ResultUtils.error("新增角色失败!");
    }

    /**
     * 编辑角色
     */
    @PutMapping
    @PreAuthorize("hasAuthority('sys:role:edit')")
    public ResultVo editRole(@RequestBody Role role){
        boolean save = roleService.updateById(role);
        if(save){
            return ResultUtils.success("编辑角色成功!");
        }
        return ResultUtils.error("编辑角色失败!");
    }

    /**
     * 删除角色
     */
    @DeleteMapping("/{roleId}")
    @PreAuthorize("hasAuthority('sys:role:delete')")
    public ResultVo deleteRole(@PathVariable("roleId") Long roleId){
        boolean b = roleService.removeById(roleId);
        if(b){
            return ResultUtils.success("删除角色成功!");
        }
        return ResultUtils.error("删除角色失败!");
    }


    /**
     * 查询分配权限树回显
     */
    @GetMapping("/getAssignTree")
    @PreAuthorize("hasAuthority('sys:role:assignMenu')")
    public ResultVo getAssignTree(RoleAssignParm parm){
        RolePermissionVo assignTree = roleService.getAssignTree(parm);
        return ResultUtils.success("获取成功!",assignTree);
    }


    /**
     * 分配权限保存
     * @param parm
     * @return
     */
    @PostMapping("/saveAssign")
    public ResultVo saveAssign(@RequestBody RolePermissionParm parm){
        roleService.saveAssign(parm);
        return ResultUtils.success("分配权限成功");
    }

    /**
     * 获取角色列表,不需要参数
     */
    @GetMapping("/getList")
    public ResultVo getList(){
        List<Role> list = roleService.list();
        return ResultUtils.success("成功",list);
    }

}
