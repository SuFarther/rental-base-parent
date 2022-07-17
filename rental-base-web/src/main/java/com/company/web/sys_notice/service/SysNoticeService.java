package com.company.web.sys_notice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.sys_notice.pojo.SysNotice;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName NoticeService
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月08日 06:22:22
 */
public interface SysNoticeService extends IService<SysNotice> {


    /**
     *  批量删除公告信息
     * @param noticeIds
     * @return
     */
//    int deleteUserByIds(Long[] noticeIds);
}
