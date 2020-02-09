package com.example.controller;

import com.example.DemoApplication;
import com.example.StudentDAO.ClassRepository;
import com.example.StudentDAO.GradeRepository;
import com.example.StudentDAO.StudentRepository;
import com.example.StudentDomain.ClassBean;
import com.example.StudentDomain.GradeBean;
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
public class GradeController {
    public static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassRepository classRepository;

    @GetMapping("/grades")
    public ModelAndView getGrades() {
        List<GradeBean> graInfo = gradeRepository.findAll();
        ModelAndView model = new ModelAndView();
        model.setViewName("/grade/gradelist");
        log.info("\n成功跳转到列表方法getGrades()");

        model.addObject("graViewInfo", graInfo);
//        return "/grade/gradelist";
        return model;
    }

    //get来到学生查询页面
    @GetMapping("/somegrades")
    public ModelAndView searchGra(HttpServletRequest req) {
        String searText = (req.getParameter("query")).trim();
//        入参@RequestParam(value ="query") String searText
        ModelAndView graSearModel = new ModelAndView();
        graSearModel.setViewName("/grade/gradelist");
        if (searText.matches("[\\u4e00-\\u9fa5]+")) {
            List<GradeBean> graInfo = gradeRepository.findAllGraByChinese(searText);
            log.info("\n成功跳转到查询方法()");
            graSearModel.addObject("graViewInfo", graInfo);
        } else if (searText.matches("[a-zA-Z]+") || searText.matches("[0-9]+")) {
            List<GradeBean> graInfo = gradeRepository.findAllGraByNumOrLet(searText);
            log.info("\n成功跳转到查询方法()");
            graSearModel.addObject("graViewInfo", graInfo);
        } else {
            List<GradeBean> graInfo1 = gradeRepository.findAllGraByChinese(searText);
            List<GradeBean> graInfo2 = gradeRepository.findAllGraByNumOrLet(searText);
            graInfo1.addAll(graInfo2);
            log.info("\n成功跳转到查询方法()");
            graSearModel.addObject("graViewInfo", graInfo1);
        }
        return graSearModel;
//        return "/student/list";
    }
    //来到添加页面,查出所有的部门，在页面显示
//        List<GradeBean> grades = gradeRepository.findAll();
//        model.addAttribute("grades",grades);

    //成绩添加页面，先查课程，学生再添加

    @GetMapping("/grade")
    public ModelAndView toAddPage() {
        ModelAndView mv = new ModelAndView();
//        List<GradeBean> grades = gradeRepository.findAll();
        List<StudentBean> students = studentRepository.findAll();
        List<ClassBean> classes = classRepository.findAll();
//        mv.addObject("graViewInfo",grades);
        mv.setViewName("/grade/addGrade");
        mv.addObject("showStu", students);
        mv.addObject("showCla", classes);
        log.info("学生回显数据首个stuBe的id:" + students.get(1).getId());
        log.info("学生回显数据首个claBe的class_name:" + classes.get(1).getClass_name());
        return mv;
//        return "grade/addGrade";
    }

    //来到修改页面，查出当前学生成绩，在页面回显
    @GetMapping("/grade/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        log.info("\n进入get修改方法");

        GradeBean grade = gradeRepository.getOne(id);
        model.addAttribute("graInfo", grade);

        //页面要显示所有的学生，成绩
        List<StudentBean> students = studentRepository.findAll();
        List<ClassBean> classes = classRepository.findAll();
        model.addAttribute("gradeBe", grade);
        model.addAttribute("showStu", students);
        log.info("学生回显数据首个stuBe的id:" + students.get(1).getId());
        model.addAttribute("showCla", classes);
        log.info("学生回显数据首个claBe的class_name:" + classes.get(1).getClass_name());

        //回到修改页面(add是一个修改添加二合一的页面);
        return "grade/addGrade";
    }

    @PostMapping("/grade")
    public String addStu( @Valid GradeBean grade) {
        //来到员工列表页面
        log.info("\n保存的成绩信息：" + grade);
        //保存员工
        gradeRepository.save(grade);
        //由于模板引擎会拼串不能直接返回路径需要 redirect: 表示重定向到一个地址  /代表当前项目路径
        return "redirect:/grades";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/grade/{id}")
    public String putGrade(@PathVariable("id") Integer id, @Valid GradeBean grade) {
        log.info("修改的员工数据：" + grade);
        gradeRepository.save(grade);
        return "redirect:/grades";
    }

    //员工删除
    @DeleteMapping("/grade/{id}")
    public String deleteGrade(@PathVariable("id") Integer id) {
        gradeRepository.deleteById(id);
        return "redirect:/grades";
    }

}
