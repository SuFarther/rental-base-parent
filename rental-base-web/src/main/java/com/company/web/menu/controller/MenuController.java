package com.company.web.menu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.utils.ResultUtils;
import com.company.utils.ResultVo;
import com.company.web.menu.pojo.Menu;
import com.company.web.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName MenuController
 * @company 公司
 * @Description TODO
 * @createTime 2022年03月01日 19:23:23
 */

@RestController
@RequestMapping("/api/menu")
public class MenuController {


    @Autowired
    private MenuService menuService;

    /**
     * 树数据列表
     */
    @GetMapping("/list")
    public ResultVo list(){
        List<Menu> list = menuService.getList();
        return ResultUtils.success("查询成功",list);
    }



    /**
     * 新增菜单
     */
    @PostMapping
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public ResultVo addMenu(@RequestBody  Menu menu){
        boolean save = menuService.save(menu);
        if(save){
            return  ResultUtils.success("新增成功!");
        }
        return ResultUtils.error("新增失败!");
    }

    /**
     * 编辑菜单
     */
    @PutMapping
    @PreAuthorize("hasAuthority('sys:menu:edit')")
    public ResultVo editMenu(@RequestBody Menu menu){
        boolean save = menuService.updateById(menu);
        if(save){
            return ResultUtils.success("编辑成功!");
        }
        return ResultUtils.error("编辑失败!");
    }

    /**
     * 删除菜单
     */
    @DeleteMapping("/{menuId}")
    @PreAuthorize("hasAuthority('sys:menu:delete')")
    public ResultVo deleteMenu(@PathVariable("menuId") Long menuId){
        // 如果有下级,不能删除
        QueryWrapper<Menu> query = new QueryWrapper<>();
        query.lambda().eq(Menu::getParentId,menuId);
        List<Menu> list = menuService.list(query);
        if(list.size() > 0){
            return  ResultUtils.error("该菜单存在下级,不能删除!");
        }
        boolean save = menuService.removeById(menuId);
        if(save){
            return ResultUtils.success("删除菜单成功！");
        }
        return ResultUtils.error("删除菜单失败!");
    }


    /**
     * 获取上级菜单
     * @return
     */
    @GetMapping("/parent")
    public ResultVo getParent(){
        List<Menu> parentList = menuService.getParentList();
        return ResultUtils.success("查询成功",parentList);
    }
}
