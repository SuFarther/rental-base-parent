package com.company.web.sys_notice.pojo;

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
 * @ClassName Notice
 * @company 公司
 * @Description 公告管理实体类
 * @createTime 2022年07月08日 06:16:16
 */

@Data
@TableName("sys_notice")
public class SysNotice implements Serializable {

    /**
     * 公告id
     */
    @TableId(type = IdType.AUTO)
     private Long noticeId;


    /**
     *  用户id
     */
     private  Long userId;

    /**
     * 标题
     */
     private  String  title;

    /**
     * 内容
     */
    private  String noticeContent;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


}
