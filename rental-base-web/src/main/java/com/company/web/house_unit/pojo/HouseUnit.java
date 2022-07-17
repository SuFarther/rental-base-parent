package com.company.web.house_unit.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseUnit
 * @company 公司
 * @Description 房屋单元表实体类
 * @createTime 2022年04月26日 08:25:25
 */
@Data
@TableName("house_unit")
public class HouseUnit implements Serializable {

    /**
     * 单元id
     */
    @TableId(type = IdType.AUTO)
    private  Long unitId;

    /**
     * 栋数id
     */
    private Long buildId;

    /**
     * 单元名称
     */
    private String unitName;


    /**
     * 栋数名称
     * 表明name字段不属于表house_unit里面的字段
     */
    @TableField(exist = false)
    private  String name;
}
