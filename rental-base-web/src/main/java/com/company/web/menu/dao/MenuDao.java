package com.company.web.menu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.web.menu.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName MenuDao
 * @company 公司
 * @Description 权限管理持久层
 * @createTime 2022年03月01日 18:54:54
 */
public interface MenuDao extends BaseMapper<Menu> {

    /**
     * 根据用户id查询权限
     */
    List<Menu> getMenuByUserId(@Param("userId") Long userId);


    /**
     * 根据业主的id查询菜单
     */
    List<Menu> getMenuByUserIdForLiveUser(@Param("userId") Long userId);

    /**
     * 根据角色id查询原来的权限
     */
    List<Menu> getMenuByRoleId(@Param("roleId") Long roleId);
}
