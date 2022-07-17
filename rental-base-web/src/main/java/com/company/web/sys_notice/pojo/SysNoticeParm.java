package com.company.web.sys_notice.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName NoticeParm
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月08日 06:26:26
 */

@Data
public class SysNoticeParm implements Serializable {
    // 当前页
    private Long currentPage;
    // 页容量
    private Long pageSize;
    // 标题
    private  String title;
}
