/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : blogging_system

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 17/07/2024 14:24:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `post_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内容',
  `user_id` int NOT NULL COMMENT '作者id',
  `created` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `last_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, 'Java训练营', 'Java训练营Java训练营Java训练营Java训练营Java训练营', 1, '2024-07-16 18:32:27', '2024-07-16 18:32:27');
INSERT INTO `article` VALUES (2, 'asddasdasdasd', 'afsddashsfdhhfgfdhfdgfhfdgh', 1, '2024-07-16 19:51:03', '2024-07-16 21:40:57');
INSERT INTO `article` VALUES (4, 'Java训练营', 'Java训练营Java训练营Java训练营Java训练营Java训练营', 1, '2024-07-16 19:51:05', '2024-07-16 19:51:05');
INSERT INTO `article` VALUES (5, 'Java训练营', 'Java训练营Java训练营Java训练营Java训练营Java训练营', 1, '2024-07-16 19:51:06', '2024-07-16 19:51:06');
INSERT INTO `article` VALUES (6, 'Java训练营', 'Java训练营Java训练营Java训练营Java训练营Java训练营', 1, '2024-07-16 19:51:06', '2024-07-16 19:51:06');
INSERT INTO `article` VALUES (7, 'Java训练营', 'Java训练营Java训练营Java训练营Java训练营Java训练营', 1, '2024-07-16 19:51:08', '2024-07-16 19:51:08');
INSERT INTO `article` VALUES (8, 'Java训练营', 'Java训练营Java训练营Java训练营Java训练营Java训练营', 1, '2024-07-16 21:32:09', '2024-07-16 21:32:09');
INSERT INTO `article` VALUES (9, 'Java训练营', 'Java训练营Java训练营Java训练营Java训练营Java训练营', 1, '2024-07-16 21:39:02', '2024-07-16 21:39:02');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
  `created` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `last_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'delu', 'e10adc3949ba59abbe56e057f20f883e', '3376451753@qq.com', '2024-07-16 17:06:25', '2024-07-16 17:06:26');
INSERT INTO `user` VALUES (2, 'delulu', 'e10adc3949ba59abbe56e057f20f883e', '3376451753@qq.com', '2024-07-16 17:07:40', '2024-07-16 17:07:40');
INSERT INTO `user` VALUES (3, 'delululu', 'e10adc3949ba59abbe56e057f20f883e', '3376451753@qq.com', '2024-07-16 21:31:21', '2024-07-16 21:31:21');
INSERT INTO `user` VALUES (4, 'delulul', 'e10adc3949ba59abbe56e057f20f883e', '3376451753@qq.com', '2024-07-16 21:38:19', '2024-07-16 21:38:19');

SET FOREIGN_KEY_CHECKS = 1;
