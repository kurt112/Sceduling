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
-- Table structure for table `strandandcourse`
--

DROP TABLE IF EXISTS `strandandcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `strandandcourse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `strand_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strandandcourse`
--

LOCK TABLES `strandandcourse` WRITE;
/*!40000 ALTER TABLE `strandandcourse` DISABLE KEYS */;
INSERT INTO `strandandcourse` VALUES (1,'ICT-Programming 11-1ST SEM'),(3,'ICT-Programming 11- 2ND  SEM'),(4,'ICT-Programming 12-1ST SEM'),(5,'ICT-Programming 12- 2ND  SEM'),(6,'ICT-Animation 11-1ST SEM'),(8,'ICT-Animation 11-2ND SEM'),(9,'ICT-Animation 12-1ST SEM'),(10,'ICT-Animation 12- 2ND  SEM'),(12,'ABM 11 2ND SEM'),(13,'ABM 12 1ST SEM'),(14,'ABM 12 2ND SEM'),(15,'HUMSS 11-1ST SEM'),(16,'HUMSS 11- 2ND  SEM'),(18,'HUMSS 12 1ST SEM'),(19,'HUMSS 12 2ND SEM'),(20,'STEM 11 1ST SEM'),(21,'STEM 11 2ND SEM'),(22,'STEM 12 1ST SEM'),(23,'STEM 12 2ND SEM'),(25,'ABM 11 1ST SEM');
/*!40000 ALTER TABLE `strandandcourse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-09 23:33:58
