package com.company.web.fee_power.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.fee_power.pojo.FeePower;
import com.company.web.fee_power.pojo.FeePowerParm;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName FeePowerService
 * @company 公司
 * @Description 数据管理层,跟controller打交道
 * @createTime 2022年06月24日 06:16:16
 */
public interface FeePowerService  extends IService<FeePower> {

    /**
     * 新增电费
     * @param feePower
     */
    void saveFeePower(FeePower feePower);

    /**
     * 编辑电费
     */
    void updateFeePower(FeePower feePower);

    /**
     * 查询列表
     * @param feePowerParm
     * @return
     */
    IPage<FeePower> getList(FeePowerParm feePowerParm);
}
