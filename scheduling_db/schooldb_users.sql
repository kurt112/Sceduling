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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('ALDIN-PT','$2a$10$bY1QMvnlJkFvTxXPst.PFexazNceCWHAjgSkjFfGeDBGBwvJjE8HK',1),('ALICE-PT','$2a$10$XJQYeP46K.elUjMoNq2MHOeEpPv8tSXnubd4h9woTpAYbH3YrHiXK',1),('ANGELICA-FT','$2a$10$fHXnNjXhwxveawC2Gf3c2e78bWTf8XSj.CILmC99G5ElttoeSZ1TO',1),('ANGELIKA-FT','$2a$10$sCHMt3bH/ZWg2GWg8CP6guQzQfs31TO8Sh4dmy1/pspHL6STAjjU2',1),('ARMAN-FT','$2a$10$7f8hO7tsBh2yHwsnmzk8EOHEuW5vS8WLTragpoxeiKfCHg4rIGVKa',1),('BIANCA-FT','$2a$10$36fTU4QZPfqGOee759PnTuKjzUg8ctQ43fixYgCvEQk2MK0ZMe6z.',1),('BRIAN-FT','$2a$10$a1FWPK6BRcke.c8MlLiYy.UNTz3WV7Ya2lnGQ7/W7Vq2DG9Dpgime',1),('CARTHY-FT','$2a$10$6HVqHkq7XL1vOWu.zuimfuP7rokyN6bEIIFG5iT8JhJlE3.oGLUdi',1),('DIVINE-FT','$2a$10$PVL.PbYEAEL8gBk.iKb43OwI9Ldv6Tu4DO6yq45dmtwW8e6sS4Fxu',1),('ED-PT','$2a$10$Gkw7NcT5xMwW8FbrLmqJoeNMfANL8SUg0OumnUcGRtkOQnGNE7OUO',1),('EDUARDO-PT','$2a$10$n/xyaC991wWBVtCLpORHEOha.0Y9sEW8QCiXCn7zrPXnx2d9wk3uS',1),('ELLYSA-ST','$2a$10$9ihXOcoqSrKHgbz.e/0ZNerX1IfRf0qgvL.OXpKzdgY9PDSKtcOtm',1),('JAPHET-FT','$2a$10$ZmeniTF9gpTcKKxH9Vmks.c3G8UiXjQ4IuDtX8YkryQ3.4Gh78Aou',1),('JERICK-PT','$2a$10$rAFIl1PlQqxZusy5MMZpuuzoDmgq4LbhRNAoNl5CS1wvCl0Kdnlmu',1),('JESSICA-FT','$2a$10$yBCIcOo6uMOlTxO/94xNcukod02FoORxf31Adp.2/1L8jWgimvjXS',1),('JINO-PT','$2a$10$7qjLQw3zviiKc3G5d/gtEOsiejj6NRhQ.R6VUiCWkomniMpOHgRwi',1),('JODEL-FT','$2a$10$VMylA4yx5ZME5J6b3Oklm.56Cb3HzoHU.NLswZla4zwQQeaKhh6WG',1),('JONATHAN-FT','$2a$10$hecBlJejtg4IonEeDypUC.itg..FUbikFzS8wdGNQNDzZHwqR4m1m',1),('JOSEPH-PT','$2a$10$OKP04UUNK6kfvUnfxZVqh.lDVw2Wz98Qna2nyId5TdcvlRrc8orya',1),('KIMBERLY-FT','$2a$10$vxWYQdUP2QNvNhUskRqaNOfmbJ7R90FXq/T4G0DvpWa89K6W6NnLW',1),('LAICA-FT','$2a$10$JejH0D3xbIA90HNLE.7fZuTlllqVaxUyHKZqudZ7cGd0V6c4smcEC',1),('LANI-FT','$2a$10$gPuPdJmTl3EccyHMrskS9eCZ/hXaS/yZ7po0AXSd7dA6YPaxPHXHa',1),('LESLYN-FT','$2a$10$ChAm06LtqvMMs0/lVvLbDOFpUDCQn.QkUtBFWXiTYQ.kh2eVVpRr2',1),('LYDIA-PT','$2a$10$0sBDNHGzmFe.1JBWYPo0seXs07yedly0gOnmotGIH6.VuXs5c.8iW',1),('MANILYN-FT','$2a$10$r0MBjGi47PADRept2kCSeu/7b4V1fPZRPoPb4mieE/wlDRJR2peaq',1),('MARK-FT','$2a$10$U6O1X6Ouzuo031KnlpsayuDrSOmNJX2fdKxrR65xF5MHxqaOWmM6m',1),('MARYLYN-FT','$2a$10$UF2H27T578qYbILWLhyukeLyc0B/QDliUYbDZs4y20K1pV54.X.Ue',1),('MICHAEL-PT','$2a$10$GfSIFFyloRYz/.6EAg88TemYq3lrTFjKvQ73eDGlfS8ROZRhU3XuG',1),('MIKAELA-FT ','$2a$10$tR60oGTaWMgN0TEJo5jgn.rfO9UTbaMViQt7Sx5.4x8EmYKsxwi4G',1),('RAYBEN-FT','$2a$10$NtTm0B/YlNnS0DFp6knqlOum7KSszLI/2VjpduPCo34Frwp44Hrxy',1),('ROWENA-FT','$2a$10$/FDZdZQannLCY15x/hGhMeNR.cGIUQR1c.HQf.ogPZ5JHwurV/WyO',1),('SAMSON-PT','$2a$10$GWf3JoDE3m4R9B6vaCvmduk2OrkroB6YnX77cHl5G6ZBBoT5Y6bNS',1),('SHIRLEY-FT','$2a$10$VBTQWLNOrHsm75ZUtU9Zr.f2piDWzhwfsx2zOZx5/lgjxhqlmYWva',1),('VERONICA-FT','$2a$10$VLhddAUXFhtaJSVSyBHo6.sQhoUISw60qkV2iBKzE.wx0P6iFL6/C',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
