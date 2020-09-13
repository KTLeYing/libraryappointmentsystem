package com.mzl.appointmentsystem.controller;

import com.mzl.appointmentsystem.dto.AppointExecution;
import com.mzl.appointmentsystem.dto.Result;
import com.mzl.appointmentsystem.entity.Appointment;
import com.mzl.appointmentsystem.entity.Book;
import com.mzl.appointmentsystem.entity.Student;
import com.mzl.appointmentsystem.enums.AppointStateEnum;
import com.mzl.appointmentsystem.exception.AppointException;
import com.mzl.appointmentsystem.exception.NoNumberException;
import com.mzl.appointmentsystem.exception.RepeatAppointException;
import com.mzl.appointmentsystem.service.AppointmentService;
import com.mzl.appointmentsystem.service.BookService;
import com.mzl.appointmentsystem.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

/**
 * @ClassName :   BookController
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/7/27 14:47
 * @Version: 1.0
 */
@Controller
@RequestMapping("/book")
public class BookController {

    //创建日志输出du==对象，在日志工厂里获取
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入依赖
    @Autowired
    private BookService bookService;

    /**
     * 获取图书列表
     * @param model
     * @return
     */
    @RequestMapping("/list")  //不指定get和post方式，两种否可以使用，如果指定了某种请求方式，则只能使用那一种方式，不然会报405错误
    public String list(Model model, String bookName){
        System.out.println(bookName);
        List<Book> list = bookService.getList(bookName);
        model.addAttribute("list", list);
        model.addAttribute("bookName", bookName);
        System.out.println(list);
        return "list";
    }

    @GetMapping("/{bookId}/detail")
    public String detail(@PathVariable("bookId") Integer bookId, Model model){
        if(bookId == null){
            return "redirect:/book/list";
        }
        //用id查询书本信息
        Book book = bookService.getById(bookId);
        System.out.println(book);
        if (book == null){
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    /**
     * 验证学生（用id和密码）
     * @param student
     * @return
     */
    @PostMapping("/verify")
    @ResponseBody
    public Map validate(Student student){
        System.out.println(student);
        HashMap resultMap = new HashMap();
        System.out.println(student);
        Student student1 = bookService.validateStu(student);
        if (student1 != null){
            resultMap.put("result", "SUCCESS");
            System.out.println("resultMap:" + resultMap);
            return resultMap;
        }else {
            resultMap.put("result", "FAILED");
            System.out.println("resultMap:" + resultMap);
            return resultMap;
        }
    }

    /**
     * 执行预约
     * @param bookId
     * @param studentId
     * @return
     */
    @PostMapping("/{bookId}/appoint")
    @ResponseBody
    public Result<AppointExecution> execute(@PathVariable("bookId") int bookId, int studentId){
        Result<AppointExecution> result;
        AppointExecution execution = null;
        //可能appoint会报错
        try {
            execution = bookService.appoint(bookId, studentId);
            result = new Result<AppointExecution>(true, execution);
            return result;
        } catch (NoNumberException e1) {
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
            result = new Result<AppointExecution>(true, execution);
            return result;
        }catch (RepeatAppointException e2){
            execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
            result = new Result<AppointExecution>(true, execution);
            return result;
        }catch (Exception e){
            execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
            result = new Result<AppointExecution>(true, execution);
            return result;
        }
    }

    /**
     * 通过id查询学生的自己预约的图书
     * @param studentId
     * @param model
     * @return
     */
    @GetMapping("/appoint")
    public String appointBookS(int studentId, Model model){
        System.out.println("studentId:" + studentId);
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        appointmentList = bookService.getAppointByStu(studentId);
        System.out.println(appointmentList);
        model.addAttribute("appointList", appointmentList);
        return "appointBookList";
    }

}
