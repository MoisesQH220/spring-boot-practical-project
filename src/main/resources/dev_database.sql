-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: dev_database
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `full_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `document_type` varchar(20) NOT NULL,
  `document_number` varchar(20) NOT NULL,
  `birth_date` datetime DEFAULT NULL,
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `username_create` varchar(30) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `username_update` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `document_number` (`document_number`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Luis Alfonso Sarmiento Urrutia','1','2454697','1997-08-15 23:11:15','2021-09-05 23:11:55',NULL,'2021-09-05 23:13:32',NULL),(2,'Maria Sofía Alvarado Quispe','1','2555691','1991-08-15 23:11:15','2021-09-05 23:11:55',NULL,'2021-09-05 23:13:25',NULL);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mobile_line`
--

DROP TABLE IF EXISTS `mobile_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mobile_line` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `client_id` bigint NOT NULL,
  `cell_phone_number` varchar(30) NOT NULL,
  `status` varchar(20) NOT NULL,
  `type` varchar(30) NOT NULL,
  `plan_name` varchar(20) NOT NULL,
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `username_create` varchar(30) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `username_update` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkey_client_mobile_line` (`client_id`),
  CONSTRAINT `fkey_client_mobile_line` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mobile_line`
--

LOCK TABLES `mobile_line` WRITE;
/*!40000 ALTER TABLE `mobile_line` DISABLE KEYS */;
INSERT INTO `mobile_line` VALUES (1,1,'987112687','Activo','Postpago','Plan S/ 29.90','2021-09-05 23:32:41',NULL,NULL,NULL),(2,2,'985749137','Activo','Prepago','Plan Prepago','2021-09-05 23:32:41',NULL,'2021-09-06 11:24:34',NULL),(3,1,'987118781','Activo','Postpago','Plan S/. 39.90','2021-09-05 23:32:41',NULL,NULL,NULL),(4,1,'992412873','Cancelado','Prepago','Plan Prepago','2021-09-05 23:32:41',NULL,'2021-09-06 11:01:05',NULL),(5,1,'983134561','Activo','Prepago','Plan Prepago','2021-09-05 23:32:41',NULL,'2021-09-06 10:49:27',NULL),(6,1,'924567621','Activo','Prepago','Plan Prepago','2021-09-05 23:32:41',NULL,'2021-09-06 10:49:27',NULL);
/*!40000 ALTER TABLE `mobile_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer`
--

DROP TABLE IF EXISTS `offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `mobile_line_id` bigint NOT NULL,
  `code` varchar(30) NOT NULL,
  `description` varchar(20) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `username_create` varchar(30) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `username_update` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkey_mobile_line_offer` (`mobile_line_id`),
  CONSTRAINT `fkey_mobile_line_offer` FOREIGN KEY (`mobile_line_id`) REFERENCES `mobile_line` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer`
--

LOCK TABLES `offer` WRITE;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` VALUES (1,1,'OF1','Oferta Simple','2021-10-05 23:33:52','2022-02-03 23:33:55','2021-09-05 23:33:51',NULL,'2021-09-06 11:31:10',NULL),(2,2,'OF1','Oferta Simple','2021-09-05 23:33:52','2022-09-05 23:33:55','2021-09-05 23:33:51',NULL,'2021-09-06 01:12:14',NULL),(3,3,'OF2','Oferta Megas','2021-09-05 23:33:52','2021-10-10 23:33:55','2021-09-05 23:33:51',NULL,'2021-09-06 09:55:36',NULL),(4,4,'OF2','Oferta Megas','2021-09-05 23:33:52','2022-01-01 23:33:55','2021-09-05 23:33:51',NULL,'2021-09-06 09:55:42',NULL),(5,5,'OF1','Oferta Simple','2021-09-05 23:33:52','2021-09-12 23:33:55','2021-09-05 23:33:51',NULL,'2021-09-06 09:55:53',NULL),(6,6,'OF1','Oferta Simple','2021-09-05 23:33:52','2021-09-11 23:33:55','2021-09-05 23:33:51',NULL,'2021-09-06 11:03:09',NULL);
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'dev_database'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-06 12:06:17
