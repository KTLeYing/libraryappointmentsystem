package com.mzl.appointmentsystem.dao;

import com.mzl.appointmentsystem.entity.Book;
import com.mzl.appointmentsystem.entity.Student;
import com.mzl.appointmentsystem.exception.AppointException;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @InterfaceName :   BookDao
 * @Description: 书本dao
 * @Author: 21989
 * @CreateDate: 2020/7/27 14:54
 * @Version: 1.0
 */
@Mapper
public interface BookDao {

    /**
     * 获取图书列表
     * @param offset
     * @param limit
     * @return
     */
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit, @Param("bookName") String bookName);

    /**
     * 用id查询书本信息
     * @param bookId
     * @return
     */
    Book getById(Integer bookId);

    /**
     * 减少库存
     * @param bookId
     * @return
     */
    int reduceNumber(int bookId);
}
