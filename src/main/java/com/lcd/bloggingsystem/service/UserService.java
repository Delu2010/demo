package com.lcd.bloggingsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lcd.bloggingsystem.model.dto.LoginDto;
import com.lcd.bloggingsystem.model.dto.RegisterDto;
import com.lcd.bloggingsystem.model.po.User;
import com.lcd.bloggingsystem.model.vo.Result;

public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param registerDto
     * @return
     */
    public Result register(RegisterDto registerDto);

    /**
     * 用户登录
     * @param loginDto
     * @return
     */
    public Result login(LoginDto loginDto);

    /**
     * 获取当前用户信息
     * @return
     */
    public Result<User> getUserInfo();

}
