package com.company.web.house_list.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.utils.ResultUtils;
import com.company.utils.ResultVo;
import com.company.web.house_list.pojo.HouseList;
import com.company.web.house_list.pojo.HouseListParm;
import com.company.web.house_list.service.HouseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseListController
 * @company 公司
 * @Description 房屋管理控制器
 * @createTime 2022年04月26日 21:55:55
 */

@RestController
@RequestMapping("/api/houseList")
public class HouseListController {
    
    @Autowired
    private HouseListService houseListService;

    /**
     * 获取房屋列表
     * @param parm
     * @return
     */
    @GetMapping("/list")
    public ResultVo getList(HouseListParm parm){
        IPage<HouseList> list = houseListService.getList(parm);
        return ResultUtils.success("查询成功!",list);
    }

    /**
     * 新增房屋
     * @param houseList
     * @return
     */
    @PostMapping
    @PreAuthorize("hasAuthority('sys:house:add')")
    public ResultVo add(@RequestBody HouseList houseList){
        boolean save = houseListService.save(houseList);
        if(save){
            return ResultUtils.success("新增房屋成功!");
        }
        return ResultUtils.error("新增房屋失败!");
    }

    /**
     * 修改房屋
     * @param houseList
     * @return
     */
    @PutMapping
    @PreAuthorize("hasAuthority('sys:house:edit')")
    public ResultVo edit(@RequestBody HouseList houseList){
        boolean b = houseListService.updateById(houseList);
        if(b){
            return ResultUtils.success("修改房屋成功! ");
        }
        return ResultUtils.error("修改房屋失败!");
    }

    /**
     * 删除房屋
     * @param houseId
     * @return
     */
    @DeleteMapping("/{houseId}")
    @PreAuthorize("hasAuthority('sys:house:delete')")
    public ResultVo delete(@PathVariable("houseId") Long houseId){
        boolean b = houseListService.removeById(houseId);
        if(b){
            return ResultUtils.success("删除房屋成功!");
        }
        return ResultUtils.error("删除房屋失败!");
    }

    /**
     * 根据单元id获取房屋列表
     */
    @GetMapping("/getHouseByUnitId")
    public ResultVo getHouseByUnitId(HouseList houseList) {
        QueryWrapper<HouseList> query = new QueryWrapper<>();
        query.lambda().eq(HouseList::getUnitId,houseList.getUnitId());
        List<HouseList> list = houseListService.list(query);
        return ResultUtils.success("查询成功!",list);
    }
}
