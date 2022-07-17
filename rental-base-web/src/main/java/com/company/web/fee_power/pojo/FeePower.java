package com.company.web.fee_power.pojo;

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
 * @version 1.0
 * @ClassName FeePower
 * @company 公司
 * @Description TODO
 * @createTime 2022年06月24日 06:07:07
 */
@Data
@TableName("fee_power")
public class FeePower implements Serializable {

    /**
     * 电费id
     */
    @TableId(type = IdType.AUTO)
    private Long powerId;

    /**
     * 房屋id
     */
    private Long houseId;

    /**
     * 业主id
     */
    private Long userId;

    /**
     * 缴费年月
     */
    private String payPowerMonth;

    /**
     * 缴费金额
     */
    private BigDecimal payPowerMoney;


    /**
     * 表显
     */
    private String powerNum;

    /**
     * 缴费状态 0:未缴费  1：已缴费
     */
    private  String payPowerStatus;

    /**
     * 缴费时间
     */
    private Date payPowerTime;
    /**
     * 数据库没有的字段需要排除
     */
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
