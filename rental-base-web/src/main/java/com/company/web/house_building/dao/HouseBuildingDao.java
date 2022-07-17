package com.company.web.house_building.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.web.house_building.pojo.HouseBuilding;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseBuilding
 * @company 公司
 * @Description 栋数的数据访问层
 * @createTime 2022年04月25日 22:33:33
 */
public interface HouseBuildingDao extends BaseMapper<HouseBuilding> {

    /**
     * 批量删除栋数信息
     * @param buildIds
     * @return
     */
//    int deleteBuildingsByIds(Long[] buildIds);
}
