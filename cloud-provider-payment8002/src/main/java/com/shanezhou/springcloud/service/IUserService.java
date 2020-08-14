package com.shanezhou.springcloud.service;

import com.shanezhou.springcloud.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/13 星期四
 */
@RestController
public interface IUserService {

    @GetMapping("/user")
    User findByName(@RequestParam("name") String name);
}
