package com.mzl.appointmentsystem.service;

import com.mzl.appointmentsystem.dto.AppointExecution;
import com.mzl.appointmentsystem.entity.Appointment;
import com.mzl.appointmentsystem.entity.Book;
import com.mzl.appointmentsystem.entity.Student;

import java.util.List;

/**
 * @InterfaceName :   BookService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/7/27 14:48
 * @Version: 1.0
 */
public interface BookService {

    /***
     * 获取图书列表
     * @return
     */
    List<Book> getList(String bookName);

    /**
     * 用id查询书本信息
     * @param bookId
     * @return
     */
    Book getById(Integer bookId);

    /**
     * 验证学生（用id和密码）
     * @param student
     * @return
     */
    Student validateStu(Student student);

    /**
     * 执行预约
     * @param bookId
     * @param studentId
     * @return
     */
    AppointExecution appoint(int bookId, int studentId);

    /**
     * 通过id查询学生的自己预约的图书
     * @param studentId
     * @return
     */
    List<Appointment> getAppointByStu(int studentId);
}
