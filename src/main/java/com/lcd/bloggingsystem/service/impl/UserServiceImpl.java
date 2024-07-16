package com.lcd.bloggingsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcd.bloggingsystem.mapper.UserMapper;
import com.lcd.bloggingsystem.service.UserService;
import com.lcd.bloggingsystem.utils.JwtUtil;
import com.lcd.bloggingsystem.utils.Md5Util;
import com.lcd.bloggingsystem.model.dto.LoginDto;
import com.lcd.bloggingsystem.model.dto.RegisterDto;
import com.lcd.bloggingsystem.model.po.User;
import com.lcd.bloggingsystem.model.vo.Result;
import com.lcd.bloggingsystem.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 用户注册
     * @param registerDto
     * @return
     */
    @Override
    public Result register(RegisterDto registerDto) {

        if (!registerDto.getPassword().equals(registerDto.getRePassword())) {
            return Result.error("两次输入的密码不一致");
        }

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, registerDto.getUsername());
        User user = this.getOne(lambdaQueryWrapper);
        if (user != null) {
            return Result.error("用户名已存在");
        }


        user = new User();
        String password = Md5Util.getMD5String(registerDto.getRePassword());
        user.setUsername(registerDto.getUsername());
        user.setPassword(password);
        user.setEmail(registerDto.getEmail());
        user.setCreated(LocalDateTime.now());
        user.setLastModified(LocalDateTime.now());
        save(user);

        return Result.success("注册成功");
    }

    /**
     * 用户登录
     * @param loginDto
     * @return
     */
    @Override
    public Result login(LoginDto loginDto) {

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, loginDto.getUsername());
        User user = this.getOne(lambdaQueryWrapper);
        if (user == null) {
            return Result.error("该用户不存在");
        }

        String password = Md5Util.getMD5String(loginDto.getPassword());
        if (!password.equals(user.getPassword())) {
            return Result.error("密码错误");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getUserId());
        claims.put("username", user.getUsername());
        String token = JwtUtil.genToken(claims);
        return Result.success("登录成功", token);
    }

    /**
     * 获取当前用户信息
     * @return
     */
    @Override
    public Result<User> getUserInfo() {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userId");

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserId, userId);
        User user = this.getOne(lambdaQueryWrapper);
        if (user == null) {
            return Result.error("当前用户不存在");
        }
        user.setPassword(null);
        return Result.success("获取用户信息成功", user);
    }
}
