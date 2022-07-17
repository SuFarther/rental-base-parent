package com.company.web.live_user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.utils.ResultUtils;
import com.company.utils.ResultVo;
import com.company.web.fee_park.pojo.FeePark;
import com.company.web.fee_park.service.FeeParkService;
import com.company.web.fee_power.pojo.FeePower;
import com.company.web.fee_power.service.FeePowerService;
import com.company.web.fee_water.pojo.FeeWater;
import com.company.web.fee_water.service.FeeWaterService;
import com.company.web.live_park.pojo.LivePark;
import com.company.web.live_user.pojo.AssignHouseParm;
import com.company.web.live_user.pojo.LiveUser;
import com.company.web.live_user.pojo.LiveUserParm;
import com.company.web.live_user.service.LiveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName LiveUserController
 * @company 公司
 * @Description TODO
 * @createTime 2022年06月14日 05:54:54
 */

@RestController
@RequestMapping("/api/liveUser")
public class LiveUserController {

    @Autowired
    private LiveUserService liveUserService;

    @Autowired
    private FeeWaterService feeWaterService;

    @Autowired
    private FeePowerService feePowerService;


    @Autowired
    private FeeParkService feeParkService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 业主列表查询
     * @param
     * @return
     */
    @GetMapping("/list")
    public  ResultVo getList(LiveUserParm liveUserParm){
        // 构造分页对象
        IPage<LiveUser> page = new Page<>();
        page.setSize(liveUserParm.getPageSize());
        page.setCurrent(liveUserParm.getCurrentPage());
        IPage<LiveUser> list = liveUserService.getList(page, liveUserParm.getLoginName(), liveUserParm.getPhone());
        return ResultUtils.success("查询业主列表成功!",list);
    }

    /**
     * 新增业主
     */
    @PostMapping
    @PreAuthorize("hasAuthority('sys:liveUser:add')")
    public ResultVo add(@RequestBody LiveUser liveUser){
        //查询登录名是否被占用
        QueryWrapper<LiveUser> query = new QueryWrapper<>();
        query.lambda().eq(LiveUser::getUsername,liveUser.getUsername());
        LiveUser one = liveUserService.getOne(query);
        if(one != null){
            return ResultUtils.error("登录名被占用!");
        }
        //用户名需要加密
//        liveUser.setPassword(DigestUtils.md5DigestAsHex(liveUser.getPassword().getBytes()));
        liveUser.setPassword(passwordEncoder.encode(liveUser.getPassword()));
        liveUserService.saveLiveUser(liveUser);
        return ResultUtils.success("新增业主成功!");
    }

    /**
     * 编辑业主
     */
    @PutMapping
    @PreAuthorize("hasAuthority('sys:liveUser:edit')")
    public ResultVo edit(@RequestBody LiveUser liveUser){
        //编辑判断登录名是否被占用
        //查询登录名是否被占用
        QueryWrapper<LiveUser> query = new QueryWrapper<>();
        query.lambda().eq(LiveUser::getUsername,liveUser.getUsername());
        LiveUser one = liveUserService.getOne(query);
        if(one != null && !one.getUserId().equals(liveUser.getUserId())){
            return ResultUtils.error("登录名被占用!");
        }
//        liveUser.setPassword(passwordEncoder.encode(liveUser.getPassword()));
        liveUserService.editLiveUser(liveUser);
        return ResultUtils.success("编辑成功!");
    }
    /**
     * 编辑查询回显
     */
    @GetMapping("/getUserById")
    public ResultVo getUserById( LiveUser liveUser){
        LiveUser user = liveUserService.getUser(liveUser.getUserId());
        return ResultUtils.success("查询成功",user);
    }
    /**
     * 分配房屋保存
     */
    @PostMapping("/assignSave")
    @PreAuthorize("hasAuthority('sys:liveUser:assignHome')")
    public ResultVo assignSave(@RequestBody AssignHouseParm parm){
        liveUserService.assignHouse(parm);
        return ResultUtils.success("分配房屋成功!");
    }

    /**
     * 分配车位保存
     */
    @PostMapping("/assignParkSave")
    @PreAuthorize("hasAuthority('sys:liveUser:assignCar')")
    public ResultVo assignParkSave(@RequestBody LivePark livePark){
        liveUserService.assignSavePark(livePark);
        return ResultUtils.success("分配车位成功!");
    }

    /**
     * 退房：
     *      1.查询电费、水费是否已经交清；
     *     2.更新租户和房屋关系表状态为解绑；
     *     3.更新房屋表的使用状态为未使用；
     */
    @PostMapping("/returnHouse")
    @PreAuthorize("hasAuthority('sys:liveUser:returnHome')")
    public ResultVo returnHouse(@RequestBody AssignHouseParm parm){
        //1.查询电费、水费是否交清
        //构造查询条件
        QueryWrapper<FeeWater> queryWater = new QueryWrapper<>();
        queryWater.lambda().eq(FeeWater::getHouseId,parm.getHouseId())
                .eq(FeeWater::getUserId,parm.getUserId())
                .eq(FeeWater::getPayWaterStatus,"0");
        List<FeeWater> list = feeWaterService.list(queryWater);
        if(list != null && list.size() >0){
            return ResultUtils.error("请缴水费之后再退房!");
        }
        //查询电费
        QueryWrapper<FeePower> queryPower = new QueryWrapper<>();
        queryPower.lambda().eq(FeePower::getHouseId,parm.getHouseId())
                .eq(FeePower::getUserId,parm.getUserId())
                .eq(FeePower::getPayPowerStatus,"0");
        List<FeePower> list1 = feePowerService.list(queryPower);
        if(list1 != null && list1.size() >0){
            return ResultUtils.error("请缴电费之后再退房!");
        }
        liveUserService.returnHouse(parm);
        return ResultUtils.success("退房成功!");
    }

    /**
     * 退车位
     *      1.查询车位费是否已经交清；
     *     2.更新租户和车位的关系为解绑；
     *     3.更新车位的使用状态为未使用；
     *
     */

    @PostMapping("/returnPark")
    @PreAuthorize("hasAuthority('sys:liveUser:returnCar')")
    public ResultVo returnPark(@RequestBody LivePark livePark){
   //     1.查询车位费是否已经交清；
        QueryWrapper<FeePark> query = new QueryWrapper<>();
        query.lambda().eq(FeePark::getParkId,livePark.getParkId())
                .eq(FeePark::getUserId,livePark.getUserId())
                .eq(FeePark::getPayParkStatus,"0");
        List<FeePark> list = feeParkService.list(query);
        if(list != null && list.size() >0){
            return ResultUtils.error("请缴清停车费后再退车位!");
        }
        liveUserService.returnPark(livePark);
        return ResultUtils.success("退车位成功!");
    }


    /**
     * 删除业主id
     */
    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('sys:liveUser:delete')")
    public ResultVo  delete(@PathVariable("userId") Long userId){
        boolean b = liveUserService.removeById(userId);
        if(b){
            return  ResultUtils.success("删除业主成功!");
        }
        return ResultUtils.error("删除业主失败!");
    }
}
