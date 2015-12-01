USE `test`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `ID`       BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME`     VARCHAR(50)  NOT NULL COMMENT '用户名',
  `PASSWORD` VARCHAR(255) NOT NULL COMMENT '密码',
  `GENDER_CODE` TINYINT(2) NOT NULL DEFAULT 1 COMMENT '性别 1-男，2-女',
  `EMAIL` VARCHAR(50) COMMENT '邮箱地址',
  `IS_ACTIVE` TINYINT(1) NOT NULL DEFAULT TRUE COMMENT '是否启用',
  PRIMARY KEY (`ID`)
);

DROP TABLE IF EXISTS `MENU`;
CREATE TABLE `MENU` (
  `ID`               BIGINT(11)   NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME`             VARCHAR(50)  NOT NULL COMMENT '菜单名称',
  `IS_SYSTEM`        TINYINT(1)   NOT NULL COMMENT '是否系统 true(1)-是，false(0)-否',
  `STATE`            VARCHAR(100) NOT NULL COMMENT '菜单对应的路由名称',
  `ICON_URL`         VARCHAR(255) COMMENT '菜单图标URL',
  `PARENT_ID`       BIGINT COMMENT '父菜单ID',
  `IS_SHORTCUT_MENU` TINYINT(1)   NOT NULL DEFAULT FALSE COMMENT '是否快捷菜单 true(1)-是，false(0)-否',
  PRIMARY KEY (`ID`)
);


INSERT INTO `USER` (`NAME`, `PASSWORD`, `GENDER_CODE`, `EMAIL`, `IS_ACTIVE`) VALUES ('admin', '123456', 1, 'sunnyxiaobai5@gmail.com', TRUE);
INSERT INTO `USER` (`NAME`, `PASSWORD`, `GENDER_CODE`, `EMAIL`, `IS_ACTIVE`) VALUES ('test', '123456', 1, 'sunnyxiaobai5@gmail.com', TRUE);

INSERT INTO `MENU` (`NAME`, `IS_SYSTEM`, `STATE`, `ICON_URL`, `PARENT_ID`, `IS_SHORTCUT_MENU`) VALUES ('系统1', TRUE, 'system1', NULL, NULL, FALSE);
INSERT INTO `MENU` (`NAME`, `IS_SYSTEM`, `STATE`, `ICON_URL`, `PARENT_ID`, `IS_SHORTCUT_MENU`) VALUES ('系统2', TRUE, 'system2', NULL, NULL, FALSE);
INSERT INTO `MENU` (`NAME`, `IS_SYSTEM`, `STATE`, `ICON_URL`, `PARENT_ID`, `IS_SHORTCUT_MENU`) VALUES ('系统3', TRUE, 'system3', NULL, NULL, FALSE);
INSERT INTO `MENU` (`NAME`, `IS_SYSTEM`, `STATE`, `ICON_URL`, `PARENT_ID`, `IS_SHORTCUT_MENU`) VALUES ('系统4', TRUE, 'system4', NULL, NULL, FALSE);
INSERT INTO `MENU` (`NAME`, `IS_SYSTEM`, `STATE`, `ICON_URL`, `PARENT_ID`, `IS_SHORTCUT_MENU`) VALUES ('系统1-模块1', FALSE, 'system1.module1', NULL, 1, FALSE);
INSERT INTO `MENU` (`NAME`, `IS_SYSTEM`, `STATE`, `ICON_URL`, `PARENT_ID`, `IS_SHORTCUT_MENU`) VALUES ('系统1-模块2', FALSE, 'system1.module2', NULL, 1, FALSE);
INSERT INTO `MENU` (`NAME`, `IS_SYSTEM`, `STATE`, `ICON_URL`, `PARENT_ID`, `IS_SHORTCUT_MENU`) VALUES ('系统2-模块1', FALSE, 'system2.module1', NULL, 2, FALSE);

SHOW CREATE DATABASE `test`;
SHOW CREATE TABLE `USER`;
SHOW CREATE TABLE `MENU`;
