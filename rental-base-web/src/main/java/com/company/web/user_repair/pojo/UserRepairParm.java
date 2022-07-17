package com.company.web.user_repair.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserRepairParm
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月07日 15:47:47
 */
@Data
public class UserRepairParm implements Serializable {

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
     private  Long userId;

    /**
     * 报修内容
     */
    private  String repairContent;
}
