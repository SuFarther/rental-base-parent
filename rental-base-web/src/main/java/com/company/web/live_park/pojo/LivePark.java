package com.company.web.live_park.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName LivePark
 * @company 公司
 * @Description 租户和车位关系表
 * @createTime 2022年06月11日 18:22:22
 */
@Data
@TableName("live_park")
public class LivePark implements Serializable {


    /**
     * 租户车位关系表
     */
    @TableId(type = IdType.AUTO)
    private Long liveParkId;

    /**
     * 业主id
     */
    private Long userId;


    /**
     * 车位id
     */
    private Long parkId;


    /**
     * 使用状态 0:使用 1：解绑、退车位状态
     */
     private String liveStatus;

}
