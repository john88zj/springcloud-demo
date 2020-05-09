package com.springcloud.cherry.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description config配置中心--本地配置文件
 * @Author zhujun
 * @Email
 * @Date 2020/5/9  5:22 PM
 * @Version
 **/
@Data
@Component
@ConfigurationProperties(prefix = "local")
//@RefreshScope
public class LocalConfig {

    private String env;


    public static class UserInfo {
        private String username;

        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }


    private UserInfo user;

}
