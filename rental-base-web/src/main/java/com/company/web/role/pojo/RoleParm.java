package com.company.web.role.pojo;

import lombok.Data;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName RoleParm
 * @company 公司
 * @Description 传到前端需要的后面页面需要的参数
 * @createTime 2022年02月27日 11:35:35
 */
@Data
public class RoleParm {
    /**
     * 页容量
     */
    private  Long pageSize;
    /**
     * 当前页
     */
    private  Long currentPage;

    /**
     * 角色名称
     */
    private String roleName;

}
