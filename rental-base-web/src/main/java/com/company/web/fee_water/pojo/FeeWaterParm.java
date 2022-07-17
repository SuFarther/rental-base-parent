package com.company.web.fee_water.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName FeeWaterParm
 * @company 公司
 * @Description 分页数据展示
 * @createTime 2022年06月28日 13:28:28
 */

@Data
public class FeeWaterParm implements Serializable {

    private Long currentPage;

    private Long pageSize;

    private String loginName;

    private String houseNum;

    private Long userId;
}
