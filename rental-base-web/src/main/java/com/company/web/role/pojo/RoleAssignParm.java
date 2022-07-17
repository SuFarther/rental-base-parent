package com.company.web.role.pojo;

import lombok.Data;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName RoleAssignParm
 * @company 公司
 * @Description 角色分配参数
 * @createTime 2022年03月14日 08:22:22
 */

@Data
public class RoleAssignParm {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private  Long roleId;
}
