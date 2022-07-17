package com.company.web.sys_notice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.sys_notice.dao.SysNoticeDao;
import com.company.web.sys_notice.pojo.SysNotice;
import com.company.web.sys_notice.service.SysNoticeService;
import org.springframework.stereotype.Service;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName SysNoticeService
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月08日 06:23:23
 */

@Service
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeDao, SysNotice> implements SysNoticeService {
//    @Override
//    public int deleteUserByIds(Long[] noticeIds) {
//       return this.baseMapper.deleteUserByIds(noticeIds);
//    }
}
