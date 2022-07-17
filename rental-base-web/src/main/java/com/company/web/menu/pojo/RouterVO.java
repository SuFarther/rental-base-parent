package com.company.web.menu.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName RouterVO
 * @company 公司
 * @Description 路由需要的数据格式如下：
 * {
 *     path: '/system',
 *     component: Layout,
 *     name: 'system',
 *     alwaysShow: true,
 *     meta: { title: '系统管理', icon: 'el-icon-s-help' },
 *     children: [
 *       {
 *         path: '/sysUserList',
 *         name: 'sysUserList',
 *         component: () => import('@/views/system/sysUserList'),
 *         meta: { title: '员工管理', icon: 'table' }
 *       },
 *       {
 *         path: '/sysRoleList',
 *         name: 'sysRoleList',
 *         component: () => import('@/views/system/sysRoleList'),
 *         meta: { title: '角色管理', icon: 'tree' }
 *       },
 *       {
 *         path: '/sysMenuList',
 *         name: 'sysMenuList',
 *         component: () => import('@/views/system/sysMenuList'),
 *         meta: { title: '权限管理', icon: 'tree' }
 *       }
 *     ]
 *   },
 * @createTime 2022年07月14日 16:19:19
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouterVO implements Serializable {

    private String path;

    private String component;

    private boolean alwaysShow;

    private String name;

    private Meta meta;

    @Data
    @AllArgsConstructor
    public class Meta {
        private String title;
        private String icon;
        private Object[] roles;
    }
    private List<RouterVO> children =new ArrayList<>();

}
