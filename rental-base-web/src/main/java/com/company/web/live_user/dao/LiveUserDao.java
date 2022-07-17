package com.company.web.live_user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.web.live_user.pojo.LiveUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author 苏东坡
 * @version
 * @ClassName LiveUserDao
 * @company 公司
 * @Description 业主表数据库访问层
 * @createTime 2022年06月14日 05:50:50
 */
public interface LiveUserDao extends BaseMapper<LiveUser> {
    /**
     * 分页查询业主用户列表
     * @param page
     * @param loginName
     * @param phone
     * @return
     */
    IPage<LiveUser> getList(IPage<LiveUser> page, @Param("loginName") String loginName,
                            @Param("phone") String phone);


    /**
     * 查询用户id
     * @param userId
     * @return
     */
    LiveUser getUser(@Param("userId") Long userId);
}
