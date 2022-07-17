package com.company.web.role_menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.role_menu.pojo.RoleMenu;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName RoleMenuService
 * @company 公司
 * @Description 角色菜单的服务层菜单类
 * @createTime 2022年03月12日 11:14:14
 */
public interface RoleMenuService extends IService<RoleMenu> {
    /**
     * 保存权限 saveRoleMenu
     * @param roleId
     * @param menuIds
     */
    void saveRoleMenu(Long roleId, List<Long> menuIds);
}
