package com.mzl.appointmentsystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;

/**
 * @ClassName :   Result
 * @Description: 数据传输，封装返回的结果到前端使用显示
 * @Author: 21989
 * @CreateDate: 2020/7/27 14:56
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class Result<T> {

    private boolean success;  //是否成功的标志
    private T data;   //成功时返回的数据
    private String error;  //错误信息

    //成功时的构造器
    public Result(boolean success, T data){
        this.success = success;
        this.data = data;
    }

    private boolean isSuccess(){
        return success;
    }


}
