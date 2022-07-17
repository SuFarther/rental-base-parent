package com.company.web.house_list.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.house_list.dao.HouseListDao;
import com.company.web.house_list.pojo.HouseList;
import com.company.web.house_list.pojo.HouseListParm;
import com.company.web.house_list.service.HouseListService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseListServiceImpl
 * @company 公司
 * @Description TODO
 * @createTime 2022年04月26日 21:54:54
 */
@Service
public class HouseListServiceImpl extends ServiceImpl<HouseListDao, HouseList> implements HouseListService {
    @Override
    public IPage<HouseList> getList(HouseListParm parm) {
        //构造分页对象
        IPage<HouseList> page = new Page<>();
        page.setSize(parm.getPageSize());
        page.setCurrent(parm.getCurrentPage());
        return this.baseMapper.getList(page,parm.getBuildName(),parm.getUnitName(),parm.getHouseNum(),parm.getStatus());
    }
}
