package com.company.web.house_unit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.web.house_unit.pojo.HouseUnit;
import org.apache.ibatis.annotations.Param;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseUnitDao
 * @company 公司
 * @Description TODO
 * @createTime 2022年04月26日 08:28:28
 */
public interface HouseUnitDao extends BaseMapper<HouseUnit> {
    /**
     *
     * @param page
     * @param unitName
     * @param buildName
     * @return
     */
    IPage<HouseUnit> getList(IPage<HouseUnit> page, @Param("unitName") String unitName, @Param("buildName") String buildName);
}
