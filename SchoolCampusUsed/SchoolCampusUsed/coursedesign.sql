/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50731
Source Host           : 47.95.227.217:3306
Source Database       : coursedesign

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-11-09 19:31:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for feedbacks
-- ----------------------------
DROP TABLE IF EXISTS `feedbacks`;
CREATE TABLE `feedbacks` (
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `goods_id` varchar(50) DEFAULT NULL COMMENT '商品ID',
  `pay_id` varchar(50) DEFAULT NULL COMMENT '支付ID',
  `value` varchar(500) DEFAULT NULL COMMENT '文字信息',
  `feedbacks_time` varchar(30) DEFAULT NULL COMMENT '时间',
  `feedbacks_status` int(11) DEFAULT NULL COMMENT '类型（1投诉、0建议、-1反馈）',
  `orders_id` varchar(50) DEFAULT NULL COMMENT '订单ID',
  `feedbacks_id` varchar(50) NOT NULL COMMENT '投诉、建议、反馈信息ID（主键、随机码）',
  `solve_status` int(11) DEFAULT NULL COMMENT '管理员处理状态（1已处理、0未处理、-1不予处理）',
  `solve_value` varchar(500) DEFAULT NULL COMMENT '管理员处理结果信息',
  `name` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  PRIMARY KEY (`feedbacks_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedbacks
-- ----------------------------
INSERT INTO `feedbacks` VALUES ('0d0cbc92-a3be-4f43-906d-4c6ec9bc1eb1', 'a5453192-5e1c-4e7e-b91c-30a8bc4f6c5b', 'a5453192-5e1c-4e7e-b91c-30a8bc4f6c5b', 'asd', '2020/11/9 上午4:56:07', '-1', 'fa58cf3a-fa58-4e31-98ba-1c8344d2e357', '2126af68-d3f3-43e2-9f1a-1f466ece8a23', '0', '', null);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `goods_id` varchar(50) NOT NULL COMMENT '商品ID（主键，随机码）',
  `dscrip` varchar(500) DEFAULT NULL COMMENT '商品介绍信息',
  `price` double DEFAULT NULL COMMENT '商品价格',
  `goods_level` double DEFAULT NULL COMMENT '商品新旧程度',
  `up_status` int(11) DEFAULT NULL COMMENT '上架状态',
  `use_status` int(11) DEFAULT NULL COMMENT '可用状态',
  `hot` double DEFAULT NULL COMMENT '热度信息',
  `name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('0d0cbc92-a3be-4f43-906d-4c6ec9bc1eb1', '053726ac-c14e-4a09-aaf5-4bef1b8d30e9', 'asdadad', '123', '99', '0', '1', '0', 'asdad');
INSERT INTO `goods` VALUES ('0d0cbc92-a3be-4f43-906d-4c6ec9bc1eb1', '0d49a0da-2927-43bd-bc0f-132a84905147', 'ASaas', '23123', '99', '1', '1', '0', 'asdsad');
INSERT INTO `goods` VALUES ('0d0cbc92-a3be-4f43-906d-4c6ec9bc1eb1', '33a35e42-c283-44f6-b9d3-8f06fefe9bae', 'waea', '123', '12', '1', '1', '0', 'qeqeq');

-- ----------------------------
-- Table structure for goodsurl
-- ----------------------------
DROP TABLE IF EXISTS `goodsurl`;
CREATE TABLE `goodsurl` (
  `goods_id` varchar(50) DEFAULT NULL COMMENT '商品ID',
  `img_url` varchar(200) DEFAULT NULL COMMENT '商品图片URL信息',
  `img_id` varchar(50) NOT NULL,
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodsurl
-- ----------------------------
INSERT INTO `goodsurl` VALUES ('33a35e42-c283-44f6-b9d3-8f06fefe9bae', 'http://localhost:9090/imgUpload/33a35e42-c283-44f6-b9d3-8f06fefe9bae698add09-ad6d-4dbf-a97d-19a37f52c584.jpg', '0c08bab5-e070-482f-862f-34350b1c4807');
INSERT INTO `goodsurl` VALUES ('5ead7b1e-53dd-4f04-885c-a61b4c44f497', 'http://localhost:9090/imgUpload/5ead7b1e-53dd-4f04-885c-a61b4c44f497d4a73186-3556-4c02-9c35-a96dd3c7d1b5.jpg', '384e96c3-df03-44c3-96c8-306678044273');
INSERT INTO `goodsurl` VALUES ('ce3de96d-1d84-442d-a121-86453a493fe7', 'http://localhost:9090/imgUpload/ce3de96d-1d84-442d-a121-86453a493fe73f14672a-a025-4159-b418-4153eb99b524.jpg', '3a934eb2-e552-4dd1-b0fe-8e73d82f721c');
INSERT INTO `goodsurl` VALUES ('2583d032-dc93-44fc-94ad-e1a8702c2840', 'http://localhost:9090/imgUpload/2583d032-dc93-44fc-94ad-e1a8702c28404734a15c-4ab5-4989-b788-9c5a989ab7e0.jpg', '52e59de3-32b8-4203-ad0c-48950d40795d');
INSERT INTO `goodsurl` VALUES ('0d49a0da-2927-43bd-bc0f-132a84905147', 'http://localhost:9090/imgUpload/0d49a0da-2927-43bd-bc0f-132a849051477051b496-7a73-4d54-a301-826658eff701.jpg', 'bfa44e0a-3e32-449d-b527-8f83a933adf3');
INSERT INTO `goodsurl` VALUES ('053726ac-c14e-4a09-aaf5-4bef1b8d30e9', 'http://localhost:9090/imgUpload/053726ac-c14e-4a09-aaf5-4bef1b8d30e9c67371dc-6474-43d1-8721-04147400ade3.jpg', 'd33ebe33-4370-4223-9d5d-c05ff0853027');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `goods_id` varchar(50) DEFAULT NULL COMMENT '商品ID',
  `orders_status` int(11) DEFAULT NULL COMMENT '订单状态（1已完成、0未完成、-1有异议）',
  `price` double DEFAULT NULL COMMENT '商品价格',
  `pay_id` varchar(50) DEFAULT NULL COMMENT '支付ID',
  `orders_id` varchar(50) NOT NULL COMMENT '订单ID（主键、随机码）',
  `admin_status` int(11) DEFAULT NULL COMMENT '处理状态（1已处理、0未处理）',
  `time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`orders_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('0d0cbc92-a3be-4f43-906d-4c6ec9bc1eb1', '33a35e42-c283-44f6-b9d3-8f06fefe9bae', '0', '123', '719b2d5a-4c08-4095-b44f-c31988166b78', '1cd3b30e-a6ca-405c-8a71-c78fedbd3e42', '0', '2020年11月09日');
INSERT INTO `orders` VALUES ('0d0cbc92-a3be-4f43-906d-4c6ec9bc1eb1', '0d49a0da-2927-43bd-bc0f-132a84905147', '0', '23123', 'c561f2b0-d0ca-41af-99c4-c838ba7d8cf3', '549faf15-d97b-48b8-ba52-c458e54ae845', '0', '2020年11月09日');
INSERT INTO `orders` VALUES ('0d0cbc92-a3be-4f43-906d-4c6ec9bc1eb1', '33a35e42-c283-44f6-b9d3-8f06fefe9bae', '0', '123', 'e997f410-f840-45ee-8e2f-43e0c872520c', '688b023c-2f82-4b30-a9be-634483c327ef', '0', '2020年11月09日');

-- ----------------------------
-- Table structure for ordersback
-- ----------------------------
DROP TABLE IF EXISTS `ordersback`;
CREATE TABLE `ordersback` (
  `orders_id` varchar(50) DEFAULT NULL COMMENT '订单ID',
  `feedbacks_id` varchar(50) DEFAULT NULL COMMENT '投诉、建议、反馈信息ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordersback
-- ----------------------------

-- ----------------------------
-- Table structure for payments
-- ----------------------------
DROP TABLE IF EXISTS `payments`;
CREATE TABLE `payments` (
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `pay_id` varchar(50) NOT NULL COMMENT '支付ID（主键，随机码）',
  `price` double DEFAULT NULL COMMENT '费用',
  `status` int(11) DEFAULT NULL COMMENT '费用状态（已经转给卖家1，费用在平台0，已经退回给买家-1）',
  `pay_time` varchar(50) DEFAULT NULL COMMENT '支付时间',
  `goods_id` varchar(50) DEFAULT NULL COMMENT '商品ID',
  `pay_status` int(11) DEFAULT NULL COMMENT '支付状态（已完成1、未完成0、有异议-1）',
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payments
-- ----------------------------

-- ----------------------------
-- Table structure for shopcar
-- ----------------------------
DROP TABLE IF EXISTS `shopcar`;
CREATE TABLE `shopcar` (
  `user_id` varchar(50) NOT NULL,
  `goods_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopcar
-- ----------------------------
INSERT INTO `shopcar` VALUES ('0d0cbc92-a3be-4f43-906d-4c6ec9bc1eb1', '053726ac-c14e-4a09-aaf5-4bef1b8d30e9');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` varchar(50) NOT NULL COMMENT '用户ID，主键（随机码）',
  `name` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1男，2女）',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` int(11) DEFAULT NULL COMMENT '账户启用状态',
  `admin` int(11) DEFAULT NULL COMMENT '是否管理员账户',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('12ebbb3f-4df4-47c7-92ee-e6988db478c1', 'kkk', 'jdassdddd', '123456a!', '0', 'asd@asd.c', '1', '1');
INSERT INTO `users` VALUES ('1977d46b-8b56-49dd-815f-3a28196dd631', 'abiusduas', 'asdasdas', 'uiasbndna', '1', 'nioansdo@ciasdo.como', '0', '0');
INSERT INTO `users` VALUES ('22c77c6b-791e-43f7-8179-31b799cf8c93', 'xuanyu', 'xuanyu', 'wxy187350@', '0', '12314@qq.com', '1', '0');
INSERT INTO `users` VALUES ('324021bf-aa22-4388-b442-b034a8b6123a', '闫孟君', 'jdassd', 'jdassd1!', '1', 'jdassd@163.com', '1', '1');
INSERT INTO `users` VALUES ('61f225aa-4089-48df-af9b-646c61b7c8da', 'aiushdiuhasd', 'nuanduona', 'njoansdoiasd', '1', 'asiod@nuasnd.cbuin', '0', '0');
INSERT INTO `users` VALUES ('79831d90-4f7b-440b-b6e7-bc7766c2edb7', '御风', 'hhhhh', '123456789@hyw', '1', '1773261858@qq.com', '1', '0');
INSERT INTO `users` VALUES ('92bae3b4-0e1b-44a4-b5ab-eb55310341b0', 'jdasd', 'jdassdd', 'jasda1!', '2', 'asd@asd.c', '1', '0');
INSERT INTO `users` VALUES ('94e3d441-3a7b-441d-aee7-eed9807108e2', 'asdasbui', 'nuiasdina', 'nionioasnd', '1', 'nioasnoi@nuasd.com', '0', '0');
INSERT INTO `users` VALUES ('964bae96-1633-49f7-ba46-d562b77fe514', 'xuanyuwq', 'xuanyuwq', 'wxy187350@', '1', '123456789@163.com', '0', '0');
INSERT INTO `users` VALUES ('9f9a3e3f-ffa2-43ce-bcb1-c922aeb0e977', 'asdnansdasd', 'jasidjioasasd', 'asdadsd', '1', 'naiosndasdioas@asuaasd.com', '0', '0');
INSERT INTO `users` VALUES ('a399f7fe-e963-4c6c-981e-8e70521afac8', '哇哈哈', 'jdassddd', 'adsd12!@#!', '0', 'asdas@asdnu.casd', '0', '0');
INSERT INTO `users` VALUES ('c2c0d448-607e-4b8d-9a5e-f18f9c12291c', 'aaa', 'aaa', 'aaa', '2', '', '1', '1');
INSERT INTO `users` VALUES ('e7805d36-e2bc-4b81-a4e1-7dae629c6887', 'asdasdas', 'asnduiasndna', 'nioasndoasd', '1', 'asda@cin.asdn', '0', '0');
INSERT INTO `users` VALUES ('e7c8e0bb-7a47-4e17-a9ff-2f2f941efc14', 'asdnansd', 'jasidjioas', 'ansiodhioa', '1', 'naiosndioas@asuaasd.com', '0', '0');
INSERT INTO `users` VALUES ('ec6b94fc-dc8e-425c-bed4-df195cd99d58', 'nioadnian', 'uiasbdi', 'niunasd', '1', 'ninasd@nuiasnd.com', '0', '0');

-- ----------------------------
-- Table structure for wantbuy
-- ----------------------------
DROP TABLE IF EXISTS `wantbuy`;
CREATE TABLE `wantbuy` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `message` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wantbuy
-- ----------------------------
INSERT INTO `wantbuy` VALUES ('4', 'xuanyuwq', 'asadsa');
INSERT INTO `wantbuy` VALUES ('5', 'xuanyuqw', 'asdsasd');
INSERT INTO `wantbuy` VALUES ('6', 'xuanyu456', 'asdada');
INSERT INTO `wantbuy` VALUES ('7', 'xuanyu456', 'asdada');
INSERT INTO `wantbuy` VALUES ('8', 'xuanyu45645', 'asdada');
INSERT INTO `wantbuy` VALUES ('9', 'xuanyu45645', 'asdada');
INSERT INTO `wantbuy` VALUES ('10', 'xuanyu45645', 'asdada');
INSERT INTO `wantbuy` VALUES ('11', 'asda', 'adsasd');
INSERT INTO `wantbuy` VALUES ('12', 'xuanyu1053', '加湿器');
INSERT INTO `wantbuy` VALUES ('13', 'sadada', 'asadad');
INSERT INTO `wantbuy` VALUES ('14', 'asda', 'adsa');
INSERT INTO `wantbuy` VALUES ('15', 'zhangsan', 'Iphone二手');
INSERT INTO `wantbuy` VALUES ('16', 'zhangsan', 'Iphone二手');
INSERT INTO `wantbuy` VALUES ('17', 'lisi', 'Mac');
INSERT INTO `wantbuy` VALUES ('18', 'wangwu', '求一本四级词汇书');
INSERT INTO `wantbuy` VALUES ('19', 'wangwu', '求一本四级词汇书');
INSERT INTO `wantbuy` VALUES ('20', 'wangwu', '求一本六级词汇书');
INSERT INTO `wantbuy` VALUES ('21', 'zhangsna', '求一部二手Iphone');
