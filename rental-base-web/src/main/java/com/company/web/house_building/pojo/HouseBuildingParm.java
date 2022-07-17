package com.company.web.house_building.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName HouseBuildingParm
 * @company 公司
 * @Description 栋数的参数实体
 * @createTime 2022年04月25日 22:23:23
 */
@Data
public class HouseBuildingParm implements Serializable {


    private String name;

    private String type;


    /**
     * 页容量
     */
    private  Long pageSize;

    /**
     * 当前页
     */
    private  Long currentPage;
}
