package com.company.web.live_user.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName LiveUserParm
 * @company 公司
 * @Description 传到前端的参数
 * @createTime 2022年06月18日 18:11:11
 */
@Data
public class LiveUserParm implements Serializable {

    /**
     * 当前页
     */
    private Long currentPage;
    /**
     * 页容量
     */
    private Long pageSize;

    /**
     * 姓名
     */
    private String loginName;

    /**
     * 电话
     */
    private String phone;
}
