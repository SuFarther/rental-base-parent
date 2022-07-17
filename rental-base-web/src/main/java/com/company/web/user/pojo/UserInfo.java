package com.company.web.user.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserInfo
 * @company 公司
 * @Description 用户信息实体类,对应mock-user.js里面的token密码的字段
 * const users = {
 *   'admin-token': {
 *     roles: ['admin'],
 *     introduction: 'I am a super administrator',
 *     avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
 *     name: 'Super Admin'
 *   },
 *   'editor-token': {
 *     roles: ['editor'],
 *     introduction: 'I am an editor',
 *     avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
 *     name: 'Normal Editor'
 *   }
 * }
 * @createTime 2022年03月12日 10:23:23
 */
@Data
public class UserInfo implements Serializable {
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 头像
     */
    private String  avatar;

    /**
     * 介绍
     */
    private  String introduction;

    /**
     * 权限集合
     */
    private  Object[] roles;

}
