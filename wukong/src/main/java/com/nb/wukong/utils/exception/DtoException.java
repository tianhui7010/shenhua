package com.nb.wukong.utils.exception;

import com.nb.wukong.utils.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * dto传参异常
 */
@RestControllerAdvice
public class DtoException extends Exception {

    public DtoException() {
        super();
    }

    public DtoException(String message) {
        super(message);
    }

    /**
     * 全局捕获异常
     */
    @ExceptionHandler(value = DtoException.class)
    public Response errorHandler(Exception ex) {

        return Response.error(ex.getMessage());

    }
}
