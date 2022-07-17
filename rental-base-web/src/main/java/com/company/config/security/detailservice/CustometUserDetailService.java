package com.company.config.security.detailservice;

import com.company.web.live_user.pojo.LiveUser;
import com.company.web.live_user.service.LiveUserService;
import com.company.web.menu.pojo.Menu;
import com.company.web.menu.service.MenuService;
import com.company.web.user.pojo.User;
import com.company.web.user.service.UserService;
import org.apache.tomcat.jni.Pool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName CustometUserDetailService
 * @company 公司
 * @Description 登录，也就是用户认证的时候调用，告诉spring security到哪里查询用户信息
 * 自定义UserDetailsService，目的:告诉spring security如何查询用户信息
 * @Component("custometUserDetailService") 把该类交给spring进行管理
 * @createTime 2022年07月10日 16:57:57
 */

@Component("custometUserDetailService")
public class CustometUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private LiveUserService liveUserService;

    @Autowired
    private MenuService menuService;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 获取用户类型 0:业主 1: 物业
        // 认证 s="admin:1"
        int index = s.indexOf(":");
        String username = s.substring(0,index);
        String userType = s.substring(index+1,s.length());
//        UserDetails user = null;
        // 业主
        if(userType.equals("0")){
            LiveUser liveUser= liveUserService.loadUser(username);
            if(liveUser == null){
                throw new UsernameNotFoundException("用户账号不存在!");
            }
            // 查询业主的权限信息
            List<Menu> menuList = menuService.getMenuByUserIdForLiveUser(liveUser.getUserId());
            List<String> collect = menuList.stream().filter(item -> item != null).map(item -> item.getMenuCode()).filter(item -> item != null).collect(Collectors.toList());
            // 转成数组
            String[] strings = collect.toArray(new String[collect.size()]);
            List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(strings);
            // 设置用户的权限
            liveUser.setAuthorities(authorityList);
            return liveUser;
            //物主
        }else if(userType.equals("1")){
          User user = userService.loadUser(username);
          if(user == null){
            throw new UsernameNotFoundException("用户账号不存在!");
          }
          // 查询用户权限信息
            List<Menu> menuList = menuService.getMenuByUserId(user.getUserId());
            List<String> collect = menuList.stream().filter(item -> item != null).map(item -> item.getMenuCode()).filter(item -> item != null).collect(Collectors.toList());
            // 转成数组
            String[] strings = collect.toArray(new String[collect.size()]);
            List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(strings);
            // 设置用户的权限
            user.setAuthorities(authorityList);
            //授权
            return user;
        }else {
            throw new UsernameNotFoundException("用户类型不存在!");
        }
    }
}
