package com.example.controller;

import com.example.DemoApplication;
import com.example.StudentDAO.ClassRepository;
import com.example.StudentDAO.StudentRepository;
import com.example.StudentDomain.ClassBean;
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
public class ClassController {
    public static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    ClassRepository classRepository;

    //查询所有课程返回列表页面
    @GetMapping("/classes")
    public ModelAndView getClasses() {
        List<ClassBean> classInfo = classRepository.findAll();
        ModelAndView classMo = new ModelAndView();
        log.info("\n成功跳转到列表方法getClasses()");
//        log.info("\n首个课程信息"+classInfo.get(1));
        classMo.setViewName("/class/classlist");

        classMo.addObject("claViewInfo", classInfo);

//分页传数据未完成
    	/*int page=1,size=2;

    	Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        model.addAttribute("users", pageable);*/
//        return "/class/classlist";
        return classMo;
    }

    //get来到课程查询页面
    @GetMapping("/someclasses")
    public ModelAndView searchCla(HttpServletRequest req) {
        String searText = (req.getParameter("query")).trim();
//        入参@RequestParam(value ="query") String searText
        //查询中英混搭先查中文再查英文数字,纯中或纯英分别查
        ModelAndView claSearModel = new ModelAndView();
        claSearModel.setViewName("/class/classlist");
        if (searText.matches("[\\u4e00-\\u9fa5]+")) {
            List<ClassBean> classInfo = classRepository.findAllClaByChinese(searText);
            log.info("\n成功跳转到查询方法()");
            claSearModel.addObject("claViewInfo", classInfo);
        } else if (searText.matches("[a-zA-Z]+") || searText.matches("[0-9]+")) {
            List<ClassBean> classInfo = classRepository.findAllClaByNumOrLet(searText);
            log.info("\n成功跳转到查询方法()");
            claSearModel.addObject("claViewInfo", classInfo);
        }

        else {
//            List<ClassBean> classInfo1 = classRepository.findAllClaByChinese(searText);
////            查询中英文混合时出错,中英文只有classroom
//            List<ClassBean> classInfo2 = classRepository.findAllClaByNumOrLet(searText);
//            classInfo1.addAll(classInfo2);
//            log.info("\n成功跳转到查询方法()");
            List<ClassBean> classInfo1 = classRepository.findAllClaByRoom(searText);
            log.info("\n成功跳转到查询方法()");
            claSearModel.addObject("claViewInfo", classInfo1);
        }
        return claSearModel;
//    claModel.addAttribute("claViewInfo",classInfo);
//        return "/class/classlist";
    }

    //get来到课程添加页面
    @GetMapping("/class")
    public String toAddPage() {
        //来到添加页面,查出所有的课程，在页面显示
//        ModelAndView mv = new ModelAndView();
//        List<ClassBean> classInfo = classRepository.findAll();
//        mv.addObject("claViewInfo", classInfo);
////                mv.setViewName("list");
        return "class/addclass";
    }

    //post课程添加,从表单绑定实体数据
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/class")
    public String addClass(@Valid ClassBean claBe) {
        //来到员工列表页面
        log.info("\n保存的课程信息：" + claBe);
        //保存员工
        classRepository.save(claBe);
        //由于模板引擎会拼串不能直接返回路径需要 redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/classes";
    }

    //    get到学生修改页面
    @GetMapping("/class/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        log.info("\n进入get修改方法");

        ClassBean claEdit = classRepository.getOne(id);
        //回显到add页面参数需要保存修改的bean claEdit
        model.addAttribute("claBe", claEdit);

        //页面要显示所有的部门列表
//        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "class/addclass";
//        return "redirect:/student";
    }

    //    put提交修改后到学生列表页面
    @PutMapping(value = {"/class/{id}"})
    public String putClass(@PathVariable("id") Integer id, ClassBean claEdit) {
        ClassBean oldCla = classRepository.getOne(id);
        log.info("\n进入put修改方法,旧数据:\n" + oldCla);
        log.info("\n修改课程数据:" + claEdit);
//        if(!(){
        log.info("\n进入save保存");
//        oldStu=stuEditBe;//赋值新变量
        classRepository.save(claEdit);
//        }
        return "redirect:/classes";

    }

    @DeleteMapping("/class/{id}")
    public String deleteStu(@PathVariable("id") Integer id) {
        log.info("\n进入delete删除方法");

        classRepository.deleteById(id);
//        }
        return "redirect:/classes";

    }

}
