package com.company.web.user.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName LoginResult
 * @company 公司
 * @Description LoginResult登录成功后的结果集
 * @createTime 2022年03月04日 16:48:48
 */
@Data
public class LoginResult implements Serializable {
    private Long userId;
    private String token;
    private Long expireTime;
}
