/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 5.7.11-log : Database - courrierdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`courrierdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `courrierdb`;

/*Table structure for table `t_authority` */

DROP TABLE IF EXISTS `t_authority`;

CREATE TABLE `t_authority` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_authority` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `activated` bit(1) NOT NULL,
  `activation_key` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `lang_key` varchar(5) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `login` varchar(50) NOT NULL,
  `password_hash` varchar(60) NOT NULL,
  `reset_date` datetime DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7gshuknepkj6oy1702fqwsr8r` (`login`),
  UNIQUE KEY `UK_i6qjjoe560mee5ajdg7v1o6mi` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

/*Table structure for table `t_utilisateur_authority` */

DROP TABLE IF EXISTS `t_utilisateur_authority`;

CREATE TABLE `t_utilisateur_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_name` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`authority_name`),
  KEY `FK_qqr66m9rv8wi66gwf5f0jjof1` (`authority_name`),
  CONSTRAINT `FK_7ftgojxgjcnc7yk5rimyval1v` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_qqr66m9rv8wi66gwf5f0jjof1` FOREIGN KEY (`authority_name`) REFERENCES `t_authority` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_utilisateur_authority` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
