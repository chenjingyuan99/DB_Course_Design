/*
Navicat MySQL Data Transfer

Source Server         : DB_Conn1
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : douban_db

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-11-16 14:20:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for db_act
-- ----------------------------
DROP TABLE IF EXISTS `db_act`;
CREATE TABLE `db_act` (
  `actor_id` int(8) NOT NULL AUTO_INCREMENT,
  `movie_id` int(8) NOT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`actor_id`,`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_act
-- ----------------------------

-- ----------------------------
-- Table structure for db_actor
-- ----------------------------
DROP TABLE IF EXISTS `db_actor`;
CREATE TABLE `db_actor` (
  `actor_id` int(8) NOT NULL AUTO_INCREMENT,
  `actor_name` varchar(32) NOT NULL,
  `is_star` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`actor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_actor
-- ----------------------------

-- ----------------------------
-- Table structure for db_awarding
-- ----------------------------
DROP TABLE IF EXISTS `db_awarding`;
CREATE TABLE `db_awarding` (
  `awards_id` int(8) NOT NULL AUTO_INCREMENT,
  `awards_name` varchar(32) NOT NULL,
  `activities` varchar(32) DEFAULT NULL,
  `award_object` varchar(32) DEFAULT NULL,
  `movie_id` int(8) NOT NULL,
  PRIMARY KEY (`awards_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_awarding
-- ----------------------------

-- ----------------------------
-- Table structure for db_classify
-- ----------------------------
DROP TABLE IF EXISTS `db_classify`;
CREATE TABLE `db_classify` (
  `type_id` int(8) NOT NULL AUTO_INCREMENT,
  `movie_id` int(8) NOT NULL,
  PRIMARY KEY (`type_id`,`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_classify
-- ----------------------------

-- ----------------------------
-- Table structure for db_comment
-- ----------------------------
DROP TABLE IF EXISTS `db_comment`;
CREATE TABLE `db_comment` (
  `com_id` int(8) NOT NULL AUTO_INCREMENT,
  `mov_id` int(8) NOT NULL,
  `usr_id` int(8) NOT NULL,
  `com_seen` tinyint(4) NOT NULL,
  `com_star` tinyint(4) DEFAULT NULL,
  `com_content` varchar(16) DEFAULT NULL,
  `com_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_comment
-- ----------------------------

-- ----------------------------
-- Table structure for db_com_lab
-- ----------------------------
DROP TABLE IF EXISTS `db_com_lab`;
CREATE TABLE `db_com_lab` (
  `lab_id` int(8) NOT NULL AUTO_INCREMENT,
  `com_id` int(8) NOT NULL,
  PRIMARY KEY (`lab_id`,`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_com_lab
-- ----------------------------

-- ----------------------------
-- Table structure for db_direct
-- ----------------------------
DROP TABLE IF EXISTS `db_direct`;
CREATE TABLE `db_direct` (
  `director_id` int(8) NOT NULL AUTO_INCREMENT,
  `movie_id` int(8) NOT NULL,
  PRIMARY KEY (`director_id`,`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_direct
-- ----------------------------

-- ----------------------------
-- Table structure for db_director
-- ----------------------------
DROP TABLE IF EXISTS `db_director`;
CREATE TABLE `db_director` (
  `director_id` int(8) NOT NULL AUTO_INCREMENT,
  `director_name` varchar(32) NOT NULL,
  PRIMARY KEY (`director_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_director
-- ----------------------------

-- ----------------------------
-- Table structure for db_discussion
-- ----------------------------
DROP TABLE IF EXISTS `db_discussion`;
CREATE TABLE `db_discussion` (
  `discuss_id` int(8) NOT NULL AUTO_INCREMENT,
  `discuss_topic` varchar(32) DEFAULT NULL,
  `promulgator` varchar(32) DEFAULT NULL,
  `release_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `movie_id` int(8) NOT NULL,
  PRIMARY KEY (`discuss_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_discussion
-- ----------------------------

-- ----------------------------
-- Table structure for db_label
-- ----------------------------
DROP TABLE IF EXISTS `db_label`;
CREATE TABLE `db_label` (
  `lab_id` int(8) NOT NULL AUTO_INCREMENT,
  `lab_content` varchar(16) NOT NULL,
  PRIMARY KEY (`lab_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_label
-- ----------------------------

-- ----------------------------
-- Table structure for db_language
-- ----------------------------
DROP TABLE IF EXISTS `db_language`;
CREATE TABLE `db_language` (
  `language_id` int(8) NOT NULL AUTO_INCREMENT,
  `language_name` varchar(32) NOT NULL,
  PRIMARY KEY (`language_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_language
-- ----------------------------

-- ----------------------------
-- Table structure for db_location
-- ----------------------------
DROP TABLE IF EXISTS `db_location`;
CREATE TABLE `db_location` (
  `region_id` int(8) NOT NULL AUTO_INCREMENT,
  `movie_id` int(8) NOT NULL,
  PRIMARY KEY (`region_id`,`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_location
-- ----------------------------

-- ----------------------------
-- Table structure for db_movie
-- ----------------------------
DROP TABLE IF EXISTS `db_movie`;
CREATE TABLE `db_movie` (
  `movie_id` int(8) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(32) NOT NULL,
  `relrese_date` date NOT NULL,
  `movie_time` tinyint(4) NOT NULL,
  `movie_intro` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_movie
-- ----------------------------

-- ----------------------------
-- Table structure for db_movie_lang
-- ----------------------------
DROP TABLE IF EXISTS `db_movie_lang`;
CREATE TABLE `db_movie_lang` (
  `language_id` int(8) NOT NULL AUTO_INCREMENT,
  `movie_id` int(8) NOT NULL,
  PRIMARY KEY (`language_id`,`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_movie_lang
-- ----------------------------

-- ----------------------------
-- Table structure for db_region
-- ----------------------------
DROP TABLE IF EXISTS `db_region`;
CREATE TABLE `db_region` (
  `region_id` int(8) NOT NULL AUTO_INCREMENT,
  `region_name` varchar(32) NOT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_region
-- ----------------------------

-- ----------------------------
-- Table structure for db_responding
-- ----------------------------
DROP TABLE IF EXISTS `db_responding`;
CREATE TABLE `db_responding` (
  `respond_id` int(8) NOT NULL AUTO_INCREMENT,
  `promulgator` varchar(32) NOT NULL,
  `release_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `discussion_cont` varchar(400) DEFAULT NULL,
  `discuss_id` int(8) NOT NULL,
  PRIMARY KEY (`respond_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_responding
-- ----------------------------

-- ----------------------------
-- Table structure for db_script
-- ----------------------------
DROP TABLE IF EXISTS `db_script`;
CREATE TABLE `db_script` (
  `scriptwriter_id` int(8) NOT NULL AUTO_INCREMENT,
  `movie_id` int(8) NOT NULL,
  PRIMARY KEY (`scriptwriter_id`,`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_script
-- ----------------------------

-- ----------------------------
-- Table structure for db_scriptwriter
-- ----------------------------
DROP TABLE IF EXISTS `db_scriptwriter`;
CREATE TABLE `db_scriptwriter` (
  `scriptwriter_id` int(8) NOT NULL AUTO_INCREMENT,
  `scriptwriter_name` varchar(32) NOT NULL,
  PRIMARY KEY (`scriptwriter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_scriptwriter
-- ----------------------------

-- ----------------------------
-- Table structure for db_type
-- ----------------------------
DROP TABLE IF EXISTS `db_type`;
CREATE TABLE `db_type` (
  `type_id` int(8) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(32) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_type
-- ----------------------------

-- ----------------------------
-- Table structure for db_usr
-- ----------------------------
DROP TABLE IF EXISTS `db_usr`;
CREATE TABLE `db_usr` (
  `usr_id` int(8) NOT NULL AUTO_INCREMENT,
  `usr_account` varchar(16) NOT NULL,
  `usr_nickname` varchar(32) NOT NULL,
  `usr_passwd` varchar(16) NOT NULL,
  PRIMARY KEY (`usr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_usr
-- ----------------------------
