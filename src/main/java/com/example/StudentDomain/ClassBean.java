package com.example.StudentDomain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "class_info")//表名,不设置默认为小写类名的表

public class ClassBean {
    @Id
    @NotNull(message = "必填")
//    @GenericGenerator(name = "systemUUID", strategy = "uuid")
//    @GeneratedValue(generator = "systemUUID")
//    @GeneratedValue(strategy = GenerationType.AUTO)//自增主键
    private int class_id;//列名省略就是属性名
    @Column(name = "class_name", nullable = false)
    private String class_name;
    @Column(name = "class_teacher", nullable = false)
    private String class_teacher;
    @Min(value = 1, message = "不得小于等于1")
    @Max(value = 20, message = "不得大于20")
    @Column(name = "class_duration", nullable = false)
    private int class_duration;
    //日期从前端获取需要使用格式化
    @Column(name = "class_createTime", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date class_createTime;
    //    更新日期可以为空
    @Column(name = "class_updateTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date class_updateTime;
@Column(name="classroom")
private String classroom;

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getClass_id() {
        return class_id;
    }

    public ClassBean() {
    }

    @Override
    public String toString() {
        return "ClassBean{" +
                "class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                ", class_teacher='" + class_teacher + '\'' +
                ", class_duration=" + class_duration +
                ", class_createTime=" + class_createTime +
                ", class_updateTime=" + class_updateTime +
                ", class_updateTime="+classroom+
                '}';
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_teacher() {
        return class_teacher;
    }

    public void setClass_teacher(String class_teacher) {
        this.class_teacher = class_teacher;
    }

    public int getClass_duration() {
        return class_duration;
    }

    public void setClass_duration(int class_duration) {
        this.class_duration = class_duration;
    }

    public Date getClass_createTime() {
        return class_createTime;
    }

    public void setClass_createTime(Date class_createTime) {
        this.class_createTime = class_createTime;
    }

    public Date getClass_updateTime() {
        return class_updateTime;
    }

    public void setClass_updateTime(Date class_updateTime) {
        this.class_updateTime = class_updateTime;
    }
}
