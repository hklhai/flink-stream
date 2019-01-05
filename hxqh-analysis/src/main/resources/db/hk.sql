/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : hk

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2019-01-05 09:23:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cartinfo
-- ----------------------------
DROP TABLE IF EXISTS `cartinfo`;
CREATE TABLE `cartinfo` (
  `cartid` int(20) NOT NULL,
  `userid` int(20) DEFAULT NULL,
  `productid` int(20) DEFAULT NULL,
  `num` int(20) DEFAULT NULL,
  `productamount` double(20,2) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `merchantid` int(20) DEFAULT NULL,
  PRIMARY KEY (`cartid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cartinfo
-- ----------------------------
INSERT INTO `cartinfo` VALUES ('1', '1', '1', '2', '60.00', '2019-01-05 09:00:15', '1');
INSERT INTO `cartinfo` VALUES ('2', '1', '2', '5', '20.00', '2019-01-05 08:59:53', '2');
INSERT INTO `cartinfo` VALUES ('3', '2', '1', '5', '26.00', '2019-01-05 09:00:31', '1');

-- ----------------------------
-- Table structure for merchant
-- ----------------------------
DROP TABLE IF EXISTS `merchant`;
CREATE TABLE `merchant` (
  `merchantid` int(20) NOT NULL,
  `merchantname` varchar(20) DEFAULT NULL,
  `merchantarea` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`merchantid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of merchant
-- ----------------------------
INSERT INTO `merchant` VALUES ('1', 'bob', '北京');
INSERT INTO `merchant` VALUES ('2', 'peter', '济南');

-- ----------------------------
-- Table structure for merchantshop
-- ----------------------------
DROP TABLE IF EXISTS `merchantshop`;
CREATE TABLE `merchantshop` (
  `merchantshopid` int(20) NOT NULL,
  `merchantshopname` varchar(50) DEFAULT NULL,
  `merchantid` int(20) DEFAULT NULL,
  PRIMARY KEY (`merchantshopid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of merchantshop
-- ----------------------------
INSERT INTO `merchantshop` VALUES ('1', '猪肉店', '1');
INSERT INTO `merchantshop` VALUES ('2', '蔬菜店', '2');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` int(20) NOT NULL,
  `userid` int(20) DEFAULT NULL,
  `merchantid` int(20) DEFAULT NULL,
  `orderamount` double(20,2) DEFAULT NULL,
  `payamount` double(20,2) DEFAULT NULL,
  `paytype` int(2) DEFAULT NULL,
  `paytime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `red` double(20,2) DEFAULT NULL,
  `cashcoupon` varchar(255) DEFAULT NULL,
  `productid` int(20) DEFAULT NULL,
  `saleid` int(20) DEFAULT '0',
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '1', '67.00', null, '1', '2019-01-05 09:09:44', '2.00', '5', '1', '0');
INSERT INTO `order` VALUES ('2', '2', '2', '45.00', null, '2', '2019-01-06 09:10:52', '0.00', '2', '2', '1');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productid` int(20) NOT NULL,
  `productname` varchar(50) DEFAULT NULL,
  `producttypeid` int(20) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `activityprice` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '猪肉', '1', '15.00', '13.00');
INSERT INTO `product` VALUES ('2', '白菜', '2', '5.00', '4.00');

-- ----------------------------
-- Table structure for producttype
-- ----------------------------
DROP TABLE IF EXISTS `producttype`;
CREATE TABLE `producttype` (
  `productcategoryid` int(20) NOT NULL,
  `productcategoryname` varchar(50) DEFAULT NULL,
  `producttypelevel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`productcategoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of producttype
-- ----------------------------
INSERT INTO `producttype` VALUES ('1', '肉类', '1');
INSERT INTO `producttype` VALUES ('2', '蔬菜', '1');

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `saleid` int(20) NOT NULL,
  `salename` varchar(50) DEFAULT NULL,
  `salestarttime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `saleendtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `productid` int(20) DEFAULT NULL,
  PRIMARY KEY (`saleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale
-- ----------------------------
INSERT INTO `sale` VALUES ('1', '蔬菜打折', '2019-01-04 09:08:03', '2019-01-12 09:08:07', '2');
INSERT INTO `sale` VALUES ('2', '猪肉打折', '2019-01-03 09:08:40', '2019-01-12 09:08:44', '1');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userid` int(20) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'alex', '28', '北京', '1234567897', '19900909', 'hh@ll.com');
INSERT INTO `userinfo` VALUES ('2', 'lyy', '28', '上海', '1234567876', '19900609', 'hh.ss.com');

-- ----------------------------
-- View structure for v_map
-- ----------------------------
DROP VIEW IF EXISTS `v_map`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_map` AS SELECT m.Location,m.pubtype,count(1) as counter from pub_map m
group by m.Location,m.pubtype ;
