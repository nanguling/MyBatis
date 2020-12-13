01_hello-mybatis:第一个入门的mybatis栗子

实现步骤：
1.新建的Test表
2.加入maven的mybatis坐标，mysql驱动的坐标
3.创建实体类，Test--保存表中一行数据
4.创建持久层的dao接口，定义操作数据库的方法
5.创建一个mybatis使用的配置文件：叫作sql映射文件
    作用是：写sql语句。一般一个表一个sql映射文件
    这个文件是xml文件,写在接口所在的目录中，文件名和接口名保持一致
6.创建mybatis的主配置文件：
    一个项目就一个主配置文件
    主配置文件提供了数据库的连接信息和sql映射文件的位置信息
7.创建使用mybatis类
    通过mybatis访问数据库