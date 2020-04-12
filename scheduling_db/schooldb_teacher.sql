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
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `work_type` varchar(45) DEFAULT NULL,
  `subject_load` int DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_username_idx` (`user_name`),
  CONSTRAINT `fk_username` FOREIGN KEY (`user_name`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (83,'MIKAELA-FT ','Mikaela Janine','Torres','FEMALE','FULLTIME',0),(84,'ANGELICA-FT','Angelica','Pamittan','FEMALE','FULLTIME',0),(85,'KIMBERLY-FT','Kimberly ','Paderan','FEMALE','FULLTIME',0),(86,'SHIRLEY-FT','Shirley ','Rebellon','FEMALE','FULLTIME',0),(87,'ARMAN-FT','Arman ','Cagampan','MALE','FULLTIME',0),(88,'JODEL-FT','Jodel','Zaballa','MALE','FULLTIME',0),(89,'JESSICA-FT','Jessica ','Nano','FEMALE','FULLTIME',0),(90,'LAICA-FT','Laica ','Dela Cruz','FEMALE','FULLTIME',0),(91,'MARYLYN-FT','Marylyn ','Berces','FEMALE','FULLTIME',0),(92,'MANILYN-FT','Manilyn','Cuizon','FEMALE','FULLTIME',0),(93,'LANI-FT','Lani Rose ','Cruz','FEMALE','FULLTIME',0),(94,'DIVINE-FT','Divine Rochelle ','Avila','FEMALE','FULLTIME',0),(95,'CARTHY-FT','Carthy Mar ','Cunanan','FEMALE','FULLTIME',0),(96,'BRIAN-FT','Brian','Sumalinog','MALE','FULLTIME',0),(97,'LESLYN-FT','Leslyn ','Tabinas','FEMALE','FULLTIME',0),(98,'RAYBEN-FT','Rayben ','Gallardo','FEMALE','FULLTIME',0),(99,'JONATHAN-FT','Jonathan ','Velarde','MALE','FULLTIME',0),(100,'JAPHET-FT','John Japhet ','Gacias','MALE','FULLTIME',0),(101,'BIANCA-FT','Bianca Micaella ','Manuel','FEMALE','FULLTIME',0),(102,'ROWENA-FT','Ma.Rowena ','Perez','FEMALE','FULLTIME',0),(103,'ANGELIKA-FT','Angelika ','Irinco','FEMALE','FULLTIME',0),(104,'VERONICA-FT','Veronica','Solomon','FEMALE','FULLTIME',0),(105,'MARK-FT','Mark Joseph ','Ferraz','MALE','FULLTIME',0),(106,'JERICK-PT','Jerick ','Quinola','MALE','PARTTIME',0),(107,'LYDIA-PT','Lydia ','Cajucom','FEMALE','PARTTIME',0),(108,'ALICE-PT','Alice ','Dela Cruz','FEMALE','PARTTIME',0),(109,'EDUARDO-PT','Eduardo ','Sabado','MALE','PARTTIME',0),(110,'MICHAEL-PT','Jan Michael ','Orias','MALE','PARTTIME',0),(111,'ED-PT','Ed ','Canda','MALE','PARTTIME',0),(112,'SAMSON-PT','Samson ','Baloaloa','MALE','PARTTIME',0),(113,'JOSEPH-PT','Joseph ','Fidelino','MALE','PARTTIME',0),(114,'ALDIN-PT','Aldin','Bautista','MALE','PARTTIME',0),(115,'JINO-PT','Jino','Barrantes','MALE','PARTTIME',0),(116,'OIC123','john','doe','MALE','FULLTIME',0);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-09 23:33:59
