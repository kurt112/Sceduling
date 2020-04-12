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
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(225) DEFAULT NULL,
  `subject_code` varchar(45) DEFAULT NULL,
  `subject_hour_cost` int DEFAULT NULL,
  `subject_minute_cost` int DEFAULT NULL,
  `subject_unit` varchar(45) DEFAULT NULL,
  `is_major` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Oral Communication','GEN-ORCOM',1,0,NULL,'Minor'),(2,'Komunikasyon at  Pananaliksik sa Wika at  Kulturang Pilipino','GEN-KPWKP',1,0,NULL,'Minor'),(3,'General Mathematics','GEN-GENM',1,0,NULL,'Minor'),(4,'Earth and Life Science','GEN-ELS',1,0,NULL,'Minor'),(5,'Understanding Culture,  Society and Politics','GEN-UCSP',1,0,NULL,'Minor'),(6,'Personal Development','GEN-PRDV',1,0,NULL,'Minor'),(7,'Physical Education and Health DANCE 1','GEN-1SPE11',1,0,NULL,'Minor'),(8,'Computer Programming (.Net Technology) 1l','ICT-CPN1',1,0,NULL,'Major'),(9,'Computer Programming (Java) 1','ICT-CPJ1',1,0,NULL,'Major'),(10,'Contemporary Philippine Arts from the Regions','GEN-CPAR',1,0,NULL,'Minor'),(11,'English for Academic and Professional Purposes','GEN-ENGAP',1,0,NULL,'Minor'),(12,'Empowerment Technologies','GEN-EMT',1,0,NULL,'Minor'),(13,'Introduction to the Philosophy of the Human Person','GEN-IPHIL',1,0,NULL,'Minor'),(14,'Pre-Calculus','STM-PREC',1,0,NULL,'Major'),(15,'21st Century Literature from the Philippines and the World','GEN-21LIT',1,0,NULL,'Minor'),(16,'Filipino sa Piling Larangan','GEN-FILPL',1,0,NULL,'Minor'),(17,'Practical Research 1','GEN-PRAC1',1,0,NULL,'Minor'),(18,'Structured Query Language','ICT-SQL',1,0,NULL,'Major'),(19,'omputer Programming (.Net Technology)  3','ICT-CPN3',1,0,NULL,'Major'),(20,'Computer Programming (Java)  3','ICT-CPJ3',1,0,NULL,'Major'),(21,'Media and Information','GEN-MAL',1,0,NULL,'Minor'),(22,'Creative Writing','HS-CTWR',1,0,NULL,'Major'),(23,'Philippines Politics and Governance','HS-PPAG',1,0,NULL,'Major'),(24,'Disciplines and Ideas in  in the Applied Social Sciences','HS-DISS',1,0,NULL,'Major'),(25,'Maintain Handtools, Equipment and Paraphernalia','ANIM-MHEP',1,0,NULL,'Major'),(26,'Perform Mensuration and Calc.','ANIM-PMSC',1,0,NULL,'Major'),(27,'Prepare and Interpret Technical Drawing','ANIM-PITD',1,0,NULL,'Major'),(28,'Fundamentals of  Acctg  Business and Mgmt. 1','ABM-FABM',1,0,NULL,'Major'),(29,'Business Marketing','ABM-BUMA',1,0,NULL,'Major'),(30,'Business Finance','ABM-BUFI',1,0,NULL,'Major'),(31,'General Pyshics 1','STM-GENPHY1',1,0,NULL,'Major'),(32,'General Biology 1','STM-GENBIO1',1,0,NULL,'Major'),(33,'Reading and Writing','GEN-REWRI',1,0,NULL,'Minor'),(34,'Pagbasa at Pagsusuri ng Iba\'t Ibang Teksto Tungo sa Pananaliksik','GEN-FILPPIT',1,0,NULL,'Minor'),(35,'Statistics and Probability','GEN-MSTATPR',1,0,NULL,'Minor'),(36,'Physical Education and Health G11  2','GEN-2SPE11',1,0,NULL,'Minor'),(37,'Physical Education and Health G12 1','GEN-12PE1',1,0,NULL,'Minor'),(38,'Physical Education and Health G12 2','Gen-12PE2',1,0,NULL,'Minor'),(39,'Practical Research 2','GEN-PRAC2',1,0,NULL,'Minor'),(40,'Computer Programming (.Net Technology) 2','ICT-CPN2',1,0,NULL,'Major'),(41,'Computer Programming (Java) 2','CT-CPJ2',1,0,NULL,'Major'),(42,'Computer Programming (.Net Technology) 3','ICT-CPN3',1,0,NULL,'Major'),(43,'Computer Programming (Java) 4','ICT-CPJ4',1,0,NULL,'Major'),(44,'Disaster Readiness and Risk Reduction','STM-DIRR',1,0,NULL,'Major'),(45,'Basic Calculus','STM-BASC',1,0,NULL,'Major'),(46,'General Chemistry 1','STM-GENCHEM1',1,0,NULL,'Major'),(47,'Organization and Mgmt','ABM-ORGM',1,0,NULL,'Major'),(48,'Fundamentals of  Acctg  Business and Mgmt. 2','ABM-FABM2',1,0,NULL,'Major'),(49,'Personal Entrepreneurial Competencies','ANIM-PERC',1,0,NULL,'Major'),(50,'Environment and Market','ANIM-ENMA',1,0,NULL,'Major'),(51,'Use Handtools and Equipments','ANIM-USE',1,0,NULL,'Major'),(52,'Introduction to World Religions and Belief Systems','HS-IWRB',1,0,NULL,'Major'),(53,'Entrepreneurship','GEN-ENTREP',1,0,NULL,'Minor'),(54,'Inquiries, Investigations and Immersion','GEN-INQVM',1,0,NULL,'Minor'),(55,'Work Immersion','GEN-OJT',1,0,NULL,'Minor'),(56,'Computer Programming (.Net Technology) 3','ICT-CPN4',1,0,NULL,'Major'),(57,'General Pyshics 2','STM-GENPHY2',1,0,NULL,'Major'),(58,'General Biology 2','STM-GENBIO2',1,0,NULL,'Major'),(59,'General Chemistry 2','STM-GENCHEM2',1,0,NULL,'Major'),(60,'Applied Economics','ABM-APPECO',1,0,NULL,'Major'),(61,'Business Ethics and Social Responsibility','ABM-BESR',1,0,NULL,'Major'),(62,'Business Enterprise Simulation','ABM-BESM',1,0,NULL,'Major'),(63,'Practice Occupational Health and Safety Procedure','ANIM-POHSP',1,0,NULL,'Major'),(64,'Providing Cleaned-Up and In-Between Drawings','ANIM-PCUIBD',1,0,NULL,'Major'),(65,'Creative Non Fiction: The Literacy Essay','HS-CNFLE',1,0,NULL,'Major'),(66,'Trends, Networks and Critical Thinking in the 21st Century Culture','HS-TNCT21',1,0,NULL,'Major'),(67,'Community Engagement, Solidarity and Citizenship','HS-CESC',1,0,NULL,'Major'),(68,'Culminating Activities','HS-CUACT',1,0,NULL,'Major'),(69,'Physical Science','GEN-PHYSCI',1,0,NULL,'Minor'),(163,'Business Math','ABM-BUMATH',1,0,NULL,'Major');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
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
