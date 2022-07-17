package com.company.web.sys_notice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.web.sys_notice.pojo.SysNotice;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName NoticeDao
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月08日 06:20:20
 */
public interface SysNoticeDao extends BaseMapper<SysNotice> {

    /**
     * 批量删除公告信息
     * @param noticeIds
     * @return
     */
//     int deleteUserByIds(Long[] noticeIds);
}
