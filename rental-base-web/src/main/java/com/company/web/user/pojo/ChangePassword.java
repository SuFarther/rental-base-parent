package com.company.web.user.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ChangePassword
 * @company 公司
 * @Description 改变原来的密码
 * @createTime 2022年07月15日 16:26:26
 */
@Data
public class ChangePassword implements Serializable {

    private Long userId;

    /**
     *  旧密码
     */
    private String oldPassword;

    /**
     * 新密码
     */
    private String newPassword;
}
