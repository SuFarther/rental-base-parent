package com.company.web.house_list.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.house_list.pojo.HouseList;
import com.company.web.house_list.pojo.HouseListParm;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseListService
 * @company 公司
 * @Description 房屋表dao-service数据服务层
 * @createTime 2022年04月26日 21:52:52
 */
public interface HouseListService extends IService<HouseList> {
    IPage<HouseList> getList(HouseListParm parm);
}
