package com.company.web.fee_water.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 苏东坡
 */
@Data
@TableName("fee_water")
public class FeeWater implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long waterId;
    /**
     * 房屋id
     */
    private Long houseId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 所属月份
     */
    private String payWaterMonth;
    /**
     * 缴费金额
     */
    private BigDecimal payWaterMoney;
    /**
     * 表显
     */
    private String waterNum;
    /**
     * 缴费状态
     */
    private String payWaterStatus;
    /**
     * 缴费时间
     */
    private Date payWaterTime;
    //数据库没有的字段需要排除
    @TableField(exist = false)
    private String loginName;
    @TableField(exist = false)
    private String phone;
    @TableField(exist = false)
    private String houseNum;
    @TableField(exist = false)
    private String unitName;
    @TableField(exist = false)
    private Long buildId;
    @TableField(exist = false)
    private Long unitId;
    @TableField(exist = false)
    private String name;
}
