package com.company.web.role_menu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.web.role_menu.pojo.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName RoleMenuDao
 * @company 公司
 * @Description 角色权限接口数据库层操作类
 * @createTime 2022年03月12日 11:09:09
 */
public interface RoleMenuDao extends BaseMapper<RoleMenu> {

    /**
     * 保存权限
     * @param roleId
     * @param menuIds
     * @return
     */
    boolean saveRoleMenu(@Param("roleId") Long roleId, @Param("menuIds") List<Long> menuIds);
}
