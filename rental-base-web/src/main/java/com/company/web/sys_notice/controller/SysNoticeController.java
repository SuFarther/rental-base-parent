package com.company.web.sys_notice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.utils.ResultUtils;
import com.company.utils.ResultVo;
import com.company.web.sys_notice.pojo.SysNotice;
import com.company.web.sys_notice.pojo.SysNoticeParm;
import com.company.web.sys_notice.service.SysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName NoticeController
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月08日 06:24:24
 */

@RestController
@RequestMapping("/api/sysNotice")
public class SysNoticeController {

    @Autowired
    private SysNoticeService sysNoticeService;




    /**
     * 公告列表(物业管理部人员)
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sys:notice:look')")
    public ResultVo getList(SysNoticeParm sysNoticeParm){
        //创建查询条件
        QueryWrapper<SysNotice> query = new QueryWrapper<SysNotice>();
        query.lambda().like(SysNotice::getTitle,sysNoticeParm.getTitle())
                .orderByDesc(SysNotice::getCreateTime);
        // 构造分页对象
        IPage<SysNotice> page = new Page<>();
        page.setCurrent(sysNoticeParm.getCurrentPage());
        page.setSize(sysNoticeParm.getPageSize());
        IPage<SysNotice> list = sysNoticeService.page(page, query);
        return ResultUtils.success("查询列表成功!",list);
    }


    /**
     * 新增
     */
    @PostMapping
    @PreAuthorize("hasAuthority('sys:noticeList:add')")
    public ResultVo add(@RequestBody SysNotice sysNotice) {
        sysNotice.setCreateTime(new Date());
        boolean save = sysNoticeService.save(sysNotice);
        if(save) {
            return ResultUtils.success("新增公告成功!");
        }
        return ResultUtils.error("新增公告失败!");
    }

    /**
     * 编辑
     */
    @PutMapping
    @PreAuthorize("hasAuthority('sys:noticeList:edit')")
    public ResultVo edit(@RequestBody SysNotice sysNotice) {
        boolean save = sysNoticeService.updateById(sysNotice);
        if(save) {
            return ResultUtils.success("编辑公告成功!");
        }
        return ResultUtils.error("编辑公告失败!");
    }

    /**
     * 删除
     */
    @DeleteMapping("/{noticeId}")
    @PreAuthorize("hasAuthority('sys:noticeList:delete')")
    public ResultVo delete(@PathVariable("noticeId") Long noticeId){
        boolean b = sysNoticeService.removeById(noticeId);
        if(b) {
            return ResultUtils.success("删除公告成功!");
        }
        return ResultUtils.error("删除公告失败!");
    }


    /**
     * 批量删除通知公告
     */
//    @DeleteMapping("/{noticeIds}")
//    public ResultVo remove(@PathVariable Long[] noticeIds){
//        int b = sysNoticeService.deleteUserByIds(noticeIds);
//        if(b > 0) {
//            return ResultUtils.success("批量删除公告信息成功!");
//        }
//        return ResultUtils.error("批量删除公告信息失败!");
//    }

}
