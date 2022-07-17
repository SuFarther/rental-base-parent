package com.company.web.live_house.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.live_house.dao.LiveHouseDao;
import com.company.web.live_house.pojo.LiveHouse;
import com.company.web.live_house.service.LiveHouseService;
import org.springframework.stereotype.Service;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName LiveHouseServiceImpl
 * @company 公司
 * @Description 租户和房屋关系表服务实现层
 * @createTime 2022年06月13日 16:44:44
 */
@Service
public class LiveHouseServiceImpl extends ServiceImpl<LiveHouseDao, LiveHouse> implements LiveHouseService {
}
