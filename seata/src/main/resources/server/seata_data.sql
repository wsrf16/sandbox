/*
Navicat MySQL Data Transfer

Source Server         : mecs
Source Server Version : 50721
Source Host           : mecs.com:3306
Source Database       : seata

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2021-04-05 20:05:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for branch_table
-- ----------------------------
DROP TABLE IF EXISTS `branch_table`;
CREATE TABLE `branch_table` (
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(128) NOT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `resource_group_id` varchar(32) DEFAULT NULL,
  `resource_id` varchar(256) DEFAULT NULL,
  `branch_type` varchar(8) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `client_id` varchar(64) DEFAULT NULL,
  `application_data` varchar(2000) DEFAULT NULL,
  `gmt_create` datetime(6) DEFAULT NULL,
  `gmt_modified` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`branch_id`),
  KEY `idx_xid` (`xid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of branch_table
-- ----------------------------
INSERT INTO `branch_table` VALUES ('8376814864824402017', '49.235.220.112:8091:8376814864824402014', '8376814864824402014', null, 'jdbc:mysql://mecs.com:3306/seata_sample', 'AT', '0', 'seata-app:223.20.182.224:52299', null, '2021-04-05 12:05:15.641566', '2021-04-05 12:05:15.641566');
INSERT INTO `branch_table` VALUES ('8376814864824402020', '49.235.220.112:8091:8376814864824402014', '8376814864824402014', null, 'jdbc:mysql://mecs.com:3306/seata_sample', 'AT', '0', 'seata-app:223.20.182.224:52299', null, '2021-04-05 12:05:16.367343', '2021-04-05 12:05:16.367343');

-- ----------------------------
-- Table structure for global_table
-- ----------------------------
DROP TABLE IF EXISTS `global_table`;
CREATE TABLE `global_table` (
  `xid` varchar(128) NOT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `application_id` varchar(32) DEFAULT NULL,
  `transaction_service_group` varchar(32) DEFAULT NULL,
  `transaction_name` varchar(128) DEFAULT NULL,
  `timeout` int(11) DEFAULT NULL,
  `begin_time` bigint(20) DEFAULT NULL,
  `application_data` varchar(2000) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`xid`),
  KEY `idx_gmt_modified_status` (`gmt_modified`,`status`),
  KEY `idx_transaction_id` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of global_table
-- ----------------------------
INSERT INTO `global_table` VALUES ('49.235.220.112:8091:8376814864824402014', '8376814864824402014', '1', 'seata-app', 'my_test_tx_group', 'purchase(java.lang.String, java.lang.String, int)', '60000', '1617624314234', null, '2021-04-05 12:05:14', '2021-04-05 12:05:14');

-- ----------------------------
-- Table structure for lock_table
-- ----------------------------
DROP TABLE IF EXISTS `lock_table`;
CREATE TABLE `lock_table` (
  `row_key` varchar(128) NOT NULL,
  `xid` varchar(128) DEFAULT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `branch_id` bigint(20) NOT NULL,
  `resource_id` varchar(256) DEFAULT NULL,
  `table_name` varchar(32) DEFAULT NULL,
  `pk` varchar(36) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`row_key`),
  KEY `idx_branch_id` (`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lock_table
-- ----------------------------
INSERT INTO `lock_table` VALUES ('jdbc:mysql://mecs.com:3306/seata_sample^^^order_tbl^^^27', '49.235.220.112:8091:8376814864824402014', '8376814864824402014', '8376814864824402020', 'jdbc:mysql://mecs.com:3306/seata_sample', 'order_tbl', '27', '2021-04-05 12:05:16', '2021-04-05 12:05:16');
INSERT INTO `lock_table` VALUES ('jdbc:mysql://mecs.com:3306/seata_sample^^^storage_tbl^^^1', '49.235.220.112:8091:8376814864824402014', '8376814864824402014', '8376814864824402017', 'jdbc:mysql://mecs.com:3306/seata_sample', 'storage_tbl', '1', '2021-04-05 12:05:15', '2021-04-05 12:05:15');
