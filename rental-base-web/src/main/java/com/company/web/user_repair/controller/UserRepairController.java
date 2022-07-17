package com.company.web.user_repair.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.utils.ResultUtils;
import com.company.utils.ResultVo;
import com.company.web.user_repair.pojo.UserRepair;
import com.company.web.user_repair.pojo.UserRepairParm;
import com.company.web.user_repair.service.UserRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserRepairController
 * @company 公司
 * @Description 维修管理控制器
 * @createTime 2022年07月07日 15:42:42
 */

@RestController
@RequestMapping("/api/userRepair")
public class UserRepairController {

    @Autowired
    private UserRepairService userRepairService;


    /**
     * 我的报修列表
     */
    @GetMapping("/myList")
    public ResultVo getMyList(UserRepairParm userRepairParm){
        // 构造查询条件
        QueryWrapper<UserRepair> query = new QueryWrapper<>();
        query.lambda().eq(UserRepair::getUserId,userRepairParm.getUserId())
                .like(UserRepair::getRepairContent,userRepairParm.getRepairContent())
                .orderByDesc(UserRepair::getCommitTime);
        //构造分页对象
        IPage<UserRepair> page = new Page<>();
        page.setSize(userRepairParm.getPageSize());
        page.setCurrent(userRepairParm.getCurrentPage());
        IPage<UserRepair> list = userRepairService.page(page, query);
        return ResultUtils.success("查询成功",list);
    }

    /**
     * 报修列表(物业管理部人员)
     */
    @GetMapping("/list")
    public ResultVo getList(UserRepairParm userRepairParm){
        //构造查询条件
        QueryWrapper<UserRepair> query = new QueryWrapper<>();
        query.lambda().like(UserRepair::getRepairContent,userRepairParm.getRepairContent())
                .orderByDesc(UserRepair::getCommitTime);
        //构造分页对象
        IPage<UserRepair> page = new Page<>();
        page.setSize(userRepairParm.getPageSize());
        page.setCurrent(userRepairParm.getCurrentPage());
        IPage<UserRepair> list = userRepairService.page(page, query);
        return ResultUtils.success("查询成功",list);
    }


    /**
     * 新增
     */
    @PostMapping
    @PreAuthorize("hasAuthority('sys:myRepair:add')")
    public ResultVo add(@RequestBody UserRepair userRepair){
        userRepair.setCommitTime(new Date());
        userRepair.setStatus("0");
        boolean save = userRepairService.save(userRepair);
        if(save) {
            return ResultUtils.success("新增我的维修列表成功!");
        }
        return ResultUtils.error("新增我的维修列表失败!");
    }

    /**
     * 编辑维修 @PreAuthorize("hasAuthority('sys:myRepair:edit')"）
     * 处理维修 @PreAuthorize("hasAuthority('sys:repairList:do')"）
     */
    @PutMapping
    @PreAuthorize("hasAuthority('sys:myRepair:edit')" + "|| hasAuthority('sys:repairList:do')")
    public ResultVo edit(@RequestBody UserRepair userRepair){
        boolean b = userRepairService.updateById(userRepair);
        if(b) {
            return ResultUtils.success("编辑我的维修列表成功!");
        }
        return ResultUtils.error("编辑我的维修列表失败!");
    }

    /**
     * 删除id
     */
    @DeleteMapping("/{repairId}")
    @PreAuthorize("hasAuthority('sys:myRepair:delete')")
    public ResultVo delete(@PathVariable("repairId") Long repairId){
        boolean b = userRepairService.removeById(repairId);
        if(b) {
            return  ResultUtils.success("删除我的维修列表成功!");
        }
        return ResultUtils.error("删除我的维修列表失败!");
    }
}
