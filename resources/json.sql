/*
Navicat MySQL Data Transfer

Source Server         : userInfo
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : json

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2016-05-20 10:17:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `img` varchar(255) NOT NULL DEFAULT '' COMMENT '头像url',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `age` int(5) NOT NULL DEFAULT '20' COMMENT '年龄',
  `intro` varchar(255) NOT NULL DEFAULT '' COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'http://pic.huakr.com/huahan/app/diary/2016-04-28/gkVpbOMgINNhsryF.jpg', '张三', '20', '简介');
INSERT INTO `userinfo` VALUES ('2', 'http://pic.huakr.com/huahan/app/diary/2016-04-27/vWnpUpUZSekmHgzQ.jpg', '付城鹏', '20', '简介');
INSERT INTO `userinfo` VALUES ('3', 'http://pic.huakr.com/huahan/app/diary/2016-04-25/lJIIfwRRAiiKxxRV.png', '刘鹏', '20', '简介');
