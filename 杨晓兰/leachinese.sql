/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : leachinese

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2020-04-20 11:00:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for calendar
-- ----------------------------
DROP TABLE IF EXISTS `calendar`;
CREATE TABLE `calendar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `studiedTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of calendar
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `studiedTag` int(11) DEFAULT NULL,
  `numberTag` int(11) DEFAULT NULL,
  `levelTag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for word
-- ----------------------------
DROP TABLE IF EXISTS `word`;
CREATE TABLE `word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(255) DEFAULT NULL,
  `pinyin` varchar(255) DEFAULT NULL,
  `audio` varchar(255) DEFAULT NULL,
  `explanation` varchar(255) DEFAULT NULL,
  `sentence1` varchar(255) DEFAULT NULL,
  `sentence2` varchar(255) DEFAULT NULL,
  `sentence3` varchar(255) DEFAULT NULL,
  `tag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of word
-- ----------------------------
INSERT INTO `word` VALUES ('1', '春', 'chūn', null, '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', '春节', '春日', null);
INSERT INTO `word` VALUES ('2', '冬', 'dōng', null, null, null, null, null, null);
INSERT INTO `word` VALUES ('3', '风', 'fēng', null, null, null, null, null, null);
INSERT INTO `word` VALUES ('4', '雪', 'xuě', null, null, null, null, null, null);
INSERT INTO `word` VALUES ('5', '花', 'huā', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for wrongword
-- ----------------------------
DROP TABLE IF EXISTS `wrongword`;
CREATE TABLE `wrongword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wordId` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wrongword
-- ----------------------------
