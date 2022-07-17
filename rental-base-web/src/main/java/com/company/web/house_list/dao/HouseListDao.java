package com.company.web.house_list.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.web.house_list.pojo.HouseList;
import org.apache.ibatis.annotations.Param;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseListDao
 * @company 公司
 * @Description 房屋列表持久层(跟数据库打交道)
 * @createTime 2022年04月26日 21:50:50
 */
public interface HouseListDao extends BaseMapper<HouseList> {
    IPage<HouseList> getList(IPage<HouseList> page, @Param("buildName") String buildName,@Param("unitName") String unitName,
                             @Param("houseNum")  String houseNum,@Param("status") String status);
}
