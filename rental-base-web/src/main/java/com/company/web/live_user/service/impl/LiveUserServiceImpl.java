package com.company.web.live_user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.house_list.dao.HouseListDao;
import com.company.web.house_list.pojo.HouseList;
import com.company.web.live_house.dao.LiveHouseDao;
import com.company.web.live_house.pojo.LiveHouse;
import com.company.web.live_park.dao.LiveParkDao;
import com.company.web.live_park.pojo.LivePark;
import com.company.web.live_role.dao.LiveRoleDao;
import com.company.web.live_role.pojo.LiveRole;
import com.company.web.live_user.dao.LiveUserDao;
import com.company.web.live_user.pojo.AssignHouseParm;
import com.company.web.live_user.pojo.LiveUser;
import com.company.web.live_user.service.LiveUserService;
import com.company.web.park_list.dao.ParkListDao;
import com.company.web.park_list.pojo.ParkList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName LiveUserServiceImpl
 * @company 公司
 * @Description 业主服务层
 * @createTime 2022年06月14日 05:53:53
 */

@Service
public class LiveUserServiceImpl extends ServiceImpl<LiveUserDao, LiveUser> implements LiveUserService {

    @Resource
    private LiveRoleDao liveRoleDao;

    @Resource
    private LiveHouseDao liveHouseDao;

    @Resource
    private HouseListDao houseListDao;

    @Resource
    private LiveParkDao liveParkDao;

    @Resource
    private ParkListDao parkListDao;


    /**
     * 涉及两个表,要不成功要不失败,加事务@Transactional
     * @param liveUser
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveLiveUser(LiveUser liveUser) {
        /**
         * 1.保存业主信息
         */
        this.baseMapper.insert(liveUser);
        /**
         * 2.维护租户角色信息
         */
        LiveRole liveRole = new LiveRole();
        liveRole.setRoleId(liveUser.getRoleId());
        liveRole.setUserId(liveUser.getUserId());
        liveRoleDao.insert(liveRole);
    }

    @Override
    public IPage<LiveUser> getList(IPage<LiveUser> page, String loginName, String phone) {
        return this.baseMapper.getList(page,loginName,phone);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editLiveUser(LiveUser liveUser) {
        /**
         * 1.更新业主
         */
        this.baseMapper.updateById(liveUser);
        /**
         * 2.角色关联表的数据删除
         *
         */
        QueryWrapper<LiveRole> query = new QueryWrapper<>();
        query.lambda().eq(LiveRole::getUserId,liveUser.getUserId());
        liveRoleDao.delete(query);

        /**
         * 3.插入新的角色
         */
        LiveRole liveRole = new LiveRole();
        liveRole.setRoleId(liveUser.getRoleId());
        liveRole.setUserId(liveUser.getUserId());
        liveRoleDao.insert(liveRole);
    }

    @Override
    public LiveUser getUser(Long userId) {
        return this.baseMapper.getUser(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void assignHouse(AssignHouseParm parm) {
       // 保存到租户和房屋的关系表
        LiveHouse liveHouse = new LiveHouse();
        liveHouse.setHouseId(parm.getHouseId());
        liveHouse.setUserId(parm.getUserId());
        liveHouse.setUseStatus("0");
        liveHouseDao.insert(liveHouse);
        // 更改房屋的使用状态
        HouseList house = new HouseList();
        house.setHouseId(parm.getHouseId());
        house.setStatus("1");
        houseListDao.updateById(house);
    }

    @Override
    public void assignSavePark(LivePark livePark) {
        // 1.把数据存储到租户和车位到关系表里面
        livePark.setLiveStatus("0");
        liveParkDao.insert(livePark);
        // 2.把车位表的状态改为已使用
        ParkList parkList = new ParkList();
        parkList.setParkId(livePark.getParkId());
        parkList.setParkStatus("1");
        parkListDao.updateById(parkList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void returnHouse(AssignHouseParm parm) {
        // 更新租户和房屋关系状态表为解绑
        LiveHouse liveHouse   = new LiveHouse();
        liveHouse.setUseStatus("1");
        QueryWrapper<LiveHouse> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(LiveHouse::getHouseId,parm.getHouseId())
                .eq(LiveHouse::getUserId,parm.getUserId())
                .eq(LiveHouse::getUseStatus,"0");
        liveHouseDao.update(liveHouse,queryWrapper);
        //更新房屋表的使用状态为未使用；
        HouseList houseList = new HouseList();
        houseList.setStatus("0");
        QueryWrapper<HouseList> query = new QueryWrapper<>();
        query.lambda().eq(HouseList::getHouseId,parm.getHouseId());
        houseListDao.update(houseList,query);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void returnPark(LivePark livePark) {
        //2.更新租户和车位的关系为解绑；
        QueryWrapper<LivePark> query = new QueryWrapper<>();
        query.lambda().eq(LivePark::getParkId,livePark.getParkId())
                .eq(LivePark::getUserId,livePark.getUserId())
                .eq(LivePark::getLiveStatus,"0");
        LivePark nLivepark = new LivePark();
        nLivepark.setLiveStatus("1");
        liveParkDao.update(nLivepark,query);
        // 3.更新车位的使用状态为未使用；
        ParkList parkList = new ParkList();
        parkList.setParkStatus("0");
        parkList.setParkId(livePark.getParkId());
        parkListDao.updateById(parkList);
    }

    @Override
    public LiveUser loadUser(String username) {
        //认证
        QueryWrapper<LiveUser> query = new QueryWrapper<>();
        query.lambda().eq(LiveUser::getUsername,username);
        return this.baseMapper.selectOne(query);
    }
}
