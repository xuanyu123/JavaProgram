# JSP校园二手交易系统后台，使用AdminLTE模板
## 技术点
#### JSP + Servlet + Mybatis + Mysql
## 展示
#### 登录界面
![image-20201109195624828](http://image.xuanyuwq.top//image/image-20201109195624828.png)
#### 注册界面
![image-20201109195717974](http://image.xuanyuwq.top//image/image-20201109195717974.png)
#### 首页
![image-20201109200116911](http://image.xuanyuwq.top//image/image-20201109200116911.png)
#### 商品管理界面
![image-20201109200129895](http://image.xuanyuwq.top//image/image-20201109200129895.png)
#### 编辑商品界面
![image-20201109200146566](http://image.xuanyuwq.top//image/image-20201109200146566.png)
#### 用户管理界面

![image-20201109200313534](http://image.xuanyuwq.top//image/image-20201109200313534.png)

#### 投诉、反馈、建议管理

![image-20201109200325759](http://image.xuanyuwq.top//image/image-20201109200325759.png)

#### 支付管理

![image-20201109200338869](http://image.xuanyuwq.top//image/image-20201109200338869.png)

#### 订单管理

![image-20201109200354599](http://image.xuanyuwq.top//image/image-20201109200354599.png)



## 部署

1. 项目由 Maven 构建，建议使用 IDEA 打开项目，如果和 [SchoolCampusUsed Vue+SSM的校园二手交易平台](https://github.com/jdassd/SchoolCampusUsed) 这个项目一起部署调试，建议使用 8081 端口运行这个后台项目。
2. 项目目录下有一个 plugins.zip 文件需要解压到 src/main/webapp 目录下
3. 将 coursedesign.sql 导入到你的数据库
4. 修改 src/main/resources/mybatis-config.xml 文件里的数据库配置，将用户名和密码修改为你的用户名和密码。**如果你使用的不是 Mysql 数据库，请自行修改该文件里的数据库配置和 pom.xml 中引入的依赖**
5. 接着使用 Tomcat 打开项目就可以查看到效果

