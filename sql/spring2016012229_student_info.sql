-- auto-generated definition
create table student_info
(
    id         int                                    not null,
    name       varchar(60) collate utf8mb4_unicode_ci null,
    age        int             default 22             not null,
    updateTime datetime                               null,
    gender     enum ('男', '女') default '男'            not null,
    createTime datetime                               not null,
    constraint Student_info_id_uindex
        unique (id)
)
    charset = utf8mb4;

create fulltext index ft_stu_index
    on student_info (name);

alter table student_info
    add primary key (id);


INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (1, '方鸿渐', 23, '2019-06-22 04:33:00', '男', '2019-05-02 04:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (2, '垡珐伐', 23, '2019-06-22 04:33:00', '女', '2019-06-02 04:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (3, '罚法发', 25, '2019-06-22 04:33:00', '男', '2019-04-02 04:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (11, '房费上', 22, '2019-05-13 04:33:00', '女', '2019-04-02 14:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (15, '十分十分', 23, null, '女', '2019-04-02 04:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (18, '方式', 23, null, '女', '2019-04-02 04:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (28, '高善文', 12, null, '男', '2019-04-02 04:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (29, '温宿镇', 12, null, '女', '2019-05-22 04:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (30, '万书时', 17, null, '女', '2019-04-02 04:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (31, '董师傅', 19, '2019-06-22 04:33:00', '男', '2019-06-02 04:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (33, '华盛顿', 23, '2019-06-22 04:33:00', '女', '2019-06-22 04:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (66, '很反对', 44, null, '女', '2019-05-02 04:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (111, '格瑞特', 45, null, '女', '2019-06-06 09:28:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (153, 'fa3', 34, null, '女', '2019-04-02 04:33:00');
INSERT INTO spring2016012229.student_info (id, name, age, updateTime, gender, createTime) VALUES (1112, '广告歌', 23, null, '女', '2019-04-02 04:33:00');