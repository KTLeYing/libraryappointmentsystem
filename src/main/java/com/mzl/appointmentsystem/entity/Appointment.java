package com.mzl.appointmentsystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName :   Appointment
 * @Description: 预约
 * @Author: 21989
 * @CreateDate: 2020/7/27 14:40
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class Appointment {

    private int appoiId;
    private int bookId;
    private int studentId;
    private String appointTime;
    //多对一,一个学生可以预约多本书
    private Book book;

}
