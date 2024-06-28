package com.example.ex3_2_back.exception;

import com.example.ex3_2_back.domain.Result;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("Error caught in global exception handler: {}", e.getMessage(), e);
        // 创建响应式Result对象，通常包含错误信息，这里可以进一步封装以只暴露有意义的错误信息给用户
        return Result.error("An error occurred").addErrors(e.toString());
    }

    // 可以添加更多的异常处理方法来处理不同类型的异常
}
