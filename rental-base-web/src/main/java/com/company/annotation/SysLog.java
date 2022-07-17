package com.company.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName SysLog
 * @company 公司
 * @Description 日志注解
 * @interface自定义注解
 * @Target: 注解的作用目标 PARAMETER:方法参数 METHOD:方法
 * @Retention:注解的保留位置 RUNTIME 种类型的Annotations将被JVM保留,
 * 能在运行时被JVM或其他使用反射机制的代码所读取和使用
 * @createTime 2022年07月09日 20:55:55
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SysLog {
    /**
     * 业务操作描述 * @return */
    String value() default "";
}
