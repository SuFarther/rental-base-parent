package com.company.web.fee_power.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.web.fee_power.pojo.FeePower;
import org.apache.ibatis.annotations.Param;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName FeePowerDao
 * @company 公司
 * @Description 电费管理数据库操作层
 * @createTime 2022年06月24日 06:14:14
 */
public interface FeePowerDao extends BaseMapper<FeePower> {
    /**
     * 分页查询列表
     * @param page
     * @param userName
     * @param houseNum
     * @return
     */
    IPage<FeePower> getList(IPage<FeePower> page, @Param("userName") String userName, @Param("houseNum") String houseNum);
}
