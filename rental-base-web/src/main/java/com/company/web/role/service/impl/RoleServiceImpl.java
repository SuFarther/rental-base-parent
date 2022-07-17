package com.company.web.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.menu.pojo.MakeMenuTree;
import com.company.web.menu.pojo.Menu;
import com.company.web.menu.service.MenuService;
import com.company.web.role.dao.RoleDao;
import com.company.web.role.pojo.*;
import com.company.web.role.service.RoleService;
import com.company.web.role_menu.pojo.RoleMenu;
import com.company.web.role_menu.service.RoleMenuService;
import com.company.web.user.pojo.User;
import com.company.web.user.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName RoleServiceImpl
 * @company 公司
 * @Description 角色管理服务层
 * @createTime 2022年02月27日 11:30:30
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public IPage<Role> list(RoleParm parm) {
        //构造查询条件
        QueryWrapper<Role> query = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(parm.getRoleName())){
            query.lambda().like(Role::getRoleName,parm.getRoleName());
        }
        //构造分页对象
        IPage<Role> page = new Page<>();
        page.setSize(parm.getPageSize());
        page.setCurrent(parm.getCurrentPage());
        return this.baseMapper.selectPage(page,query);
    }

    @Override
    public RolePermissionVo getAssignTree(RoleAssignParm parm) {
        // 根据用户id查询当前用户信息
        User user = userService.getById(parm.getUserId());
        // 查询当前用户的所有权限信息,如果是超级管理员,全部权限
        List<Menu> menuList = null;
        // 如果是超级管理员
        if(user.getIsAdmin().equals("1")){
            menuList = menuService.list();
        }else { //不是超级管理员,根据用户id查询权限信息
            menuList = menuService.getMenuByUserId(parm.getUserId());
        }
        // 组装树的格式
        List<Menu> menus = MakeMenuTree.makeTree(menuList, 0L);

        //  根据角色id查询角色原来的权限信息
        List<Long> ids = new ArrayList<>();
        //根据角色id查询权限
        List<Menu> listByRoleId = menuService.getMenuByRoleId(parm.getRoleId());
        Optional.ofNullable(menuList).orElse(new ArrayList<>
                ()).stream().filter(item -> item !=null).forEach(item ->{
            Optional.ofNullable(listByRoleId).orElse(new ArrayList<>
                    ()).stream().filter(dom -> dom != null).forEach(dom ->{
                        //相等的时候,放到list中
                if(item.getMenuId().equals(dom.getMenuId())){
                    ids.add(dom.getMenuId());
                    return; }
            }); });
        RolePermissionVo vo = new RolePermissionVo();
        vo.setListmenu(menus);
        vo.setCheckList(ids.toArray());
        return vo;
    }

    /**
     * 分配权限保存
     * @param parm
     *
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAssign(RolePermissionParm parm) {
        //保存权限之前,需要把原来的权限删除
        QueryWrapper<RoleMenu> query = new QueryWrapper<>();
        query.lambda().eq(RoleMenu::getRoleId,parm.getRoleId());
        roleMenuService.remove(query);
        //保存新的权限
        roleMenuService.saveRoleMenu(parm.getRoleId(),parm.getList());
    }
}
