package com.shanezhou.springcloud.controllerview;

import com.shanezhou.springcloud.entity.AccountEntity;
import com.shanezhou.springcloud.service.IAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ShaneZhou
 * @since 2020/9/27 周日
 */
@Controller
//@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/login")
    public String login(@RequestParam(value = "userName", required = false) String userName,
                        @RequestParam(value = "password", required = false) String password,
                        HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            return "index";
        }
        Map<String, Object> map = new HashMap<>();
        AccountEntity accountEntity = accountService.getAccountByName(userName);
        // 记住我
        //String remember = request.getParameter("remember");
        if (accountEntity == null || !accountEntity.getPassword().equals(password)){
            map.put("msg", "密码错误！");
            return "index";
        } else {
            return "redirect:/main";
        }
    }

    @PostMapping("/logout")
    public String logout() {
        return "login";
    }

    @GetMapping("/list")
    public String toList() {
        return "list";
    }

    @GetMapping("/success")
    public String toSuccess() {
        return "success";
    }
}
