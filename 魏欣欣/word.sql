/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50701
Source Host           : localhost:3306
Source Database       : learnchinese

Target Server Type    : MYSQL
Target Server Version : 50701
File Encoding         : 65001

Date: 2020-04-21 13:57:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for word
-- ----------------------------
DROP TABLE IF EXISTS `word`;
CREATE TABLE `word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(255) DEFAULT NULL,
  `pinyin` varchar(255) DEFAULT NULL,
  `explanation` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `findlevel` int(11) DEFAULT NULL,
  `likeword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of word
-- ----------------------------
INSERT INTO `word` VALUES ('1', '春', null, null, null, '1', '春，青，夏，菁');
INSERT INTO `word` VALUES ('2', '冬', null, null, null, '1', '冬，佟');
INSERT INTO `word` VALUES ('3', '风', null, null, null, '1', '风，凤，讽');
INSERT INTO `word` VALUES ('4', '雪', null, null, null, '1', '雪，雨，学');
INSERT INTO `word` VALUES ('5', '花', null, null, null, '1', '花，草');
INSERT INTO `word` VALUES ('6', '飞', null, null, null, '1', '飞，厂，非');
INSERT INTO `word` VALUES ('7', '入', null, null, null, '1', '入，人，大');
INSERT INTO `word` VALUES ('8', '姓', null, null, null, '1', '姓，蛙，娃');
INSERT INTO `word` VALUES ('9', '什', null, null, null, '1', '什，佳，价');
INSERT INTO `word` VALUES ('10', '么', null, null, null, '1', '么，会，什');
INSERT INTO `word` VALUES ('11', '双', null, null, null, '1', '双，又，口');
INSERT INTO `word` VALUES ('12', '国', null, null, null, '1', '国，固，囫，囵');
INSERT INTO `word` VALUES ('13', '王', null, null, null, '1', '王,主，玉');
INSERT INTO `word` VALUES ('14', '方', null, null, null, '1', '方，万');
