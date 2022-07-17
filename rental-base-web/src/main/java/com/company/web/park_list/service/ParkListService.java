package com.company.web.park_list.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.park_list.pojo.ParkList;
import com.company.web.park_list.pojo.ParkListParm;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ParkListService
 * @company 公司
 * @Description TODO
 * @createTime 2022年06月03日 03:26:26
 */
public interface ParkListService extends IService<ParkList> {

    IPage<ParkList> getList(ParkListParm parkListParm);

    /**
     * 批量删除车位ID
     */
//    int batchDelete(List<Long> parkId);
}
