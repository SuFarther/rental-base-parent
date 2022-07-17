package com.company.web.house_building.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.house_building.pojo.HouseBuilding;
import com.company.web.house_building.pojo.HouseBuildingParm;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseBuildingService
 * @company 公司
 * @Description 栋数的业务逻辑层
 * @createTime 2022年04月25日 22:36:36
 */
public interface HouseBuildingService extends IService<HouseBuilding> {

    /**
     * 列表查询
     */
    IPage<HouseBuilding> getList(HouseBuildingParm parm);

    /**
     * 批量删除栋数信息
     * @param buildIds
     * @return
     */
//    int deleteBuildingsByIds(Long[] buildIds);
}
