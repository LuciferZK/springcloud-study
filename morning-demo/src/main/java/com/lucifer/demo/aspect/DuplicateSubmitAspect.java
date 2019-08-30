package com.lucifer.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author: lucifer
 * @date: 2019/8/30
 * @description: 高并发下，防止接口短时间内重复调用
 */
@Aspect
@Component
@Slf4j
public class DuplicateSubmitAspect {

    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @Around("execution(* com.lucifer.demo.controller.*.*(..)) && @annotation(nrs)")
    public Object around(ProceedingJoinPoint joinPoint, NoRepeatSubmit nrs) {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
            HttpServletRequest request = attributes.getRequest();
            String key = sessionId + "-" + request.getServletPath();
            log.debug("key:" + key);
            // 如果缓存中有这个url视为重复提交
            Long increment = redisTemplate.opsForValue().increment(key, 1);
            log.debug("increment:", increment);
            if (increment == 1) {
                //设置过期时间
                redisTemplate.expire(key, nrs.timeout(), TimeUnit.SECONDS);
            }
            if (increment > 1) {
                throw new RuntimeException("请求过于频繁，请稍后重试");
            }
            //执行目标方法
            Object proceed = joinPoint.proceed();
            return proceed;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (Throwable e) {
            e.printStackTrace();
            logger.error("验证重复提交时出现未知异常!");
            throw new RuntimeException("验证重复提交时出现未知异常");
        }
    }
}
