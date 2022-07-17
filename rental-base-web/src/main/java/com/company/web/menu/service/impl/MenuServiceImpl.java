package com.company.web.menu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.menu.pojo.MakeMenuTree;
import com.company.web.menu.pojo.Menu;
import com.company.web.menu.dao.MenuDao;
import com.company.web.menu.service.MenuService;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName MenuServiceImpl
 * @company 公司
 * @Description 权限管理服务层实现类
 * @createTime 2022年03月01日 19:02:02
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements
        MenuService {
    @Override
    public List<Menu> getList() {
        /**
         * 构造查询条件
         */
        QueryWrapper<Menu> query = new QueryWrapper<>();
        query.lambda().orderByAsc(Menu::getName);
        /**
         * 组装成树数据
         */
        List<Menu> menus = this.baseMapper.selectList(query);
        List<Menu> menuList = MakeMenuTree.makeTree(menus, 0L);
        return menuList;
    }


    @Override
    public List<Menu> getParentList() {
        /**
         * 只查询目录和菜单 即只查询 0和1 的数据
         *
         */
        String[] types = {"0","1"};
        /**
         * 构造查询条件
         */
        QueryWrapper<Menu> query = new QueryWrapper<>();
        query.lambda().in(Menu::getType,types).orderByAsc(Menu::getOrderNum);
        List<Menu> menus = this.baseMapper.selectList(query);
        /**
         * 构造顶级菜单
         */
        Menu menu = new Menu();
        menu.setMenuId(0L);
        menu.setParentId(-1L);
        menu.setMenuLabel("顶级菜单");
        menus.add(menu);
        /**
         * 构造菜单树
         */
        List<Menu> menuList = MakeMenuTree.makeTree(menus, -1L);
        return menuList;
    }

    @Override
    public List<Menu> getMenuByUserId(Long userId) {
        return this.baseMapper.getMenuByUserId(userId);
    }

    @Override
    public List<Menu> getMenuByUserIdForLiveUser(Long userId) {
        return this.baseMapper.getMenuByUserIdForLiveUser(userId);
    }

    @Override
    public List<Menu> getMenuByRoleId(Long roleId) {
        return this.baseMapper.getMenuByRoleId(roleId);
    }
}
