package com.company.web.live_user.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName AssignHouseParm
 * @company 公司
 * @Description 分配房屋参数
 * @createTime 2022年06月19日 21:03:03
 */
@Data
public class AssignHouseParm implements Serializable {
    private Long userId;
    private Long houseId;
}

