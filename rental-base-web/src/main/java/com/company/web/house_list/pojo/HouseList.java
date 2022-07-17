package com.company.web.house_list.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseList
 * @company 公司
 * @Description 房屋表实体类
 * @createTime 2022年04月26日 21:47:47
 */
@Data
@TableName("house_list")
public class HouseList {

    /**
     * 房屋id
     */
    @TableId(type = IdType.AUTO)
    private Long houseId;

    /**
     * 栋数id,不属于house_list表，需要排除
     */
    @TableField(exist = false)
    private  Long buildId;

    /**
     * 单元id
     */
    private Long unitId;


    /**
     * 栋数名称,不属于house_list表，需要排除
     */
    @TableField(exist = false)
    private  String name;



    /**
     * 单元名称,不属于house_list表，需要排除
     */
    @TableField(exist = false)
    private  String unitName;

    /**
     * 房屋编号
     */
    private String houseNum;

    /**
     * 房屋面积
     */
     private String houseArea;


    /**
     * 房屋使用状态 0:未使用 1：已使用
     */
    private String status;
}
