# StudentsGradeManagement
## 主要的源文件目录
本系统是按照尚硅谷视频课程修改的基于springBoot2的springMVC5管理系统

├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─example
│  │  │          ├─config
│  │  │          ├─controller
│  │  │          ├─handler
│  │  │          ├─service
│  │  │          ├─StudentDAO
│  │  │          └─StudentDomain
│  │  └─resources
│  │      ├─static
│  │      │  ├─asserts
│  │      │  │  ├─css
│  │      │  │  ├─img
│  │      │  │  └─js
│  │      │  └─public
│  │      └─templates
│  │          ├─class
│  │          ├─commons
│  │          ├─grade
│  │          └─student
│  └─test
│      └─java
│          └─com
│              └─example
│                  └─StudentDomain
程序资源（清单）说明。
程序文件或文件夹 |	作用
| ---- | :---------- | 
DemoApplication |	springBoot工程的启动类
com.example.controller文件夹 |	登录，学生成绩课程三大功能增删改查页面转发请求，内存数据持久化的传递处理
com.example.config文件夹 |	注册登录器，将所有未登录时访问的非首页和登录页面转发回登录login
com.example.handler文件夹	| 登录拦截，继承HandlerInterceptorAdapter
获取到转发器，请求和响应由MyMVCconfig转发到index

com.example.service文件夹 |	未实现，直接就用DAO里自己继承了的Jparepository传递数据了
com.example.StudentDAO文件夹 |	处理数据持久化，使用原生sql，hql还有jpql，最终只有原生sql能自定义模糊查找中文findAllStuByChinese和按ID字段混合查找的findAllStuByNumOrLet方法
com.example.StudentDomain文件夹 |	数据实体，配置好表名,外键部分由hibernate自动生成,使用JSR验证成绩和年龄最大最小值
Templates静态页面存放文件夹 |	登录和成绩管理增删改查的视图显示
application.properties | 数据配置文件	数据库连接,数据库命名策略，关联时防止出错, 设置动态页面资源路径
Asserts |	所有图片，js和css静态文件，但是自定义视图解析器也没办法加载css文件，没有全部生效
pom.xml |	所有依赖管理的文件

## 使用方法

域名直接使用localhost:8080/xxx来访问,没有加上前缀,使用RestfulCRUD：CRUD满足Rest风格；
具体URI风格： /资源名称/资源标识 HTTP请求方式区分对资源CRUD操作
实验功能(以成绩为例) |	请求URI| 	请求方式|
| ---- | :---------- | :----: |
查询所有成绩 |	grades| GET|
查询某个成绩(来到修改页面) 	grade/1(1是指编号)| GET
来到添加页面 |	grade |	GET
添加成绩 | grade |	POST
来到修改页面（查出课程学号进行信息回显）| grade/1 |	GET
修改成绩 |	grade |	PUT
删除成绩 |	grade/1 |	DELETE

##功能介绍(篇幅有限仅展示学生管理,其他管理均相同)

css有时生效有时不生效的bug未解决
![css生效.png](https://i.loli.net/2020/02/09/VQtoEuDaWeIid5C.png)
![登录.png](https://i.loli.net/2020/02/09/W9KT7VSfb4nNUrB.png)
未登录会拦截回到假登陆，未实现账号密码的数据，密码默认123456,下图css未生效
![登录和首页.png](https://i.loli.net/2020/02/09/oH12VOnM4v6L5F9.png)
![css未生效图.png](https://i.loli.net/2020/02/09/qsEPcxZ8nCDRh6m.png)
1. 所有的表格都有关联，相关时自动更新，界面有简单的导航栏和搜索框。
查询使用正则表达式分别判断中文和英文数字,搜法查出带法字的所有数据
![学生查询.png](https://i.loli.net/2020/02/09/kK489mx5dUlogWv.png)
2. 学生界面管理学生，按学号或者按名字模糊查询修改，实现对某个学生信息的增删改查
  -表单的按钮显示为添加,添加后正常回显
![学生添加.png](https://i.loli.net/2020/02/09/Zh3lbicgA9OHUa7.png)
![学生添加2.png](https://i.loli.net/2020/02/09/WIMCAxQmrjshJnZ.png)
  -Id输入框便灰色,只能显示不能输入.修改冯绍峰年龄12,更新时间为1月
![学生修改.png](https://i.loli.net/2020/02/09/dzr5QwxS4uc3Gfs.png)
![学生修改2.png](https://i.loli.net/2020/02/09/6Qmjn38dLUGP5Th.png)
  -学生删除点击删除按钮即可,不做演示
3. 成绩界面登记成绩，按课程号或者按名字模糊查询课程的所有人的成绩，实现对某个课程里学生成绩的增删改查
4. 课程界面新建课程，按课程号或者按名字模糊查询课程，实现对某个课程信息的增删改查

登出
![登出.png](https://i.loli.net/2020/02/09/8CVOgzxL2Bw5nXG.png)
