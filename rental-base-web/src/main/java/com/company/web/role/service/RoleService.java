package com.company.web.role.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.role.pojo.*;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName RoleService
 * @company 公司
 * @Description 角色管理服务层
 * @createTime 2022年02月27日 11:28:28
 */
public interface RoleService extends IService<Role> {
    /**
     * 分页查询
     * @param parm
     * @return
     */
    IPage<Role> list(RoleParm parm);


    /**
     * 分配权限树数据回显查询
     */
    RolePermissionVo getAssignTree(RoleAssignParm parm);

    /**
     * 分配权限保存
     */
    void saveAssign(RolePermissionParm parm);
}
