package com.mzl.appointmentsystem.dao;

import com.mzl.appointmentsystem.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName :   AppointmentDao
 * @Description: 预约dao
 * @Author: 21989
 * @CreateDate: 2020/7/27 14:54
 * @Version: 1.0
 */
@Mapper
public interface AppointmentDao {

    /**
     * 执行预约操作
     * @param bookId
     * @param studentId
     * @return
     */
    int insertAppointment(@Param("bookId") int bookId, @Param("studentId") int studentId);

    /**
     * 通过id查询学生的自己预约的图书
     * @param studentId
     * @return
     */
    List<Appointment> queryAndReturn(int studentId);
}
