package com.lcd.bloggingsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lcd.bloggingsystem.model.dto.ArticleDto;
import com.lcd.bloggingsystem.model.dto.PageParams;
import com.lcd.bloggingsystem.model.po.Article;
import com.lcd.bloggingsystem.model.vo.PageResult;
import com.lcd.bloggingsystem.model.vo.Result;

public interface ArticleService extends IService<Article> {

    /**
     * 创建新文章
     * @param articleDto
     * @return
     */
    public Result createNewArticle(ArticleDto articleDto);

    /**
     * 获取某个用户的所有文章 支持分页/安装件时间正/倒序
     * @param uid
     * @param pageParams
     * @return
     */
    public Result<PageResult<Article>> getArticlesByAuthor(Long uid, PageParams pageParams);

    /**
     * 获取单篇文章详情
     * @param id
     * @return
     */
    public Result<Article> getArticleById(Long id);

    /**
     * 更新文章
     * @param id
     * @param articleDto
     * @return
     */
    public Result updateArticle(Long id, ArticleDto articleDto);

    /**
     * 删除文章
     * @param id
     * @return
     */
    public Result deleteArticle(Long id);
}
