package com.company.web.sys_log.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.utils.ResultUtils;
import com.company.utils.ResultVo;
import com.company.web.sys_log.pojo.LogParm;
import com.company.web.sys_log.pojo.SysLogPojo;
import com.company.web.sys_log.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName SysLogController
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月09日 20:35:35
 */

@RestController
@RequestMapping("/api/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 日志列表查询
     */
    @GetMapping("/list")
    public ResultVo getSysLogList(LogParm logParm) {
        // 构造查询条件
        QueryWrapper<SysLogPojo> query = new QueryWrapper<>();
        query.lambda().orderByDesc(SysLogPojo::getCreateTime);
        // 构造分页条件
        IPage<SysLogPojo> page = new Page<>();
        page.setCurrent(logParm.getCurrentPage());
        page.setSize(logParm.getPageSize());
        IPage<SysLogPojo> list = sysLogService.page(page, query);
        return ResultUtils.success("查询成功!",list);
    }
}
