package com.example.demo.exception;

import com.example.demo.utils.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: tianHui
 * 2018/10/8.15:13
 * 全局处理异常
 */
@RestControllerAdvice
public class ExceptionDeal {
    @ExceptionHandler(value = MyException.class)
    public Response errorHandler(Exception ex) {
        return Response.error("捕获到自定义抛出的异常！");

    }
}
