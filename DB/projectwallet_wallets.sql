-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: projectwallet
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `wallets`
--

DROP TABLE IF EXISTS `wallets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wallets` (
  `username` varchar(15) NOT NULL,
  `Wname` varchar(10) NOT NULL,
  `Wdescription` varchar(100) DEFAULT NULL,
  `Wid` int NOT NULL,
  `IBAN` varchar(33) NOT NULL,
  `amount` double NOT NULL,
  `refCurrency` varchar(5) NOT NULL,
  UNIQUE KEY `IBAN` (`IBAN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallets`
--

LOCK TABLES `wallets` WRITE;
/*!40000 ALTER TABLE `wallets` DISABLE KEYS */;
INSERT INTO `wallets` VALUES ('username','wallet1','username1-first wallet',1,'1JUNOSXPWVF40CG0XYFFGR54DSO',0,'EUR'),('username5','Xx','X',5,'26LIMNGVM3Y7B73CC1RO1SUOJJE',0,'EUR'),('username','walletXX','walleDescription',4,'2MHGKZLL4BEODQD3MY8213M1MGE',0,'EUR'),('username2','wallet3','Test 3',3,'6MYWOCBVXQMM26BRYCL06ETZH7U',0,'EUR'),('username2','L','MLL',5,'6UYVI94D593EKF7OEZPM9H8QRPP',0,'EUR'),('username2','wallet1','test01',1,'715OR2IRZFIU9RSSKPUZ8YUOUOA',0,'EUR'),('username2','wallet2','XXX',2,'715OR2IRZFIZ9RSSKPUZ8YUOUOA',0,'EUR'),('username','wallet55','qsfqsgdqqsd',3,'NFQW5RKMR5QVKKB92ZOSFDC4LFS',0,'EUR'),('username5','walletSp','this is a test2',3,'PQ93FM6VNP12OTUYMT24PRFZB1I',0,'ARS'),('username5','x','x',4,'PU6GOHD1SP5IASF4L5YKBEPNNFQ',0,'EUR'),('username','wallet2','2nd wallet-username',2,'R40V6HOFGYNEYXQVR4D3HV2BZXN',0,'EUR'),('username5','wallet1','this is a test',1,'RQAKV924G9I9ZIXYEB0J69MYKPO',0,'EUR'),('username2','X','sqd',4,'VLY6GRK525YCWQXC3T2YEJ4FAJR',0,'EUR');
/*!40000 ALTER TABLE `wallets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-17  9:35:45
