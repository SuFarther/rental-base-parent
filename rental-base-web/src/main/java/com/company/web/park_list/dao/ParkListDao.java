package com.company.web.park_list.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.web.park_list.pojo.ParkList;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ParkListDao
 * @company 公司
 * @Description TODO
 * @createTime 2022年06月03日 03:23:23
 */
public interface ParkListDao  extends BaseMapper<ParkList> {
    /**
     * 批量删除车位ID
     */
//    int batchDelete(List<Long>  parkId);
}
