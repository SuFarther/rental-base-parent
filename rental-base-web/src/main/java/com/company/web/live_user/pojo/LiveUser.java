package com.company.web.live_user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName LiveUser
 * @company 公司
 * @Description 业主表实体映射
 * @createTime 2022年06月14日 05:45:45
 */
@Data
@TableName("live_user")
public class LiveUser implements UserDetails,Serializable {

    /**
     * 业主id
     */
    @TableId(type= IdType.AUTO)
    private Long userId;


    /**
     * 登录账号
     */
    private String username;


    /**
     * 业主电话
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 姓名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private  String password;

    /**
     * 状态 0:启用 1:禁用
     */
    private  String status;


    /**
     * 角色id从前端传过来的,不属于业主表,需要排除
     */
    @TableField(exist = false)
    private Long roleId;

    /**
     * 不属于业主表,所以需要排除
     */
    @TableField(exist = false)
    private String houseNum;

    /**
     * 不属于业主表,所以需要排除
     */
    @TableField(exist = false)
    private String houseArea;


    /**
     * 不属于业主表,所以需要排除
     */
    @TableField(exist = false)
    private String unitName;

    /**
     * 不属于业主表,所以需要排除
     */
    @TableField(exist = false)
    private String name;

    /**
     * 不属于业主表,所以需要排除
     */
    @TableField(exist = false)
    private String parkName;

    @TableField(exist = false)
    private Long houseId;
    @TableField(exist = false)
    private Long parkId;
    @TableField(exist = false)
    private String useStatus;
    @TableField(exist = false)
    private String liveStatus;

    //下面的字段，属于spring security的UserDetails的字段
    //帐户是否过期(1 未过期，0已过期)
    private boolean isAccountNonExpired = true;
    //帐户是否被锁定(1 未锁定，0已锁定)
    private boolean isAccountNonLocked = true;
    //密码是否过期(1 未过期，0已过期)
    private boolean isCredentialsNonExpired = true;
    //帐户是否可用(1 可用，0 删除用户)
    private boolean isEnabled = true;
    //由于authorities不是数据库里面的字段，所以要排除他，不然mybatis-plus找不到该字段会报错
    @TableField(exist = false)
    Collection<? extends GrantedAuthority> authorities;
}
