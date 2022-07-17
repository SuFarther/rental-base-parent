package com.company.config.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName CustomerAuthenionException
 * @company 公司
 * @Description token异常(自定义异常)
 * @createTime 2022年07月11日 06:38:38
 */
public class CustomerAuthenionException extends AuthenticationException {
    public CustomerAuthenionException(String msg) {
        super(msg);
    }
}