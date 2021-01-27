/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2020-11-11 09:51:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` varchar(32) NOT NULL,
  `cname` varchar(50) DEFAULT NULL,
  `is_del` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('c001', '家电', '0');
INSERT INTO `category` VALUES ('c002', '服饰', '0');
INSERT INTO `category` VALUES ('c003', '化妆品', '0');
INSERT INTO `category` VALUES ('c004', '食品', '0');
INSERT INTO `category` VALUES ('c005', '数码', '0');
INSERT INTO `category` VALUES ('c006', '哈哈哈', '0');
INSERT INTO `category` VALUES ('c007', '不会吧', '0');
INSERT INTO `category` VALUES ('c008', '就这就这', '0');
INSERT INTO `category` VALUES ('c009', '随便加一个', '0');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `pid` varchar(32) NOT NULL,
  `pname` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `is_del` varchar(2) DEFAULT NULL,
  `flag` varchar(2) DEFAULT NULL,
  `category_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `products_fk` (`category_id`),
  CONSTRAINT `products_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('p001', '联想', '5000', '0', '1', 'c001');
INSERT INTO `products` VALUES ('p002', '海尔', '3000', '0', '1', 'c001');
INSERT INTO `products` VALUES ('p003', '雷神', '5000', '0', '1', 'c001');
INSERT INTO `products` VALUES ('p004', 'JACKJONES', '800', '0', '1', 'c002');
INSERT INTO `products` VALUES ('p005', '真维斯', '200', '0', '1', 'c002');
INSERT INTO `products` VALUES ('p006', '花花公子', '440', '0', '1', 'c002');
INSERT INTO `products` VALUES ('p007', '劲霸', '2000', '0', '1', 'c002');
INSERT INTO `products` VALUES ('p008', '香奈儿', '800', '0', '1', 'c003');
INSERT INTO `products` VALUES ('p009', '相宜本草', '200', '0', '1', 'c003');
INSERT INTO `products` VALUES ('p010', '哈哈哈哈', '3000', '0', '1', 'c001');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(10) DEFAULT NULL COMMENT '0为待审核 1为通过 2为未通过',
  `is_del` int(10) DEFAULT NULL COMMENT '0为未删除 1为已删除',
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xxx', '111', '1', '0', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('2', '11', '11', '0', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('3', '22', '22', '1', '0', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('4', '33', '33', '1', '0', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('5', '34', '34', '1', '0', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('6', '551', '44', '1', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('9', '554', '77', '2', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('10', '555', '88', '2', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('11', '556', '99', '2', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('12', '557', '00', '2', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('13', '558', '112', '0', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('14', '111', '111', '0', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('15', '2222', '222', '0', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('16', '1', '3333', '0', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('17', 'xxxx', '111', '0', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('18', 'xxxxx', '1', '0', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('19', '123', '123', '0', '1', '/upload/img/avatar04.png');
INSERT INTO `user` VALUES ('20', '122', '122', '1', '1', '/upload/img/avatar04.png');
