package com.company.aspect;

import com.baomidou.mybatisplus.core.toolkit.SystemClock;
import com.company.annotation.SysLog;
import com.company.utils.DateUtils;
import com.company.utils.IPHelper;
import com.company.utils.JsonToBeanUtils;
import com.company.utils.UUIDUtil;
import com.company.web.sys_log.SysLogTask.SysLogTask;
import com.company.web.sys_log.pojo.SysLogPojo;
import com.company.web.sys_log.service.SysLogService;
import com.company.web.user.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName SysLogAspect
 * @company 公司
 * @Description 日志切面类
 * @Aspect 注解用来描述一个切面类，定义切面类的时候需要打上这个注解
 * @Component 注解将该类交给 Spring 来管理
 * @createTime 2022年07月16日 13:42:42
 */

@Aspect
@Component
public class SysLogAspect {
    private static final ThreadLocal<SysLogPojo> threadLog = new NamedThreadLocal<>("log");

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogTask sysLogTask;
//    private SysLogService sysLogService;


    /**
     * 定义切面
     */
    @Pointcut("@annotation(com.company.annotation.SysLog)")
    public void pointAspect(){

    }
    /**
     * 前置通知：方法执行之前处理
     * @param joinPoint
     */
    @Before("pointAspect()")
    public void deBefore(JoinPoint joinPoint){
        //开始执行时间
        Date beginTime = new Date();
        //定义日志实体
        SysLogPojo sysLogPojo = new SysLogPojo();
        sysLogPojo.setLogId(UUIDUtil.getUniqueIdByUUId());
        //获取操作用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        sysLogPojo.setUserId(user.getUserId());
        sysLogPojo.setLoginName(user.getLoginName());
        sysLogPojo.setStartTime(beginTime);
        sysLogPojo.setCreateTime(new Date());
        //获取ip
        sysLogPojo.setIpNum(IPHelper.getIpAddr(request));
        sysLogPojo.setRemoteAddr(request.getRemoteAddr());
        //保存日志
//        sysLogService.save(sysLogPojo);
        sysLogTask.saveLog(sysLogPojo);
        threadLog.set(sysLogPojo);
    }

    /**
     * 后置通知：方法执行之后处理
     * @param joinPoint
     */
    @After("pointAspect()")
    public void doAfter(JoinPoint joinPoint){
        SysLogPojo sysLogPojo = threadLog.get();
        long now = SystemClock.now();
        sysLogPojo.setEndTime(DateUtils.parseDate(now));
        //获取请求的方法
        String name = joinPoint.getSignature().getName();
        sysLogPojo.setMethod(request.getMethod() + "-----"+name+"()");
        sysLogPojo.setRequestUri(request.getRequestURI());
        //获取切入点所在的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog annotation = method.getAnnotation(SysLog.class);
        if(annotation != null){
            sysLogPojo.setTitle(annotation.value());
        }
        //获取请求的参数
        Object[] args = joinPoint.getArgs();
        int length = args.length;
        if(length>0){
            String jsonString = JsonToBeanUtils.toJsonString(args[0]);
            //设置请求参数
            sysLogPojo.setParams(jsonString);
        }
        sysLogPojo.setType("0");
        //更新
        sysLogTask.updateLog(sysLogPojo);
//        sysLogService.updateById(sysLogPojo);
//        threadLog.set(sysLogPojo);
    }

    /**
     * 成功返回时的通知
     * @param res
     */
    @AfterReturning(returning = "res",pointcut = "pointAspect()")
    public void doReturn(Object res){
        SysLogPojo sysLogPojo = threadLog.get();
        if(sysLogPojo != null){
            sysLogPojo.setResultParams(JsonToBeanUtils.toJsonString(res));
            //更新
            sysLogTask.updateLog(sysLogPojo);
//            sysLogService.updateById(sysLogPojo);
//            threadLog.set(logEntity);
        }
    }

    /**
     * 异常时的通知
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "pointAspect()",throwing = "e")
    public void doException(JoinPoint joinPoint, Throwable e){
        SysLogPojo sysLogPojo = threadLog.get();
        if(sysLogPojo != null){
            sysLogPojo.setType("1");
            sysLogPojo.setException(e.toString());
            //更新
            sysLogTask.updateLog(sysLogPojo);
//            sysLogService.updateById(sysLogPojo);
//            threadLog.set(sysLogPojo);
        }
    }
}