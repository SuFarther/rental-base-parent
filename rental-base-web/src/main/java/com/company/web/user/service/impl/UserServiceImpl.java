package com.company.web.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.user.dao.UserDao;
import com.company.web.user.pojo.User;
import com.company.web.user.pojo.UserParm;
import com.company.web.user.service.UserService;
import com.company.web.user_role.dao.UserRoleDao;
import com.company.web.user_role.pojo.UserRole;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserServiceImpl
 * @company 公司
 * @Description
 * 继承 ServiceImpl 的好处是 可以使用 Mybatis-Plus的通用CRUD方法，
 * implements UserService的原因，是如果 Mybatis-Plus的通用CRUD方法不够用，或者不符合开发需求的
 * 时候，需要扩展我们自己定义的方法
 * @Service 表示把该类交给spring 进行管理，我们就可以在其他类里面直接注入使用
 * @createTime 2022年01月10日 16:37:37
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public IPage<User> list(UserParm parm) {
        //构造分页的对象
        IPage<User> page = new Page<>();
        page.setSize(parm.getPageSize());
        page.setCurrent(parm.getCurentPage());
        //构造查询条件
        QueryWrapper<User> query =  new QueryWrapper<>();
        if(StringUtils.isNotEmpty(parm.getPhone())){
            query.lambda().like(User::getPhone,parm.getPhone());
        }
        if(StringUtils.isNotEmpty(parm.getLoginName())){
            query.lambda().like(User::getUsername,parm.getLoginName());
        }
        return this.page(page,query);
    }

    @Override
    public UserRole getRoleByUserId(UserRole userRole) {
        QueryWrapper<UserRole> query = new QueryWrapper<>();
        query.lambda().eq(UserRole::getUserId,userRole.getUserId());
        return userRoleDao.selectOne(query);
    }

    @Override
    @Transactional
    public void saveRole(UserRole userRole) {
       //先把原来的角色删除
        QueryWrapper<UserRole> query = new QueryWrapper<>();
        query.lambda().eq(UserRole::getUserId,userRole.getUserId());
        userRoleDao.delete(query);
        //把新角色保存
        userRoleDao.insert(userRole);
    }



    @Override
    public User loadUser(String username) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.lambda().eq(User::getUsername, username);
        return this.baseMapper.selectOne(query);
    }
}
