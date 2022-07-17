package com.company.web.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.user.pojo.User;
import com.company.web.user.pojo.UserParm;
import com.company.web.user_role.pojo.UserRole;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserService
 * @company 公司
 * @Description TODO
 * @createTime 2022年01月10日 16:34:34
 */
public interface UserService extends IService<User> {
    /**
     * 查询用户列表
     */
    IPage<User> list(UserParm parm);

    /**
     * 根据用户id查询角色
     */
    UserRole getRoleByUserId(UserRole userRole);


    /**
     * 保存用户角色
     */
    void saveRole(UserRole userRole);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User loadUser(String username);
}
