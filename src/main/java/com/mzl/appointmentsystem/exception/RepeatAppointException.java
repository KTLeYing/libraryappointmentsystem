package com.mzl.appointmentsystem.exception;

/**
 * @ClassName :   RepeatAppointException
 * @Description: 重复预约异常
 * @Author: 21989
 * @CreateDate: 2020/7/27 15:51
 * @Version: 1.0
 */
public class RepeatAppointException extends RuntimeException{

    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
