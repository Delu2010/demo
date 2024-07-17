# 使用官方的 OpenJDK 镜像作为基础镜像
FROM openjdk:17.0.1-jdk

# 设置工作目录
WORKDIR /app

# 将生成的 JAR 包复制到工作目录中
COPY target/bloggingSystem-0.0.1-SNAPSHOT.jar /app/MyApp.jar

# 运行 Java 应用
CMD ["java", "-jar", "MyApp.jar"]
