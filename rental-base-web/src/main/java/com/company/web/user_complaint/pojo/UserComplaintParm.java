package com.company.web.user_complaint.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserComplaintParm
 * @company 公司
 * @Description 投诉分页参数
 * @createTime 2022年07月04日 04:56:56
 */

@Data
public class UserComplaintParm implements Serializable {

    /**
     * 当前页
     */
    private Long currentPage;

    /**
     * 页容量
     */
    private Long pageSize;

    /**
     * 投诉人id
     */
    private Long userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String complaintContent;

}
