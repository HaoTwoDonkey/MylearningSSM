package com.hao.ssm.interceptor;

import com.hao.ssm.annotation.AnnoLog;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**
 * @author : hao
 * @description :  定义日志切面
 * @time : 2018/3/16 11:02
 */
@Aspect
@Component
public class LogInterceptor {

    private static final Logger logger = Logger.getLogger(LogInterceptor.class);
    //切面条件是 必须是com.hao.ssm包及子包 并且含有annoLog注解
    @Around("within(com.hao.ssm..*) && @annotation(annoLog)")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint, AnnoLog annoLog) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object[] params = proceedingJoinPoint.getArgs();
        logger.debug("执行方法前获取到的参数：");
        for (Object param : params) {
            logger.debug(":" + param + "\r");

        }

        Object result = proceedingJoinPoint.proceed();
        logger.debug("返回的结果：" + result);


        String optType = annoLog.operationType();
        logger.debug("操作类型：" + optType);

        long endTime = System.currentTimeMillis();//结束时间
        float excTime = (float) (endTime - startTime) / 1000;

        logger.debug("执行时间:" + excTime + "s");
        System.currentTimeMillis();

        return result;
    }
}
