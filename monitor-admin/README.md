# 快速开始

### 编译
``
mvn clean install 
``

    
### 执行

`
java -jar target/monitor-admin-1.0.0.jar
`

### [浏览器访问](http://localhost:8769/login)

打开浏览器访问：`http://localhost:8769/login`

## 相关

* 添加spring security

pom文件添加依赖包
    
```$xslt
<!--security 依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

配置文件添加

```$xslt

# security 安全配置
spring.security.user.name=admin
spring.security.user.password=admin
eureka.instance.metadata-map.user.name=${spring.security.user.name}
eureka.instance.metadata-map.user.password=${spring.security.user.password}

```

*   注册到 eureka 

pom文件添加依赖包

```$xslt

<!--eureka 依赖-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

```


配置文件添加

```$xslt

# 注册中心注册
eureka.client.registryFetchIntervalSeconds=5
eureka.client.service-url.defaultZone=${EUREKA_SERVICE_URL:http://localhost:8761}/eureka/
eureka.instance.leaseRenewalIntervalInSeconds=10


# 健康检查路径
eureka.instance.health-check-url-path=/actuator/health
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=ALWAYS
```

*   添加邮件提醒功能 

pom文件添加依赖包

```$xslt

<!--email依赖包，用于异常邮件通知-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>

```


配置文件添加

```$xslt
## 配置邮件
#spring.mail.host=smtp.qq.com
## 设置用户名
#spring.mail.username=senduser@qq.com
## 设置密码，该处的密码是QQ邮箱开启SMTP的授权码而非QQ密码
##登录邮箱->设置->账户->开启IMAP/SMTP服务
#spring.mail.password=xxxxx
## 当我们已注册的客户端的状态从 UP 变为 OFFLINE 或其他状态，
## 服务端就会自动将电子邮件发送到xxxx@qq.com。
#spring.boot.admin.notify.mail.to=touser@qq.com
#spring.boot.admin.notify.mail.from=fromuser@qq.com
#spring.mail.default-encoding=UTF-8
##安全认证(默认是true)=true
#spring.mail.properties.mail.smtp.auth=true
#spring.mail.properties.mail.debug=true
#spring.mail.properties.mail.smtp.timeout=1000
#spring.mail.properties.mail.smtp.port=465
#
##开启ssl加密 否则项目启动时报530error
#spring.mail.properties.mail.smtp.ssl.enable=true
#spring.mail.properties.mail.smtp.ssl.socketFactory=sf
#
#spring.mail.properties.mail.smtp.socketFactory.port=465
#spring.mail.properties.mail.smtp.socketFactory.fallback=false
#spring.mail.properties.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
#spring.mail.properties.mail.smtp.starttls.enable=true
#spring.mail.properties.mail.smtp.starttls.required=true

```


