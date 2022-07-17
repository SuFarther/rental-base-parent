package com.company.web.fee_park.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.fee_park.dao.FeeParkDao;
import com.company.web.fee_park.pojo.FeePark;
import com.company.web.fee_park.pojo.FeeParkParm;
import com.company.web.fee_park.service.FeeParkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName FeeParkServiceImpl
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月01日 05:13:13
 */

@Service
public class FeeParkServiceImpl extends ServiceImpl<FeeParkDao, FeePark> implements FeeParkService {
    /**
     * 分页查询
     * @param feeParkParm
     * @return
     */
    @Override
    public IPage<FeePark> getList(FeeParkParm feeParkParm) {
        // 构造分页独享
        IPage<FeePark> page = new Page<>();
        page.setCurrent(feeParkParm.getCurrentPage());
        page.setSize(feeParkParm.getPageSize());
        return this.baseMapper.getList(page,feeParkParm.getUserName(),feeParkParm.getParkName());
    }
}
