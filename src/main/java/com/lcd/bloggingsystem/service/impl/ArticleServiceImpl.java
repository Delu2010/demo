package com.lcd.bloggingsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcd.bloggingsystem.mapper.ArticleMapper;
import com.lcd.bloggingsystem.model.dto.ArticleDto;
import com.lcd.bloggingsystem.model.dto.PageParams;
import com.lcd.bloggingsystem.model.po.Article;
import com.lcd.bloggingsystem.model.vo.PageResult;
import com.lcd.bloggingsystem.model.vo.Result;
import com.lcd.bloggingsystem.service.ArticleService;
import com.lcd.bloggingsystem.utils.ThreadLocalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {

    /**
     * 创建新文章
     * @param articleDto
     * @return
     */
    @Override
    public Result createNewArticle(ArticleDto articleDto) {

        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userId");

        Article article = new Article();
        BeanUtils.copyProperties(articleDto, article);
        article.setUserId(Long.valueOf(userId));
        article.setCreated(LocalDateTime.now());
        article.setLastModified(LocalDateTime.now());

        boolean save = this.save(article);
        if (!save) {
            return Result.error("创建文章失败");
        }

        return Result.success("创建文章成功");
    }

    /**
     * 获取某个用户的所有文章 支持分页/安装件时间正/倒序
     * @param uid
     * @param pageParams
     * @return
     */
    @Override
    public Result<PageResult<Article>> getArticlesByAuthor(Long uid, PageParams pageParams) {

        if (pageParams == null) {
            pageParams = new PageParams();
        }

        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getUserId, uid);
        if (pageParams.getOrderBy()) {
            queryWrapper.orderByAsc(Article::getCreated);
        } else {
            queryWrapper.orderByDesc(Article::getCreated);
        }

        Page<Article> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        page = page(page, queryWrapper);
        if (page.getRecords() == null) {
            return Result.success("该用户没有文章");
        }
        PageResult<Article> pageResult = new PageResult<>(page.getRecords(), page.getTotal(), pageParams.getPageNo(), pageParams.getPageSize());

        return Result.success("查询成功", pageResult);

    }

    /**
     * 获取单篇文章详情
     * @param id
     * @return
     */
    @Override
    public Result<Article> getArticleById(Long id) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getPostId, id);
        Article article = this.getOne(queryWrapper);
        if (article == null) {
            return Result.error("文章不存在");
        }
        return Result.success("查询成功", article);
    }

    /**
     * 更新文章
     * @param id
     * @param articleDto
     * @return
     */
    @Override
    public Result updateArticle(Long id, ArticleDto articleDto) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getPostId, id);
        Article article = this.getOne(queryWrapper);
        if (article == null) {
            return Result.error("文章不存在");
        }
        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        article.setLastModified(LocalDateTime.now());
        boolean update = this.updateById(article);
        if (!update) {
            return Result.error("更新文章失败");
        }
        return Result.success("更新文章成功");
    }


    /**
     * 删除文章
     * @param id
     * @return
     */
    @Override
    public Result deleteArticle(Long id) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getPostId, id);
        Article article = this.getOne(queryWrapper);
        if (article == null) {
            return Result.error("文章不存在");
        }
        boolean remove = remove(queryWrapper);

        if (!remove) {
            return Result.error("删除文章失败");
        }
        return Result.success("删除文章成功");
    }
}
