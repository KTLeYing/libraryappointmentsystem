package com.mzl.appointmentsystem.service.impl;

import com.mzl.appointmentsystem.dao.AppointmentDao;
import com.mzl.appointmentsystem.dao.BookDao;
import com.mzl.appointmentsystem.dao.StudentDao;
import com.mzl.appointmentsystem.dto.AppointExecution;
import com.mzl.appointmentsystem.entity.Appointment;
import com.mzl.appointmentsystem.entity.Book;
import com.mzl.appointmentsystem.entity.Student;
import com.mzl.appointmentsystem.enums.AppointStateEnum;
import com.mzl.appointmentsystem.exception.AppointException;
import com.mzl.appointmentsystem.exception.NoNumberException;
import com.mzl.appointmentsystem.exception.RepeatAppointException;
import com.mzl.appointmentsystem.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName :   BookServiceImpl
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/7/27 14:50
 * @Version: 1.0
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookDao bookDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private AppointmentDao appointmentDao;

    /**
     * 获取图书列表
     * @return
     */
    @Override
    public List<Book> getList(String bookName) {
        return bookDao.queryAll(0, 1000, bookName);
    }

    /**
     * 用id查询书本信息
     * @param bookId
     * @return
     */
    @Override
    public Book getById(Integer bookId) {
        return bookDao.getById(bookId);
    }

    /**
     * 验证学生（用id和密码）
     * @param student
     * @return
     */
    @Override
    public Student validateStu(Student student) {
        return studentDao.validateStu(student);
    }

    /**
     * 执行预约
     * @param bookId
     * @param studentId
     * @return
     */
    @Override
    public AppointExecution appoint(int bookId, int studentId) {
        //在Dao层的基础上组织逻辑，形成与Web成交互用的方法
        try {
            //返回预约的类型
            //减少库存
            int update = bookDao.reduceNumber(bookId);
            if(update <= 0){//已经无库存！
                throw new NoNumberException("no number");
            }else {
                //执行预约操作
                int insert = appointmentDao.insertAppointment(bookId, studentId);
                if (insert <= 0){  //预约失败，重新预约
                    throw new RepeatAppointException("reeat appoint");
                }else {
                    //预约成功
                    return new AppointExecution(bookId,AppointStateEnum.SUCCESS);
                }
            }
        } catch (NoNumberException e1) {
            throw e1;
        }catch (RepeatAppointException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage());
            //所有编译期异常转换为运行期异常
            throw new AppointException("appoint inner error:" + e.getMessage());
        }
    }

    /**
     * 通过id查询学生的自己预约的图书
     * @param studentId
     * @return
     */
    @Override
    public List<Appointment> getAppointByStu(int studentId) {
        System.out.println("uuuuu");
        return appointmentDao.queryAndReturn(studentId);
    }

}
