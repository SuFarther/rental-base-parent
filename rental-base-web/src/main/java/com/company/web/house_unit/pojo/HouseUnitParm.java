package com.company.web.house_unit.pojo;

import lombok.Data;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseUnitParm
 * @company 公司
 * @Description TODO
 * @createTime 2022年04月26日 21:36:36
 */

@Data
public class HouseUnitParm {


    private String buildName;

    private String unitName;


    /**
     * 页容量
     */
    private  Long pageSize;

    /**
     * 当前页
     */
    private  Long currentPage;
}
