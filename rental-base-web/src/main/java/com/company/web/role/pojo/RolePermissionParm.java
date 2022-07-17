package com.company.web.role.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName RolePermissionParm
 * @company 公司
 * @Description 角色许可证
 * @createTime 2022年03月14日 08:58:58
 */
@Data
public class RolePermissionParm {
    private Long roleId;
    List<Long> list;
}