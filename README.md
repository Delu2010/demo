# Spring Boot 博客系统代码题

本项目主要使用了SpringBoot、MyBatisPlus、MySQL等技术进行开发

## 实现思路

本项目通过定义全局异常处理器实现了对全局异常的捕获，并定义了统一的返回类 `Result<T>`。使用JWT令牌技术生成和管理token，在拦截器和过滤器中对以下路径进行了登录认证拦截：

- `GET /api/auth/me` - 获取当前用户信息
- `POST /api/posts` - 创建新文章
- `PUT /api/posts/{id}` - 更新文章
- `DELETE /api/posts/{id}` - 删除文章

密码加密采用MD5算法。文章的创建、更新和删除操作使用了ThreadLocal获取当前用户信息，并在这些操作中进行了用户权限校验

## 注意事项：

使用本项目之前，需要将项目根目录下的 `blogging_system.sql` 导入到自己的数据库中，并修改`application.yml` 配置文件中的 `url`、`username` 和 `password`，以匹配自己的数据库配置。然后进行重新编译打包。

## Docker 部署说明

**构建 Docker 镜像**：

​		打开终端，导航到项目根目录，运行 `docker build -t my-java-app .` 进行构建。

**运行 Docker 容器**：

​		使用 `docker run -d -p 8080:8080 --name my-java-container my-java-app` 启动容器。