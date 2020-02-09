package com.example.StudentDAO;

import com.example.StudentDomain.GradeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository extends JpaRepository<GradeBean,Integer> {
//   根据时间模糊查找,学号或者班级准确查找
    @Query(nativeQuery = true,value ="select * from student_grade where  claName like binary concat('','%',?1,'%','') ")
//    @Query(nativeQuery = true,value ="select * from class_info where class_teacher like binary concat('','%',?1,'%','') or class_name like binary concat('','%',?1,'%','')")

    List<GradeBean> findAllGraByChinese(  String queryText);
    //    @Param("searchContent")
    @Query(nativeQuery = true,value ="select * from student_grade where gradeID=?1 or stuID = ?1 or createTime like CONCAT('','%',?1,'%','') or updateTime like CONCAT('','%',?1,'%','') ")
    List<GradeBean> findAllGraByNumOrLet(String queryText);
}
