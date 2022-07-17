package com.company.web.house_building.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.utils.ResultUtils;
import com.company.utils.ResultVo;
import com.company.web.house_building.pojo.HouseBuilding;
import com.company.web.house_building.pojo.HouseBuildingParm;
import com.company.web.house_building.service.HouseBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseBuildingController
 * @company 公司
 * @Description 栋数的页面展示层控制器
 * @createTime 2022年04月25日 22:43:43
 */

@RestController
@RequestMapping("/api/HouseBuilding")
public class HouseBuildingController {

    @Autowired
    private HouseBuildingService houseBuildingService;

    /**
     * 表格列表
     * @param parm
     * @return
     */
    @GetMapping("/list")
    public ResultVo list(HouseBuildingParm parm){
        IPage<HouseBuilding> list = houseBuildingService.getList(parm);
        return ResultUtils.success("查询成功!",list);
    }

    /**
     * 给单元查询列表
     * @param
     * @return
     */
    @GetMapping("/unitList")
    public ResultVo unitList(){
        List<HouseBuilding> list = houseBuildingService.list();
        return ResultUtils.success("查询成功",list);
    }



    /**
     * 新增栋数
     * @param houseBuilding
     * @return
     */
    @PostMapping
    @PreAuthorize("hasAuthority('sys:houseBuilding:add')")
    public ResultVo save(@RequestBody HouseBuilding houseBuilding){
        boolean save = houseBuildingService.save(houseBuilding);
        if(save){
            return ResultUtils.success("新增楼栋成功！");
        }
        return ResultUtils.error("新增楼栋失败！");
    }


    /**
     * 编辑栋数
     * @param houseBuilding
     * @return
     */
    @PutMapping
    @PreAuthorize("hasAuthority('sys:houseBuilding:edit')")
    public ResultVo edit(@RequestBody HouseBuilding houseBuilding){
        boolean save = houseBuildingService.updateById(houseBuilding);
        if(save){
            return ResultUtils.success("编辑楼栋成功！");
        }
        return ResultUtils.error("编辑楼栋失败！");
    }

    /**
     * 删除栋数
     * @param buildId
     * @return
     */
    @DeleteMapping("/{buildId}")
    @PreAuthorize("hasAuthority('sys:houseBuilding:delete')")
    public ResultVo delete(@PathVariable("buildId") Long buildId){
        boolean b = houseBuildingService.removeById(buildId);
        if(b){
            return ResultUtils.success("删除楼栋成功！");
        }
        return ResultUtils.error("删除楼栋失败！");
    }

    /**
     * 批量删除栋数信息
     */
//    @DeleteMapping("/{buildIds}")
//    public ResultVo remove(@PathVariable Long[] buildIds){
//        int i = houseBuildingService.deleteBuildingsByIds(buildIds);
//        if(i > 0){
//            return ResultUtils.success("批量删除栋数信息成功！");
//        }
//        return ResultUtils.error("批量删除栋数信息失败！");
//    }
}
