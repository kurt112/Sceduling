-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: schooldb
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `room_shift`
--

DROP TABLE IF EXISTS `room_shift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_shift` (
  `id` int NOT NULL AUTO_INCREMENT,
  `room_id` int DEFAULT NULL,
  `strand_and_course_id` int DEFAULT NULL,
  `shift_name` varchar(45) DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `section` varchar(45) DEFAULT NULL,
  `start_time` varchar(45) DEFAULT NULL,
  `end_time` varchar(45) DEFAULT NULL,
  `initial_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `RoomId_FK_idx` (`room_id`),
  KEY `StrandandCourse_FK_idx` (`strand_and_course_id`),
  CONSTRAINT `RoomId_FK` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `StrandandCourse_FK` FOREIGN KEY (`strand_and_course_id`) REFERENCES `strandandcourse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_shift`
--

LOCK TABLES `room_shift` WRITE;
/*!40000 ALTER TABLE `room_shift` DISABLE KEYS */;
INSERT INTO `room_shift` VALUES (88,2,3,'1st Shift','11','ABRAMS','07:00','11:00',NULL),(89,9,3,'1st Shift','11','DORSEY','07:00','11:00',NULL),(90,3,3,'1st Shift','11','ELLISON','07:00','11:00',NULL),(91,5,12,'1st Shift','11','GOSLING','07:00','11:00',NULL),(92,11,8,'1st Shift','11','GATES','07:00','11:00',NULL),(93,7,12,'1st Shift','11','HOFFMAN','07:00','11:00',NULL),(94,17,16,'1st Shift','11','MECHELIN','07:00','11:00',NULL),(95,16,16,'1st Shift','11','MINER','07:00','11:00',NULL),(96,4,16,'1st Shift','11','MORSE','07:00','11:00',NULL),(97,14,21,'1st Shift','11','STONE','07:00','11:00',NULL),(98,2,3,'2nd Shift','11','ACTON','11:10','15:10',NULL),(99,8,3,'2nd Shift','11','BABBAGE','11:10','15:10',NULL),(100,9,3,'2nd Shift','11','BERNES-LEE','11:10','15:10',NULL),(101,5,12,'2nd Shift','11','JOBS','11:10','15:10',NULL),(102,16,12,'2nd Shift','11','KREIGER','11:10','15:10',NULL),(103,3,16,'2nd Shift','11','PAGE','11:10','15:10',NULL),(104,7,16,'2nd Shift','11','MORGAN','11:10','15:10',NULL),(105,4,16,'2nd Shift','11','SYSTROM','11:10','15:10',NULL),(106,14,21,'2nd Shift','11','WALKER','11:10','15:10',NULL),(107,17,21,'2nd Shift','11','WILLIAMS','11:10','15:10',NULL),(108,5,3,'3rd Shift','11','CERF','15:30','19:30',NULL),(109,18,3,'3rd Shift','11','COOPER','15:30','19:30',NULL),(110,12,12,'3rd Shift','11','ENGELBART','15:30','19:30',NULL),(111,7,12,'3rd Shift','11','KNOLL','15:30','19:30',NULL),(112,8,12,'3rd Shift','11','MCCARTHY','15:30','19:30',NULL),(113,9,16,'3rd Shift','11','TORVALDS','15:30','19:30',NULL),(114,2,16,'3rd Shift','11','WALES','15:30','19:30',NULL),(115,3,16,'3rd Shift','11','WEINER','15:30','19:30',NULL),(116,4,21,'3rd Shift','11','ZUCKERBERG','15:30','19:30',NULL),(117,11,8,'3rd Shift','11','EDISON','15:30','19:30',NULL),(118,10,5,'1st Shift','12','APPLE','07:00','11:00',NULL),(119,13,5,'1st Shift','11','CISCO','08:00','12:10',NULL),(120,12,14,'1st Shift','12','GOOGLE','07:00','10:00',NULL),(121,18,14,'1st Shift','12','IBM','07:00','10:00',NULL),(122,10,5,'2nd Shift','12','LINUX','11:10','15:10',NULL),(123,11,10,'2nd Shift','12','DELL','11:10','15:10',NULL),(124,18,14,'2nd Shift','12','MICROSOFT','11:10','15:10',NULL),(125,13,19,'2nd Shift','12','ORACLE','12:10','15:10',NULL),(126,12,23,'2nd Shift','12','QUALCOMM','11:10','14:10',NULL),(127,10,5,'3rd Shift','12','MACINTOSH','15:30','19:30',NULL),(128,13,19,'3rd Shift','12','SAMSUNG','15:30','19:30',NULL),(129,14,23,'3rd Shift','12','SAP','15:30','19:30',NULL);
/*!40000 ALTER TABLE `room_shift` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-06  2:07:05
