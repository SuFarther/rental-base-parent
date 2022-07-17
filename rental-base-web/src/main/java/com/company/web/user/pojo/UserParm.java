package com.company.web.user.pojo;

import lombok.Data;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserParm
 * @company 公司
 * @Description 用户分页参数
 *
 * pageSize 页容量
 * currentPage 当前页
 * username 姓名
 * phone 电话
 * @createTime 2022年01月12日 16:31:31
 */
@Data
public class UserParm {
    /**
     * 页容量
     */
    private  Long pageSize;
    /**
     * 当前页
     */
    private  Long curentPage;
    /**
     * 姓名
     */
    private  String loginName;
    /**
     * 电话
     */
    private  String phone;
}
