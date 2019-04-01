package com.example.demo.exception;

/**
 * @Author: tianHui
 * 2018/10/8.15:11
 * 自定义异常类
 */
public class MyException extends Exception {

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}
