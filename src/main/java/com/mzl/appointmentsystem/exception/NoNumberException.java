package com.mzl.appointmentsystem.exception;

/**
 * @ClassName :   NoNumberException
 * @Description: 存库不足异常
 * @Author: 21989
 * @CreateDate: 2020/7/27 15:48
 * @Version: 1.0
 */
public class NoNumberException extends RuntimeException{

    public NoNumberException(String message) {
        super(message);
    }

    public NoNumberException(String message, Throwable cause){
        super(message, cause);
    }
}
