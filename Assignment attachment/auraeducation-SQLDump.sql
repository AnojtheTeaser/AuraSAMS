-- MySQL dump 10.13  Distrib 8.4.8, for Win64 (x86_64)
--
-- Host: localhost    Database: auraeducation
-- ------------------------------------------------------
-- Server version	8.4.8

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
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `att_id` int NOT NULL AUTO_INCREMENT,
  `sched_id` int NOT NULL,
  `stu_id` int NOT NULL,
  `status` enum('PRESENT','LATE','ABSENT') NOT NULL,
  PRIMARY KEY (`att_id`),
  KEY `fk_attendance_students` (`stu_id`),
  KEY `fk_attendance_schedule` (`sched_id`),
  CONSTRAINT `fk_attendance_schedule` FOREIGN KEY (`sched_id`) REFERENCES `class_schedule` (`sched_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_attendance_students` FOREIGN KEY (`stu_id`) REFERENCES `students` (`stu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (37,14,1,'PRESENT'),(38,14,2,'LATE'),(39,14,3,'PRESENT'),(40,14,6,'PRESENT'),(41,14,14,'PRESENT'),(42,14,16,'PRESENT'),(43,14,18,'PRESENT'),(44,15,1,'PRESENT'),(45,15,2,'PRESENT'),(46,15,3,'PRESENT'),(47,15,6,'PRESENT'),(48,15,14,'PRESENT'),(49,15,16,'PRESENT'),(50,15,18,'PRESENT'),(51,16,1,'PRESENT'),(52,16,2,'PRESENT'),(53,16,3,'PRESENT'),(54,16,6,'PRESENT'),(55,16,14,'PRESENT'),(56,16,16,'PRESENT'),(57,16,18,'PRESENT'),(58,17,1,'PRESENT'),(59,17,2,'PRESENT'),(60,17,3,'PRESENT'),(61,17,6,'PRESENT'),(62,17,14,'PRESENT'),(63,17,16,'PRESENT'),(64,17,18,'ABSENT'),(65,18,1,'PRESENT'),(66,18,2,'PRESENT'),(67,18,3,'PRESENT'),(68,18,6,'PRESENT'),(69,18,14,'PRESENT'),(70,18,16,'ABSENT'),(71,18,18,'ABSENT'),(72,19,4,'PRESENT'),(73,19,5,'PRESENT'),(74,19,7,'PRESENT'),(75,19,9,'PRESENT'),(76,19,11,'PRESENT'),(77,20,4,'PRESENT'),(78,20,5,'PRESENT'),(79,20,7,'PRESENT'),(80,20,9,'PRESENT'),(81,20,11,'PRESENT');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_schedule`
--

DROP TABLE IF EXISTS `class_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_schedule` (
  `sched_id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `sub_id` int NOT NULL,
  `lec_id` int NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  PRIMARY KEY (`sched_id`),
  KEY `fk_class_schedule_course` (`course_id`),
  KEY `fk_class_schedule_subjects` (`sub_id`),
  KEY `fk_class_schedule_lecturer` (`lec_id`),
  CONSTRAINT `fk_class_schedule_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_class_schedule_lecturer` FOREIGN KEY (`lec_id`) REFERENCES `lecturer` (`lec_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_class_schedule_subjects` FOREIGN KEY (`sub_id`) REFERENCES `subjects` (`sub_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_schedule`
--

LOCK TABLES `class_schedule` WRITE;
/*!40000 ALTER TABLE `class_schedule` DISABLE KEYS */;
INSERT INTO `class_schedule` VALUES (14,3,10,8,'2026-07-05','09:00:00'),(15,3,5,8,'2026-07-05','10:00:00'),(16,3,8,9,'2026-07-05','11:00:00'),(17,3,6,8,'2026-07-05','13:00:00'),(18,3,9,10,'2026-07-05','15:00:00'),(19,1,1,1,'2026-07-12','09:00:00'),(20,1,3,3,'2026-07-12','11:00:00'),(21,2,2,2,'2026-07-12','10:00:00'),(22,2,4,4,'2026-07-12','11:00:00'),(23,2,7,9,'2026-07-12','13:00:00'),(25,4,11,7,'2026-07-15','16:00:00'),(26,4,12,6,'2026-07-16','16:00:00'),(27,4,13,6,'2026-07-16','13:00:00'),(28,4,14,5,'2026-07-17','16:00:00');
/*!40000 ALTER TABLE `class_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'BIT'),(2,'HND Computing'),(3,'Software Engineering'),(4,'HR');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_subjects`
--

DROP TABLE IF EXISTS `course_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_subjects` (
  `cst_id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `sub_id` int NOT NULL,
  PRIMARY KEY (`cst_id`),
  KEY `fk_course_subject_course` (`course_id`),
  KEY `fk_course_subject_subject` (`sub_id`),
  CONSTRAINT `fk_course_subject_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_course_subject_subject` FOREIGN KEY (`sub_id`) REFERENCES `subjects` (`sub_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_subjects`
--

LOCK TABLES `course_subjects` WRITE;
/*!40000 ALTER TABLE `course_subjects` DISABLE KEYS */;
INSERT INTO `course_subjects` VALUES (49,1,1),(50,1,3),(51,2,2),(52,2,4),(53,2,7),(54,3,5),(55,3,6),(56,3,8),(57,3,9),(58,3,10),(59,4,11),(60,4,12),(61,4,13),(62,4,14);
/*!40000 ALTER TABLE `course_subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecturer` (
  `lec_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`lec_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecturer`
--

LOCK TABLES `lecturer` WRITE;
/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` VALUES (1,'nimal perera','nimal@gmail','0122222222'),(2,'kamal','kamal@gmail.com','0713333333'),(3,'perera','perera@gamail.com','071222121212'),(4,'wimitha kaleum','wimitha@gamaill.com','07446464646'),(5,'darshana withana','darshana@gmail.com','0767676767'),(6,'kalhara sadun','kalhara@gmail.com','0746464646'),(7,'kulitha nissanka','kulitha@gamil.com','076543232'),(8,'madura rangana','madura@gmail.com','077222243'),(9,'dushen bandara','dushen@gmail.com','077888888'),(10,'nirawan dasanayaka','nirwan@gmail.com','077777667');
/*!40000 ALTER TABLE `lecturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecturer_subjects`
--

DROP TABLE IF EXISTS `lecturer_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecturer_subjects` (
  `lst_id` int NOT NULL AUTO_INCREMENT,
  `lec_id` int NOT NULL,
  `sub_id` int NOT NULL,
  PRIMARY KEY (`lst_id`),
  KEY `fk_lecturer_subject_lecturer` (`lec_id`),
  KEY `fk_lecturer_subject_subjects` (`sub_id`),
  CONSTRAINT `fk_lecturer_subject_lecturer` FOREIGN KEY (`lec_id`) REFERENCES `lecturer` (`lec_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_lecturer_subject_subjects` FOREIGN KEY (`sub_id`) REFERENCES `subjects` (`sub_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecturer_subjects`
--

LOCK TABLES `lecturer_subjects` WRITE;
/*!40000 ALTER TABLE `lecturer_subjects` DISABLE KEYS */;
INSERT INTO `lecturer_subjects` VALUES (27,1,1),(28,2,2),(29,3,3),(30,4,4),(31,5,14),(32,6,13),(33,6,12),(34,7,11),(35,8,5),(36,8,6),(37,8,10),(38,9,7),(39,9,8),(40,10,9);
/*!40000 ALTER TABLE `lecturer_subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `stu_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`stu_id`),
  UNIQUE KEY `email` (`email`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `students_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'kalum rasanga','kalum@gmail.com','0711111989',3),(2,'jayan gunawardana','jayan@gmail.com','0711112222',3),(3,'imesh madushan','imesh@gmail.com','07144444',3),(4,'madushan bandara','madushan@gmail.com','0711111100',1),(5,'sunil jayawickrama ','sunil@amailcom','0711111909',1),(6,'rasith udayanga','rasith@gmail.com','0711111188',3),(7,'nisal alahakon','nisal2gmail.com','0711111109',1),(8,'rajith yatagedra','rajith@gmail.com','0711112222',4),(9,'malith sadun','malith@gmail.com','0711111112',1),(10,'malith dasanayaka','malithda@gmail.com','07134343223',4),(11,'tharindu siriwardana ','tharindu@gmail.com','0713434111',1),(12,'tharindu akash','tharinduakash@gmail.com','0713432321',4),(13,'chamiika karunarathna','chamika@gmail.com','0713454543',2),(14,'namal bandara','namal@gmail.com','0713439987',3),(15,'sumudu deshan','sumudu@gmail.com','0713433456',2),(16,'rangana rusiru','rangana@gmail.com','0713434222',3),(17,'malisha malshan','malisha @gmail.com','0713434777',2),(18,'dilshan maleesha ','dilshan@gmail.com','0713499877',3),(19,'kasun kalhara','kasun@gmail.com','0713676767',2),(20,'dsun sanjaaya','dasun@gmail.com','0713436611',2);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `sub_id` int NOT NULL AUTO_INCREMENT,
  `sub_name` varchar(100) NOT NULL,
  PRIMARY KEY (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'Database Systems'),(2,'Programming Fundamentals'),(3,'Web Development'),(4,'Networking Fundamentals'),(5,'Information Security'),(6,'Object Oriented Programming'),(7,'Data Structures'),(8,'Operating Systems'),(9,'Software Engineering'),(10,'Cloud Computing'),(11,'CoreHR'),(12,'Business & Stratergy'),(13,'Legal & complaince'),(14,'data & Tech');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'LECkamal','12345678'),(2,'ADMpasan','11223344');
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

-- Dump completed on 2026-06-26 12:28:32
