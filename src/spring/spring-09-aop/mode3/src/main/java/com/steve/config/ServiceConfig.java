package com.steve.config;

import com.steve.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.steve")
@EnableAspectJAutoProxy
public class ServiceConfig {
//    @Bean
//    public UserServiceImpl getUserServiceImpl(){
//        return new UserServiceImpl();
//    }
}
