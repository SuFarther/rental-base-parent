package com.company.web.menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.menu.pojo.Menu;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName MenuService
 * @company 公司
 * @Description 权限(菜单)管理服务层
 * @createTime 2022年03月01日 18:26:26
 */
public interface MenuService extends IService<Menu> {
    /**
     * 获取菜单列表树数据
     * @return Menu
     */
     List<Menu> getList();

    /**
     * 查询上级菜单
     * @return
     */
    List<Menu> getParentList();

    /**
     * 根据用户id查询用户列表
     */
    List<Menu> getMenuByUserId(Long userId);

    /**
     * 根据业主的id查询菜单
     */
    List<Menu> getMenuByUserIdForLiveUser(Long userId);

    /**
     * 根据角色id查询权限信息
     */
    List<Menu> getMenuByRoleId(Long roleId);
}
