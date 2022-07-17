package com.company.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author  苏东坡
 * @version 1.0
 * @ClassName ResultVo
 * @company 公司
 * @Description TODO
 * @Data 自动生成get 和 set 方法
 * @AllArgsConstructor 自动生成构造函数
 * @createTime 2022年01月10日 14:49:49
 */
@Data
@AllArgsConstructor
public class ResultVo<T> {
    private String msg;
    private int code;
    private T data;
}
