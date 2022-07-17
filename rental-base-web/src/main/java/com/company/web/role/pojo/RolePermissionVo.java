package com.company.web.role.pojo;

import com.company.web.menu.pojo.Menu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName RolePermissionVo
 * @company 公司
 * @Description 角色准许前端参数
 * @createTime 2022年03月14日 08:24:24
 */
@Data
public class RolePermissionVo {
    /**
     * 当前登录系统用户的菜单数据
     */
    List<Menu> listmenu = new ArrayList<>();

    /**
     * 角色原来分配的菜单
     */
    private Object[] checkList;
}
