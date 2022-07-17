package com.company.web.house_unit.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.house_unit.pojo.HouseUnit;
import com.company.web.house_unit.pojo.HouseUnitParm;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseUnitService
 * @company 公司
 * @Description TODO
 * @createTime 2022年04月26日 08:30:30
 */
public interface HouseUnitService extends IService<HouseUnit> {

    IPage<HouseUnit> getList(HouseUnitParm houseUnitParm);
}
