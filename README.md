# example-springboot
## 常见开发-Demo.
### 1、全局异常拦截器，自定义消息格式。
### 2、自定义类加载器。
### 3、服务端跨域解决方案。
### 4、服务异步执行方案。
### 5、多线程demo实操。
### 6、ssh远程CMD执行案例。
### 7、spring-boot实现本地https。
### 8、java 执行shell脚本
### 9、@Valid(javax)和@Validated(spring)分组校验 顺序验证 嵌套验证等
### 10、Spring事务原理分析
### 11、spring事务的传播属性分析 to see com.example.dsz.controller.TransactionalController
### 12、Maven-Mybatis逆向工程插件集成
### 13、TkMapper集成
### 14、泛型熟悉操作demo
### 15、页面爬虫操作HPO数据
### 16、Java SPI机制实现
### 17、Java Agent代理应用
#### a、JavaAgent工程地址
https://github.com/ShouZhiDuan/my-java-agent
#### b、ClassPath下手动创建
META-INF/MANIFEST.MF文件

Manifest-Version: 1.0
Can-Redefine-Classes: true
Can-Retransform-Classes: true
Premain-Class: com.example.dsz.MyAgent
记住留空一行，必须

#### c、将myagent.jar依赖到需要使用当前agent的工程中去(具体依赖具体情况定，必须依赖否则加载不到相关的jar)

<dependency>
    <groupId>com.agent</groupId>
    <artifactId>java-agent-test</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>

#### d、使用JavaAgent启动参数(在使用方项目启动脚本置顶如下参数)
-javaagent:E:/dsz-git-work/java-agent-test/target/myagent.jar