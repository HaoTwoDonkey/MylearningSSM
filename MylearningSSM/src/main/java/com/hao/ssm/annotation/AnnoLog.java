package com.hao.ssm.annotation;

import java.lang.annotation.*;

/**
 * @author : hao
 * @description :
 * @time : 2018/3/16 11:01
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnoLog {
    
    /** Ҫִ�еĲ������ͱ��磺add���� **/
    public String operationType() default "";
}
