package com.lcd.bloggingsystem.controller;

import com.lcd.bloggingsystem.model.dto.LoginDto;
import com.lcd.bloggingsystem.model.dto.RegisterDto;
import com.lcd.bloggingsystem.model.vo.Result;
import com.lcd.bloggingsystem.model.po.User;
import com.lcd.bloggingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    // 用户注册
    @PostMapping("/register")
    public Result register(@RequestBody @Validated RegisterDto registerDto) {
        return userService.register(registerDto);
    }

    // 用户登录
    @PostMapping("/login")
    public Result login(@RequestBody @Validated LoginDto loginDto) {
        return userService.login(loginDto);
    }

    // 获取当前用户信息
    @GetMapping("/me")
    public Result<User> getUserInfo() {
        return userService.getUserInfo();
    }
}
