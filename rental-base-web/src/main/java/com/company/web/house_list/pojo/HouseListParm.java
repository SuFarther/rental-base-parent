package com.company.web.house_list.pojo;

import lombok.Data;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseListParm
 * @company 公司
 * @Description TODO
 * @createTime 2022年04月26日 22:02:02
 */
@Data
public class HouseListParm {

    /**
     * 栋数名称
     */
    private String buildName;


    private String status;

    /**
     * 单元名称
     */
    private String unitName;

    private String houseNum;


    /**
     * 页容量
     */
    private  Long pageSize;

    /**
     * 当前页
     */
    private  Long currentPage;
}
