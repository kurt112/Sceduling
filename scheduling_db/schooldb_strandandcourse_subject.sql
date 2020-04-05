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
-- Table structure for table `strandandcourse_subject`
--

DROP TABLE IF EXISTS `strandandcourse_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `strandandcourse_subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `strand_and_course_id` int DEFAULT NULL,
  `subject_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `strandcourse_id_idx` (`strand_and_course_id`),
  KEY `subject_fk_idx` (`subject_id`),
  CONSTRAINT `strandcourse_fk` FOREIGN KEY (`strand_and_course_id`) REFERENCES `strandandcourse` (`id`),
  CONSTRAINT `subject_fk` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strandandcourse_subject`
--

LOCK TABLES `strandandcourse_subject` WRITE;
/*!40000 ALTER TABLE `strandandcourse_subject` DISABLE KEYS */;
INSERT INTO `strandandcourse_subject` VALUES (14,9,27),(19,14,62),(22,16,24),(23,16,33),(52,1,8),(53,1,9),(54,1,4),(55,1,3),(56,1,2),(57,1,1),(58,1,6),(59,1,7),(60,1,5),(61,3,40),(62,3,41),(63,3,12),(64,3,34),(65,3,36),(66,3,69),(67,3,17),(68,3,33),(69,3,35),(70,6,11),(71,6,4),(72,6,3),(73,6,2),(74,6,1),(75,6,6),(76,6,7),(77,6,5),(78,8,12),(79,8,50),(80,8,34),(81,8,49),(82,8,36),(83,8,69),(84,8,17),(85,8,33),(86,8,35),(87,8,51),(88,25,2),(89,25,4),(90,25,11),(91,25,3),(92,25,1),(93,25,6),(94,25,7),(95,25,5),(97,15,10),(98,15,4),(99,15,12),(100,15,11),(101,15,3),(102,15,2),(103,15,1),(104,15,7),(105,15,5),(106,20,14),(107,20,4),(108,20,3),(109,20,13),(110,20,2),(111,20,1),(112,20,7),(113,20,5),(114,21,46),(115,21,45),(116,21,44),(117,21,34),(118,21,6),(119,21,36),(120,21,17),(121,21,33),(122,21,35),(123,4,42),(124,4,20),(125,4,15),(126,4,16),(127,4,13),(128,4,37),(129,4,18),(130,4,39),(131,5,56),(133,5,10),(134,5,53),(135,5,21),(136,5,38),(137,5,55),(138,10,64),(139,10,10),(140,10,53),(141,10,21),(142,10,38),(143,10,55),(144,13,30),(145,13,15),(146,13,29),(147,13,16),(148,13,48),(149,13,13),(150,13,37),(151,13,39),(152,18,24),(153,18,22),(154,18,13),(155,18,21),(156,18,23),(157,18,37),(158,18,39),(159,19,68),(160,19,67),(161,19,65),(162,19,53),(163,19,54),(164,19,38),(165,19,69),(166,19,66),(167,22,31),(168,22,15),(169,22,10),(170,22,11),(171,22,16),(172,22,32),(173,22,37),(174,22,39),(175,22,5),(176,23,59),(177,23,53),(178,23,58),(179,23,57),(180,23,54),(181,23,21),(182,23,38),(183,23,55),(1092,12,28),(1093,12,12),(1094,12,47),(1095,12,34),(1096,12,36),(1097,12,17),(1098,12,33),(1099,12,35);
/*!40000 ALTER TABLE `strandandcourse_subject` ENABLE KEYS */;
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
