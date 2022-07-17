package com.company.web.fee_water.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.fee_water.dao.FeeWaterDao;
import com.company.web.fee_water.pojo.FeeWater;
import com.company.web.fee_water.pojo.FeeWaterParm;
import com.company.web.fee_water.service.FeeWaterService;
import org.springframework.stereotype.Service;

/**
 * @author zairensuyi
 * @version 1.0
 * @ClassName FeeWaterServiceImpl
 * @company 公司
 * @Description TODO
 * @createTime 2022年06月28日 12:46:46
 */

@Service
public class FeeWaterServiceImpl extends ServiceImpl<FeeWaterDao, FeeWater> implements FeeWaterService {


    /**
     * 查询列表
     * @param feeWaterParm
     * @return
     */
    @Override
    public IPage<FeeWater> getList(FeeWaterParm feeWaterParm) {
        IPage<FeeWater> page = new Page<>();
        page.setCurrent(feeWaterParm.getCurrentPage());
        page.setSize(feeWaterParm.getPageSize());
        return this.baseMapper.getList(page,feeWaterParm.getLoginName(),feeWaterParm.getHouseNum());
    }
}
