CREATE DATABASE  IF NOT EXISTS `imageannotation` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `imageannotation`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: imageannotation
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `annotation`
--

DROP TABLE IF EXISTS `annotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `annotation` (
  `annotationID` int NOT NULL AUTO_INCREMENT,
  `imageID` int NOT NULL,
  `annotaterID` int NOT NULL,
  `annotationDate` datetime NOT NULL,
  `annotationResult` varchar(15000) NOT NULL,
  `checkerID` int DEFAULT NULL,
  `checkDate` datetime DEFAULT NULL,
  `checkOpinion` varchar(511) DEFAULT NULL,
  `checkResult` int DEFAULT NULL,
  PRIMARY KEY (`annotationID`),
  KEY `imageID_idx` (`imageID`),
  KEY `annotaterID_idx` (`annotaterID`),
  KEY `checkerID_idx` (`checkerID`),
  CONSTRAINT `annotaterID` FOREIGN KEY (`annotaterID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `checkerID` FOREIGN KEY (`checkerID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `imageID` FOREIGN KEY (`imageID`) REFERENCES `image` (`imageID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annotation`
--

LOCK TABLES `annotation` WRITE;
/*!40000 ALTER TABLE `annotation` DISABLE KEYS */;
INSERT INTO `annotation` VALUES (5,10,3,'2023-04-15 18:48:58','{\"1\":{\"newalllText\":[{\"props\":{\"name\":\"text\",\"textId\":\"label-text-id-1681555687051\",\"deleteMarkerId\":\"label-marker-id-1681555687051\"},\"type\":\"TEXT\",\"style\":{\"opacity\":1,\"strokeStyle\":\"#D2691E\",\"background\":true,\"fontColor\":\"#0f0\",\"fillStyle\":\"#F4A460\",\"font\":\"normal 12px Arial\",\"textAlign\":\"left\",\"textBaseline\":\"bottom\",\"globalAlpha\":1},\"textInfo\":{\"text\":\"text\",\"position\":{\"x\":821.9791666666666,\"y\":278.28125},\"offset\":{\"x\":0,\"y\":0}},\"id\":\"label-text-id-1681555687051\"},{\"props\":{\"name\":\"text\"},\"type\":\"TEXT\",\"style\":{\"opacity\":1,\"strokeStyle\":\"#D2691E\",\"background\":true,\"fontColor\":\"#0f0\",\"fillStyle\":\"rgba(42, 83, 231, 1)\",\"font\":\"normal 12px Arial\",\"textAlign\":\"left\",\"textBaseline\":\"bottom\",\"globalAlpha\":1},\"textInfo\":{\"text\":\"缺陷\",\"position\":{\"x\":719.4106602030371,\"y\":612.3743855756882},\"offset\":{\"x\":-10,\"y\":-10}},\"id\":\"label-text-id-1681555720180\"}],\"newallFeatures\":[{\"props\":{\"name\":\"RECT\",\"textId\":\"label-text-id-1681555687051\",\"deleteMarkerId\":\"label-marker-id-1681555687051\"},\"type\":\"RECT\",\"style\":{\"opacity\":1,\"fillStyle\":\"rgba(255, 0, 0, 0)\",\"lineWidth\":1,\"strokeStyle\":\"#00f\"},\"shape\":{\"x\":821.9791666666666,\"y\":278.28125,\"width\":333.3333333333333,\"height\":195.3125},\"id\":\"1681555687051\"},{\"props\":{\"name\":\"POLYGON\",\"textId\":\"label-text-id-1681555720180\",\"deleteMarkerId\":\"label-marker-id-1681555720180\"},\"type\":\"POLYGON\",\"style\":{\"opacity\":1,\"fillStyle\":\"rgba(255, 0, 0, 0)\",\"lineWidth\":2,\"strokeStyle\":\"rgba(52, 231, 29, 1)\"},\"shape\":{\"points\":[{\"x\":710.2477260087372,\"y\":366.829003816517},{\"x\":724.2987989591561,\"y\":586.9052048573608},{\"x\":1129.2708333333333,\"y\":593.3854166666666},{\"x\":749.0625,\"y\":765.2604166666666},{\"x\":533.1674362503292,\"y\":778.897521446918},{\"x\":470.4166666666667,\"y\":582.96875}]},\"id\":\"1681555720180\"}]}}',4,'2023-04-15 18:49:47',NULL,1);
/*!40000 ALTER TABLE `annotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `imageID` int NOT NULL AUTO_INCREMENT,
  `uploaderID` int NOT NULL,
  `description` varchar(511) DEFAULT NULL,
  `path` varchar(511) NOT NULL,
  `uploadDate` datetime NOT NULL,
  `status` int DEFAULT '0',
  PRIMARY KEY (`imageID`),
  KEY `uploaderID_idx` (`uploaderID`),
  CONSTRAINT `uploaderID` FOREIGN KEY (`uploaderID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (10,2,'','/imageDB/e25e0ae6-596e-4fdf-928a-958c915050ca.PNG','2023-04-15 18:47:28',1);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(511) NOT NULL,
  `role` varchar(255) NOT NULL DEFAULT 'user',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','admin'),(2,'pwb','pwb','user'),(3,'lzy','lzy','annotater'),(4,'lhy','lhy','checker'),(6,'qgd','qgd','annotater');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-15 18:56:51
