package com.hezhe.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 贺哲
 * @2020-02-05 10:35
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //默认访问根路径的时候重定向到登录页面，此页面是由springSecurity提供的
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("redirect:/login-view");
//        registry.addViewController("/login-view").setViewName("login");
//    }
}
