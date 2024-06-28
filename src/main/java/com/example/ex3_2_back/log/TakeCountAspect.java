package com.example.ex3_2_back.log;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class TakeCountAspect {

    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate redisTemplate;

    @Pointcut("@annotation(com.example.ex3_2_back.log.TakeCount) || @within(com.example.ex3_2_back.log.AutoTakeCount)")
    public void takeCountPointcut() {}

    @Before("takeCountPointcut()")
    public void doBefore(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        if (method.getDeclaringClass().isAnnotationPresent(AutoTakeCount.class) || method.isAnnotationPresent(TakeCount.class)) {
            //记录接口的开始时间
            long startTime = System.currentTimeMillis();
            //获取请求信息
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                String clientIp = request.getRemoteAddr();
                String url = request.getRequestURL().toString();
                String methodType = request.getMethod();
                String params = formatArgs(joinPoint.getArgs(), request);
                String currentTime = java.time.LocalDateTime.now().toString();

                //在方法进行之前添加日志
                log.info("接收到来自IP地址为 {} 的 {} 请求, 当前时间为：{}, 方法名为：{}，url：{}，参数：{}",
                        clientIp, methodType, currentTime, joinPoint.getSignature().getName(), url, params);

                //将开始时间记录到线程本地变量
                startTimeThreadLocal.set(startTime);
            }
        }
    }

    //用于保存开始时间的线程本地变量
    private ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();

    @AfterReturning(pointcut = "takeCountPointcut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        if (method.getDeclaringClass().isAnnotationPresent(AutoTakeCount.class) || method.isAnnotationPresent(TakeCount.class)) {
            //将当前的时间减去之前的时间，计算接口耗时
            long duration = System.currentTimeMillis() - startTimeThreadLocal.get();
            log.info("url为{}的接口调用时间：{}ms，接口返回值: {}",
                    getRequestUrl(), duration, result);
        }
    }

    @AfterThrowing(pointcut = "takeCountPointcut()", throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Exception exception) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        if (method.getDeclaringClass().isAnnotationPresent(AutoTakeCount.class) || method.isAnnotationPresent(TakeCount.class)) {
            long duration = System.currentTimeMillis() - startTimeThreadLocal.get();
            log.error("url为{}的接口调用时间：{}ms，发生异常：{}",
                    getRequestUrl(), duration, exception.getMessage(), exception);
        }
    }

    //获取当前HTTP请求的URL
    private String getRequestUrl() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            return request.getRequestURL().toString();
        }
        return null;
    }

    //格式化传入的参数，并将其转换为字符串
    private String formatArgs(Object[] args, HttpServletRequest httpServletRequest) {
        return Arrays.stream(args)
                .map(arg -> {
                    if (arg instanceof HttpServletRequest) {
                        HttpServletRequest request = (HttpServletRequest) arg;
                        return "HttpServletRequest{" +
                                "parameters=" + getParametersAsString(request) +
                                "}";
                    } else {
                        return String.valueOf(arg);
                    }
                })
                .collect(Collectors.joining(", "));
    }

    //获取HttpServletRequest中的参数，并将其转换为字符串
    private String getParametersAsString(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.isEmpty()) {
            return "";
        }
        return parameterMap.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + Arrays.toString(entry.getValue()))
                .collect(Collectors.joining(", "));
    }
}
