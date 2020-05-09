package com.springcloud.cherry.web.controller;

import com.netflix.discovery.converters.Auto;
import com.springcloud.cherry.web.config.GitConfig;
import com.springcloud.cherry.web.config.LocalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhujun
 * @Email
 * @Date 2020/5/9  5:21 PM
 * @Version
 **/
@RestController(value = "/config")
//@RefreshScope
public class ConfigController {

    @Autowired
    private LocalConfig localConfig;

    @Autowired
    private GitConfig gitConfig;


    @GetMapping(value = "/local")
    public Object local(){
        return  localConfig;
    }

    @GetMapping(value = "/git")
    public Object git(){
        return  gitConfig;
    }

}
