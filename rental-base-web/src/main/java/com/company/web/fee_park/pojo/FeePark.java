package com.company.web.fee_park.pojo;

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
 * @ClassName FeePark
 * @company 公司
 * @Description 停车位缴费
 * @createTime 2022年07月01日 04:43:43
 */

@Data
@TableName("fee_park")
public class FeePark implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long parkFeeId;

    /**
     * 租户id
     */
     private Long userId;

    /**
     * 车位id
     */
    private  Long parkId;

    /**
     * 缴费年月
     */
    private String payParkMonth;

    /**
     * 缴费金额
     */
    private BigDecimal payParkMoney;

    /**
     * 缴费状态 0:未缴费  1：已缴费
     */
     private String  payParkStatus;


    /**
     * 缴费时间
     */
     private Date payParkTime;

    /**
     * 数据库没有的字段需要排除
     */
    @TableField(exist = false)
    private String loginName;
    @TableField(exist = false)
    private String phone;
    @TableField(exist = false)
    private String parkName;
    @TableField(exist = false)
    private String parkType;


}
