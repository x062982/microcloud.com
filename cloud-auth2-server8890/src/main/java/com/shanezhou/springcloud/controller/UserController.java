package com.shanezhou.springcloud.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShaneZhou
 * @since 2020/9/23 周三
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/user")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }
}
