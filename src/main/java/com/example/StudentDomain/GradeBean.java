package com.example.StudentDomain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "student_grade")//表名,不设置默认为小写类名的表

public class GradeBean {
    @Id
    @NotNull(message = "必填")
//    @GenericGenerator(name = "systemUUID", strategy = "uuid")
//    @GeneratedValue(generator = "systemUUID")
//    @GeneratedValue(strategy = GenerationType.AUTO)//自增主键

    private int gradeID;//列名省略就是属性名
    //外键使用多对一,
//    @ManyToOne
//    @JoinColumn(name = "stuID", nullable = false)
//    private StudentBean stu;
    @Column(name="stuID", nullable = false)
    private int stuID;
    @Column(name = "claName", nullable = false)
    private String claName;

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName;
    }
//@ManyToOne
//@JoinColumn(name = "claName", nullable = false)
//private ClassBean cla;

    @Min(value = 1, message = "不得小于等于1")
    @Max(value = 100, message = "不得大于100")
    @Column(name = "score", nullable = false)
    private int score;


    //日期从前端获取需要使用格式化
    @Column(name = "createTime", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;
    //    更新日期可以为空
    @Column(name = "updateTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;
    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

//    放弃外键使用注释掉
//    public StudentBean getStu() {
//        return stu;
//    }
//
//    public void setStu(StudentBean stu) {
//        this.stu = stu;
//    }

//    public ClassBean getCla() {
//        return cla;
//    }
//
//    public void setCla(ClassBean cla) {
//        this.cla = cla;
//    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

//    public GradeBean(StudentBean stu) {
//        this.stu = stu;
//    }

    public GradeBean() {
    }

    @Override
    public String toString() {
        return "GradeBean{" +
                "gradeID=" + gradeID +
                ", stu=" + stuID +
                ", cla=" + claName +
                ", score=" + score +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
