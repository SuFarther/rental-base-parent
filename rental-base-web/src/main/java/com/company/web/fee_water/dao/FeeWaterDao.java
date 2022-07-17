package com.company.web.fee_water.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.web.fee_water.pojo.FeeWater;
import org.apache.ibatis.annotations.Param;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName FeeWaterDao
 * @company 公司
 * @Description 水费管理持久层
 * @createTime 2022年06月28日 12:38:38
 */
public interface FeeWaterDao extends BaseMapper<FeeWater> {


    /**
     * 分页查询列表
     * @param page
     * @param loginName
     * @param houseNum
     * @return
     */
    IPage<FeeWater> getList(IPage<FeeWater> page, @Param("loginName") String loginName, @Param("houseNum") String houseNum);
}
