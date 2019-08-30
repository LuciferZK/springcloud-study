package com.lucifer.demo.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lucifer
 * @功能描述 防止重复提交标记注解
 * @date 2019-08-30
 */
@Target(ElementType.METHOD) // 作用到方法上
@Retention(RetentionPolicy.RUNTIME) // 运行时有效
public @interface NoRepeatSubmit {

    /**
     * 默认redis超时时间5秒
     *
     * @return
     */
    int timeout() default 5;
}
