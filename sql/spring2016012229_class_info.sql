-- auto-generated definition
create table class_info
(
    class_id         int         not null
        primary key,
    class_duration   int(5)      null comment '单位为周数',
    class_teacher    char(50)    null,
    class_name       varchar(60) null,
    class_updateTime datetime    null,
    class_createTime datetime    not null
)
    collate = utf8mb4_unicode_ci;

create index class_info_class_name_index
    on class_info (class_name);

create fulltext index ft_cla_index
    on class_info (class_name, class_teacher);


INSERT INTO spring2016012229.class_info (class_id, class_duration, class_teacher, class_name, class_updateTime, class_createTime) VALUES (14, 12, '是个思否', '法制分析', '2019-06-12 07:55:00', '2019-06-02 04:55:00');
INSERT INTO spring2016012229.class_info (class_id, class_duration, class_teacher, class_name, class_updateTime, class_createTime) VALUES (15, 12, '石室山', '搜索引擎', null, '2019-02-18 09:09:00');
INSERT INTO spring2016012229.class_info (class_id, class_duration, class_teacher, class_name, class_updateTime, class_createTime) VALUES (16, 12, '管上局', '经济理论', null, '2019-06-02 04:55:00');
INSERT INTO spring2016012229.class_info (class_id, class_duration, class_teacher, class_name, class_updateTime, class_createTime) VALUES (25, 20, '李玲玲', '高等数学', null, '2019-05-02 04:55:00');
INSERT INTO spring2016012229.class_info (class_id, class_duration, class_teacher, class_name, class_updateTime, class_createTime) VALUES (26, 12, '秦二十', '法制分析', '2019-06-02 07:55:00', '2019-06-02 04:55:00');
INSERT INTO spring2016012229.class_info (class_id, class_duration, class_teacher, class_name, class_updateTime, class_createTime) VALUES (27, 12, '阿古斯', '移民理论', null, '2019-06-02 04:55:00');
INSERT INTO spring2016012229.class_info (class_id, class_duration, class_teacher, class_name, class_updateTime, class_createTime) VALUES (51, 14, '首师大', '拖车拉网', null, '2019-06-22 04:55:00');