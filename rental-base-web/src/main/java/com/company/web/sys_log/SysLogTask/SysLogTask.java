package com.company.web.sys_log.SysLogTask;

import com.company.web.sys_log.pojo.SysLogPojo;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName SysLogTask
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月16日 14:49:49
 */
public interface SysLogTask {
    /**
     * 保存日志
     * @param sysLogPojo
     */
    void saveLog(SysLogPojo sysLogPojo);

    /**
     * 更新日志
     * @param sysLogPojo
     */
    void updateLog(SysLogPojo sysLogPojo);
}

