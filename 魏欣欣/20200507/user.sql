/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50701
Source Host           : localhost:3306
Source Database       : learnchinese

Target Server Type    : MYSQL
Target Server Version : 50701
File Encoding         : 65001

Date: 2020-05-07 17:41:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `levelone` int(11) DEFAULT NULL,
  `leveltwo` int(11) DEFAULT NULL,
  `levelthree` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '4', '3', '2');
