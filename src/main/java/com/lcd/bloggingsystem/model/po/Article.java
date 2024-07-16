package com.lcd.bloggingsystem.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("article")
public class Article {

    // 主键
    @TableId(type = IdType.AUTO)
    private Long postId;

    // 标题
    private String title;

    // 内容
    private String content;

    // 作者ID
    private Long userId;

    // 创建时间
    private LocalDateTime created;

    // 更新时间
    private LocalDateTime lastModified;
}
