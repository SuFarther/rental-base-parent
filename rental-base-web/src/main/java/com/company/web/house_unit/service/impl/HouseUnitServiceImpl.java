package com.company.web.house_unit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.house_unit.dao.HouseUnitDao;
import com.company.web.house_unit.pojo.HouseUnit;
import com.company.web.house_unit.pojo.HouseUnitParm;
import com.company.web.house_unit.service.HouseUnitService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseUnitServiceImpl
 * @company 公司
 * @Description TODO
 * @createTime 2022年04月26日 08:32:32
 */
@Service
public class HouseUnitServiceImpl  extends ServiceImpl<HouseUnitDao, HouseUnit> implements HouseUnitService {
    @Override
    public IPage<HouseUnit> getList(HouseUnitParm houseUnitParm) {

        //构造分页条件
        IPage<HouseUnit> page = new Page<>();
        page.setSize(houseUnitParm.getPageSize());
        page.setCurrent(houseUnitParm.getCurrentPage());
        return this.baseMapper.getList(page,houseUnitParm.getUnitName(),houseUnitParm.getBuildName());
    }
}
