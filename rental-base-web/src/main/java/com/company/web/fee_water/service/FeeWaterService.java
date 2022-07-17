package com.company.web.fee_water.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.fee_water.pojo.FeeWater;
import com.company.web.fee_water.pojo.FeeWaterParm;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName FeeWaterService
 * @company 公司
 * @Description 水费管理服务层
 * @createTime 2022年06月28日 12:43:43
 */
public interface FeeWaterService extends IService<FeeWater> {


    /**
     * 查询列表
     * @param feeWaterParm
     * @return
     */
    IPage<FeeWater> getList(FeeWaterParm feeWaterParm);

}
