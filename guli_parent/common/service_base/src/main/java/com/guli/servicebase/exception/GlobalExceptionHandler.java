package com.guli.servicebase.exception;

import com.guli.commonutils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zzy
 * @description: 异常处理类
 * @date 2023/11/1 21:46
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R doException(Exception e) {
        return R.error().message("全局异常");
    }

    @ExceptionHandler(GuliException.class)
    public R doGuliExceoptin(GuliException e) {
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
