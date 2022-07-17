package com.company.web.house_building.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.house_building.dao.HouseBuildingDao;
import com.company.web.house_building.pojo.HouseBuilding;
import com.company.web.house_building.pojo.HouseBuildingParm;
import com.company.web.house_building.service.HouseBuildingService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseBuildingServiceImpl
 * @company 公司
 * @Description 业务逻辑层实现类
 * @createTime 2022年04月25日 22:41:41
 */

@Service
public class HouseBuildingServiceImpl extends ServiceImpl<HouseBuildingDao, HouseBuilding> implements HouseBuildingService {
    @Override
    public IPage<HouseBuilding> getList(HouseBuildingParm parm) {
        //构造查询条件
        QueryWrapper<HouseBuilding> query = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(parm.getName())){
            query.lambda().like(HouseBuilding::getName,parm.getName());
        }
        if(StringUtils.isNotEmpty(parm.getType())){
            query.lambda().eq(HouseBuilding::getType,parm.getType());
        }
        //构造分页对象
        IPage<HouseBuilding> page = new Page<>();
        page.setSize(parm.getPageSize());
        page.setCurrent(parm.getCurrentPage());
        return this.baseMapper.selectPage(page,query);
    }

//    @Override
//    public int deleteBuildingsByIds(Long[] buildIds) {
//        return this.baseMapper.deleteBuildingsByIds(buildIds);
//    }
}
