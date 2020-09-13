package com.mzl.appointmentsystem.exception;

import com.mzl.appointmentsystem.enums.AppointStateEnum;

/**
 * @ClassName :   AppointException
 * @Description: 自定义的预约异常
 * @Author: 21989
 * @CreateDate: 2020/7/27 15:45
 * @Version: 1.0
 */
public class AppointException extends RuntimeException{

    public AppointException(String message){
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
