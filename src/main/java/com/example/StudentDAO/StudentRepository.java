package com.example.StudentDAO;

import com.example.StudentDomain.StudentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentBean, Integer> {
//增删改查都有xxxone，写的是自定义,通配符只能由jpa官方的方法绑定
@Query(nativeQuery = true,value ="select * from student_info where name like binary concat('','%',?1,'%','') or gender =?1 ")
List<StudentBean> findAllStuByChinese( String queryText);
//@Param("searchContent")
    @Query(nativeQuery = true,value ="select * from student_info where  createTime like concat('','%',?1,'%','')  or updateTime like  concat('','%',?1,'%','') or id =?1 or age = ?1")
    List<StudentBean> findAllStuByNumOrLet(String queryText);

    //   查找包含相同字的学生,注释的sql语句都有语法问题或者hibernate无法转换
//    @Query(value = "select  * from student_info where name like ?1 ", nativeQuery = true)
//    List<StudentBean> findAllStuByName(String name) ;
//    分页传输未使用
//    未使用通配符的原生查询无法完成目标,加单引号无法转义,需要使用contact函数,四个单引号表示转义为单引号，+号拼接参数无法使用
//@Query(nativeQuery = true,value ="select * from student_info where  gender = :searchContent or name like  concat('%',:searchContent,'%')  or age  =:searchContent   or createTime like CONCAT('%',:searchContent,'%') or updateTime like CONCAT('%',:searchContent,'%') or id = :searchContent")
//@Query("select u from student_info u where u.name like %||?1||% or u.age like %?1% or  u.gender = ?1 or u.createTime like %?1% or u.updateTime like %?1% or u.id = ?1")//HQL语句也无法模糊查询
//    JPQL语句问题更多
//    @Query(value = "select s from StudentBean  s where s.id = :searchContent " +
//            "or s.gender=:searchContent " +
//            "or s.name like %:searchContent% "+
//            "or s.createTime like %:searchContent% "+
//            "or s.updateTime like %:searchContent%")
//    List<StudentBean> findAllStu(@Param("searchContent")String queryText);
//    //   更新指定id的学生名字
//    @Modifying
//    @Query(nativeQuery = true,value = "update student_info set name = ?1  where id = ?2 ")
//    int updateStudentId(String name,int id);
//    //   更新指定名字的学生学号
////    @Modifying
////    @Query(nativeQuery = true,value = "update student_info set name = ?1  where id = ?2 ")
////    int updateStuIdByName(int id ,String name);
////    //   更新指定id的学生id
//    @Modifying
//    @Query(nativeQuery = true,value = "update student_info set id = ?1 where id = ?2 ")
//    void updateStuById(int newId ,int oldId);
    //   增加指定id的学生
//    @Modifying
//    @Query(nativeQuery = true,value = "insert user from student_info id = ?1 ")
//    void insertStudentId(int id);
}
