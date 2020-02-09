package com.example.StudentDomain;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "student_info")//表名,不设置默认为小写类名的表

public class StudentBean {
    //    @Pattern(regexp = "^[0-9]{10}", message = "必须是10位数字")
    @Id
    @NotNull(message = "必填")
//    @GenericGenerator(name = "systemUUID", strategy = "uuid")
//    @GeneratedValue(generator = "systemUUID")
//    @GeneratedValue(strategy = GenerationType.AUTO)//自增主键

    private int id;//列名省略就是属性名
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Min(value = 1, message = "不得小于等于1")
    @Max(value = 200, message = "不得大于200")
    @Column(name = "age", nullable = false)
    private int age;
    //日期从前端获取需要使用格式化
    @Column(name = "createTime", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;
    //    更新日期可以为空
    @Column(name = "updateTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;

    public StudentBean() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    @Override
    public String toString() {
        //转换成json字符串
        return "StudentBean [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", createTime="
                + createTime + ", updateTime=" + updateTime + "]";
    }


}
