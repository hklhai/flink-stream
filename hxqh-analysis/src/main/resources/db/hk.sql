/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : hk

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2019-01-04 08:50:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cartinfo
-- ----------------------------
DROP TABLE IF EXISTS `cartinfo`;
CREATE TABLE `cartinfo` (
  `userid` int(20) NOT NULL,
  `productid` int(20) DEFAULT NULL,
  `num` int(20) DEFAULT NULL,
  `productamount` double(20,2) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `merchantid` int(20) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(20) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
