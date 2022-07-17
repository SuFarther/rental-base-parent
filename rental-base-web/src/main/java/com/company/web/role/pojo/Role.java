package com.company.web.role.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName Role
 * @company 公司
 * @Description 角色管理模块的实体类
 * @Data 自动生成 get和set方法
 * @TableName("sys_role") 指定实体对应的表 是哪一个
 * @createTime 2022年02月27日 11:20:20
 */
@Data
@TableName("sys_role")
public class Role implements Serializable {

    /**
     * 角色Id
     */
    @TableId(type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色名称
     */
    private  String roleName;

    /**
     *  角色备注
     */
    private  String remark;
}
