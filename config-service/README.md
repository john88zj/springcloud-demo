# 快速开始

### 编译
``
mvn clean install 
``

    
### 执行

`
java -jar target/config-service-1.0.0.jar
`

### [浏览器访问](http://localhost:8769/login)

访问 [monitor-admin](http://localhost:8769/login) 看到CONFIG-CENTER注册成功
访问 [eureka-register](http://localhost:8761/) 看到CONFIG-CENTER注册成功
验证配置文件，访问 `http://localhost:8890/config-client-dev.properties` 显示配置文件信息

## 相关

支持多种加载方式

* git加载
```$xslt

##1、config 默认Git加载
#spring.cloud.config.server.git.uri=https://github.com/john88zj/springcloud-demo
##github账户
##spring.cloud.config.server.git.username=username
##github密码
##spring.cloud.config.server.git.password=password
#spring.cloud.config.server.git.default-label=master
#spring.cloud.config.server.git.search-paths=config
```

* 加载本地开发环境

```$xslt
##2、加载本地开发环境
spring.profiles.active=native
spring.cloud.config.server.native.searchLocations=classpath:/config
```

* 加载磁盘文件
```$xslt
##3、加载 本地物理环境
#spring.profiles.active=native
##本地文件路径
#spring.cloud.config.server.native.searchLocations= file:///Users/zhujun/Documents/workspace-my/springcloud-demo1/config/master
```



* 加载svn环境 
```$xslt
##4、加载svn环境  http://localhost:8080/{application}/{profile}/{label}，比如：http://localhost:8080/dmeo/development/trunk
#### config server svn
#spring.cloud.config.server.svn.uri=http://localhost:8080/dmeo/development/trunk
#spring.cloud.config.server.svn.username=xxx
#spring.cloud.config.server.svn.password=xxx
#spring.profiles.active=subversion
#
#PS:  svn 环境 需要 引入 SVN jar包 
#<groupId>org.tmatesoft.svnkit</groupId>
#<artifactId>svnkit</artifactId>


```
* 验证

```$xslt
#/{application}/{profile}[/{label}]
#/{application}-{profile}.yml
#/{label}/{application}-{profile}.yml
#/{application}-{profile}.properties
#/{label}/{application}-{profile}.properties
#{application} 就是应用名称，对应到配置文件上来，就是配置文件的名称部分，例如我上面创建的配置文件。
#
#{profile} 就是配置文件的版本，我们的项目有开发版本、测试环境版本、生产环境版本，对应到配置文件上来就是以 application-{profile}.yml 加以区分，例如application-dev.yml、application-sit.yml、application-prod.yml。
#
#{label} 表示 git 分支，默认是 master 分支，如果项目是以分支做区分也是可以的，那就可以通过不同的 label 来控制访问不同的配置文件了。
#上面的 5 条规则中，我们只看前三条，因为我这里的配置文件都是 yml 格式的。根据这三条规则，我们可以通过以下地址查看配置文件内容:
#
#http://localhost:8888/config-client/dev/master
#
#http://localhost:8888/config-client/dev
#
#http://localhost:8888/config-single-client-dev.yml
#
#http://localhost:8888/config-single-client-prod.yml
#
#http://localhost:8888/master/config-single-client-prod.yml
#
#通过访问以上地址，如果可以正常返回数据，则说明配置中心服务端一切正常。


```
    
    

