/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 8.0.28 : Database - postgraduate_forum
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`postgraduate_forum` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `postgraduate_forum`;

/*Table structure for table `block` */

DROP TABLE IF EXISTS `block`;

CREATE TABLE `block` (
  `blockID` int NOT NULL AUTO_INCREMENT,
  `zoneName` varchar(20) NOT NULL,
  `blockName` varchar(20) NOT NULL,
  `blockIntroduce` varchar(100) DEFAULT NULL,
  `postNumber` int NOT NULL,
  `followers` int NOT NULL,
  PRIMARY KEY (`blockID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `block` */

insert  into `block`(`blockID`,`zoneName`,`blockName`,`blockIntroduce`,`postNumber`,`followers`) values (1,'华北地区','北京市高校','这个板块暂时还没有简介',0,0),(2,'华北地区','天津市高校','这个板块暂时还没有简介',0,0),(3,'华北地区','河北省高校','这个板块暂时还没有简介',0,0),(4,'华北地区','山西省高校','这个板块暂时还没有简介',0,0),(5,'华北地区','内蒙古高校','这个板块暂时还没有简介',0,0),(6,'东北三省','辽宁省高校','这个板块暂时还没有简介',0,0),(7,'东北三省','吉林省高校','这个板块暂时还没有简介',0,0),(8,'东北三省','黑龙江省高校','这个板块暂时还没有简介',0,0),(9,'华东地区','上海市高校','这个板块暂时还没有简介',0,0),(10,'华东地区','江苏省高校','这个板块暂时还没有简介',0,0),(11,'华东地区','浙江省高校','这个板块暂时还没有简介',0,0),(12,'华东地区','安徽省高校','这个板块暂时还没有简介',0,0),(13,'华东地区','福建省高校','这个板块暂时还没有简介',0,0),(14,'华东地区','山东省高校','这个板块暂时还没有简介',0,0),(15,'西南地区','重庆市高校','这个板块暂时还没有简介',0,0),(16,'西南地区','四川省高校','这个板块暂时还没有简介',0,0),(17,'西南地区','贵州省高校','这个板块暂时还没有简介',0,0),(18,'西南地区','云南省高校','这个板块暂时还没有简介',0,0),(19,'西南地区','西藏高校','这个板块暂时还没有简介',0,0),(20,'华南地区','广东省高校','这个板块暂时还没有简介',0,0),(21,'华南地区','广西区高校','这个板块暂时还没有简介',0,0),(22,'华南地区','海南省高校','这个板块暂时还没有简介',0,0),(23,'华中地区','江西省高校','这个板块暂时还没有简介',0,0),(24,'华中地区','河南省高校','这个板块暂时还没有简介',0,0),(25,'华中地区','湖北省高校','这个板块暂时还没有简介',0,0),(26,'华中地区','湖南省高校','这个板块暂时还没有简介',0,0),(27,'西北地区','陕西省高校','这个板块暂时还没有简介',0,0),(28,'西北地区','甘肃省高校','这个板块暂时还没有简介',0,0),(29,'西北地区','青海省高校','这个板块暂时还没有简介',0,0),(30,'西北地区','宁夏区高校','这个板块暂时还没有简介',0,0),(31,'西北地区','新疆区高校','这个板块暂时还没有简介',0,0);

/*Table structure for table `file` */

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
  `fileID` int NOT NULL AUTO_INCREMENT,
  `userID` int DEFAULT NULL,
  `fileName` varchar(50) NOT NULL,
  `filePath` varchar(50) NOT NULL,
  PRIMARY KEY (`fileID`),
  KEY `FK_upload_and_download` (`userID`),
  CONSTRAINT `FK_upload_and_download` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `file` */

insert  into `file`(`fileID`,`userID`,`fileName`,`filePath`) values (1,NULL,'initialAvatar.jpg','/initial'),(4,1,'1707876561.jpg','/2024/1/14/10'),(5,1,'1707876976.jpg','/2024/1/14/10'),(6,1,'1707877198.jpg','/2024/1/14/10'),(7,1,'1707887785.jpg','/2024/1/14/13'),(8,1,'1707887856.jpg','/2024/1/14/13'),(9,2,'1707910559.jpg','/2024/1/14/19'),(10,2,'1707911487.jpg','/2024/1/14/19'),(11,2,'1707912439.jpg','/2024/1/14/20'),(12,2,'1707912509.jpg','/2024/1/14/20'),(13,NULL,'logo.jpg','/initial');

/*Table structure for table `isfollow` */

DROP TABLE IF EXISTS `isfollow`;

CREATE TABLE `isfollow` (
  `userID` int NOT NULL,
  `blockID` int NOT NULL,
  PRIMARY KEY (`userID`,`blockID`),
  KEY `FK_isFollow2` (`blockID`),
  CONSTRAINT `FK_isFollow` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_isFollow2` FOREIGN KEY (`blockID`) REFERENCES `block` (`blockID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `isfollow` */

/*Table structure for table `post` */

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `postID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `blockID` int NOT NULL,
  `replyNumber` int NOT NULL,
  `postTitle` varchar(30) NOT NULL,
  `postDate` datetime NOT NULL,
  PRIMARY KEY (`postID`),
  KEY `FK_contain` (`blockID`),
  KEY `FK_publish` (`userID`),
  CONSTRAINT `FK_contain` FOREIGN KEY (`blockID`) REFERENCES `block` (`blockID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_publish` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `post` */

insert  into `post`(`postID`,`userID`,`blockID`,`replyNumber`,`postTitle`,`postDate`) values (1,1,1,5,'论为什么要考研','2024-02-15 15:29:28'),(2,2,13,2,'考研真不如考公吧','2024-02-16 21:07:51'),(3,2,16,1,'今年的形式还是这么难','2024-02-16 21:15:02'),(4,1,13,0,'好想摆烂','2024-02-16 22:06:37'),(6,4,1,2,'寒假马上就要结束喽','2024-02-19 16:02:41');

/*Table structure for table `postreply` */

DROP TABLE IF EXISTS `postreply`;

CREATE TABLE `postreply` (
  `postReplyID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `postID` int NOT NULL,
  `postReplyContent` varchar(100) NOT NULL,
  `postReplyTime` datetime NOT NULL,
  PRIMARY KEY (`postReplyID`),
  KEY `FK_interactToPost` (`userID`),
  KEY `FK_makeup` (`postID`),
  CONSTRAINT `FK_interactToPost` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_makeup` FOREIGN KEY (`postID`) REFERENCES `post` (`postID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `postreply` */

insert  into `postreply`(`postReplyID`,`userID`,`postID`,`postReplyContent`,`postReplyTime`) values (1,1,1,'因为闲的没事干','2024-02-15 15:29:28'),(2,2,1,'只能说现在还是太卷了','2024-02-15 18:22:09'),(3,2,2,'如题','2024-02-16 21:07:52'),(4,2,3,'无论是考研 考公 还是找工作 都好难','2024-02-16 21:15:02'),(5,1,4,'但是摆不得','2024-02-16 22:06:38'),(6,1,2,'评价是两个都考不上','2024-02-16 22:35:50'),(7,1,3,'加油做好自己咯~','2024-02-16 22:42:56'),(8,1,1,'今年考研就是被数学害了 QAQ','2024-02-16 22:46:10'),(9,2,2,'确实','2024-02-16 22:49:33'),(10,2,1,'嗨，还是没时间做模拟卷了，我自己问题也很大','2024-02-17 16:33:03'),(11,4,6,'也不知道能不能考上','2024-02-19 16:02:41'),(12,4,6,'考不上应该怎么办呢QAQ','2024-02-19 16:07:20');

/*Table structure for table `uploadfile` */

DROP TABLE IF EXISTS `uploadfile`;

CREATE TABLE `uploadfile` (
  `uploadfileID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `uploadfileName` varchar(50) NOT NULL,
  `uploadfilePath` varchar(50) NOT NULL,
  `uploadfileSize` varchar(20) NOT NULL,
  `downloadCounts` int NOT NULL,
  `uploadDate` datetime NOT NULL,
  PRIMARY KEY (`uploadfileID`),
  KEY `userID` (`userID`),
  CONSTRAINT `uploadfile_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `uploadfile` */

insert  into `uploadfile`(`uploadfileID`,`userID`,`uploadfileName`,`uploadfilePath`,`uploadfileSize`,`downloadCounts`,`uploadDate`) values (7,1,'开题报告-1708354095.zip','/2024/1/19/22','2981',16,'2024-02-19 22:48:15'),(8,1,'英语-1708356702.zip','/2024/1/19/23','9419',10,'2024-02-19 23:31:42'),(12,2,'nginx-1708404386.zip','/2024/1/20/12','1432',1,'2024-02-20 12:46:26');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `userName` char(15) NOT NULL,
  `userLevel` int NOT NULL,
  `userAvatar` int NOT NULL,
  `userExperience` int NOT NULL,
  `userAccount` varchar(20) NOT NULL,
  `userPassword` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `authority` char(10) NOT NULL,
  `isAdministrators` tinyint(1) NOT NULL,
  `userDescription` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`userID`,`userName`,`userLevel`,`userAvatar`,`userExperience`,`userAccount`,`userPassword`,`authority`,`isAdministrators`,`userDescription`) values (1,'柑橘味香气',1,8,25,'2625124158@qq.com','3d3f8c805febde5abf889e9a21190cb6','1,2',0,'是我最喜欢的猎宝'),(2,'我就吃个橘子',1,12,39,'2482302653@qq.com','3d3f8c805febde5abf889e9a21190cb6','1,2',0,'还吃'),(4,'走在冷风中n',1,1,0,'2323572223@qq.com','3d3f8c805febde5abf889e9a21190cb6','1,2',0,'这个人很懒，什么都没有留下');

/*Table structure for table `userreply` */

DROP TABLE IF EXISTS `userreply`;

CREATE TABLE `userreply` (
  `userReplyID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `postID` int NOT NULL,
  `postReplyID` int NOT NULL,
  `userReplyContent` varchar(30) NOT NULL,
  `userReplyTime` datetime NOT NULL,
  PRIMARY KEY (`userReplyID`),
  KEY `FK_communicate` (`postReplyID`),
  KEY `FK_interactToUser` (`userID`),
  KEY `FK_portion` (`postID`),
  CONSTRAINT `FK_communicate` FOREIGN KEY (`postReplyID`) REFERENCES `postreply` (`postReplyID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_interactToUser` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_portion` FOREIGN KEY (`postID`) REFERENCES `post` (`postID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `userreply` */

insert  into `userreply`(`userReplyID`,`userID`,`postID`,`postReplyID`,`userReplyContent`,`userReplyTime`) values (1,2,1,8,'今年的数学真的是不好评价','2024-02-17 09:56:56'),(2,2,4,5,'摆了！','2024-02-17 16:23:32'),(3,2,1,8,'而且408也不是个好东西','2024-02-17 16:24:33'),(4,4,6,12,'希望可以考上吧','2024-02-19 16:07:38');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
