package com.mzl.appointmentsystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName :   Book
 * @Description: 书本
 * @Author: 21989
 * @CreateDate: 2020/7/27 14:43
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class Book {

    private int bookId;
    private String bookName;
    private int number;   //馆藏数量
    private String introd;  //书本简介

}
