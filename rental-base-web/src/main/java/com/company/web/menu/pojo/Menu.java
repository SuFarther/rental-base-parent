package com.company.web.menu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName Menu
 * @company 公司
 * @Description 权限管理
 * @Data  自动生成get和set方法
 * @TableName("sys_menu") 指明menu实体对应的表是 sys_menu
 * @createTime 2022年03月01日 18:44:44
 */

@Data
@TableName("sys_menu")
public class Menu implements Serializable {
    /**
     * 主键
     * menuId：上级菜单id
     * parentId: 菜单名称
     * menuLabel: 权限字段
     * menuCode:  路由名称
     * name: 路由地址
     * path: 组件路径
     * type: 菜单类型 0:目录 1:菜单 2:按钮
     * icon: 图标
     * remark: 备注
     * parentName: 上级菜单名称
     * orderNum: 序号
     * children: 不属于数据库表中的字段，需要排除
     */
    @TableId(type = IdType.AUTO)
    private Long menuId;

    private Long parentId;
    private String menuLabel;
    private String menuCode;
    private String name;
    private String path;
    private String url;
    private String type;
    private String icon;
    private String remark;
    private String parentName;
    private Integer orderNum;
    @TableField(exist = false)
    private List<Menu> children = new ArrayList<>();
}