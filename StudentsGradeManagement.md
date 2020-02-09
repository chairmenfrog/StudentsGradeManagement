# StudentsGradeManagement
## ��Ҫ��Դ�ļ�Ŀ¼
��ϵͳ�ǰ����й����Ƶ�γ��޸ĵĻ���springBoot2��springMVC5����ϵͳ
```
����src
��  ����main
��  ��  ����java
��  ��  ��  ����com
��  ��  ��      ����example
��  ��  ��          ����config
��  ��  ��          ����controller
��  ��  ��          ����handler
��  ��  ��          ����service
��  ��  ��          ����StudentDAO
��  ��  ��          ����StudentDomain
��  ��  ����resources
��  ��      ����static
��  ��      ��  ����asserts
��  ��      ��  ��  ����css
��  ��      ��  ��  ����img
��  ��      ��  ��  ����js
��  ��      ��  ����public
��  ��      ����templates
��  ��          ����class
��  ��          ����commons
��  ��          ����grade
��  ��          ����student
��  ����test
��      ����java
��          ����com
��              ����example
��                  ����StudentDomain
```
������Դ���嵥��˵����
�����ļ����ļ��� |	����
| ---- | :---------- | 
DemoApplication |	springBoot���̵�������
com.example.controller�ļ��� |	��¼��ѧ���ɼ��γ���������ɾ�Ĳ�ҳ��ת�������ڴ����ݳ־û��Ĵ��ݴ���
com.example.config�ļ��� |	ע���¼����������δ��¼ʱ���ʵķ���ҳ�͵�¼ҳ��ת���ص�¼login
com.example.handler�ļ���	| ��¼���أ��̳�HandlerInterceptorAdapter��ȡ��ת�������������Ӧ��MyMVCconfigת����index
com.example.service�ļ��� |	δʵ�֣�ֱ�Ӿ���DAO���Լ��̳��˵�Jparepository����������
com.example.StudentDAO�ļ��� |	�������ݳ־û���ʹ��ԭ��sql��hql����jpql������ֻ��ԭ��sql���Զ���ģ����������findAllStuByChinese�Ͱ�ID�ֶλ�ϲ��ҵ�findAllStuByNumOrLet����
com.example.StudentDomain�ļ��� |	����ʵ�壬���úñ���,���������hibernate�Զ�����,ʹ��JSR��֤�ɼ������������Сֵ
Templates��̬ҳ�����ļ��� |	��¼�ͳɼ�������ɾ�Ĳ����ͼ��ʾ
application.properties | ���������ļ�	���ݿ�����,���ݿ��������ԣ�����ʱ��ֹ����, ���ö�̬ҳ����Դ·��
Asserts |	����ͼƬ��js��css��̬�ļ��������Զ�����ͼ������Ҳû�취����css�ļ���û��ȫ����Ч
pom.xml |	��������������ļ�

## ʹ�÷���

����ֱ��ʹ��localhost:8080/xxx������,û�м���ǰ׺,ʹ��RestfulCRUD��CRUD����Rest���
����URI��� /��Դ����/��Դ��ʶ HTTP����ʽ���ֶ���ԴCRUD����
ʵ�鹦��(�Գɼ�Ϊ��) |	����URI| 	����ʽ|
| ---- | :---------- | :----: |
��ѯ���гɼ� |	grades| GET|
��ѯĳ���ɼ�(�����޸�ҳ��) | grade/1(1��ָ���)| GET
�������ҳ�� |	grade |	GET
��ӳɼ� | grade |	POST
�����޸�ҳ�棨����γ�ѧ�Ž�����Ϣ���ԣ�| grade/1 |	GET
�޸ĳɼ� |	grade |	PUT
ɾ���ɼ� |	grade/1 |	DELETE

##���ܽ���(ƪ�����޽�չʾѧ������,�����������ͬ)

css��ʱ��Ч��ʱ����Ч��bugδ���
![css��Ч.png](https://i.loli.net/2020/02/09/VQtoEuDaWeIid5C.png)
![��¼.png](https://i.loli.net/2020/02/09/W9KT7VSfb4nNUrB.png)
1.δ��¼�����ػص��ٵ�½��δ����˺�����Ĺ�������Ĭ��123456,��ͼcssδ��Ч
![��¼����ҳ.png](https://i.loli.net/2020/02/09/oH12VOnM4v6L5F9.png)
![cssδ��Чͼ.png](https://i.loli.net/2020/02/09/qsEPcxZ8nCDRh6m.png)
2. ���еı���й��������ʱ�Զ����£������м򵥵ĵ�������������
    - ��ѯʹ��������ʽ�ֱ��ж����ĺ�Ӣ������,�ѷ���������ֵ���������
![ѧ����ѯ.png](https://i.loli.net/2020/02/09/kK489mx5dUlogWv.png)
3. ѧ���������ѧ������ѧ�Ż��߰�����ģ����ѯ�޸ģ�ʵ�ֶ�ĳ��ѧ����Ϣ����ɾ�Ĳ�
  - ���İ�ť��ʾΪ���,��Ӻ���������
![ѧ�����.png](https://i.loli.net/2020/02/09/Zh3lbicgA9OHUa7.png)
![ѧ�����2.png](https://i.loli.net/2020/02/09/WIMCAxQmrjshJnZ.png)
  - �޸ķ��ܷ�����12,����ʱ��Ϊ1�¡�Id�������ɫ,ֻ����ʾ��������
![ѧ���޸�.png](https://i.loli.net/2020/02/09/dzr5QwxS4uc3Gfs.png)
![ѧ���޸�2.png](https://i.loli.net/2020/02/09/6Qmjn38dLUGP5Th.png)
  - ѧ��ɾ�����ɾ����ť����,������ʾ
4. �ɼ�����Ǽǳɼ������γ̺Ż��߰�����ģ����ѯ�γ̵������˵ĳɼ���ʵ�ֶ�ĳ���γ���ѧ���ɼ�����ɾ�Ĳ�
5. �γ̽����½��γ̣����γ̺Ż��߰�����ģ����ѯ�γ̣�ʵ�ֶ�ĳ���γ���Ϣ����ɾ�Ĳ�

6. �ǳ�URI�ı�
![�ǳ�.png](https://i.loli.net/2020/02/09/8CVOgzxL2Bw5nXG.png)
