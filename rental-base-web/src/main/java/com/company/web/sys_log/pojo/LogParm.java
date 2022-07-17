package com.company.web.sys_log.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author  苏东坡
 * @version 1.0
 * @ClassName LogParm
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月09日 20:41:41
 */
@Data
public class LogParm implements Serializable {
    private Long currentPage;
    private Long pageSize;
}
