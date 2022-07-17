package com.company.web.live_user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.live_park.pojo.LivePark;
import com.company.web.live_user.pojo.AssignHouseParm;
import com.company.web.live_user.pojo.LiveUser;


/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName LiveUserService
 * @company 公司
 * @Description 业主服务层
 * @createTime 2022年06月14日 05:52:52
 */
public interface LiveUserService extends IService<LiveUser> {

    /**
     * 新增业主用户,需要维护用户角色表
     * @param liveUser
     */
    void saveLiveUser(LiveUser liveUser);

    /**
     *  业主列表
     * @param page
     * @param userName
     * @param phone
     * @return
     */
    IPage<LiveUser> getList(IPage<LiveUser> page, String userName, String phone);

    /**
     * 编辑业主
     * @param liveUser
     */
    void editLiveUser(LiveUser liveUser);


    /**
     * 编辑查询
     * @param userId
     * @return
     */
    LiveUser getUser(Long userId);

    /**
     * 分配房屋保存
     */
    void assignHouse(AssignHouseParm parm);

    /**
     * 分配车位保存
     * @param livePark
     */
    void assignSavePark(LivePark livePark);

    /**
     * 退房
     * @param parm
     */
    void returnHouse(AssignHouseParm parm);

    /**
     * 退车位
     * @param livePark
     */
    void returnPark(LivePark livePark);


    /**
     *  根据用户名查用户
     * @param username
     * @return
     */
    LiveUser loadUser(String username);
}
