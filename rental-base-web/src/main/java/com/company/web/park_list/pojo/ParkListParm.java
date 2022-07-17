package com.company.web.park_list.pojo;

import com.sun.scenario.effect.impl.prism.PrRenderInfo;
import lombok.Data;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ParkListParm
 * @company 公司
 * @Description 分页参数
 * @createTime 2022年06月04日 00:27:27
 */

@Data
public class ParkListParm {

    private Long currentPage;

    private Long pageSize;

    private String parkName;

    private String  parkStatus;

    private String parkType;
}
