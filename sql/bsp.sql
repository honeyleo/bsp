/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.6.13 : Database - dass
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bsp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bsp`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) DEFAULT NULL COMMENT '登录名',
  `password` varchar(256) DEFAULT NULL COMMENT '登录密码，保存md5值',
  `realName` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(50) DEFAULT NULL COMMENT '公司的个人邮箱，邮件提醒功能',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `roleId` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `state` int(2) DEFAULT NULL COMMENT '数据状态',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gameId` int(11) DEFAULT '0' COMMENT '游戏ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='后勤用户身份';

/*Data for the table `admin` */

insert  into `admin`(`id`,`username`,`password`,`realName`,`email`,`phone`,`address`,`roleId`,`state`,`createTime`,`gameId`) values (1,'dev','8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918','开发者',NULL,NULL,NULL,1,1,'2013-01-23 17:33:24',NULL),(2,'admin','8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918','管理员',NULL,NULL,NULL,2,1,'2013-01-23 17:33:46',NULL);

/*Table structure for table `admin_menu` */

DROP TABLE IF EXISTS `admin_menu`;

CREATE TABLE `admin_menu` (
  `adminId` bigint(11) NOT NULL,
  `menuId` bigint(11) NOT NULL,
  PRIMARY KEY (`adminId`,`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户菜单绑定';

/*Data for the table `admin_menu` */

insert  into `admin_menu`(`adminId`,`menuId`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,10),(1,21),(1,22),(1,715),(1,716),(1,727),(1,739),(1,740),(1,741),(1,742),(1,743),(1,753),(1,754),(1,761),(1,762),(1,763),(1,764),(1,765),(1,766),(1,767),(1,768),(1,769),(1,770),(1,771),(1,772),(1,773),(1,774),(1,775),(1,776),(1,777),(1,778),(1,779),(1,780),(1,781),(1,782),(1,783),(1,784),(1,785),(1,786),(1,787),(1,788),(1,789),(1,790),(1,791),(1,792),(1,793),(1,794),(1,795),(1,796),(1,797),(1,798),(1,799),(1,800),(1,801),(1,802),(1,803),(1,804),(1,805),(1,806),(1,807),(1,808),(1,809),(1,810),(1,811),(1,812),(1,813),(1,814),(1,815),(1,816),(1,817),(1,818),(1,819),(1,820),(1,821),(1,822),(1,823),(1,824),(1,825),(1,827),(1,828),(1,829),(2,1),(2,2),(2,3),(2,4),(2,5),(2,10),(2,21),(2,22),(2,715),(2,716),(2,727),(2,739),(2,740),(2,741),(2,742),(2,743),(2,753),(2,754),(2,761),(2,762),(2,763),(2,764),(2,765),(2,766),(2,767),(2,768),(2,769),(2,770),(2,771),(2,772),(2,773),(2,774),(2,775),(2,776),(2,777),(2,778),(2,779),(2,780),(2,781),(2,782),(2,783),(2,784),(2,785),(2,786),(2,787),(2,788),(2,789),(2,790),(2,791),(2,792),(2,793),(2,794),(2,795),(2,796),(2,797),(2,798),(2,799),(2,800),(2,801),(2,802),(2,803),(2,804),(2,805),(2,806),(2,807),(2,808),(2,809),(2,810),(2,811),(2,812),(2,813),(2,814),(2,815),(2,816),(2,817),(2,818),(2,819),(2,820),(2,821),(2,822),(2,823),(2,824),(2,825),(2,827),(2,828),(2,829);

/*Table structure for table `channel` */

DROP TABLE IF EXISTS `channel`;

CREATE TABLE `channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `channelId` bigint(20) DEFAULT NULL,
  `channelName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

/*Data for the table `channel` */

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `type` int(4) NOT NULL COMMENT '类型，1为省，2为市',
  `parentId` bigint(11) DEFAULT '0' COMMENT '归属省份',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `abbr` varchar(10) DEFAULT '0' COMMENT '简称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='现在只有省份一级';

/*Data for the table `city` */

insert  into `city`(`id`,`type`,`parentId`,`name`,`abbr`) values (1,1,0,'北京市','京'),(2,1,0,'天津市','津'),(3,1,0,'上海市','沪'),(4,1,0,'重庆市','渝'),(5,1,0,'河北省','冀'),(6,1,0,'河南省','豫'),(7,1,0,'云南省','云'),(8,1,0,'辽宁省','辽'),(9,1,0,'黑龙江省','黑'),(10,1,0,'湖南省','湘'),(11,1,0,'安徽省','皖'),(12,1,0,'山东省','鲁'),(13,1,0,'新疆维吾尔','新'),(14,1,0,'江苏省','苏'),(15,1,0,'浙江省','浙'),(16,1,0,'江西省','赣'),(17,1,0,'湖北省','鄂'),(18,1,0,'广西壮族','桂'),(19,1,0,'甘肃省','甘'),(20,1,0,'山西省','晋'),(21,1,0,'内蒙古','蒙'),(22,1,0,'陕西省','陕'),(23,1,0,'吉林省','吉'),(24,1,0,'福建省','闽'),(25,1,0,'贵州省','贵'),(26,1,0,'广东省','粤'),(27,1,0,'青海省','青'),(28,1,0,'西藏','藏'),(29,1,0,'四川省','川'),(30,1,0,'宁夏回族','宁'),(31,1,0,'海南省','琼'),(32,1,0,'台湾省','台'),(33,1,0,'香港特别行政区','港'),(34,1,0,'澳门特别行政区','澳');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '菜单名称',
  `type` int(4) DEFAULT NULL COMMENT '菜单所属分类，1为内勤人员功能菜单，2为外勤人员功能菜单',
  `parentId` bigint(11) NOT NULL COMMENT '父级菜单ID',
  `parentIdPath` varchar(500) NOT NULL COMMENT '父级菜单ID串联，便于查询，格式：$1$2$',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单链接',
  `orderNo` int(11) DEFAULT '0' COMMENT '排序',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `state` int(2) DEFAULT '1' COMMENT '数据状态',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `onMenu` tinyint(4) DEFAULT '1' COMMENT '是否显示在菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=825 DEFAULT CHARSET=utf8 COMMENT='后勤管理权限菜单信息';

/*Data for the table `menu` */

insert  into `menu`(`id`,`name`,`type`,`parentId`,`parentIdPath`,`url`,`orderNo`,`remark`,`state`,`createTime`,`onMenu`) 
values (1,'应用推广管理后台',1,-1,'$','',0,'推广管理后台',1,'2013-01-21 14:19:22',1),
(2,'系统管理',1,1,'$1$','',0,'用户和菜单的设置',1,'2013-01-23 10:12:31',1),
(3,'系统管理人员',1,2,'$1$2$','system/admin/list',1,'内勤人员管理',1,'2013-01-23 10:15:27',1),
(4,'功能菜单及权限',1,2,'$1$2$','system/menu/list?type=1',3,'内勤功能菜单管理',1,'2013-01-23 10:17:34',1),
(5,'功能菜单及权限',1,715,'$1$715$','system/menu/list?type=2',4,'外勤功能菜单管理',1,'2013-01-24 14:28:03',1),
(10,'人员角色',1,2,'$1$2$','system/role/list?type=1',2,'人员角色管理',1,'2013-01-24 19:01:56',1),
(716,'人员角色',1,715,'$1$715$','system/role/list?type=2',3,'',1,'2013-03-26 15:02:53',1),
(761,'添加管理人员',1,3,'$1$2$3$','system/admin/goadd',1,'',1,'2013-09-20 15:45:49',0),
(762,'添加管理人员提交',1,3,'$1$2$3$','system/admin/add',2,'',1,'2013-09-20 15:46:19',0),
(763,'编辑管理人员',1,3,'$1$2$3$','system/admin/detail',3,'',1,'2013-09-20 15:46:49',0),
(764,'编辑管理人员提交',1,3,'$1$2$3$','system/admin/update',4,'',1,'2013-09-20 15:47:25',0),
(765,'选择关联客户',1,3,'$1$2$3$','system/admin/listLookup',6,'',1,'2013-09-20 15:49:21',0),
(766,'选择关联客户的子客户',1,3,'$1$2$3$','system/admin/childListLookup',7,'',1,'2013-09-20 15:49:53',0),
(767,'确定关联客户',1,3,'$1$2$3$','system/admin/lookup',10,'',1,'2013-09-20 15:50:35',0),
(768,'编辑管理人员权限',1,3,'$1$2$3$','system/admin_menu/list',8,'',1,'2013-09-20 15:51:46',0),
(769,'删除管理人员',1,3,'$1$2$3$','system/admin/del',5,'',1,'2013-09-20 15:53:05',0),
(770,'添加角色',1,10,'$1$2$10$','system/role/goadd',1,'',1,'2013-09-20 15:54:44',0),
(771,'添加角色提交',1,10,'$1$2$10$','system/role/add',2,'',1,'2013-09-20 15:55:18',0),
(772,'编辑角色',1,10,'$1$2$10$','system/role/detail',3,'',1,'2013-09-20 15:55:54',0),
(773,'编辑角色提交',1,10,'$1$2$10$','system/role/update',4,'',1,'2013-09-20 15:56:22',0),
(774,'删除角色',1,10,'$1$2$10$','system/role/del',5,'',1,'2013-09-20 15:56:53',0),
(775,'编辑角色默认权限',1,10,'$1$2$10$','system/role_menu/list',6,'',1,'2013-09-20 15:57:30',0),
(776,'编辑菜单及权限',1,4,'$1$2$4$','system/menu/goedit',1,'',1,'2013-09-20 16:01:23',0),
(777,'编辑菜单及权限提交',1,4,'$1$2$4$','system/menu/save',2,'',1,'2013-09-20 16:02:00',0),
(778,'检索菜单',1,4,'$1$2$4$','system/menu/goselect',3,'',1,'2013-09-20 16:03:00',0),
(779,'删除菜单',1,4,'$1$2$4$','system/menu/del',4,'',1,'2013-09-20 16:03:27',0),
(794,'编辑角色默认权限提交',1,10,'$1$2$10$','system/role_menu/save',7,'',1,'2013-09-20 16:19:14',0),
(795,'编辑管理人员权限提交',1,3,'$1$2$3$','system/admin_menu/save',9,'',1,'2013-09-20 16:20:23',0),
(796,'添加角色',1,716,'$1$715$716$','system/role/goadd',1,'',1,'2013-09-20 16:29:34',0),
(797,'添加角色提交',1,716,'$1$715$716$','system/role/add',2,'',1,'2013-09-20 16:29:56',0),
(798,'编辑角色',1,716,'$1$715$716$','system/role/detail',3,'',1,'2013-09-20 16:30:26',0),
(799,'编辑角色提交',1,716,'$1$715$716$','system/role/update',4,'',1,'2013-09-20 16:30:54',0),
(800,'删除角色',1,716,'$1$715$716$','system/role/del',5,'',1,'2013-09-20 16:31:23',0),
(801,'编辑角色默认权限',1,716,'$1$715$716$','system/role_menu/list',6,'',1,'2013-09-20 16:31:58',0),
(802,'编辑角色默认权限提交',1,716,'$1$715$716$','system/role_menu/save',7,'',1,'2013-09-20 16:32:36',0),
(803,'编辑菜单及权限',1,5,'$1$715$5$','system/menu/goedit',1,'',1,'2013-09-20 16:35:13',0),
(804,'编辑菜单角色及权限提交',1,5,'$1$715$5$','system/menu/save',2,'',1,'2013-09-20 16:35:37',0),
(805,'检索菜单',1,5,'$1$715$5$','system/menu/goselect',3,'',1,'2013-09-20 16:36:02',0),
(806,'删除菜单',1,5,'$1$715$5$','system/menu/del',4,'',1,'2013-09-20 16:36:21',0);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '内勤管理角色名称',
  `type` int(4) DEFAULT NULL COMMENT '角色作用人员，1作用于内勤人员，2作用于外勤人员',
  `desc` varchar(200) DEFAULT NULL COMMENT '描述',
  `orderNo` int(11) DEFAULT '100',
  `popedom` int(4) DEFAULT NULL COMMENT '甜椒权限标识：甜椒为1001、1002等；权限值越小，权限越大，主要用于创建用户判断权限的大小',
  `projectId` bigint(20) DEFAULT '0',
  `state` int(2) DEFAULT '1' COMMENT '数据状态',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='内勤管理人员角色';

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`type`,`desc`,`orderNo`,`popedom`,`projectId`,`state`,`createTime`) 
values (1,'系统开发者',1,'系统开发者',1,NULL,0,1,'2013-01-21 14:24:33'),
(2,'管理员',1,'管理员',2,NULL,0,1,'2013-01-21 14:33:17'),
(3,'开发商',2,'游戏开发商',3,NULL,0,1,'2013-08-27 16:54:31');

/*Table structure for table `role_default_menu` */

DROP TABLE IF EXISTS `role_default_menu`;

CREATE TABLE `role_default_menu` (
  `roleId` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
  `menuId` bigint(20) NOT NULL DEFAULT '0' COMMENT '权限菜单id',
  PRIMARY KEY (`roleId`,`menuId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='内勤管理角色默认对应的菜单';

/*Data for the table `role_default_menu` */

insert  into `role_default_menu`(`roleId`,`menuId`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,10),(1,21),(1,22),(1,715),(1,716),(1,727),(1,739),(1,740),(1,741),(1,742),(1,743),(1,753),(1,754),(1,761),(1,762),(1,763),(1,764),(1,765),(1,766),(1,767),(1,768),(1,769),(1,770),(1,771),(1,772),(1,773),(1,774),(1,775),(1,776),(1,777),(1,778),(1,779),(1,780),(1,781),(1,782),(1,783),(1,784),(1,785),(1,786),(1,787),(1,788),(1,789),(1,790),(1,791),(1,792),(1,793),(1,794),(1,795),(1,796),(1,797),(1,798),(1,799),(1,800),(1,801),(1,802),(1,803),(1,804),(1,805),(1,806),(1,807),(1,808),(1,809),(1,810),(1,811),(1,812),(1,813),(1,814),(1,815),(1,816),(1,817),(1,818),(1,819),(1,820),(1,821),(1,822),(1,823),(1,824),(1,825),(2,1),(2,2),(2,3),(2,4),(2,5),(2,10),(2,21),(2,22),(2,715),(2,716),(2,727),(2,739),(2,740),(2,741),(2,742),(2,743),(2,753),(2,754),(2,761),(2,762),(2,763),(2,764),(2,765),(2,766),(2,767),(2,768),(2,769),(2,770),(2,771),(2,772),(2,773),(2,774),(2,775),(2,776),(2,777),(2,778),(2,779),(2,780),(2,781),(2,782),(2,783),(2,784),(2,785),(2,786),(2,787),(2,788),(2,789),(2,790),(2,791),(2,792),(2,793),(2,794),(2,795),(2,796),(2,797),(2,798),(2,799),(2,800),(2,801),(2,802),(2,803),(2,804),(2,805),(2,806),(2,807),(2,808),(2,809),(2,810),(2,811),(2,812),(2,813),(2,814),(2,815),(2,816),(2,817),(2,818),(2,819),(2,820),(2,821),(2,822),(2,823),(2,824),(2,825),(3,1),(3,807),(3,808),(3,809),(3,810);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
