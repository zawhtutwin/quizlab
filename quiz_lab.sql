/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : quiz_lab

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2015-08-23 20:08:33
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `answer_id` int(11) NOT NULL,
  `answer_text` varchar(1000) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `correct_flg` varchar(1) DEFAULT 'F',
  PRIMARY KEY (`answer_id`),
  KEY `FKABCA3FBE5C95740C` (`question_id`),
  CONSTRAINT `FKABCA3FBE5C95740C` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1', 'live မသြားခင္ changes မ်ားကို test လုပ္ရန္ အခ်ိန္မရေပ။ထို ့ေၾကာင့္ tester အစား developer ကသာလုပ္သင့္သည္။ ထိုမွသာ အခ်ိန္ကုန္သက္သာမည္။', '1', 'F');
INSERT INTO `answer` VALUES ('2', 'defect ျဖစ္ေနေသာေနရာကိုသာ ျပန္ test လုပ္ရမည္', '1', 'F');
INSERT INTO `answer` VALUES ('3', 'system ၏ အျခား ေနရာမ်ားကို effect ျဖစ္မျဖစ္ သိႏိုင္ရန္ Regression test ကိုအစအဆံုးျပန္run ရမည္။', '1', 'F');
INSERT INTO `answer` VALUES ('4', 'changes area ကိုျပန္ test လုပ္ျပီး regression test၏မည္သည့္အခ်က္မ်ားကိုစစ္ရမည္ကို risk accessment ကိုၾကည့္ျပီးဆံုးျဖတ္ရမည္။ထိုမွသာ system ၏မည္သည့္ေနရာကို effect ျဖစ္မည္ကိုသိႏိုင္မည္။ ', '1', 'T');
INSERT INTO `answer` VALUES ('5', 'ျပင္လိုက္ေသာအရာမ်ား ျပင္ျပီးေၾကာင္းသက္ေသျပရန္', '2', 'F');
INSERT INTO `answer` VALUES ('6', 'ျပီးဆံုးသြားျပီဟု မွားယြင္းစြာ ေဖၚျပေသာ task မရွိေစရန္', '2', 'F');
INSERT INTO `answer` VALUES ('7', 'modification ေၾကာင့္ defect မ်ား ျဖစ္ေပၚျခင္းကို စစ္ရန္', '2', 'T');
INSERT INTO `answer` VALUES ('8', 'Programmer မ်ားကို unit testing ေကာင္းမြန္စြာလုပ္ရန္ တြန္းအားေပးရန္', '2', 'F');
INSERT INTO `answer` VALUES ('9', 'statement coverage ၉၀% ေက်ာ္လ်က္ decision coverage ၁၀၀% ျဖစ္သည္။', '3', 'F');
INSERT INTO `answer` VALUES ('10', 'decision coverage ၉၀% ေက်ာ္လ်င္ statement coverage ၁၀၀% ျဖစ္သည္။', '3', 'F');
INSERT INTO `answer` VALUES ('11', 'decision coverage ၁၀၀% ဆိုသည္မွာ statement coverage ၁၀၀% ဟုဆိုျခင္းျဖစ္သည္။', '3', 'T');
INSERT INTO `answer` VALUES ('12', 'statement coverage ၁၀၀% ဆိုသည္မွာ decision coverage ၁၀၀% ဟုဆိုျခင္းျဖစ္သည္။', '3', 'F');
INSERT INTO `answer` VALUES ('13', 'customer မ်ား ၄င္းတို ့၏ ရံုး တြင္ test လုပ္ျခင္း', '4', 'T');
INSERT INTO `answer` VALUES ('14', 'customer မ်ား developer၏   ရံုးတြင္ test လုပ္ျခင္း', '4', 'F');
INSERT INTO `answer` VALUES ('15', 'ျပင္ပ test team မွ test လုပ္ျခင္း', '4', 'F');
INSERT INTO `answer` VALUES ('16', 'specific user(customer) အတြက္ customize လုပ္ထားေသာ software ကို test လုပ္ရာတြင္အသံုး၀င္သည္။', '4', 'F');

-- ----------------------------
-- Table structure for `design_work`
-- ----------------------------
DROP TABLE IF EXISTS `design_work`;
CREATE TABLE `design_work` (
  `work_no` varchar(255) NOT NULL,
  `work` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`work_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of design_work
-- ----------------------------

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `member_id` int(11) NOT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `member_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', 'zawhtutwin', null);

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_text` varchar(1000) DEFAULT NULL,
  `next_question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', 'Emergency changes မ်ားကိုျပင္ျပီးလ်င္ မည္သည့္အခ်က္ကိုလုပ္ေဆာင္ရမည္နည္း', '2');
INSERT INTO `question` VALUES ('2', 'ISTQB Glossary အရ regression test ကိုအဘယ္ေၾကာင့္လုပ္ေဆာင္ရန္လိုအပ္သနည္း', '3');
INSERT INTO `question` VALUES ('3', 'statement coverage ႏွင့္ decision coverage ႏွစ္ခု မည္သို ့ဆက္စပ္ေနသနည္း', '4');
INSERT INTO `question` VALUES ('4', 'Beta Testing ဆိုသည္မွာ', '1');
