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
-- Table structure for table `teacher_subjects`
--

DROP TABLE IF EXISTS `teacher_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_subjects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `teacher_id` int DEFAULT NULL,
  `subject_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_fk_idx` (`teacher_id`),
  KEY `subject_fk_idx` (`subject_id`),
  KEY `teacherteach_fk_idx` (`teacher_id`),
  KEY `subjectteach_fk_idx` (`subject_id`),
  CONSTRAINT `subjectteach_fk` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `teacheteachr_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_subjects`
--

LOCK TABLES `teacher_subjects` WRITE;
/*!40000 ALTER TABLE `teacher_subjects` DISABLE KEYS */;
INSERT INTO `teacher_subjects` VALUES (151,114,56),(152,114,43),(153,108,62),(154,108,28),(155,84,15),(156,84,33),(157,103,12),(158,103,55),(159,87,67),(160,87,24),(161,87,54),(162,101,53),(163,101,34),(164,96,40),(165,96,12),(166,95,34),(167,95,6),(168,94,21),(169,94,17),(170,111,35),(171,109,163),(172,109,35),(173,106,68),(174,106,52),(175,106,6),(176,110,50),(177,110,54),(178,110,49),(179,110,63),(180,110,64),(181,110,51),(182,89,52),(183,89,34),(184,88,69),(185,88,35),(186,100,53),(187,100,54),(188,100,35),(189,99,35),(190,113,40),(191,113,43),(192,85,21),(193,85,33),(194,90,17),(195,93,15),(196,93,65),(197,97,44),(198,97,59),(199,97,69),(200,107,45),(201,107,163),(202,107,69),(203,102,33),(204,102,66),(205,92,24),(206,92,52),(207,92,6),(208,105,36),(209,91,10),(210,91,34),(211,83,17),(212,98,58),(213,98,46),(214,98,39),(215,112,44),(216,112,6),(217,86,33),(218,104,38),(219,115,56),(220,115,41),(221,115,53),(222,115,54);
/*!40000 ALTER TABLE `teacher_subjects` ENABLE KEYS */;
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
