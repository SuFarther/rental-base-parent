package com.company.web.fee_park.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName FeePakrParm
 * @company 公司
 * @Description 查询列表
 * @createTime 2022年07月01日 04:53:53
 */

@Data
public class FeeParkParm implements Serializable {

    private  Long currentPage;
    private  Long pageSize;
    private  String userName;
    private  String parkName;
    private Long userId;
}
