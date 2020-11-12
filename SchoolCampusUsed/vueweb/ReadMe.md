# Vue + SSM 的校园二手交易平台

## 技术点

Vue.js + Spring + SpringMVC + Mybatis + Mysql

项目需求中有 Redis、支付宝沙箱支付、Echarts 或 V-charts 图表等技术，待加入

## 对应后台项目

[SchoolCampusUsedBack JSP校园二手交易系统后台，使用AdminLTE模板](https://github.com/jdassd/SchoolCampusUsedBack) **需要用到后台的话，可以额外部署这个后台项目，后台的前后端使用的是 JSP + Servlet 持久层使用 Mybatis 数据库为 Mysql**

## 展示

#### 首页

![image-20201109201815005](http://image.xuanyuwq.top//image/image-20201109201815005.png)

#### 首页商品展示效果

![image-20201109201833298](http://image.xuanyuwq.top//image/image-20201109201833298.png)

#### 查看商品详情效果

![image-20201109201847330](http://image.xuanyuwq.top//image/image-20201109201847330.png)

#### 购物车

![image-20201109201925210](http://image.xuanyuwq.top//image/image-20201109201925210.png)

#### 上传二手（闲置卖钱）

![image-20201109201956485](http://image.xuanyuwq.top//image/image-20201109201956485.png)



##### 查看商品大图

![image-20201109202135210](http://image.xuanyuwq.top//image/image-20201109202135210.png)

#### 求购功能

![image-20201109202035277](http://image.xuanyuwq.top//image/image-20201109202035277.png)

#### 个人信息展示与更改

![image-20201109202152836](http://image.xuanyuwq.top//image/image-20201109202152836.png)

#### 查看订单与闲置

![image-20201109202207408](http://image.xuanyuwq.top//image/image-20201109202207408.png)

## 部署

1. 项目由 Maven 构建，建议使用 IDEA 打开项目引入依赖，如果需要和对应的后台项目一起使用：[SchoolCampusUsedBack JSP校园二手交易系统后台，使用AdminLTE模板](https://github.com/jdassd/SchoolCampusUsedBack)，请在编译运行时注意调整 Tomcat 的端口。**该项目默认 Vue 端口 8080，Tomcat 端口 8083请不要更改该项目的 Tomcat 端口，否则将无法发送和收到对应的 Ajax 请求。**
2. 导入项目后请不要着急运行项目，该项目上传图片需要一个单独的图片服务器。**代码中写入的调试服务器地址为 localhost:9090 ，请使用 Node.js 安装 Serve，再通过下面的方法映射本地文件夹到 localhost:9090 用来作为本地图片服务器。**

- 1)全局安装 Serve

  ```
  npm install -g serve
  ```

- 2)打开cmd，在项目文件下运行

  ```
  serve -p 9090
  ```

  ![image-20201109202439695](http://image.xuanyuwq.top//image/image-20201109202439695.png)

1. 将 coursedesign.sql 导入到你的数据库
2. 修改 src/main/resources/jdbc.properties 为你的数据库配置信息，将用户名和密码修改为你的用户名和密码**如果你使用的不是 Mysql 数据库，请自行修改 applicationContext.xml 文件里的数据库配置，和 pom.xml 中引入的依赖**
3. 在 Terminal 控制台 cd 进入SchoolCompausUsed 工程下的 vueweb 文件夹，并执行指令 `npm install` 安装 Vue.js 的依赖。**如果依赖安装总是出错，请尝试全局科学上网或者使用淘宝镜像。**
4. 先确保第 2 步已经映射成功，再启动名为 spring 的 tomcat，最后启动vue前端的`npm run dev`  
5. 如果在控制台输出中无误，可以打开 [这里](http://localhost:8080/) 查看效果。**如果你在第 1 步修改了 Vue 的端口，那么点击这里将无效。**

## FAQ

#### 为什么这个项目跑起来报错？

如果你的项目已经跑起来了，而不能访问到首页，你可以尝试切换 Tomcat 版本，这个项目构建时的版本为 Tomcat-8.5.50

#### 我发现这个项目有个 BUG ？

这个项目目前发现而没有解决的 BUG 有：

1. 未登录但可以通过链接访问到个人中心，以及登录后可以通过链接访问到登录和注册页面。
2. 其他一些 BUG ，但基本不影响使用。