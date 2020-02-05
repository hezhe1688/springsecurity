package com.hezhe.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 贺哲
 * @2020-02-05 11:49
 */
@Controller
public class UserController {

    @RequestMapping(value = {"/"})
    public String to_login() {
        return "login";
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }

    @ResponseBody
    @GetMapping("/test1")
    @PreAuthorize("hasAuthority('p:test1')")
    public String test1() {
        return getUserName() + "test1";
    }

    @ResponseBody
    @GetMapping("/test2")
    @PreAuthorize("hasAuthority('p:test2')")
    public String test2() {
        return getUserName() + "test2";
    }

    //获取当前用户信息
    public String getUserName() {
        String username = null;
        //当前认真通过的用户上下文信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal == null) {
            username = "游客";
        }
        if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}
