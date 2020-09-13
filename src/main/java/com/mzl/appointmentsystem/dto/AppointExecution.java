package com.mzl.appointmentsystem.dto;

import com.mzl.appointmentsystem.enums.AppointStateEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName :   AppointExecution
 * @Description: 预约传输对象，前后端的数据封装传输，用于前端的显示，和controller的Model的数据封装作用类似
 * @Author: 21989
 * @CreateDate: 2020/7/27 15:30
 * @Version: 1.0
 */
//@Data
//@NoArgsConstructor
public class AppointExecution {

    private int bookId;  //图书id
    private int state;   //秒杀预约结果状态
    private String stateInfo;   //状态标识

    // 预约失败的构造器
    public AppointExecution(int bookId, AppointStateEnum stateEnum) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //set get 方法！
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {
        return "AppointExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
