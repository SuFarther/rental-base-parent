package com.company.web.user_complaint.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;



import java.io.Serializable;
import java.util.Date;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName Complaint
 * @company 公司
 * @Description 投诉实体类
 * @createTime 2022年07月04日 04:37:37
 */
@Data
@TableName("user_complaint")
public class UserComplaint implements Serializable {


    /**
     * 投诉id
     */
    @TableId(type= IdType.AUTO)
    private Long complaintId;

    /**
     * 业主id(投诉人id)
     */
    private Long userId;

    /**
     * 标题
     */
     private String title;

    /**
     * 投诉内容
     */
     private String complaintContent;

    /**
     * 投诉时间
     */
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;


    /**
     * 投诉处理状态 0：未处理 1:已处理
     */
    private String status;
}
