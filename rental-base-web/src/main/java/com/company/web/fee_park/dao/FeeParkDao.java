package com.company.web.fee_park.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.web.fee_park.pojo.FeePark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName FeeParkDao
 * @company 公司
 * @Description 车位管理持久层
 * @createTime 2022年07月01日 04:58:58
 */
public interface FeeParkDao extends BaseMapper<FeePark> {
    /**
     * 列表查询
     * @param page
     * @param userName
     * @param parkName
     * @return
     */
    IPage<FeePark> getList(IPage<FeePark> page, @Param("userName") String userName,@Param("parkName") String parkName);
}
