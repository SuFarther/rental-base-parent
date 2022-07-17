package com.company.web.live_house.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName LiveHouse
 * @company 公司
 * @Description 业主跟房屋关系表
 * @createTime 2022年06月11日 18:37:37
 */

@Data
@TableName("live_house")
public class LiveHouse implements Serializable {


    /**
      * 业主和房屋关系id
     */
    @TableId(type= IdType.AUTO)
    private Long liveHouseId;

    /**
     * 业主id
     */
    private Long userId;

    /**
     * 房屋id
     *
     */
    private Long houseId;

    /**
     * 使用状态 0:未使用 1: 已使用
     */
    private String useStatus;
}
