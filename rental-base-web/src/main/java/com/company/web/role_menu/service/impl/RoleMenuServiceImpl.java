package com.company.web.role_menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.role_menu.dao.RoleMenuDao;
import com.company.web.role_menu.pojo.RoleMenu;
import com.company.web.role_menu.service.RoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName RoleMenuServiceImpl
 * @company 公司
 * @Description 角色权限服务层实现类
 * @createTime 2022年03月12日 11:17:17
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuDao, RoleMenu>
        implements RoleMenuService {
    @Override
    public void saveRoleMenu(Long roleId, List<Long> menuIds) {
        this.baseMapper.saveRoleMenu(roleId,menuIds);
    }
}
