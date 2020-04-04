create table spring2016012229.student_grade
(
    gradeID    int                                    not null
        primary key,
    stuID      int                                    not null,
    claName    varchar(60) collate utf8mb4_unicode_ci null,
    score      int(7)                                 not null comment '分数',
    createTime datetime                               not null,
    updateTime datetime                               null,
    constraint FK4pt0joksxkphh4uk3yj7p4b62
        foreign key (stuID) references spring2016012229.student_info (id)
)
    charset = utf8mb4;

create fulltext index ft_gra_index
    on spring2016012229.student_grade (claName);

create index student_grade_claName_index
    on spring2016012229.student_grade (claName);


INSERT INTO spring2016012229.student_grade (gradeID, stuID, claName, score, createTime, updateTime) VALUES (5, 11, '高等数学', 83, '2019-04-02 04:33:00', null);
INSERT INTO spring2016012229.student_grade (gradeID, stuID, claName, score, createTime, updateTime) VALUES (32, 1, '搜索引擎', 11, '2019-04-02 14:33:00', null);
INSERT INTO spring2016012229.student_grade (gradeID, stuID, claName, score, createTime, updateTime) VALUES (33, 18, '高等数学', 69, '2019-05-02 04:33:00', '2019-06-22 04:33:00');
INSERT INTO spring2016012229.student_grade (gradeID, stuID, claName, score, createTime, updateTime) VALUES (34, 3, '经济理论', 72, '2019-01-22 04:33:00', '2019-06-22 04:33:00');
INSERT INTO spring2016012229.student_grade (gradeID, stuID, claName, score, createTime, updateTime) VALUES (423, 3, '高等数学', 66, '2019-04-02 04:33:00', null);