package com.hao.ssm.interceptor;

import com.hao.ssm.annotation.AnnoLog;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**
 * @author : hao
 * @description :  ������־����
 * @time : 2018/3/16 11:02
 */
@Aspect
@Component
public class LogInterceptor {

    private static final Logger logger = Logger.getLogger(LogInterceptor.class);
    //���������� ������com.hao.ssm�����Ӱ� ���Һ���annoLogע��
    @Around("within(com.hao.ssm..*) && @annotation(annoLog)")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint, AnnoLog annoLog) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object[] params = proceedingJoinPoint.getArgs();
        logger.debug("ִ�з���ǰ��ȡ���Ĳ�����");
        for (Object param : params) {
            logger.debug(":" + param + "\r");

        }

        Object result = proceedingJoinPoint.proceed();
        logger.debug("���صĽ����" + result);


        String optType = annoLog.operationType();
        logger.debug("�������ͣ�" + optType);

        long endTime = System.currentTimeMillis();//����ʱ��
        float excTime = (float) (endTime - startTime) / 1000;

        logger.debug("ִ��ʱ��:" + excTime + "s");
        System.currentTimeMillis();

        return result;
    }
}
