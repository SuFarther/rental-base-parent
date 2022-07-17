package com.company.web.sys_log.SysLogTask;

import com.company.utils.AddressUtils;
import com.company.web.sys_log.pojo.SysLogPojo;
import com.company.web.sys_log.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName SysLogTaskImpl
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月16日 14:51:51
 */

@Component
public class SysLogTaskImpl implements SysLogTask{
    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private AddressUtils addressUtils;

    @Override
    @Async(value = "threadPoolTaskExecutor")
    public void saveLog(SysLogPojo sysLogPojo) {
        String regin = addressUtils.getRealAddressByIP(sysLogPojo.getIpNum());
        sysLogPojo.setIpRegion(regin);
        sysLogService.save(sysLogPojo);
    }

    @Override
    @Async(value = "threadPoolTaskExecutor")
    public void updateLog(SysLogPojo sysLogPojo) {
        sysLogService.updateById(sysLogPojo);
    }
}
