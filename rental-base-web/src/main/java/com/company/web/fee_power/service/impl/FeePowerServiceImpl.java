package com.company.web.fee_power.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.fee_power.dao.FeePowerDao;
import com.company.web.fee_power.pojo.FeePower;
import com.company.web.fee_power.pojo.FeePowerParm;
import com.company.web.fee_power.service.FeePowerService;
import com.company.web.live_house.dao.LiveHouseDao;
import com.company.web.live_house.pojo.LiveHouse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName FeePowerServiceImpl
 * @company 公司
 * @Description TODO
 * @createTime 2022年06月24日 06:16:16
 */

@Service
public class FeePowerServiceImpl  extends ServiceImpl<FeePowerDao, FeePower> implements FeePowerService {

    @Resource
    private LiveHouseDao LiveHouseDao;

    /**
     * 新增电费
     * @param feePower
     */
    @Override
    public void saveFeePower(FeePower feePower) {
        // 保存电费到数据库
        this.baseMapper.insert(feePower);
    }


    /**
     * 编辑电费
     * @param feePower
     */
    @Override
    public void updateFeePower(FeePower feePower) {
        // 编辑电费
        this.baseMapper.updateById(feePower);
    }

    @Override
    public IPage<FeePower> getList(FeePowerParm feePowerParm) {
        // 构造分页对象
        IPage<FeePower> page  = new Page<>();
        page.setCurrent(feePowerParm.getCurrentPage());
        page.setSize(feePowerParm.getPageSize());
        return this.baseMapper.getList(page,feePowerParm.getUserName(),feePowerParm.getHouseNum());
    }
}
