/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 08/11/2019 14:07:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` double NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '电冰箱', 2600, 51);
INSERT INTO `product` VALUES (2, '电视机', 230, 30);
INSERT INTO `product` VALUES (3, '电灯泡', 80, 60);
INSERT INTO `product` VALUES (7, '华硕笔记本', 7600, 20);
INSERT INTO `product` VALUES (8, '手机', 3600, 30);
INSERT INTO `product` VALUES (9, 'Java基础', 36, 50);
INSERT INTO `product` VALUES (10, 'JavaEE', 48, 129);
INSERT INTO `product` VALUES (11, 'C语言', 28, 30);
INSERT INTO `product` VALUES (14, 'Mysql', 37, 30);
INSERT INTO `product` VALUES (15, 'Oracle', 37, 30);
INSERT INTO `product` VALUES (16, '计算机组成原理', 88, 55);
INSERT INTO `product` VALUES (17, '小电筒', 15, 100);
INSERT INTO `product` VALUES (18, '神州笔记本', 4500, 30);

SET FOREIGN_KEY_CHECKS = 1;
