package com.company.web.fee_power.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName FeePowerParm
 * @company 公司
 * @Description TODO
 * @createTime 2022年06月26日 12:39:39
 */

@Data
public class FeePowerParm implements Serializable {
    private Long currentPage;
    private Long pageSize;
    private String userName;
    private String houseNum;
    private Long userId;
}
