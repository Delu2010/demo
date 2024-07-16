package com.lcd.bloggingsystem.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {

    // 主键
    @TableId(type = IdType.AUTO)
    private Long userId;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 邮箱
    private String email;

    // 创建时间
    private LocalDateTime created;

    // 更新时间
    private LocalDateTime lastModified;
}
