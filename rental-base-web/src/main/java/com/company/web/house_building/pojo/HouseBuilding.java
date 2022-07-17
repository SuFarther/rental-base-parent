package com.company.web.house_building.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseBuilding
 * @company 公司
 * @Description 栋数的实体
 * @createTime 2022年04月25日 22:23:23
 */
@Data
@TableName("house_building")
public class HouseBuilding implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long buildId;

    /**
     * 0：普通房 1： 电梯房
     */
    private String type;

    /**
     * 栋数名称
     */
    private String name;

    /**
     * 序号
     */
    private  Long orderNum;
}
