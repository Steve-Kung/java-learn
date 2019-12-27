package com.steve.config;

import com.steve.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration // 完全取代配置文件
@ComponentScan("com.steve.pojo")
//@Import(SteveConfig.class)
public class UserConfig {
    @Bean
    public User getUser(){
        return new User();
    }
}
