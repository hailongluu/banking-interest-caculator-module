-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: banking
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `premission` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `idcard` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idcard_UNIQUE` (`idcard`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Lưu Hải Long','Hà Nội','1234567890','0987654321');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interestrate`
--

DROP TABLE IF EXISTS `interestrate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `interestrate` (
  `id` int(11) NOT NULL,
  `date` varchar(45) DEFAULT NULL,
  `0months` varchar(45) DEFAULT NULL,
  `1months` varchar(45) DEFAULT NULL,
  `3months` varchar(45) DEFAULT NULL,
  `6months` varchar(45) DEFAULT NULL,
  `9months` varchar(45) DEFAULT NULL,
  `12months` varchar(45) DEFAULT NULL,
  `18months` varchar(45) DEFAULT NULL,
  `24months` varchar(45) DEFAULT NULL,
  `36months` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interestrate`
--

LOCK TABLES `interestrate` WRITE;
/*!40000 ALTER TABLE `interestrate` DISABLE KEYS */;
INSERT INTO `interestrate` VALUES (1,'2018-03','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(2,'2018-04','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(3,'2018-05','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(4,'2018-06','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(5,'2018-07','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(6,'2018-08','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(7,'2018-09','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(8,'2018-10','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(9,'2018-11','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(10,'2018-12','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(11,'2019-01','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(12,'2019-02','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(13,'2019-03','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1');
/*!40000 ALTER TABLE `interestrate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `savingaccount`
--

DROP TABLE IF EXISTS `savingaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `savingaccount` (
  `id` int(11) NOT NULL,
  `number` varchar(45) NOT NULL,
  `cash` float DEFAULT NULL,
  `interestrate` float DEFAULT NULL,
  `term` int(11) DEFAULT NULL,
  `idcustomer` int(11) DEFAULT NULL,
  `kind` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `iswithdrawned` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer saving account_idx` (`idcustomer`),
  CONSTRAINT `customer saving account` FOREIGN KEY (`idcustomer`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `savingaccount`
--

LOCK TABLES `savingaccount` WRITE;
/*!40000 ALTER TABLE `savingaccount` DISABLE KEYS */;
INSERT INTO `savingaccount` VALUES (1,'HN000001',100000000,8,12,1,'Deposite','2018-03-25',0),(2,'HN000002',100000000,1,0,1,'Deposite','2018-03-25',0),(3,'HN000003',100000000,8.1,36,1,'Deposite','2018-03-25',0),(4,'HN000004',100000000,7.6,6,1,'Deposite','2018-03-25',0);
/*!40000 ALTER TABLE `savingaccount` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-01 22:37:31
