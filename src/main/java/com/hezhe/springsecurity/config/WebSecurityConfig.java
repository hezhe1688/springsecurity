package com.hezhe.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 贺哲
 * @2020-02-05 10:39
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启方法权限控制
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 密码编码器
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 进行认证，没有权限不可以访问
     *
     * @param httpSecurity
     * @throws Exception
     */
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable() //屏蔽csrf的控制
                .authorizeRequests()
                .antMatchers("/r/r1").hasAuthority("p1")//访问/r/r1 必须拥有 p1权限
                .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated()//   这个路径/r/**下的都需要认证才可以访问
                .anyRequest().permitAll() //  除/r/**这个以为其他的都可以访问
                .and()
                .formLogin() //允许表单登录
                .loginPage("/") //进入登录页面
                .loginProcessingUrl("/login") //登录表单提交的请求路径，自动进行登录认证
                .successForwardUrl("/success") //自定义登录成功页面
                .and()
                .logout()
                .logoutUrl("/logout") //springsecurity登出路径
                .logoutSuccessUrl("/");  //退出以后进入到登录页面（自定义）
    }
}