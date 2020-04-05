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
-- Table structure for table `teacher_lecture`
--

DROP TABLE IF EXISTS `teacher_lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_lecture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `teacher_data` int DEFAULT NULL,
  `lecture_day` varchar(45) DEFAULT NULL,
  `start_time` varchar(45) DEFAULT NULL,
  `end_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacherFK_id_idx` (`teacher_data`),
  CONSTRAINT `data_teacher_FK` FOREIGN KEY (`teacher_data`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_lecture`
--

LOCK TABLES `teacher_lecture` WRITE;
/*!40000 ALTER TABLE `teacher_lecture` DISABLE KEYS */;
INSERT INTO `teacher_lecture` VALUES (28,83,'MWF','07:00','17:30'),(29,83,'TTH','07:00','16:30'),(30,84,'MWF','07:00','17:30'),(31,84,'MONDAY','09:00','16:30'),(32,85,'MWF','07:00','16:30'),(33,85,'TTH','10:00','16:30'),(34,86,'MWF','07:00','17:30'),(35,86,'TTH','09:00','17:30'),(36,87,'MWF','08:00','18:30'),(37,87,'TTH','08:00','15:10'),(39,88,'TTH','08:00','17:30'),(40,88,'MWF','08:00','18:30'),(41,89,'MWF','12:10','18:30'),(42,89,'TTH','07:00','19:30'),(43,90,'MWF','09:00','16:30'),(44,90,'TTH','07:00','17:30'),(45,91,'MWF','09:00','18:30'),(46,91,'TTH','07:00','19:30'),(47,92,'MWF','07:00','15:10'),(48,92,'TTH','08:00','19:30'),(49,93,'MWF','07:00','16:30'),(50,93,'TTH','09:00','18:30'),(51,94,'MWF','10:00','18:30'),(52,94,'TTH','09:00','16:30'),(53,95,'MWF','07:00','17:30'),(54,95,'TTH','09:00','18:30'),(55,96,'MWF','07:00','15:10'),(56,96,'TTH','07:00','17:30'),(57,97,'MWF','08:00','16:30'),(58,97,'TTH','08:00','17:30'),(59,98,'MWF','09:00','16:30'),(60,98,'TTH','12:10','19:30'),(61,99,'MWF','08:00','15:10'),(62,99,'TTH','08:00','18:30'),(63,100,'MWF','08:00','18:30'),(64,100,'TTH','08:00','15:10'),(65,101,'MWF','08:00','17:30'),(66,101,'TTH','07:00','17:30'),(67,102,'MWF','07:00','17:30'),(68,102,'TTH','07:00','16:30'),(69,103,'MWF','08:00','17:30'),(70,103,'TTH','07:00','19:30'),(71,104,'MWF','10:00','17:00'),(72,104,'TTH','10:00','17:00'),(73,105,'MWF','09:00','17:30'),(74,105,'TTH','10:00','17:00'),(75,106,'MWF','13:10','19:30'),(76,106,'TTH','11:10','18:30'),(77,107,'MWF','13:10','17:30'),(78,107,'TTH','09:00','15:10'),(79,108,'MWF','15:30','19:30'),(80,108,'TTH','07:00','09:00'),(81,109,'MWF','16:30','19:30'),(82,109,'TTH','16:30','19:30'),(83,115,'MWF','07:00','17:30'),(84,115,'TTH','09:00','15:10'),(85,110,'MWF','07:00','19:30'),(86,111,'TTH','17:30','19:30'),(87,112,'MWF','17:30','19:30'),(88,112,'TTH','16:30','19:30'),(89,113,'MWF','08:00','10:00'),(90,113,'TTH','07:30','10:00'),(92,114,'TTH','15:30','19:30');
/*!40000 ALTER TABLE `teacher_lecture` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-06  2:07:06
