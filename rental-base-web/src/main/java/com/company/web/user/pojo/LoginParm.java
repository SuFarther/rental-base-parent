package com.company.web.user.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName LoginParm
 * @company 公司
 * @Description 登录操作传到前端的参数
 * @createTime 2022年03月04日 16:37:37
 */
@Data
public class LoginParm implements Serializable {


    private String username;
    private String password;
    private String userType;
}
