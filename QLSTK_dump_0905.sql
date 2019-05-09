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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'admin','c4ca4238a0b923820dcc509a6f75849b',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Nguyễn Văn A','Hà Nội','1234','0987654321'),(2,'ngoc','hd','12345','1234'),(3,'1','fdsasd','1','23456787654321234567876541234'),(4,'4354535','4355534435435','4','3453'),(5,'adasda','ádasdad','7','786876'),(6,'â','a','9','32424342'),(7,'a','a','5','1'),(8,'luu hai long','ha noi','123456','0911111111');
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
INSERT INTO `interestrate` VALUES (1,'2018-03','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(2,'2018-04','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(3,'2018-05','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(4,'2018-06','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(5,'2018-07','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(6,'2018-08','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(7,'2018-09','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(8,'2018-10','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(9,'2018-11','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(10,'2018-12','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(11,'2019-01','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(12,'2019-02','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(13,'2019-03','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(14,'2019-04','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(15,'2019-05','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(16,'2019-06','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(17,'2019-07','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(18,'2019-08','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(19,'2019-09','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(20,'2019-10','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(21,'2019-11','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(22,'2019-12','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(23,'2020-02','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(24,'2020-08','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(25,'2020-10','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(26,'2021-02','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(27,'2021-06','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(28,'2022-02','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(29,'2023-02','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1'),(30,'2024-01','1','5.5','5.5','7.6','7.8','8','8.1','8.1','8.1');
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
INSERT INTO `savingaccount` VALUES (1,'HN000001',100000000,5.5,1,1,'Deposite','2018-03-01',1),(2,'HN000002',100000000,5.5,2,1,'Deposite','2018-03-01',1),(3,'HN000003',100000000,5.5,3,1,'Deposite','2018-03-01',0),(4,'HN000004',100000000,5.5,5,1,'Deposite','2018-03-01',0),(5,'HN000005',100000000,7.6,6,1,'Deposite','2018-03-01',0),(6,'HN000006',100000000,7.6,8,1,'Deposite','2018-03-01',0),(7,'HN000007',100000000,7.8,9,1,'Deposite','2018-03-01',0),(8,'HN000008',100000000,7.8,11,1,'Deposite','2018-03-01',0),(9,'HN000009',100000000,8,12,1,'Deposite','2018-03-01',0),(10,'HN000010',100000000,8,16,1,'Deposite','2018-03-01',0),(11,'HN000011',100000000,8.1,18,1,'Deposite','2018-03-01',0),(12,'HN000012',100000000,8.1,20,1,'Deposite','2018-03-01',0),(13,'HN000013',100000000,8.1,24,1,'Deposite','2018-03-01',0),(14,'HN000014',100000000,8.1,30,1,'Deposite','2018-03-01',0),(15,'HN000015',100000000,8.1,36,1,'Deposite','2018-03-01',0),(16,'HN000016',500000,8.1,300,2,'Deposite','2019-04-16',1),(17,'HN000017',500000,8.1,300,2,'Deposite','2019-04-16',0),(18,'HN000018',500000,8.1,300,2,'Deposite','2019-04-16',0),(19,'HN000019',1.23457e20,5.5,1,2,'Deposite','2019-04-16',0),(20,'HN000020',5553440,8.1,123456,3,'Deposite','2019-04-16',0),(21,'HN000021',34343400000,8.1,123456789,2,'Deposite','2019-04-22',0),(22,'HN000022',34343400000,8.1,123456789,2,'Deposite','2019-04-22',0),(23,'HN000023',11111100,5.5,1,1,'Deposite','2019-04-22',0),(24,'HN000024',11111100,5.5,1,1,'Deposite','2019-04-22',0),(25,'HN000025',1000000,7.6,6,3,'Deposite','2019-05-07',1),(26,'HN000026',4344230,8.1,123,3,'Deposite','2019-05-07',0),(27,'HN000027',1000000,5.5,3,4,'Deposite','2019-05-07',1),(28,'HN000028',1000000,5.5,3,5,'Deposite','2019-05-07',0),(29,'HN000029',6000000,5.5,3,6,'Deposite','2019-05-07',0),(30,'HN000030',6000000,5.5,3,6,'Deposite','2019-05-07',0),(31,'HN000031',500001,5.5,2,7,'Deposite','2019-05-07',0),(32,'HN000032',500001,5.5,2,7,'Deposite','2019-05-07',0),(33,'HN000033',500001,5.5,2,7,'Deposite','2019-05-07',0),(34,'HN000034',123457000,8,12,5,'Deposite','2019-05-07',0),(35,'HN000035',5000000,8,14,5,'Deposite','2019-05-07',0),(36,'HN000036',600001,7.6,6,5,'Deposite','2019-05-07',0),(37,'HN000037',10000000,5.5,3,8,'Deposite','2019-05-09',0);
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

-- Dump completed on 2019-05-09  9:33:30
