package com.company.web.user_role.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserRole
 * @company 公司
 * @Description 用户角色表
 * @createTime 2022年04月11日 19:25:25
 */
@Data
@TableName("sys_user_role")
public class UserRole implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long userRoleId;
    private Long userId;
    private Long roleId;
}
