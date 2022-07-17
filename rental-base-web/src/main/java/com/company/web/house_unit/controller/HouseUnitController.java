package com.company.web.house_unit.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.utils.ResultUtils;
import com.company.utils.ResultVo;
import com.company.web.house_unit.pojo.HouseUnit;
import com.company.web.house_unit.pojo.HouseUnitParm;
import com.company.web.house_unit.service.HouseUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseUnitController
 * @company 公司
 * @Description 房屋单元表控制器
 * @createTime 2022年04月26日 21:22:22
 */
@RestController
@RequestMapping("/api/houseUnit")
public class HouseUnitController {

    @Autowired
    private HouseUnitService houseUnitService;


    /**
     *  获取单元列表
     */
    @GetMapping("/list")
    public ResultVo getList(HouseUnitParm houseUnitParm){
        IPage<HouseUnit> list = houseUnitService.getList(houseUnitParm);
        return ResultUtils.success("查询成功!",list);
    }


    /**
     * 新增单元
     * @param houseUnit
     * @return
     */

    @PostMapping
    @PreAuthorize("hasAuthority('sys:houseUnit:add')")
    public  ResultVo save(@RequestBody HouseUnit houseUnit){
        boolean save = houseUnitService.save(houseUnit);
        if(save){
            return ResultUtils.success("新增单元成功!");
        }
        return ResultUtils.error("新增单元失败!");
    }

    /**
     * 修改单元
     * @param houseUnit
     * @return
     */
    @PutMapping
    @PreAuthorize("hasAuthority('sys:houseUnit:edit')")
    public  ResultVo edit(@RequestBody HouseUnit houseUnit){
        boolean b = houseUnitService.updateById(houseUnit);
        if(b){
            return ResultUtils.success("修改单元成功!");
        }
        return ResultUtils.error("修改单元失败!");
    }


    /**
     * 删除单元
     * @param unitId
     * @return
     */
    @DeleteMapping("/{unitId}")
    @PreAuthorize("hasAuthority('sys:houseUnit:delete')")
    public ResultVo delete(@PathVariable("unitId") Long unitId){
        boolean b = houseUnitService.removeById(unitId);
        if(b){
            return ResultUtils.success("删除单元成功!");
        }
        return  ResultUtils.error("删除单元失败!");
    }

    /**
     * 根据栋数id查询单元列表
     */
    @GetMapping("/getUnitListByBuildId")
    public ResultVo getUnitListByBuildId(HouseUnit houseUnit){
        // 构造查询条件
        QueryWrapper<HouseUnit> query = new QueryWrapper<>();
        query.lambda().eq(HouseUnit::getBuildId,houseUnit.getBuildId());
        List<HouseUnit> list = houseUnitService.list(query);
        return ResultUtils.success("查询成功",list);
    }
}
