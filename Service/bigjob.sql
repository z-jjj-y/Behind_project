/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 80037 (8.0.37)
 Source Host           : localhost:3306
 Source Schema         : bigjob

 Target Server Type    : MySQL
 Target Server Version : 80037 (8.0.37)
 File Encoding         : 65001

 Date: 29/05/2024 14:06:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for archives
-- ----------------------------
DROP TABLE IF EXISTS `archives`;
CREATE TABLE `archives`  (
  `archive_id` int NOT NULL AUTO_INCREMENT,
  `group_project_id` int NOT NULL,
  `final_score` int NULL DEFAULT NULL,
  `rating` enum('very poor','poor','average','good','excellent') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`archive_id`) USING BTREE,
  INDEX `group_project_id`(`group_project_id` ASC) USING BTREE,
  CONSTRAINT `archives_ibfk_1` FOREIGN KEY (`group_project_id`) REFERENCES `group_projects` (`group_project_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `archives_chk_1` CHECK ((`final_score` >= 0) and (`final_score` <= 100))
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of archives
-- ----------------------------
INSERT INTO `archives` VALUES (1, 1, 90, 'excellent', '2024-05-20 13:34:57');
INSERT INTO `archives` VALUES (2, 2, 80, 'good', '2024-05-20 13:34:57');
INSERT INTO `archives` VALUES (3, 4, 85, 'good', '2024-05-20 13:34:57');
INSERT INTO `archives` VALUES (4, 5, 90, 'excellent', '2024-05-20 13:34:57');

-- ----------------------------
-- Table structure for grades
-- ----------------------------
DROP TABLE IF EXISTS `grades`;
CREATE TABLE `grades`  (
  `grade_id` int NOT NULL AUTO_INCREMENT,
  `group_project_id` int NOT NULL,
  `teacher_id` int NOT NULL,
  `score` int NULL DEFAULT NULL,
  `comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`grade_id`) USING BTREE,
  INDEX `group_project_id`(`group_project_id` ASC) USING BTREE,
  INDEX `teacher_id`(`teacher_id` ASC) USING BTREE,
  CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`group_project_id`) REFERENCES `group_projects` (`group_project_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `grades_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `grades_chk_1` CHECK ((`score` >= 0) and (`score` <= 100))
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of grades
-- ----------------------------
INSERT INTO `grades` VALUES (1, 1, 2, 85, '非常出色的表现！', '2024-05-20 13:34:57');
INSERT INTO `grades` VALUES (2, 2, 2, 75, '有一些进步但还需努力！', '2024-05-20 13:34:57');
INSERT INTO `grades` VALUES (3, 4, 5, 80, '表现良好，继续努力！', '2024-05-20 13:34:57');
INSERT INTO `grades` VALUES (4, 5, 5, 90, '优秀的工作，继续保持！', '2024-05-20 13:34:57');

-- ----------------------------
-- Table structure for group_projects
-- ----------------------------
DROP TABLE IF EXISTS `group_projects`;
CREATE TABLE `group_projects`  (
  `group_project_id` int NOT NULL AUTO_INCREMENT,
  `group_id` int NOT NULL,
  `project_id` int NOT NULL,
  `status` enum('not started','in progress','completed') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'not started',
  `createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`group_project_id`) USING BTREE,
  INDEX `group_id`(`group_id` ASC) USING BTREE,
  INDEX `project_id`(`project_id` ASC) USING BTREE,
  CONSTRAINT `group_projects_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `user_groups` (`group_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `group_projects_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of group_projects
-- ----------------------------
INSERT INTO `group_projects` VALUES (1, 1, 1, 'not started', '2024-05-20 13:34:57');
INSERT INTO `group_projects` VALUES (2, 2, 2, 'in progress', '2024-05-20 13:34:57');
INSERT INTO `group_projects` VALUES (3, 3, 3, 'completed', '2024-05-20 13:34:57');
INSERT INTO `group_projects` VALUES (4, 4, 4, 'not started', '2024-05-20 13:34:57');
INSERT INTO `group_projects` VALUES (5, 5, 5, 'in progress', '2024-05-20 13:34:57');
INSERT INTO `group_projects` VALUES (6, 6, 6, 'completed', '2024-05-20 13:34:57');

-- ----------------------------
-- Table structure for projects
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects`  (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`project_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of projects
-- ----------------------------
INSERT INTO `projects` VALUES (1, '项目A', '这是项目A的描述', '2024-05-20 13:34:57');
INSERT INTO `projects` VALUES (2, '项目B', '这是项目B的描述', '2024-05-20 13:34:57');
INSERT INTO `projects` VALUES (3, '项目C', '这是项目C的描述', '2024-05-20 13:34:57');
INSERT INTO `projects` VALUES (4, '项目D', '这是项目D的描述', '2024-05-20 13:34:57');
INSERT INTO `projects` VALUES (5, '项目E', '这是项目E的描述', '2024-05-20 13:34:57');
INSERT INTO `projects` VALUES (6, '项目F', '这是项目F的描述', '2024-05-20 13:34:57');

-- ----------------------------
-- Table structure for reviews
-- ----------------------------
DROP TABLE IF EXISTS `reviews`;
CREATE TABLE `reviews`  (
  `review_id` int NOT NULL AUTO_INCREMENT,
  `reviewer_id` int NOT NULL,
  `group_project_id` int NOT NULL,
  `score` int NULL DEFAULT NULL,
  `comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`review_id`) USING BTREE,
  INDEX `reviewer_id`(`reviewer_id` ASC) USING BTREE,
  INDEX `group_project_id`(`group_project_id` ASC) USING BTREE,
  CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`reviewer_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`group_project_id`) REFERENCES `group_projects` (`group_project_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `reviews_chk_1` CHECK ((`score` >= 0) and (`score` <= 100))
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of reviews
-- ----------------------------
INSERT INTO `reviews` VALUES (1, 2, 1, 80, '项目A完成得很好！', '2024-05-20 13:34:57');
INSERT INTO `reviews` VALUES (2, 2, 2, 70, '项目B有些地方需要改进。', '2024-05-20 13:34:57');
INSERT INTO `reviews` VALUES (3, 5, 4, 75, '项目D有进步的空间。', '2024-05-20 13:34:57');
INSERT INTO `reviews` VALUES (4, 5, 5, 85, '项目E做得相当不错。', '2024-05-20 13:34:57');

-- ----------------------------
-- Table structure for user_groups
-- ----------------------------
DROP TABLE IF EXISTS `user_groups`;
CREATE TABLE `user_groups`  (
  `group_id` int NOT NULL AUTO_INCREMENT,
  `group_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `user_id` int NOT NULL,
  `role` enum('leader','member') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`group_id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `user_groups_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_groups
-- ----------------------------
INSERT INTO `user_groups` VALUES (1, '小组1', '这是小组1的描述', 1, 'leader', '2024-05-20 13:34:57');
INSERT INTO `user_groups` VALUES (2, '小组2', '这是小组2的描述', 2, 'leader', '2024-05-20 13:34:57');
INSERT INTO `user_groups` VALUES (3, '小组3', '这是小组3的描述', 3, 'member', '2024-05-20 13:34:57');
INSERT INTO `user_groups` VALUES (4, '小组4', '这是小组4的描述', 4, 'leader', '2024-05-20 13:34:57');
INSERT INTO `user_groups` VALUES (5, '小组5', '这是小组5的描述', 5, 'leader', '2024-05-20 13:34:57');
INSERT INTO `user_groups` VALUES (6, '小组6', '这是小组6的描述', 6, 'member', '2024-05-20 13:34:57');
INSERT INTO `user_groups` VALUES (8, '小组1', 'Description', 7, 'member', '2024-05-29 10:20:12');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` enum('student','teacher','admin') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `account`(`account` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'user1@example.com', '张三', 'password1', 'student', '2024-05-20 13:34:57');
INSERT INTO `users` VALUES (2, 'user2@example.com', '李四', 'password2', 'teacher', '2024-05-20 13:34:57');
INSERT INTO `users` VALUES (3, 'user3@example.com', '王五', 'password3', 'admin', '2024-05-20 13:34:57');
INSERT INTO `users` VALUES (4, 'user4@example.com', '赵六', 'password4', 'student', '2024-05-20 13:34:57');
INSERT INTO `users` VALUES (5, 'user5@example.com', '钱七', 'password5', 'teacher', '2024-05-20 13:34:57');
INSERT INTO `users` VALUES (6, 'user6@example.com', '孙八', 'password6', 'admin', '2024-05-20 13:34:57');
INSERT INTO `users` VALUES (7, 'tetun', 'testUser', 'testPassword', 'student', '2024-05-29 10:19:40');

SET FOREIGN_KEY_CHECKS = 1;
