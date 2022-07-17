/*
 Navicat Premium Data Transfer

 Source Server         : www.onecbuying.com
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : wygl

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 17/07/2022 13:42:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fee_park
-- ----------------------------
DROP TABLE IF EXISTS `fee_park`;
CREATE TABLE `fee_park` (
  `park_fee_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int DEFAULT NULL COMMENT '业主id',
  `park_id` int DEFAULT NULL COMMENT '车位id',
  `pay_park_month` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '缴费年月',
  `pay_park_money` decimal(18,2) DEFAULT NULL COMMENT '缴费金额',
  `pay_park_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '0:未缴费  1：已缴费',
  `pay_park_time` datetime DEFAULT NULL,
  PRIMARY KEY (`park_fee_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fee_park
-- ----------------------------
BEGIN;
INSERT INTO `fee_park` VALUES (27, 30, 17, '2022-02', 566.00, '0', NULL);
INSERT INTO `fee_park` VALUES (28, 29, 16, '2022-02', 43.99, '0', NULL);
INSERT INTO `fee_park` VALUES (29, 31, 15, '2022-06', 887.00, '0', NULL);
COMMIT;

-- ----------------------------
-- Table structure for fee_power
-- ----------------------------
DROP TABLE IF EXISTS `fee_power`;
CREATE TABLE `fee_power` (
  `power_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `house_id` int DEFAULT NULL COMMENT '房屋id',
  `user_id` int DEFAULT NULL COMMENT '业主id',
  `pay_power_month` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '缴费年月',
  `pay_power_money` decimal(18,2) DEFAULT NULL COMMENT '缴费金额',
  `power_num` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '表显',
  `pay_power_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '0:未缴费  1：已缴费',
  `pay_power_time` datetime DEFAULT NULL COMMENT '缴费时间',
  PRIMARY KEY (`power_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fee_power
-- ----------------------------
BEGIN;
INSERT INTO `fee_power` VALUES (33, 10, 31, '2022-02', 299.00, '36', '0', NULL);
INSERT INTO `fee_power` VALUES (34, 13, 29, '2022-06', 794.00, '50.00', '1', NULL);
INSERT INTO `fee_power` VALUES (35, 14, 30, '2022-02', 799.00, '23', '0', NULL);
COMMIT;

-- ----------------------------
-- Table structure for fee_water
-- ----------------------------
DROP TABLE IF EXISTS `fee_water`;
CREATE TABLE `fee_water` (
  `water_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `house_id` int DEFAULT NULL COMMENT '房屋id',
  `user_id` int DEFAULT NULL COMMENT '业主id',
  `pay_water_month` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '缴费年月',
  `pay_water_money` decimal(18,2) DEFAULT NULL COMMENT '缴费金额',
  `water_num` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '表显',
  `pay_water_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '0:未缴费  1：已缴费',
  `pay_water_time` datetime DEFAULT NULL COMMENT '缴费时间',
  PRIMARY KEY (`water_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fee_water
-- ----------------------------
BEGIN;
INSERT INTO `fee_water` VALUES (22, 13, 29, '2022-02', 38.99, '5', '0', NULL);
INSERT INTO `fee_water` VALUES (23, 10, 31, '2022-06', 190.99, '12.4', '0', NULL);
INSERT INTO `fee_water` VALUES (24, 14, 30, '2022-02', 693.00, '45', '0', NULL);
COMMIT;

-- ----------------------------
-- Table structure for house_building
-- ----------------------------
DROP TABLE IF EXISTS `house_building`;
CREATE TABLE `house_building` (
  `build_id` int NOT NULL AUTO_INCREMENT COMMENT '栋数id',
  `type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '栋数类型 0：普通房 1：电梯房',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '栋数名称',
  `order_num` int DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`build_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of house_building
-- ----------------------------
BEGIN;
INSERT INTO `house_building` VALUES (21, '1', 'A栋', 1);
INSERT INTO `house_building` VALUES (22, '0', 'B栋', 1);
INSERT INTO `house_building` VALUES (23, '0', 'C栋', NULL);
INSERT INTO `house_building` VALUES (24, '1', 'D栋', 1);
INSERT INTO `house_building` VALUES (25, '0', 'E栋', 1);
COMMIT;

-- ----------------------------
-- Table structure for house_list
-- ----------------------------
DROP TABLE IF EXISTS `house_list`;
CREATE TABLE `house_list` (
  `house_id` int NOT NULL AUTO_INCREMENT COMMENT '房屋id',
  `unit_id` int DEFAULT NULL COMMENT '单元id',
  `house_num` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '房屋编号',
  `house_area` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '房屋面积',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '使用状态 0:未使用 1：已使用',
  PRIMARY KEY (`house_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of house_list
-- ----------------------------
BEGIN;
INSERT INTO `house_list` VALUES (2, 3, 'A-102', '90', '1');
INSERT INTO `house_list` VALUES (3, 3, 'A-103', '88', '1');
INSERT INTO `house_list` VALUES (4, 3, 'A-104', '70', '0');
INSERT INTO `house_list` VALUES (5, 2, 'B-101', '78', '0');
INSERT INTO `house_list` VALUES (7, 10, 'D-101', '120', '1');
INSERT INTO `house_list` VALUES (8, 12, 'C-102', '100', '0');
INSERT INTO `house_list` VALUES (9, 13, 'B-102', '100', '0');
INSERT INTO `house_list` VALUES (10, 14, '101', '100.00', '1');
INSERT INTO `house_list` VALUES (11, 15, '102', '90.00', '1');
INSERT INTO `house_list` VALUES (12, 16, '101', '135.00', '1');
INSERT INTO `house_list` VALUES (13, 17, '102', '200.00', '1');
INSERT INTO `house_list` VALUES (14, 18, '101', '79.00', '1');
INSERT INTO `house_list` VALUES (15, 20, '101', '89.00', '1');
INSERT INTO `house_list` VALUES (16, 23, '101', '399.00', '1');
INSERT INTO `house_list` VALUES (17, 24, '103', '92.00', '1');
COMMIT;

-- ----------------------------
-- Table structure for house_unit
-- ----------------------------
DROP TABLE IF EXISTS `house_unit`;
CREATE TABLE `house_unit` (
  `unit_id` int NOT NULL AUTO_INCREMENT COMMENT '单元id',
  `build_id` int DEFAULT NULL COMMENT '栋数id',
  `unit_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '单元名称',
  PRIMARY KEY (`unit_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of house_unit
-- ----------------------------
BEGIN;
INSERT INTO `house_unit` VALUES (2, 2, 'B-1');
INSERT INTO `house_unit` VALUES (3, 1, 'A-2');
INSERT INTO `house_unit` VALUES (4, 1, 'A-1');
INSERT INTO `house_unit` VALUES (8, 1, 'A-3');
INSERT INTO `house_unit` VALUES (10, 6, 'D-1');
INSERT INTO `house_unit` VALUES (11, 20, 'H-1');
INSERT INTO `house_unit` VALUES (12, 5, 'C-1');
INSERT INTO `house_unit` VALUES (13, 2, 'B-2');
INSERT INTO `house_unit` VALUES (14, 21, 'A01');
INSERT INTO `house_unit` VALUES (15, 21, 'A02');
INSERT INTO `house_unit` VALUES (16, 22, 'B01');
INSERT INTO `house_unit` VALUES (17, 22, 'B02');
INSERT INTO `house_unit` VALUES (18, 23, 'C01');
INSERT INTO `house_unit` VALUES (19, 23, 'C02');
INSERT INTO `house_unit` VALUES (20, 24, 'D01');
INSERT INTO `house_unit` VALUES (21, 24, 'D02');
INSERT INTO `house_unit` VALUES (22, 25, 'E01');
INSERT INTO `house_unit` VALUES (23, 25, 'E02');
INSERT INTO `house_unit` VALUES (24, 21, 'A03');
COMMIT;

-- ----------------------------
-- Table structure for live_house
-- ----------------------------
DROP TABLE IF EXISTS `live_house`;
CREATE TABLE `live_house` (
  `live_house_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int DEFAULT NULL COMMENT '业主id',
  `house_id` int DEFAULT NULL COMMENT '房屋id',
  `use_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '0:使用中 1： 解绑、退房',
  PRIMARY KEY (`live_house_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of live_house
-- ----------------------------
BEGIN;
INSERT INTO `live_house` VALUES (13, 18, 2, '0');
INSERT INTO `live_house` VALUES (14, 19, 7, '0');
INSERT INTO `live_house` VALUES (15, 22, 4, '1');
INSERT INTO `live_house` VALUES (16, 23, 5, '1');
INSERT INTO `live_house` VALUES (17, 24, 8, '1');
INSERT INTO `live_house` VALUES (18, 25, 9, '1');
INSERT INTO `live_house` VALUES (19, 26, 11, '1');
INSERT INTO `live_house` VALUES (20, 27, 17, '0');
INSERT INTO `live_house` VALUES (21, 28, 12, '0');
INSERT INTO `live_house` VALUES (22, 26, 11, '0');
INSERT INTO `live_house` VALUES (23, 29, 13, '0');
INSERT INTO `live_house` VALUES (24, 30, 14, '0');
INSERT INTO `live_house` VALUES (25, 31, 10, '0');
INSERT INTO `live_house` VALUES (26, 32, 17, '0');
COMMIT;

-- ----------------------------
-- Table structure for live_park
-- ----------------------------
DROP TABLE IF EXISTS `live_park`;
CREATE TABLE `live_park` (
  `live_park_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int DEFAULT NULL COMMENT '业主id',
  `park_id` int DEFAULT NULL COMMENT '车位id',
  `live_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '0:使用 1：解绑、退车位状态',
  PRIMARY KEY (`live_park_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of live_park
-- ----------------------------
BEGIN;
INSERT INTO `live_park` VALUES (18, 18, 1, '0');
INSERT INTO `live_park` VALUES (19, 19, 5, '1');
INSERT INTO `live_park` VALUES (20, 22, 9, '1');
INSERT INTO `live_park` VALUES (21, 23, 10, '1');
INSERT INTO `live_park` VALUES (22, 24, 4, '1');
INSERT INTO `live_park` VALUES (23, 25, 5, '1');
INSERT INTO `live_park` VALUES (24, 24, 4, '0');
INSERT INTO `live_park` VALUES (25, 23, 1, '0');
INSERT INTO `live_park` VALUES (26, 26, 1, '1');
INSERT INTO `live_park` VALUES (27, 28, 3, '0');
INSERT INTO `live_park` VALUES (28, 26, 1, '0');
INSERT INTO `live_park` VALUES (29, 26, 14, '0');
INSERT INTO `live_park` VALUES (30, 29, 16, '0');
INSERT INTO `live_park` VALUES (31, 30, 17, '0');
INSERT INTO `live_park` VALUES (32, 31, 14, '1');
INSERT INTO `live_park` VALUES (33, 32, 18, '0');
INSERT INTO `live_park` VALUES (34, 31, 15, '0');
COMMIT;

-- ----------------------------
-- Table structure for live_role
-- ----------------------------
DROP TABLE IF EXISTS `live_role`;
CREATE TABLE `live_role` (
  `liv_role_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int DEFAULT NULL COMMENT '角色id',
  `user_id` int DEFAULT NULL COMMENT '业主id',
  PRIMARY KEY (`liv_role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of live_role
-- ----------------------------
BEGIN;
INSERT INTO `live_role` VALUES (39, 8, 29);
INSERT INTO `live_role` VALUES (42, 8, 30);
INSERT INTO `live_role` VALUES (45, 8, 31);
INSERT INTO `live_role` VALUES (46, 8, 32);
COMMIT;

-- ----------------------------
-- Table structure for live_user
-- ----------------------------
DROP TABLE IF EXISTS `live_user`;
CREATE TABLE `live_user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '业主id',
  `username` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '登录账号',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '业主电话',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '性别 0：男 1：女',
  `login_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '登录密码',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT ' 0：启用 1：禁用',
  `is_account_non_expired` int DEFAULT NULL COMMENT '帐户是否过期(1 未过期，0已过期)	',
  `is_account_non_locked` int DEFAULT NULL COMMENT ' 帐户是否被锁定(1 未过期，0已过期)	',
  `is_credentials_non_expired` int DEFAULT NULL COMMENT '密码是否过期(1 未过期，0已过期)	',
  `is_enabled` int DEFAULT NULL COMMENT '帐户是否可用(1 可用，0 删除用户)	',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of live_user
-- ----------------------------
BEGIN;
INSERT INTO `live_user` VALUES (29, 'zhoudao', '13123123232', '0', '周道', '$2a$10$PtGuweTnItw2/gk2v7718OkIpiRlAe6aZVSL3vqMhiWWKn3duI1EK', '1', 1, 1, 1, 1);
INSERT INTO `live_user` VALUES (30, 'sushaoqi', '13456554342', '0', '苏少奇', '$2a$10$pfJ5jJH0mTnbHObhH68na.p2BNLYNdeo9cX9/sXyXufX1TN85BdiO', '1', 1, 1, 1, 1);
INSERT INTO `live_user` VALUES (31, 'guagua', '15235532212', '1', 'guagua', '$2a$10$yhZTurMOldTHiYucgt/oKunw9hbcYYBs5WOEuOHUOQj2.cqljpi5.', '1', 1, 1, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for parking_list
-- ----------------------------
DROP TABLE IF EXISTS `parking_list`;
CREATE TABLE `parking_list` (
  `park_id` int NOT NULL AUTO_INCREMENT COMMENT '车位id',
  `park_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '车位类型 0:地上 1：地下',
  `park_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '车位名称',
  `park_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '车位使用状态 0：未使用 1：已使用',
  `park_num` int DEFAULT NULL COMMENT '车位序号',
  PRIMARY KEY (`park_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of parking_list
-- ----------------------------
BEGIN;
INSERT INTO `parking_list` VALUES (14, '1', 'P01', '0', 1);
INSERT INTO `parking_list` VALUES (15, '1', 'P03', '1', 2);
INSERT INTO `parking_list` VALUES (16, '0', 'P02', '1', 1);
INSERT INTO `parking_list` VALUES (17, '0', 'P04', '1', 2);
INSERT INTO `parking_list` VALUES (18, '0', 'P05', '1', 3);
COMMIT;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `log_id` varchar(56) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci NOT NULL,
  `type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '0:正常 1：错误',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '标题',
  `remote_addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '请求地址',
  `request_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '请求url',
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '请求方法',
  `params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci COMMENT '参数',
  `exception` text CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci COMMENT '异常信息',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `user_id` int DEFAULT NULL COMMENT '操作人id',
  `login_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '操作人',
  `result_params` varchar(125) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '返回参数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `ip_num` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT 'ip',
  `ip_region` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '区域',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
BEGIN;
INSERT INTO `sys_log` VALUES ('1000000130854656', '0', '删除员工', '0:0:0:0:0:0:0:1', '/api/user/24', 'DELETE-----deleteUser()', '24', NULL, '2022-07-16 19:41:02', '2022-07-16 19:41:02', 4, '管理员', '{\"msg\":\"删除员工成功\",\"code\":200,\"data\":null}', '2022-07-16 19:41:02', '0:0:0:0:0:0:0:1', 'XX XX');
INSERT INTO `sys_log` VALUES ('1000000859009826', '0', '编辑员工', '0:0:0:0:0:0:0:1', '/api/user', 'PUT-----editUser()', '{\"userId\":4,\"loginName\":\"管理员\",\"password\":\"\",\"username\":\"admin\",\"phone\":\"13232425592\",\"sex\":\"1\",\"idCard\":\"440811199703250934\",\"isAdmin\":null,\"status\":\"0\",\"isUsed\":\"0\",\"authorities\":null,\"enabled\":true,\"accountNonLocked\":true,\"credentialsNonExpired\":true,\"accountNonExpired\":true}', NULL, '2022-07-16 19:37:21', '2022-07-16 19:37:21', 4, '管理员', '{\"msg\":\"编辑员工成功\",\"code\":200,\"data\":null}', '2022-07-16 19:37:21', '0:0:0:0:0:0:0:1', 'XX XX');
INSERT INTO `sys_log` VALUES ('1000001068852255', '0', '编辑员工', '0:0:0:0:0:0:0:1', '/api/user', 'PUT-----editUser()', '{\"userId\":24,\"loginName\":\"师哥\",\"password\":\"\",\"username\":\"shige2\",\"phone\":\"14124333463\",\"sex\":\"1\",\"idCard\":\"444099123124242\",\"isAdmin\":null,\"status\":\"0\",\"isUsed\":\"1\",\"authorities\":null,\"enabled\":true,\"accountNonLocked\":true,\"credentialsNonExpired\":true,\"accountNonExpired\":true}', NULL, '2022-07-16 19:40:59', '2022-07-16 19:40:59', 4, '管理员', '{\"msg\":\"编辑员工成功\",\"code\":200,\"data\":null}', '2022-07-16 19:40:59', '0:0:0:0:0:0:0:1', 'XX XX');
INSERT INTO `sys_log` VALUES ('1000001226176293', '0', '新增员工', '0:0:0:0:0:0:0:1', '/api/user', 'POST-----addUser()', '{\"userId\":24,\"loginName\":\"师哥\",\"password\":\"$2a$10$7Pn5C9Vcx/9l9HIv/UYG5ORYkTqKXHMudUJv8toUvmH4HPAZMYJ1W\",\"username\":\"shige\",\"phone\":\"14124333463\",\"sex\":\"1\",\"idCard\":\"444099123124242\",\"isAdmin\":null,\"status\":\"0\",\"isUsed\":\"1\",\"authorities\":null,\"enabled\":true,\"accountNonLocked\":true,\"credentialsNonExpired\":true,\"accountNonExpired\":true}', NULL, '2022-07-16 19:40:08', '2022-07-16 19:40:08', 4, '管理员', '{\"msg\":\"新增员工成功\",\"code\":200,\"data\":null}', '2022-07-16 19:40:08', '0:0:0:0:0:0:0:1', 'XX XX');
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` int DEFAULT NULL COMMENT '父级菜单id',
  `menu_label` varchar(56) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '菜单名称',
  `menu_code` varchar(56) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '权限字段',
  `name` varchar(56) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '路由名称',
  `path` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '路由地址',
  `url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '组件路由',
  `type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '类型 0：目录 1：菜单 2：按钮',
  `icon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '图标',
  `order_num` int DEFAULT NULL COMMENT '序号',
  `remark` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `parent_name` varchar(56) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '上级菜单名称',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (3, 0, '系统管理', 'sys:system', '', '/system', '', '0', 'el-icon-menu', 1, '', '顶级菜单');
INSERT INTO `sys_menu` VALUES (4, 3, '员工管理', 'sys:sysUserList', 'sys:user:index', '/sysUserList', '/system/sysUserList', '1', 'el-icon-s-custom', 1, '', '系统管理');
INSERT INTO `sys_menu` VALUES (5, 3, '角色管理', 'sys:sysRoleList', 'sysRoleList', '/sysRoleList', '/system/sysRoleList', '1', 'el-icon-date', 2, '', '系统管理');
INSERT INTO `sys_menu` VALUES (6, 3, '权限管理', 'sys:sysMenuList', 'sysMenuList', '/sysMenuList', '/system/sysMenuList', '1', 'el-icon-school', 3, '', '系统管理');
INSERT INTO `sys_menu` VALUES (7, 4, '新增', 'sys:user:add', '', '', '', '2', '', 1, '', '员工管理');
INSERT INTO `sys_menu` VALUES (8, 4, '编辑', 'sys:user:edit', '', '', '', '2', '', 2, '', '员工管理');
INSERT INTO `sys_menu` VALUES (9, 4, '删除', 'sys:user:delete', '', '', '', '2', '', 3, '', '员工管理');
INSERT INTO `sys_menu` VALUES (10, 5, '新增', 'sys:role:add', '', '', '', '2', '', 1, '', '角色管理');
INSERT INTO `sys_menu` VALUES (11, 5, '编辑', 'sys:role:edit', '', '', '', '2', '', 2, '', '角色管理');
INSERT INTO `sys_menu` VALUES (12, 5, '删除', 'sys:role:delete', '', '', '', '2', '', 3, '', '角色管理');
INSERT INTO `sys_menu` VALUES (13, 6, '新增', 'sys:menu:add', '', '', '', '2', '', 1, '', '权限管理');
INSERT INTO `sys_menu` VALUES (14, 6, '编辑', 'sys:menu:edit', '', '', '', '2', '', 2, '', '权限管理');
INSERT INTO `sys_menu` VALUES (15, 6, '删除', 'sys:menu:delete', '', '', '', '2', '', 3, '', '权限管理');
INSERT INTO `sys_menu` VALUES (16, 0, '房屋管理', 'sys:home:index', '', '/sysHouse', '', '0', 'el-icon-s-help', 2, '', '顶级菜单');
INSERT INTO `sys_menu` VALUES (17, 16, '房屋列表', 'sys:house:list', 'sysHouseList', '/sysHouseList', '/house/houseList', '1', 'el-icon-mobile', 3, '', '房屋管理');
INSERT INTO `sys_menu` VALUES (18, 17, '新增', 'sys:house:add', '', '', '', '2', '', 1, '', '房屋列表');
INSERT INTO `sys_menu` VALUES (19, 17, '编辑', 'sys:house:edit', '', '', '', '2', '', 2, '', '房屋列表');
INSERT INTO `sys_menu` VALUES (20, 17, '删除', 'sys:house:delete', '', '', '', '2', '', 3, '', '房屋列表');
INSERT INTO `sys_menu` VALUES (21, 16, '单元管理', 'sys:houseUnit', 'houseUnit', '/houseUnit', '/house/houseUnit', '1', 'table', 2, '', '房屋管理');
INSERT INTO `sys_menu` VALUES (22, 16, '栋数管理', 'sys:houseBuilding', 'houseBuilding', '/houseBuilding', '/house/houseBuilding', '1', 'table', 1, '', '房屋管理');
INSERT INTO `sys_menu` VALUES (23, 22, '新增', 'sys:houseBuilding:add', '', '', '', '2', '', 1, '', '栋数管理');
INSERT INTO `sys_menu` VALUES (24, 22, '编辑', 'sys:houseBuilding:edit', '', '', '', '2', '', 2, '', '栋数管理');
INSERT INTO `sys_menu` VALUES (25, 22, '删除', 'sys:houseBuilding:delete', '', '', '', '2', '', 3, '', '栋数管理');
INSERT INTO `sys_menu` VALUES (26, 21, '新增', 'sys:houseUnit:add', '', '', '', '2', '', 1, '', '单元管理');
INSERT INTO `sys_menu` VALUES (27, 21, '编辑', 'sys:houseUnit:edit', '', '', '', '2', '', 2, '', '单元管理');
INSERT INTO `sys_menu` VALUES (28, 21, '删除', 'sys:houseUnit:delete', '', '', '', '2', '', 3, '', '单元管理');
INSERT INTO `sys_menu` VALUES (29, 0, '车位管理', 'sys:sysPark', '', '/sysPark', '', '0', 'el-icon-money', 3, '', '顶级菜单');
INSERT INTO `sys_menu` VALUES (30, 29, '车位管理', 'sys:parkList', 'parkList', '/parkList', '/park/parkList', '1', 'el-icon-money', 1, '', '车位管理');
INSERT INTO `sys_menu` VALUES (31, 30, '新增', 'sys:parkList:add', '', '', '', '2', '', 1, '', '车位管理');
INSERT INTO `sys_menu` VALUES (32, 30, '编辑', 'sys:parkList:edit', '', '', '', '2', '', 2, '', '车位管理');
INSERT INTO `sys_menu` VALUES (33, 30, '删除', 'sys:parkList:delete', '', '', '', '2', '', 3, '', '车位管理');
INSERT INTO `sys_menu` VALUES (34, 0, '业主管理', 'sys:live', '', '/live', '', '0', 'el-icon-s-grid', 4, '', '顶级菜单');
INSERT INTO `sys_menu` VALUES (35, 34, '业主列表', 'sys:liveUser', 'liveUser', '/liveUser', '/live/liveUser', '1', 'el-icon-s-data', 1, '', '业主管理');
INSERT INTO `sys_menu` VALUES (36, 35, '新增', 'sys:liveUser:add', '', '', '', '2', '', 1, '', '业主列表');
INSERT INTO `sys_menu` VALUES (37, 35, '编辑', 'sys:liveUser:edit', '', '', '', '2', '', 2, '', '业主列表');
INSERT INTO `sys_menu` VALUES (38, 35, '删除', 'sys:liveUser:delete', '', '', '', '2', '', 3, '', '业主列表');
INSERT INTO `sys_menu` VALUES (39, 35, '分配房屋', 'sys:liveUser:assignHome', '', '', '', '2', '', 4, '', '业主列表');
INSERT INTO `sys_menu` VALUES (40, 35, '分配车位', 'sys:liveUser:assignCar', '', '', '', '2', '', 6, '', '业主列表');
INSERT INTO `sys_menu` VALUES (41, 35, '退房', 'sys:liveUser:returnHome', '', '', '', '2', '', 7, '', '业主列表');
INSERT INTO `sys_menu` VALUES (42, 35, '退车位', 'sys:liveUser:returnCar', '', '', '', '2', '', 8, '', '业主列表');
INSERT INTO `sys_menu` VALUES (43, 0, '收费管理', 'sys:fee', '', '/fee', '', '0', 'el-icon-s-open', 5, '', '顶级菜单');
INSERT INTO `sys_menu` VALUES (44, 43, '电费管理', 'sys:feePower', 'feePower', '/feePower', '/fee/feePower', '1', 'el-icon-picture', 1, '', '收费管理');
INSERT INTO `sys_menu` VALUES (45, 43, '水费管理', 'sys:feeWater', 'feeWater', '/feeWater', '/fee/feeWater', '1', 'el-icon-s-data', 2, '', '收费管理');
INSERT INTO `sys_menu` VALUES (46, 43, '停车管理', 'sys:feePark', 'feePark', '/feePark', '/fee/feePark', '1', 'el-icon-s-order', 3, '', '收费管理');
INSERT INTO `sys_menu` VALUES (47, 44, '新增', 'sys:feePower:add', '', '', '', '2', '', 1, '', '电费管理');
INSERT INTO `sys_menu` VALUES (48, 44, '编辑', 'sys:feePower:edit', '', '', '', '2', '', 2, '', '电费管理');
INSERT INTO `sys_menu` VALUES (49, 44, '删除', 'sys:feePower:delete', '', '', '', '2', '', 3, '', '电费管理');
INSERT INTO `sys_menu` VALUES (50, 45, '新增', 'sys:feeWater:add', '', '', '', '2', '', 1, '', '水费管理');
INSERT INTO `sys_menu` VALUES (51, 45, '编辑', 'sys:feeWater:edit', '', '', '', '2', '', 2, '', '水费管理');
INSERT INTO `sys_menu` VALUES (52, 45, '删除', 'sys:feeWater:delete', '', '', '', '2', '', 3, '', '水费管理');
INSERT INTO `sys_menu` VALUES (53, 46, '新增', 'sys:feePark:add', '', '', '', '2', '', 1, '', '停车管理');
INSERT INTO `sys_menu` VALUES (54, 46, '编辑', 'sys:feePark:edit', '', '', '', '2', '', 2, '', '停车管理');
INSERT INTO `sys_menu` VALUES (55, 46, '删除', 'sys:feePark:delete', '', '', '', '2', '', 3, '', '停车管理');
INSERT INTO `sys_menu` VALUES (56, 0, '投诉管理', 'sys:userComplaint', '', '/userComplaint', '', '0', 'el-icon-date', 6, '', '顶级菜单');
INSERT INTO `sys_menu` VALUES (57, 56, '投诉列表', 'sys:userComplaintList', 'userComplaintList', '/userComplaintList', '/userComplaint/userComplaint', '1', 'el-icon-edit-outline', 1, '', '投诉管理');
INSERT INTO `sys_menu` VALUES (58, 56, '我的投诉', 'sys:myUserComplaint', 'myUserComplaint', '/myUserComplaint', '/userComplaint/myUserComplaint', '1', 'el-icon-menu', 2, '', '投诉管理');
INSERT INTO `sys_menu` VALUES (62, 58, '新增', 'sys:myUserComplaint:add', '', '', '', '2', '', 1, '', '我的投诉');
INSERT INTO `sys_menu` VALUES (63, 58, '编辑', 'sys:myUserComplaint:edit', '', '', '', '2', '', 2, '', '我的投诉');
INSERT INTO `sys_menu` VALUES (64, 58, '删除', 'sys:myUserComplaint:delete', '', '', '', '2', '', 3, '', '我的投诉');
INSERT INTO `sys_menu` VALUES (65, 0, '维修管理', 'sys:repairModel', '', '/repairModel', '', '0', 'el-icon-picture-outline', 7, '', '顶级菜单');
INSERT INTO `sys_menu` VALUES (66, 65, '维修列表', 'sys:repairList', 'repairList', '/repairList', '/repair/repairList', '1', 'el-icon-s-marketing', 1, '', '维修管理');
INSERT INTO `sys_menu` VALUES (67, 65, '我的维修', 'sys:myRepair', 'myRepair', '/myRepair', '/repair/myRepair', '1', 'el-icon-picture-outline', 2, '', '维修管理');
INSERT INTO `sys_menu` VALUES (68, 67, '新增', 'sys:myRepair:add', '', '', '', '2', '', 1, '', '我的维修');
INSERT INTO `sys_menu` VALUES (69, 67, '编辑', 'sys:myRepair:edit', '', '', '', '2', '', 2, '', '我的维修');
INSERT INTO `sys_menu` VALUES (70, 67, '删除', 'sys:myRepair:delete', '', '', '', '2', '', 3, '', '我的维修');
INSERT INTO `sys_menu` VALUES (71, 0, '公告管理', 'sys:notice', '', '/notice', '', '0', 'el-icon-document-copy', 8, '', '顶级菜单');
INSERT INTO `sys_menu` VALUES (72, 71, '公告列表', 'sys:noticeList', 'noticeList', '/noticeList', '/notice/noticeList', '1', 'el-icon-s-marketing', 1, '', '公告管理');
INSERT INTO `sys_menu` VALUES (73, 72, '新增', 'sys:noticeList:add', '', '', '', '2', '', 1, '', '公告列表');
INSERT INTO `sys_menu` VALUES (74, 72, '编辑', 'sys:noticeList:edit', '', '', '', '2', '', 2, '', '公告列表');
INSERT INTO `sys_menu` VALUES (75, 72, '删除', 'sys:noticeList:delete', '', '', '', '2', '', 3, '', '公告列表');
INSERT INTO `sys_menu` VALUES (76, 72, '查看', 'sys:notice:look', '', '', '', '2', '', 4, '', '公告列表');
INSERT INTO `sys_menu` VALUES (77, 4, '分配角色', 'sys:user:assignRole', '', '', '', '2', '', 5, '', '员工管理');
INSERT INTO `sys_menu` VALUES (78, 5, '分配权限', 'sys:role:assignMenu', '', '', '', '2', '', 4, '', '角色管理');
INSERT INTO `sys_menu` VALUES (79, 66, '处理', 'sys:repairList:do', '', '', '', '2', '', 1, '', '维修列表');
INSERT INTO `sys_menu` VALUES (80, 57, '处理', 'sys:myUserComplaint:do', '', '', '', '2', '', 1, '', '投诉列表');
INSERT INTO `sys_menu` VALUES (81, 44, '缴费', 'sys:feePower:pay', '', '', '', '2', '', 4, '', '电费管理');
INSERT INTO `sys_menu` VALUES (82, 46, '缴费', 'sys:feePark:pay', '', '', '', '2', '', 4, '', '停车管理');
INSERT INTO `sys_menu` VALUES (83, 45, '缴费', 'sys:feeWater:pay', '', '', '', '2', '', 4, '', '水费管理');
INSERT INTO `sys_menu` VALUES (84, 0, '缴费记录', 'sys:feeList', '', '/feeList', '', '0', 'el-icon-c-scale-to-original', 6, '', '顶级菜单');
INSERT INTO `sys_menu` VALUES (85, 84, '我的电费', 'sys:myPowerFee', 'myPowerFee', '/myPowerFee', '/feeList/myPowerFee', '1', 'el-icon-date', 1, '', '缴费记录');
INSERT INTO `sys_menu` VALUES (86, 84, '我的水费', 'sys:myWaterFee', 'myWaterFee', '/myWaterFee', '/feeList/myWaterFee', '1', 'el-icon-s-shop', 2, '', '缴费记录');
INSERT INTO `sys_menu` VALUES (87, 84, '我的停车费', 'sys:myParkFee', 'myParkFee', '/myParkFee', '/feeList/myParkFee', '1', 'el-icon-s-finance', 3, '', '缴费记录');
COMMIT;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '标题',
  `notice_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
BEGIN;
INSERT INTO `sys_notice` VALUES (1, NULL, '环境卫生', '请大家不要随地乱扔垃圾！', '2021-06-25 22:14:53');
INSERT INTO `sys_notice` VALUES (3, NULL, '测试', '测试', '2021-06-25 22:20:47');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(56) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(56) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (5, '管理员角色', '管理员角色');
INSERT INTO `sys_role` VALUES (6, '水费管理员', '收水费');
INSERT INTO `sys_role` VALUES (8, '业主', '租住房子的人');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_menu_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int DEFAULT NULL COMMENT '角色id',
  `menu_id` int DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2257 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES (1401, 6, 45);
INSERT INTO `sys_role_menu` VALUES (1402, 6, 50);
INSERT INTO `sys_role_menu` VALUES (1403, 6, 51);
INSERT INTO `sys_role_menu` VALUES (1404, 6, 52);
INSERT INTO `sys_role_menu` VALUES (1405, 6, 83);
INSERT INTO `sys_role_menu` VALUES (1406, 6, 43);
INSERT INTO `sys_role_menu` VALUES (1407, 8, 18);
INSERT INTO `sys_role_menu` VALUES (1408, 8, 58);
INSERT INTO `sys_role_menu` VALUES (1409, 8, 62);
INSERT INTO `sys_role_menu` VALUES (1410, 8, 63);
INSERT INTO `sys_role_menu` VALUES (1411, 8, 64);
INSERT INTO `sys_role_menu` VALUES (1412, 8, 67);
INSERT INTO `sys_role_menu` VALUES (1413, 8, 68);
INSERT INTO `sys_role_menu` VALUES (1414, 8, 69);
INSERT INTO `sys_role_menu` VALUES (1415, 8, 70);
INSERT INTO `sys_role_menu` VALUES (1416, 8, 76);
INSERT INTO `sys_role_menu` VALUES (1417, 8, 84);
INSERT INTO `sys_role_menu` VALUES (1418, 8, 85);
INSERT INTO `sys_role_menu` VALUES (1419, 8, 86);
INSERT INTO `sys_role_menu` VALUES (1420, 8, 87);
INSERT INTO `sys_role_menu` VALUES (1421, 8, 16);
INSERT INTO `sys_role_menu` VALUES (1422, 8, 17);
INSERT INTO `sys_role_menu` VALUES (1423, 8, 56);
INSERT INTO `sys_role_menu` VALUES (1424, 8, 65);
INSERT INTO `sys_role_menu` VALUES (1425, 8, 71);
INSERT INTO `sys_role_menu` VALUES (1426, 8, 72);
INSERT INTO `sys_role_menu` VALUES (2187, 5, 3);
INSERT INTO `sys_role_menu` VALUES (2188, 5, 4);
INSERT INTO `sys_role_menu` VALUES (2189, 5, 7);
INSERT INTO `sys_role_menu` VALUES (2190, 5, 8);
INSERT INTO `sys_role_menu` VALUES (2191, 5, 9);
INSERT INTO `sys_role_menu` VALUES (2192, 5, 77);
INSERT INTO `sys_role_menu` VALUES (2193, 5, 5);
INSERT INTO `sys_role_menu` VALUES (2194, 5, 10);
INSERT INTO `sys_role_menu` VALUES (2195, 5, 11);
INSERT INTO `sys_role_menu` VALUES (2196, 5, 12);
INSERT INTO `sys_role_menu` VALUES (2197, 5, 78);
INSERT INTO `sys_role_menu` VALUES (2198, 5, 6);
INSERT INTO `sys_role_menu` VALUES (2199, 5, 13);
INSERT INTO `sys_role_menu` VALUES (2200, 5, 14);
INSERT INTO `sys_role_menu` VALUES (2201, 5, 15);
INSERT INTO `sys_role_menu` VALUES (2202, 5, 16);
INSERT INTO `sys_role_menu` VALUES (2203, 5, 17);
INSERT INTO `sys_role_menu` VALUES (2204, 5, 18);
INSERT INTO `sys_role_menu` VALUES (2205, 5, 19);
INSERT INTO `sys_role_menu` VALUES (2206, 5, 20);
INSERT INTO `sys_role_menu` VALUES (2207, 5, 21);
INSERT INTO `sys_role_menu` VALUES (2208, 5, 26);
INSERT INTO `sys_role_menu` VALUES (2209, 5, 27);
INSERT INTO `sys_role_menu` VALUES (2210, 5, 28);
INSERT INTO `sys_role_menu` VALUES (2211, 5, 22);
INSERT INTO `sys_role_menu` VALUES (2212, 5, 23);
INSERT INTO `sys_role_menu` VALUES (2213, 5, 24);
INSERT INTO `sys_role_menu` VALUES (2214, 5, 25);
INSERT INTO `sys_role_menu` VALUES (2215, 5, 29);
INSERT INTO `sys_role_menu` VALUES (2216, 5, 30);
INSERT INTO `sys_role_menu` VALUES (2217, 5, 31);
INSERT INTO `sys_role_menu` VALUES (2218, 5, 32);
INSERT INTO `sys_role_menu` VALUES (2219, 5, 33);
INSERT INTO `sys_role_menu` VALUES (2220, 5, 34);
INSERT INTO `sys_role_menu` VALUES (2221, 5, 35);
INSERT INTO `sys_role_menu` VALUES (2222, 5, 36);
INSERT INTO `sys_role_menu` VALUES (2223, 5, 37);
INSERT INTO `sys_role_menu` VALUES (2224, 5, 38);
INSERT INTO `sys_role_menu` VALUES (2225, 5, 39);
INSERT INTO `sys_role_menu` VALUES (2226, 5, 40);
INSERT INTO `sys_role_menu` VALUES (2227, 5, 41);
INSERT INTO `sys_role_menu` VALUES (2228, 5, 42);
INSERT INTO `sys_role_menu` VALUES (2229, 5, 43);
INSERT INTO `sys_role_menu` VALUES (2230, 5, 44);
INSERT INTO `sys_role_menu` VALUES (2231, 5, 47);
INSERT INTO `sys_role_menu` VALUES (2232, 5, 48);
INSERT INTO `sys_role_menu` VALUES (2233, 5, 49);
INSERT INTO `sys_role_menu` VALUES (2234, 5, 81);
INSERT INTO `sys_role_menu` VALUES (2235, 5, 45);
INSERT INTO `sys_role_menu` VALUES (2236, 5, 50);
INSERT INTO `sys_role_menu` VALUES (2237, 5, 51);
INSERT INTO `sys_role_menu` VALUES (2238, 5, 52);
INSERT INTO `sys_role_menu` VALUES (2239, 5, 83);
INSERT INTO `sys_role_menu` VALUES (2240, 5, 46);
INSERT INTO `sys_role_menu` VALUES (2241, 5, 53);
INSERT INTO `sys_role_menu` VALUES (2242, 5, 54);
INSERT INTO `sys_role_menu` VALUES (2243, 5, 55);
INSERT INTO `sys_role_menu` VALUES (2244, 5, 82);
INSERT INTO `sys_role_menu` VALUES (2245, 5, 57);
INSERT INTO `sys_role_menu` VALUES (2246, 5, 80);
INSERT INTO `sys_role_menu` VALUES (2247, 5, 66);
INSERT INTO `sys_role_menu` VALUES (2248, 5, 79);
INSERT INTO `sys_role_menu` VALUES (2249, 5, 71);
INSERT INTO `sys_role_menu` VALUES (2250, 5, 72);
INSERT INTO `sys_role_menu` VALUES (2251, 5, 73);
INSERT INTO `sys_role_menu` VALUES (2252, 5, 74);
INSERT INTO `sys_role_menu` VALUES (2253, 5, 75);
INSERT INTO `sys_role_menu` VALUES (2254, 5, 76);
INSERT INTO `sys_role_menu` VALUES (2255, 5, 56);
INSERT INTO `sys_role_menu` VALUES (2256, 5, 65);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `login_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '登录密码',
  `username` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '登录账号',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '电话',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '性别 0：女 1：男',
  `id_card` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '身份证号码',
  `is_admin` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '是否是管理员 0：不是 1：是',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '0：在职  1：离职',
  `is_used` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '0：启用 1：禁用',
  `is_account_non_expired` int DEFAULT NULL COMMENT '帐户是否过期(1 未过期，0已过期)	',
  `is_account_non_locked` int DEFAULT NULL COMMENT ' 帐户是否被锁定(1 未过期，0已过期)	',
  `is_credentials_non_expired` int DEFAULT NULL COMMENT '密码是否过期(1 未过期，0已过期)	',
  `is_enabled` int DEFAULT NULL COMMENT '帐户是否可用(1 可用，0 删除用户)	',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (4, '管理员', '$2a$10$s9o9zvaZNaxyBYSjR4FkhuO2ZcLAnKtP2kCnzCNVBmMY3SOfdpnS.', 'admin', '13232425592', '1', '440811199703250934', '1', '0', '0', 1, 1, 1, 1);
INSERT INTO `sys_user` VALUES (21, '水费管理员', '$2a$10$A3HeevapLsaWqq7vPbl96.LtsH1E2tQpwOgeY.CZNOle5lVJavH.C', 'water', '13232353456', '1', '454534534535345', NULL, '0', '0', 1, 1, 1, 1);
INSERT INTO `sys_user` VALUES (22, '业主', '$2a$10$Par9GPuwYB1rdBCk/UIvhulAMn5RYJju.8pqX5CQkPXZUSinao5Be', 'yezhu', '13242342322', '1', '449823123123121', NULL, '0', '0', 1, 1, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_role_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int DEFAULT NULL COMMENT '角色id',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (10, 5, 4);
INSERT INTO `sys_user_role` VALUES (11, 6, 13);
INSERT INTO `sys_user_role` VALUES (12, 6, 14);
INSERT INTO `sys_user_role` VALUES (15, 8, 19);
INSERT INTO `sys_user_role` VALUES (16, 8, 17);
INSERT INTO `sys_user_role` VALUES (17, 8, 20);
INSERT INTO `sys_user_role` VALUES (18, 6, 21);
INSERT INTO `sys_user_role` VALUES (19, 11, 23);
INSERT INTO `sys_user_role` VALUES (20, 8, 22);
COMMIT;

-- ----------------------------
-- Table structure for user_complaint
-- ----------------------------
DROP TABLE IF EXISTS `user_complaint`;
CREATE TABLE `user_complaint` (
  `complaint_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int DEFAULT NULL COMMENT '业主id',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '标题',
  `complaint_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci COMMENT '投诉内容',
  `create_time` datetime DEFAULT NULL COMMENT '投诉时间',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '处理状态 0：未处理 1：已处理',
  PRIMARY KEY (`complaint_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_complaint
-- ----------------------------
BEGIN;
INSERT INTO `user_complaint` VALUES (6, 4, '乱丢垃圾', '1栋乱丢垃圾', '2021-06-24 22:06:18', '1');
INSERT INTO `user_complaint` VALUES (7, 18, 'A栋下水道井盖坏了', 'A栋下水道井盖坏了', '2021-07-09 19:02:02', '1');
INSERT INTO `user_complaint` VALUES (8, 19, '乱丢垃圾', 'D栋乱丢垃圾', '2021-07-09 21:31:11', '1');
INSERT INTO `user_complaint` VALUES (9, 4, '水龙头爆了', 'A栋水龙头喷水2', '2022-07-06 13:15:31', '1');
INSERT INTO `user_complaint` VALUES (10, 22, 'A栋办事太大声', '隔壁运动的声音太大影响休息', '2022-07-14 20:53:46', '1');
COMMIT;

-- ----------------------------
-- Table structure for user_repair
-- ----------------------------
DROP TABLE IF EXISTS `user_repair`;
CREATE TABLE `user_repair` (
  `repair_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int DEFAULT NULL COMMENT '业主id',
  `phone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '联系电话',
  `repair_address` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci COMMENT '维修地址',
  `repair_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci COMMENT '维修内容',
  `commit_time` datetime DEFAULT NULL COMMENT '报修时间',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL COMMENT '维修状态 0：未维修 1：已维修',
  PRIMARY KEY (`repair_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_repair
-- ----------------------------
BEGIN;
INSERT INTO `user_repair` VALUES (9, 4, '13232798493', 'vavcas', 'edasd', '2022-07-07 17:27:26', '0');
INSERT INTO `user_repair` VALUES (10, 4, '13252803673', 'A栋', '132', '2022-07-09 19:55:24', '1');
INSERT INTO `user_repair` VALUES (12, 22, '13254255232', 'eqeqweq', 'qeqweq', '2022-07-14 20:54:25', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
