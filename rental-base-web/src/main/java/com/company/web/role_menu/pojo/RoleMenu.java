package com.company.web.role_menu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName RoleMenu
 * @company 公司
 * @Description 角色权限实体类
 * @Data 自动生成get和set方法
 * @TableName("sys_role_menu") 指明RoleMenu实体对应的数据库的表sys_role_menu
 * @createTime 2022年03月12日 11:06:06
 */
@Data
@TableName("sys_role_menu")
public class RoleMenu implements Serializable {

    /**
     * 角色权限ID
     */
    @TableId(type = IdType.AUTO)
    private  Long  roleMenuId;

    /**
     * 角色id
     */
    private  Long roleId;

    /**
     * 菜单id
     */
    private Long menuId;

}
