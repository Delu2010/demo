package com.lcd.bloggingsystem.config;

import com.lcd.bloggingsystem.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/auth/login", "/auth/register")
                .excludePathPatterns("/api/posts")
                .excludePathPatterns("/api/posts/*")
                .addPathPatterns("/**")  // 默认拦截所有路径
                .excludePathPatterns("/api/posts/{id}");
    }
}
