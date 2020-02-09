package com.example.controller;

import com.example.DemoApplication;
import com.example.StudentDAO.StudentRepository;
import com.example.StudentDomain.StudentBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    public static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    StudentRepository studentRepository;

    //    用户登录页面
    @RequestMapping(value = "/dashboard")
    public String entry() {
        return "dashboard";
    }

    //查询所有学生返回列表页面
    @GetMapping("/students")
    public ModelAndView getStudents() {
        List<StudentBean> stuInfo = studentRepository.findAll();
//model的attribute和object方法添加的值用于传入还是传出？
        ModelAndView model = new ModelAndView();
        model.setViewName("/student/list");
        log.info("\n成功跳转到列表方法getStudents()");

        model.addObject("stuViewInfo", stuInfo);

//分页传数据未完成
    	/*int page=1,size=2;

    	Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        model.addAttribute("users", pageable);*/
        return model;
//        return "/student/list";
    }
    //get来到学生查询页面
    @GetMapping("/somestudents")
    public ModelAndView searchStu(HttpServletRequest req) {
        String searText=(req.getParameter("query")).trim();
//        入参@RequestParam(value ="query") String searText
        ModelAndView stuSearModel = new ModelAndView();
        stuSearModel.setViewName("/student/list");
        if (searText.matches("[\\u4e00-\\u9fa5]+")) {
            List<StudentBean> stuInfo = studentRepository.findAllStuByChinese(searText);
            log.info("\n成功跳转到查询方法()");
            stuSearModel.addObject("stuViewInfo", stuInfo);
        } else if (searText.matches("[a-zA-Z]+") || searText.matches("[0-9]+")) {
            List<StudentBean> stuInfo = studentRepository.findAllStuByNumOrLet(searText);
            log.info("\n成功跳转到查询方法()");
            stuSearModel.addObject("stuViewInfo", stuInfo);
        } else {
            List<StudentBean> stuInfo1 = studentRepository.findAllStuByChinese(searText);
            List<StudentBean> stuInfo2 = studentRepository.findAllStuByNumOrLet(searText);
            stuInfo1.addAll(stuInfo2);
            log.info("\n成功跳转到查询方法()");
            stuSearModel.addObject("stuViewInfo", stuInfo1);
        }
        return stuSearModel;
//        return "/student/list";
    }
    //get来到学生添加页面
    @GetMapping("/student")
    public String toAddPage() {
        //来到添加页面,查出所有的部门，在页面显示
//        ModelAndView mv = new ModelAndView();
//        List<StudentBean> stuInfo = studentRepository.findAll();
//        mv.addObject("stuViewInfo", stuInfo);
//                mv.setViewName("list");
        return "student/add";
    }

    //post学生添加,从表单绑定实体数据
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/student")
    public String addStu(@Valid StudentBean student) {
        //来到员工列表页面
        log.info("\n保存的学生信息：" + student);
        //保存员工
        studentRepository.save(student);
        //由于模板引擎会拼串不能直接返回路径需要 redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
//        this.getStudents();
        return "redirect:/students";
    }

    //    get到学生修改页面
    @GetMapping("/student/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        log.info("\n进入get修改方法");

        StudentBean stuEdit = studentRepository.getOne(id);
        //回显到add页面参数需要保存修改的bean stuEdit
        model.addAttribute("student", stuEdit);

        //页面要显示所有的部门列表
//        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "student/add";
//        return "redirect:/student";
    }

    //    put提交修改后到学生列表页面
    @PutMapping(value = {"/student/{id}"})
    public String putStudent(@PathVariable("id") Integer id,StudentBean stuEditBe) {
        StudentBean oldStu=studentRepository.getOne(id);
        log.info("\n进入put修改方法,旧数据:\n"+oldStu);

//        if(!(){
        log.info("\n进入save保存");
//        oldStu=stuEditBe;//赋值新变量
//        studentRepository.save(stuEditBe);
//        if(id!=stuEditBe.getId()){
//        studentRepository.updateStuById(id,stuEditBe.getId());
//            log.info("\n修改id的学生数据:" + stuEditBe);
//        studentRepository.save(stuEditBe);
//        }else
             studentRepository.save(stuEditBe);
//        }
        return "redirect:/students";

    }

    @DeleteMapping("/student/{id}")
    public String deleteStu(@PathVariable("id") Integer id) {
        log.info("\n进入delete删除方法");

        studentRepository.deleteById(id);
//        }
        return "redirect:/students";

    }

}
