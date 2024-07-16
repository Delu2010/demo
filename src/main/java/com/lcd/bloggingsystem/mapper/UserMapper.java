package com.lcd.bloggingsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcd.bloggingsystem.model.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
