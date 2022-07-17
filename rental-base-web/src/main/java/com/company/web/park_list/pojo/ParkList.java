package com.company.web.park_list.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 车辆管理
 * @version 1.0
 * @ClassName ParkList
 * @company 公司
 * @Description TODO
 * @createTime 2022年06月02日 21:05:05
 */
@Data
@TableName("parking_list")
public class ParkList implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long parkId;
    /**
     * 车位类型 0：地上 1：地下
     */
    private String parkType;

    /**
     * 车位名称
     */
    private String parkName;

    /**
     * 使用状态 0：未使用 1：已使用
     */
     private String parkStatus;

    /**
     * 序号
     */
    private Long parkNum;

}
