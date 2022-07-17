package com.company.web.sys_log.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author  苏东坡
 * @version 1.0
 * @ClassName SysLog
 * @company 公司
 * @Description 日志表实体类
 * @createTime 2022年07月09日 20:29:29
 */
@Data
@TableName("sys_log")
public class SysLogPojo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键 */
    @TableId
    private String logId;
    /**
     * 0:info  1: error
     */
    private String type;
    /**
     * 标题 */
    private String title;
    /**
     * 请求地址 */
    private String remoteAddr;
    /**
     * URI */
    private String requestUri;
    /**
     * 请求方法 */
    private String method;
    /**
     * 请求参数 */
    private String params;
    /**
     * 异常 */
    private String exception;
    /**
     * 开始时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    /**
     * 结束时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;
    /**
     * 用户id */
    private Long userId;
    /**
     * 姓名
     */
    private String loginName;
    /**
     * 返回参数 */
    private String resultParams;
    /**
     * ip号
     */
    private String ipNum;
    /**
     * 区域
     */
    private String ipRegion;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
