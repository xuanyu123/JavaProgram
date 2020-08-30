/*
Navicat MySQL Data Transfer

Source Server         : aliyun-ecs
Source Server Version : 50731
Source Host           : 47.93.4.32:3306
Source Database       : ordermeal

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-08-30 13:09:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for o_admin
-- ----------------------------
DROP TABLE IF EXISTS `o_admin`;
CREATE TABLE `o_admin` (
  `id` int(5) NOT NULL,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_admin
-- ----------------------------
INSERT INTO `o_admin` VALUES ('1', 'admin', '123456', '2020-08-26 15:29:54');

-- ----------------------------
-- Table structure for o_class
-- ----------------------------
DROP TABLE IF EXISTS `o_class`;
CREATE TABLE `o_class` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `info` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_class
-- ----------------------------
INSERT INTO `o_class` VALUES ('1', '凉菜类', '凉菜类介绍');
INSERT INTO `o_class` VALUES ('2', '特色菜类', '特色菜类介绍');
INSERT INTO `o_class` VALUES ('3', '热菜类', '热菜类介绍');
INSERT INTO `o_class` VALUES ('4', '干锅类', '干锅类介绍');
INSERT INTO `o_class` VALUES ('5', '汤类', '汤类介绍');
INSERT INTO `o_class` VALUES ('8', '酒水类', '酒水类介绍');
INSERT INTO `o_class` VALUES ('9', 'sa', 'sa');
INSERT INTO `o_class` VALUES ('10', 'sas', 'sasa');
INSERT INTO `o_class` VALUES ('11', 'sas', 'sa');
INSERT INTO `o_class` VALUES ('12', 'sas', 'saas');
INSERT INTO `o_class` VALUES ('13', 'sasa', 'sasa');
INSERT INTO `o_class` VALUES ('14', 'sasa', 'sasa');

-- ----------------------------
-- Table structure for o_customertype
-- ----------------------------
DROP TABLE IF EXISTS `o_customertype`;
CREATE TABLE `o_customertype` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_customertype
-- ----------------------------
INSERT INTO `o_customertype` VALUES ('1', '普通客户');
INSERT INTO `o_customertype` VALUES ('2', 'VIP客户');
INSERT INTO `o_customertype` VALUES ('3', '员工');

-- ----------------------------
-- Table structure for o_meal
-- ----------------------------
DROP TABLE IF EXISTS `o_meal`;
CREATE TABLE `o_meal` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `mealName` varchar(32) NOT NULL,
  `classId` int(5) NOT NULL,
  `price` float(10,2) NOT NULL,
  `mealInfo` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `class_foreign` (`classId`),
  CONSTRAINT `class_foreign` FOREIGN KEY (`classId`) REFERENCES `o_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_meal
-- ----------------------------
INSERT INTO `o_meal` VALUES ('1', '泡椒凤爪', '1', '18.00', '泡椒凤爪是起源于重庆的民间独特美食');
INSERT INTO `o_meal` VALUES ('3', '皮蛋豆腐', '1', '12.00', '皮蛋豆腐介绍');
INSERT INTO `o_meal` VALUES ('4', '番茄蛋花汤', '5', '12.00', '番茄蛋花汤介绍');
INSERT INTO `o_meal` VALUES ('5', '辣子鸡', '3', '28.00', '辣子鸡介绍');
INSERT INTO `o_meal` VALUES ('6', '香辣小龙虾', '2', '38.00', '香辣小龙虾介绍');
INSERT INTO `o_meal` VALUES ('7', '干锅土鸡', '4', '28.00', '干锅土鸡介绍');
INSERT INTO `o_meal` VALUES ('9', '开味木耳', '1', '12.00', '开味木耳介绍');
INSERT INTO `o_meal` VALUES ('10', '紫菜蛋花汤', '5', '10.00', '紫菜蛋花汤介绍');
INSERT INTO `o_meal` VALUES ('11', '酸菜粉丝汤', '5', '12.00', '酸菜粉丝汤介绍');
INSERT INTO `o_meal` VALUES ('12', '酸汤肥牛', '2', '48.00', '酸汤肥牛介绍');
INSERT INTO `o_meal` VALUES ('13', '老妈鱼头', '2', '48.00', '老妈鱼头介绍');
INSERT INTO `o_meal` VALUES ('14', '旺仔', '8', '7.00', '旺仔介绍');

-- ----------------------------
-- Table structure for o_order
-- ----------------------------
DROP TABLE IF EXISTS `o_order`;
CREATE TABLE `o_order` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(255) NOT NULL,
  `totalAmount` int(5) NOT NULL,
  `totalMoney` float(10,2) NOT NULL,
  `sale` int(5) NOT NULL,
  `realMoney` float(10,2) NOT NULL,
  `cTypeId` int(5) NOT NULL,
  `cashier` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ctype_foreign` (`cTypeId`),
  KEY `ordernum_foreign` (`orderNum`),
  CONSTRAINT `ctype_foreign` FOREIGN KEY (`cTypeId`) REFERENCES `o_customertype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_order
-- ----------------------------
INSERT INTO `o_order` VALUES ('1', '960829720200830032214', '2', '30.00', '9', '27.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('2', '727977120200830032445', '2', '30.00', '8', '24.00', '2', 'MIke');
INSERT INTO `o_order` VALUES ('3', '453937220200830032828', '4', '60.00', '7', '42.00', '3', 'zhnagsan');
INSERT INTO `o_order` VALUES ('4', '129837320200830033047', '2', '40.00', '9', '36.00', '1', 'lisi');
INSERT INTO `o_order` VALUES ('5', '474333120200830033336', '2', '40.00', '8', '32.00', '2', 'wangwu');
INSERT INTO `o_order` VALUES ('6', '407291720200830033446', '2', '60.00', '8', '48.00', '2', 'Alice');
INSERT INTO `o_order` VALUES ('7', '672796320200830033615', '2', '40.00', '8', '32.00', '1', 'alice');
INSERT INTO `o_order` VALUES ('8', '679334120200830033736', '2', '50.00', '9', '45.00', '1', 'zhangsan');
INSERT INTO `o_order` VALUES ('9', '507996220200830033840', '2', '30.00', '9', '27.00', '2', 'lin');
INSERT INTO `o_order` VALUES ('10', '279715620200830035257', '2', '40.00', '8', '32.00', '2', 'mike');
INSERT INTO `o_order` VALUES ('11', '635107620200830035701', '2', '60.00', '9', '54.00', '1', 'mike');
INSERT INTO `o_order` VALUES ('12', '309172220200830040840', '1', '10.00', '10', '10.00', '1', 'Mike');
INSERT INTO `o_order` VALUES ('13', '732947920200830041128', '1', '10.00', '9', '9.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('14', '416551420200830042126', '2', '40.00', '9', '36.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('15', '729308520200830042423', '2', '30.00', '8', '24.00', '2', 'alice');
INSERT INTO `o_order` VALUES ('16', '968094720200830043042', '2', '30.00', '10', '30.00', '1', 'Mike');
INSERT INTO `o_order` VALUES ('17', '807819720200830043127', '2', '30.00', '10', '30.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('18', '488558920200830043300', '2', '40.00', '10', '40.00', '1', 'Mike');
INSERT INTO `o_order` VALUES ('19', '654218120200830043834', '1', '38.00', '10', '38.00', '1', 'Mike');
INSERT INTO `o_order` VALUES ('20', '122230120200830050256', '1', '28.00', '10', '28.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('21', '651766520200830050344', '1', '38.00', '10', '38.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('22', '512087720200830050715', '1', '12.00', '10', '12.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('23', '607372020200830051114', '4', '62.00', '10', '62.00', '1', 'ALice');
INSERT INTO `o_order` VALUES ('24', '189609920200830051234', '3', '66.00', '10', '66.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('25', '824051420200830052116', '3', '66.00', '10', '66.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('26', '348973420200830052223', '6', '102.00', '10', '102.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('27', '450659220200830054944', '2', '50.00', '10', '50.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('28', '511671020200830055220', '3', '42.00', '10', '42.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('29', '291591920200830055355', '3', '94.00', '9', '84.60', '1', 'Alice');
INSERT INTO `o_order` VALUES ('30', '646206820200830055612', '3', '88.00', '10', '88.00', '1', 'Mike');
INSERT INTO `o_order` VALUES ('31', '858952420200830055958', '3', '36.00', '9', '32.40', '1', 'Alice');
INSERT INTO `o_order` VALUES ('32', '137826020200830060442', '2', '40.00', '10', '40.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('33', '396192620200830060525', '2', '40.00', '9', '36.00', '1', 'Alice');
INSERT INTO `o_order` VALUES ('34', '111827820200830073918', '2', '24.00', '9', '21.60', '1', 'Alice');

-- ----------------------------
-- Table structure for o_ordermid
-- ----------------------------
DROP TABLE IF EXISTS `o_ordermid`;
CREATE TABLE `o_ordermid` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `orderName` varchar(32) NOT NULL,
  `orderPrice` float(10,2) NOT NULL,
  `orderAmount` int(5) NOT NULL,
  `classId` int(5) NOT NULL,
  `totalMoney` float(10,2) NOT NULL,
  `orderNum` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class_foreign2` (`classId`),
  KEY `orderNum` (`orderNum`),
  CONSTRAINT `class_foreign2` FOREIGN KEY (`classId`) REFERENCES `o_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_ordermid
-- ----------------------------

-- ----------------------------
-- Table structure for o_ordermid_copy
-- ----------------------------
DROP TABLE IF EXISTS `o_ordermid_copy`;
CREATE TABLE `o_ordermid_copy` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `orderName` varchar(32) NOT NULL,
  `orderPrice` float(10,2) NOT NULL,
  `orderAmount` int(5) NOT NULL,
  `classId` int(5) NOT NULL,
  `totalMoney` float(10,2) NOT NULL,
  `orderNum` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class_foreign2` (`classId`),
  KEY `orderNum` (`orderNum`),
  CONSTRAINT `o_ordermid_copy_ibfk_1` FOREIGN KEY (`classId`) REFERENCES `o_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_ordermid_copy
-- ----------------------------
INSERT INTO `o_ordermid_copy` VALUES ('1', '泡椒凤爪', '18.00', '1', '1', '18.00', '960829720200830032214');
INSERT INTO `o_ordermid_copy` VALUES ('2', '皮蛋豆腐', '12.00', '1', '1', '12.00', '960829720200830032214');
INSERT INTO `o_ordermid_copy` VALUES ('3', '泡椒凤爪', '18.00', '1', '1', '18.00', '453937220200830032828');
INSERT INTO `o_ordermid_copy` VALUES ('4', '皮蛋豆腐', '12.00', '1', '1', '12.00', '453937220200830032828');
INSERT INTO `o_ordermid_copy` VALUES ('5', '泡椒凤爪', '18.00', '1', '1', '18.00', '453937220200830032828');
INSERT INTO `o_ordermid_copy` VALUES ('6', '皮蛋豆腐', '12.00', '1', '1', '12.00', '453937220200830032828');
INSERT INTO `o_ordermid_copy` VALUES ('7', '辣子鸡', '28.00', '1', '3', '28.00', '129837320200830033047');
INSERT INTO `o_ordermid_copy` VALUES ('8', '番茄蛋花汤', '12.00', '1', '5', '12.00', '129837320200830033047');
INSERT INTO `o_ordermid_copy` VALUES ('9', '干锅土鸡', '28.00', '1', '4', '28.00', '474333120200830033336');
INSERT INTO `o_ordermid_copy` VALUES ('10', '开味木耳', '12.00', '1', '1', '12.00', '474333120200830033336');
INSERT INTO `o_ordermid_copy` VALUES ('11', '酸汤肥牛', '48.00', '1', '2', '48.00', '407291720200830033446');
INSERT INTO `o_ordermid_copy` VALUES ('12', '酸菜粉丝汤', '12.00', '1', '5', '12.00', '407291720200830033446');
INSERT INTO `o_ordermid_copy` VALUES ('13', '辣子鸡', '28.00', '1', '3', '28.00', '672796320200830033615');
INSERT INTO `o_ordermid_copy` VALUES ('14', '酸菜粉丝汤', '12.00', '1', '5', '12.00', '672796320200830033615');
INSERT INTO `o_ordermid_copy` VALUES ('15', '香辣小龙虾', '38.00', '1', '2', '38.00', '679334120200830033736');
INSERT INTO `o_ordermid_copy` VALUES ('16', '开味木耳', '12.00', '1', '1', '12.00', '679334120200830033736');
INSERT INTO `o_ordermid_copy` VALUES ('17', '泡椒凤爪', '18.00', '1', '1', '18.00', '507996220200830033840');
INSERT INTO `o_ordermid_copy` VALUES ('18', '皮蛋豆腐', '12.00', '1', '1', '12.00', '507996220200830033840');
INSERT INTO `o_ordermid_copy` VALUES ('19', '辣子鸡', '28.00', '1', '3', '28.00', '279715620200830035257');
INSERT INTO `o_ordermid_copy` VALUES ('20', '酸菜粉丝汤', '12.00', '1', '5', '12.00', '279715620200830035257');
INSERT INTO `o_ordermid_copy` VALUES ('21', '老妈鱼头', '48.00', '1', '2', '48.00', '635107620200830035701');
INSERT INTO `o_ordermid_copy` VALUES ('22', '开味木耳', '12.00', '1', '1', '12.00', '635107620200830035701');
INSERT INTO `o_ordermid_copy` VALUES ('23', '紫菜蛋花汤', '10.00', '1', '5', '10.00', '732947920200830041128');
INSERT INTO `o_ordermid_copy` VALUES ('24', '开味木耳', '12.00', '1', '1', '12.00', '416551420200830042126');
INSERT INTO `o_ordermid_copy` VALUES ('25', '干锅土鸡', '28.00', '1', '4', '28.00', '416551420200830042126');
INSERT INTO `o_ordermid_copy` VALUES ('26', '泡椒凤爪', '18.00', '1', '1', '18.00', '729308520200830042423');
INSERT INTO `o_ordermid_copy` VALUES ('27', '番茄蛋花汤', '12.00', '1', '5', '12.00', '729308520200830042423');
INSERT INTO `o_ordermid_copy` VALUES ('28', '泡椒凤爪', '18.00', '1', '1', '18.00', '968094720200830043042');
INSERT INTO `o_ordermid_copy` VALUES ('29', '酸菜粉丝汤', '12.00', '1', '5', '12.00', '968094720200830043042');
INSERT INTO `o_ordermid_copy` VALUES ('30', '泡椒凤爪', '18.00', '1', '1', '18.00', '807819720200830043127');
INSERT INTO `o_ordermid_copy` VALUES ('31', '皮蛋豆腐', '12.00', '1', '1', '12.00', '807819720200830043127');
INSERT INTO `o_ordermid_copy` VALUES ('32', '辣子鸡', '28.00', '1', '3', '28.00', '488558920200830043300');
INSERT INTO `o_ordermid_copy` VALUES ('33', '开味木耳', '12.00', '1', '1', '12.00', '488558920200830043300');
INSERT INTO `o_ordermid_copy` VALUES ('34', '香辣小龙虾', '38.00', '1', '2', '38.00', '654218120200830043834');
INSERT INTO `o_ordermid_copy` VALUES ('35', '干锅土鸡', '28.00', '1', '4', '28.00', '122230120200830050256');
INSERT INTO `o_ordermid_copy` VALUES ('36', '香辣小龙虾', '38.00', '1', '2', '38.00', '651766520200830050344');
INSERT INTO `o_ordermid_copy` VALUES ('37', '开味木耳', '12.00', '1', '1', '12.00', '512087720200830050715');
INSERT INTO `o_ordermid_copy` VALUES ('38', '番茄蛋花汤', '12.00', '1', '5', '12.00', '607372020200830051114');
INSERT INTO `o_ordermid_copy` VALUES ('39', '紫菜蛋花汤', '10.00', '1', '5', '10.00', '607372020200830051114');
INSERT INTO `o_ordermid_copy` VALUES ('40', '开味木耳', '12.00', '1', '1', '12.00', '607372020200830051114');
INSERT INTO `o_ordermid_copy` VALUES ('41', '干锅土鸡', '28.00', '1', '4', '28.00', '607372020200830051114');
INSERT INTO `o_ordermid_copy` VALUES ('42', '干锅土鸡', '28.00', '1', '4', '28.00', '189609920200830051234');
INSERT INTO `o_ordermid_copy` VALUES ('43', '紫菜蛋花汤', '10.00', '1', '5', '10.00', '189609920200830051234');
INSERT INTO `o_ordermid_copy` VALUES ('44', '辣子鸡', '28.00', '1', '3', '28.00', '189609920200830051234');
INSERT INTO `o_ordermid_copy` VALUES ('45', '干锅土鸡', '28.00', '1', '4', '28.00', '348973420200830052223');
INSERT INTO `o_ordermid_copy` VALUES ('46', '紫菜蛋花汤', '10.00', '1', '5', '10.00', '348973420200830052223');
INSERT INTO `o_ordermid_copy` VALUES ('47', '干锅土鸡', '28.00', '1', '4', '28.00', '348973420200830052223');
INSERT INTO `o_ordermid_copy` VALUES ('48', '开味木耳', '12.00', '1', '1', '12.00', '348973420200830052223');
INSERT INTO `o_ordermid_copy` VALUES ('49', '皮蛋豆腐', '12.00', '1', '1', '12.00', '348973420200830052223');
INSERT INTO `o_ordermid_copy` VALUES ('50', '番茄蛋花汤', '12.00', '1', '5', '12.00', '348973420200830052223');
INSERT INTO `o_ordermid_copy` VALUES ('51', '香辣小龙虾', '38.00', '1', '2', '38.00', '450659220200830054944');
INSERT INTO `o_ordermid_copy` VALUES ('52', '开味木耳', '12.00', '1', '1', '12.00', '450659220200830054944');
INSERT INTO `o_ordermid_copy` VALUES ('53', '泡椒凤爪', '18.00', '1', '1', '18.00', '511671020200830055220');
INSERT INTO `o_ordermid_copy` VALUES ('54', '皮蛋豆腐', '12.00', '1', '1', '12.00', '511671020200830055220');
INSERT INTO `o_ordermid_copy` VALUES ('55', '番茄蛋花汤', '12.00', '1', '5', '12.00', '511671020200830055220');
INSERT INTO `o_ordermid_copy` VALUES ('56', '辣子鸡', '28.00', '1', '3', '28.00', '291591920200830055355');
INSERT INTO `o_ordermid_copy` VALUES ('57', '香辣小龙虾', '38.00', '1', '2', '38.00', '291591920200830055355');
INSERT INTO `o_ordermid_copy` VALUES ('58', '干锅土鸡', '28.00', '1', '4', '28.00', '291591920200830055355');
INSERT INTO `o_ordermid_copy` VALUES ('59', '干锅土鸡', '28.00', '1', '4', '28.00', '646206820200830055612');
INSERT INTO `o_ordermid_copy` VALUES ('60', '皮蛋豆腐', '12.00', '1', '1', '12.00', '646206820200830055612');
INSERT INTO `o_ordermid_copy` VALUES ('61', '酸汤肥牛', '48.00', '1', '2', '48.00', '646206820200830055612');
INSERT INTO `o_ordermid_copy` VALUES ('62', '皮蛋豆腐', '12.00', '1', '1', '12.00', '858952420200830055958');
INSERT INTO `o_ordermid_copy` VALUES ('63', '番茄蛋花汤', '12.00', '1', '5', '12.00', '858952420200830055958');
INSERT INTO `o_ordermid_copy` VALUES ('64', '开味木耳', '12.00', '1', '1', '12.00', '858952420200830055958');
INSERT INTO `o_ordermid_copy` VALUES ('65', '番茄蛋花汤', '12.00', '1', '5', '12.00', '137826020200830060442');
INSERT INTO `o_ordermid_copy` VALUES ('66', '干锅土鸡', '28.00', '1', '4', '28.00', '137826020200830060442');
INSERT INTO `o_ordermid_copy` VALUES ('67', '辣子鸡', '28.00', '1', '3', '28.00', '396192620200830060525');
INSERT INTO `o_ordermid_copy` VALUES ('68', '酸菜粉丝汤', '12.00', '1', '5', '12.00', '396192620200830060525');
INSERT INTO `o_ordermid_copy` VALUES ('69', '皮蛋豆腐', '12.00', '1', '1', '12.00', '111827820200830073918');
INSERT INTO `o_ordermid_copy` VALUES ('70', '皮蛋豆腐', '12.00', '1', '1', '12.00', '111827820200830073918');
