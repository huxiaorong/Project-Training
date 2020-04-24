/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : leachinese

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2020-04-24 11:35:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `wordId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `levelName` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES ('1', '小学 一年级 上册', 'classoneup.jpg');
INSERT INTO `level` VALUES ('2', '小学 一年级 下册', 'classOneDown.jpg');
INSERT INTO `level` VALUES ('3', '小学 二年级 上册', 'classTwoOn.jpg');
INSERT INTO `level` VALUES ('4', '小学 二年级 下册', 'classTwoDown.jpg');
INSERT INTO `level` VALUES ('5', '小学 三年级 上册', 'classThreeOn.jpg');
INSERT INTO `level` VALUES ('6', '小学 三年级 下册', 'classThreeDown.jpg');
INSERT INTO `level` VALUES ('7', '小学 四年级 上册', 'classFourOn.jpg');
INSERT INTO `level` VALUES ('8', '小学 四年级 下册', 'classFourDown.jpg');
INSERT INTO `level` VALUES ('9', '小学 五年级 上册', 'classFIveOn.jpg');
INSERT INTO `level` VALUES ('10', '小学 五年级 下册', 'classFiveDown.jpg');
INSERT INTO `level` VALUES ('11', '小学 六年级 上册', 'classSixOn.jpg');
INSERT INTO `level` VALUES ('12', '小学 六年级 下册', 'classSixDown.jpg');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `studiedTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1', '2020-04-23 11:13:22');
INSERT INTO `record` VALUES ('2', '1', '2020-04-23 12:43:13');
INSERT INTO `record` VALUES ('3', '1', '2020-04-23 12:54:15');
INSERT INTO `record` VALUES ('4', '1', '2020-04-23 12:55:25');
INSERT INTO `record` VALUES ('5', '1', '2020-04-23 20:00:32');
INSERT INTO `record` VALUES ('6', '1', '2020-04-23 20:41:28');
INSERT INTO `record` VALUES ('7', '1', '2020-04-23 20:56:27');
INSERT INTO `record` VALUES ('8', '1', '2020-04-24 11:27:46');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `studiedTag` int(11) DEFAULT '1',
  `numberTag` int(11) DEFAULT '0',
  `levelTag` int(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小明', '13912345678', '男', '2', '4', '1', null);

-- ----------------------------
-- Table structure for userprogress
-- ----------------------------
DROP TABLE IF EXISTS `userprogress`;
CREATE TABLE `userprogress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `studiedTag` int(11) DEFAULT '1',
  `numberTag` int(11) DEFAULT '0',
  `levelTag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userprogress
-- ----------------------------
INSERT INTO `userprogress` VALUES ('1', '1', '2', '4', '1');

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
  `pinyin1` varchar(255) DEFAULT NULL,
  `sentence2` varchar(255) DEFAULT NULL,
  `pinyin2` varchar(255) DEFAULT NULL,
  `sentence3` varchar(255) DEFAULT NULL,
  `pinyin3` varchar(255) DEFAULT NULL,
  `tag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of word
-- ----------------------------
INSERT INTO `word` VALUES ('1', '春', 'chūn', '春.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1');
INSERT INTO `word` VALUES ('2', '冬', 'dōng', '冬.m4a', '1.冬季。2.姓。3.同“咚”', '冬天', 'dōng tiān', '寒冬', 'hán dōng', '丁冬', 'dīng dōng', '1');
INSERT INTO `word` VALUES ('3', '风', 'fēng', '风.m4a', '', null, null, null, null, null, null, '1');
INSERT INTO `word` VALUES ('4', '雪', 'xuě', '春.m4a', null, null, null, null, null, null, null, '1');
INSERT INTO `word` VALUES ('5', '花', 'huā', null, null, null, null, null, null, null, null, '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wrongword
-- ----------------------------
INSERT INTO `wrongword` VALUES ('1', '1', '2020-04-22 16:55:29', '1');
INSERT INTO `wrongword` VALUES ('2', '1', '2020-04-23 11:50:17', '1');
