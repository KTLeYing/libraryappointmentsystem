package com.mzl.appointmentsystem.dao;

import com.mzl.appointmentsystem.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName :   StudentDao
 * @Description: 学生dao
 * @Author: 21989
 * @CreateDate: 2020/7/27 14:53
 * @Version: 1.0
 */
@Mapper
public interface StudentDao {

    /**
     * 验证学生（用id和密码）
     * @param student
     * @return
     */
    Student validateStu(Student student);

}
