package com.lcd.bloggingsystem.controller;

import com.lcd.bloggingsystem.model.dto.PageParams;
import com.lcd.bloggingsystem.model.po.Article;
import com.lcd.bloggingsystem.model.vo.PageResult;
import com.lcd.bloggingsystem.model.dto.ArticleDto;
import com.lcd.bloggingsystem.model.vo.Result;
import com.lcd.bloggingsystem.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // 创建新文章
    @PostMapping
    public Result createNewArticle(@RequestBody ArticleDto articleDto) {
        return articleService.createNewArticle(articleDto);
    }

    // 获取某个用户的所有文章 支持分页/按创建时间正/倒序
    @GetMapping
    public Result<PageResult<Article>> getArticlesByAuthor(Long uid, @RequestBody(required = false) PageParams pageParams) {
        return articleService.getArticlesByAuthor(uid, pageParams);
    }

    // 获取单篇文章详情
    @GetMapping("/{id}")
    public Result<Article> getArticleById(@PathVariable("id") Long id) {
        return articleService.getArticleById(id);
    }

    // 更新文章（需要登录和权限判断）、
    @PutMapping("/{id}")
    public Result updateArticle(@PathVariable("id") Long id, @RequestBody ArticleDto articleDto) {
        return articleService.updateArticle(id, articleDto);
    }

    // 删除文章（需要登录和权限判断）
    @DeleteMapping("/{id}")
    public Result deleteArticle(@PathVariable("id") Long id) {
        return articleService.deleteArticle(id);
    }
}
