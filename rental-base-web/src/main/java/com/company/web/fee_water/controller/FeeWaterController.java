package com.company.web.fee_water.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.utils.ResultUtils;
import com.company.utils.ResultVo;
import com.company.web.fee_power.pojo.FeePower;
import com.company.web.fee_power.pojo.FeePowerParm;
import com.company.web.fee_water.pojo.FeeWater;
import com.company.web.fee_water.pojo.FeeWaterParm;
import com.company.web.fee_water.service.FeeWaterService;
import com.company.web.live_house.pojo.LiveHouse;
import com.company.web.live_house.service.LiveHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 水费管理模块
 * @author 苏东坡
 */
@RestController
@RequestMapping("/api/feeWater")
public class FeeWaterController {
    @Autowired
    private FeeWaterService feeWaterService;
    @Autowired
    private LiveHouseService liveHouseService;

    /**
     * 我的水费
     */
    @GetMapping("/getMyWaterFee")
    @PreAuthorize("hasAuthority('sys:myWaterFee')")
    public  ResultVo getMyWaterFee(FeeWaterParm FeeWaterParm){
        //构造分页对象
        IPage<FeeWater> page = new Page<>();
        page.setCurrent(FeeWaterParm.getCurrentPage());
        page.setSize(FeeWaterParm.getPageSize());
        //查询条件
        QueryWrapper<FeeWater> query = new QueryWrapper<>();
        query.lambda().eq(FeeWater::getUserId,FeeWaterParm.getUserId());
        IPage<FeeWater> list = feeWaterService.page(page, query);
        return ResultUtils.success("查询成功",list);
    }

    /**
     * 新增
     */
    @PostMapping
    @PreAuthorize("hasAuthority('sys:feeWater:add')")
    public ResultVo add(@RequestBody FeeWater feeWater){
        //根据房屋id查询正在使用该房间用户
        QueryWrapper<LiveHouse> query = new QueryWrapper<>();
        query.lambda().eq(LiveHouse::getHouseId,feeWater.getHouseId())
                .eq(LiveHouse::getUseStatus,"0");
        LiveHouse house = liveHouseService.getOne(query);
        if(house == null){
            return ResultUtils.error("该房间没有人使用，不能添加水费!");
        }
        //把查询出来的用户id设置到电费实体里面
        feeWater.setUserId(house.getUserId());
        feeWaterService.save(feeWater);
        return ResultUtils.success("新增水费成功!");
    }

    /**
     * 编辑
     */
    @PutMapping
    @PreAuthorize("hasAuthority('sys:feeWater:edit')")
    public ResultVo edit(@RequestBody FeeWater feeWater){
        //根据房屋id查询正在使用该房间用户
        QueryWrapper<LiveHouse> query = new QueryWrapper<>();
        query.lambda().eq(LiveHouse::getHouseId,feeWater.getHouseId())
                .eq(LiveHouse::getUseStatus,"0");
        LiveHouse house = liveHouseService.getOne(query);
        if(house == null){
            return ResultUtils.error("该房间没有人使用，不能编辑水费!");
        }
        //把查询出来的用户id设置到电费实体里面
        feeWater.setUserId(house.getUserId());
        feeWaterService.updateById(feeWater);
        return ResultUtils.success("编辑水费成功!");
    }

    /**
     * 删除
     */
    @DeleteMapping("/{waterId}")
    @PreAuthorize("hasAuthority('sys:feeWater:delete')")
    public ResultVo delete(@PathVariable("waterId") Long waterId){
        //如果已经缴费，就不能删除
        QueryWrapper<FeeWater> query = new QueryWrapper<>();
        query.lambda().eq(FeeWater::getWaterId,waterId).eq(FeeWater::getPayWaterStatus,"1");
        FeeWater one = feeWaterService.getOne(query);
        if(one != null){
            return ResultUtils.error("已缴费，不能删除!");
        }
        //删除操作
        boolean b = feeWaterService.removeById(waterId);
        if(b){
            return ResultUtils.success("删除水费成功!");
        }
        return ResultUtils.error("删除水费失败!");
    }

    /**
     * 列表查询
     */
    @GetMapping("/list")
    public ResultVo getList(FeeWaterParm parm){
        IPage<FeeWater> list = feeWaterService.getList(parm);
        return ResultUtils.success("查询成功",list);
    }

    /**
     * 缴费
     */
    @PostMapping("/payPower")
    @PreAuthorize("hasAuthority('sys:feeWater:pay')")
    public ResultVo payPower(@RequestBody FeeWater feeWater){
        //缴费时间
        feeWater.setPayWaterTime(new Date());
        feeWater.setPayWaterStatus("1");
        boolean b = feeWaterService.updateById(feeWater);
        if(b){
            return ResultUtils.success("缴费成功!");
        }
        return ResultUtils.error("缴费失败!");
    }
}
