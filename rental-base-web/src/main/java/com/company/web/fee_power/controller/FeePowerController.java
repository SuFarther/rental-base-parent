package com.company.web.fee_power.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.utils.ResultUtils;
import com.company.utils.ResultVo;
import com.company.web.fee_park.pojo.FeePark;
import com.company.web.fee_park.pojo.FeeParkParm;
import com.company.web.fee_power.pojo.FeePower;
import com.company.web.fee_power.pojo.FeePowerParm;
import com.company.web.fee_power.service.FeePowerService;
import com.company.web.live_house.pojo.LiveHouse;
import com.company.web.live_house.service.LiveHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName FeePowerController
 * @company 公司
 * @Description 电费管理控制器
 * @createTime 2022年06月24日 06:18:18
 */

/**
 * 电费管理控制器
 * @author zairensuyi
 */
@RestController
@RequestMapping("/api/feePower")
public class FeePowerController {
    @Autowired
    private FeePowerService feePowerService;
    @Autowired
    private LiveHouseService liveHouseService;

    /**
     * 我的电费
     */
    @GetMapping("/getMyPowerFee")
    @PreAuthorize("hasAuthority('sys:myPowerFee')")
    public  ResultVo getMyPowerFee(FeePowerParm feePowerParm){
        //构造分页对象
        IPage<FeePower> page = new Page<>();
        page.setCurrent(feePowerParm.getCurrentPage());
        page.setSize(feePowerParm.getPageSize());
        //查询条件
        QueryWrapper<FeePower> query = new QueryWrapper<>();
        query.lambda().eq(FeePower::getUserId,feePowerParm.getUserId());
        IPage<FeePower> list = feePowerService.page(page, query);
        return ResultUtils.success("查询成功",list);
    }

    /**
     * 新增
     */
    @PostMapping
    @PreAuthorize("hasAuthority('sys:feePower:add')")
    public ResultVo add(@RequestBody FeePower feePower){
        //根据房屋id查询正在使用该房间用户
        /**
         * 先通过电费表(fee_power)查询房屋表(house_id)的房屋id,在通过房屋表的房屋id
         * 查询租户和房屋表(live_house)房屋的使用状态(0:使用中 1： 解绑、退房)
         * 是否在使用,因为一个房屋对应多个租户
         */
        QueryWrapper<LiveHouse> query = new QueryWrapper<>();
        query.lambda().eq(LiveHouse::getHouseId,feePower.getHouseId())
                .eq(LiveHouse::getUseStatus,"0");
        LiveHouse house = liveHouseService.getOne(query);
        if(house == null){
            return ResultUtils.error("该房间没有人使用，不能添加电费!");
        }
        //把查询出来的用户id设置到电费实体里面
        feePower.setUserId(house.getUserId());
        feePowerService.saveFeePower(feePower);
        return ResultUtils.success("新增电费成功!");
    }

    /**
     * 编辑
     */
    @PutMapping
    @PreAuthorize("hasAuthority('sys:feePower:edit')")
    public ResultVo edit(@RequestBody FeePower feePower){
        //根据房屋id查询正在使用该房间用户
        QueryWrapper<LiveHouse> query = new QueryWrapper<>();
        query.lambda().eq(LiveHouse::getHouseId,feePower.getHouseId())
                .eq(LiveHouse::getUseStatus,"0");
        LiveHouse house = liveHouseService.getOne(query);
        if(house == null){
            return ResultUtils.error("该房间没有人使用，不能编辑电费!");
        }
        //把查询出来的用户id设置到电费实体里面
        feePower.setUserId(house.getUserId());
        feePowerService.updateFeePower(feePower);
        return ResultUtils.success("编辑电费成功!");
    }

    /**
     * 删除
     */
    @DeleteMapping("/{powerId}")
    @PreAuthorize("hasAuthority('sys:feePower:delete')")
    public ResultVo delete(@PathVariable("powerId") Long powerId){
        //如果已经缴费，就不能删除
        QueryWrapper<FeePower> query = new QueryWrapper<>();
        query.lambda().eq(FeePower::getPowerId,powerId).eq(FeePower::getPayPowerStatus,"1");
        FeePower one = feePowerService.getOne(query);
        if(one != null){
            return ResultUtils.error("已缴费，不能删除!");
        }
        //删除操作
        boolean b = feePowerService.removeById(powerId);
        if(b){
            return ResultUtils.success("删除电费成功!");
        }
        return ResultUtils.error("删除电费失败!");
    }

    /**
     * 列表查询
     */
    @GetMapping("/list")
    public ResultVo getList(FeePowerParm parm){
        IPage<FeePower> list = feePowerService.getList(parm);
        return ResultUtils.success("查询成功",list);
    }

    /**
     * 缴费
     */
    @PostMapping("/payPower")
    @PreAuthorize("hasAuthority('sys:feePower:pay')")
    public ResultVo payPower(@RequestBody FeePower feePower){
        boolean b = feePowerService.updateById(feePower);
        if(b){
            return ResultUtils.success("缴费成功!");
        }
        return ResultUtils.error("缴费失败!");
    }
}
