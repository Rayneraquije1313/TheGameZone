-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: thegamezone
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id_compra` bigint NOT NULL AUTO_INCREMENT,
  `fecha_compra` datetime(6) DEFAULT NULL,
  `usuario` bigint NOT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `FK6cco5rb1mtrxbfxwjccitupyn` (`usuario`),
  CONSTRAINT `FK6cco5rb1mtrxbfxwjccitupyn` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,'2024-06-17 17:48:29.000000',1);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_producto`
--

DROP TABLE IF EXISTS `compra_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra_producto` (
  `id_compra_producto` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `compra` bigint NOT NULL,
  `producto` bigint NOT NULL,
  PRIMARY KEY (`id_compra_producto`),
  KEY `FK2m63285q0x0do2jhoxb6yajvo` (`compra`),
  KEY `FKalo4v22qsfp0dqp1x8nycgpy3` (`producto`),
  CONSTRAINT `FK2m63285q0x0do2jhoxb6yajvo` FOREIGN KEY (`compra`) REFERENCES `compra` (`id_compra`),
  CONSTRAINT `FKalo4v22qsfp0dqp1x8nycgpy3` FOREIGN KEY (`producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_producto`
--

LOCK TABLES `compra_producto` WRITE;
/*!40000 ALTER TABLE `compra_producto` DISABLE KEYS */;
INSERT INTO `compra_producto` VALUES (1,1,1,1);
/*!40000 ALTER TABLE `compra_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funko`
--

DROP TABLE IF EXISTS `funko`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funko` (
  `id_funko` bigint NOT NULL AUTO_INCREMENT,
  `franquicia` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` decimal(38,2) NOT NULL,
  `tamaño` varchar(255) NOT NULL,
  PRIMARY KEY (`id_funko`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funko`
--

LOCK TABLES `funko` WRITE;
/*!40000 ALTER TABLE `funko` DISABLE KEYS */;
INSERT INTO `funko` VALUES (1,'Harry Potter','Funko Pop Harry Potter',10.00,'Mediano'),(2,'Star Wars','Funko Pop Star Wars',12.00,'Grande'),(3,'Marvel','Funko Pop Marvel',8.00,'Pequeño'),(4,'Star Wars','Darth Vader',14.99,'Regular'),(5,'The Simpsons','Homer Simpson',9.99,'Regular'),(6,'Harry Potter','Harry Potter',12.99,'Regular'),(7,'Disney','Mickey Mouse',8.99,'Regular'),(8,'Game of Thrones','Jon Snow',11.99,'Regular'),(9,'DC Comics','Batman',10.99,'Regular'),(10,'Dragon Ball','Goku',13.99,'Regular');
/*!40000 ALTER TABLE `funko` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juego`
--

DROP TABLE IF EXISTS `juego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juego` (
  `id_juego` bigint NOT NULL AUTO_INCREMENT,
  `consola` varchar(255) NOT NULL,
  `desarrolladora` varchar(255) NOT NULL,
  `genero` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` decimal(38,2) NOT NULL,
  PRIMARY KEY (`id_juego`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juego`
--

LOCK TABLES `juego` WRITE;
/*!40000 ALTER TABLE `juego` DISABLE KEYS */;
INSERT INTO `juego` VALUES (1,'PlayStation 4','Naughty Dog','Acción y Aventura','The Last of Us Part II',59.99),(2,'Xbox One','CD Projekt Red','RPG','Cyberpunk 2077',49.99),(3,'Nintendo Switch','Nintendo','Plataforma','Super Mario Odyssey',49.99),(4,'PC','Rockstar Games','Acción y Aventura','Grand Theft Auto V',29.99),(5,'PlayStation 5','Insomniac Games','Acción y Aventura','Spider-Man: Miles Morales',69.99),(6,'Xbox Series X','343 Industries','Shooter','Halo Infinite',59.99),(7,'Nintendo Switch','Square Enix','RPG','The Legend of Zelda: Breath of the Wild',59.99),(8,'PC','CD Projekt Red','RPG','The Witcher 3: Wild Hunt',39.99),(9,'PlayStation 5','Capcom','Survival Horror','Resident Evil Village',59.99),(10,'Xbox Series X','Bethesda Game Studios','RPG','The Elder Scrolls V: Skyrim Special Edition',39.99);
/*!40000 ALTER TABLE `juego` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id_producto` bigint NOT NULL AUTO_INCREMENT,
  `tipo` varchar(255) NOT NULL,
  `funko` bigint DEFAULT NULL,
  `juego` bigint DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `FKhs76nggpe76296wl2l6cp330r` (`funko`),
  KEY `FKn034s3manqas8ulcvksxjq8e4` (`juego`),
  CONSTRAINT `FKhs76nggpe76296wl2l6cp330r` FOREIGN KEY (`funko`) REFERENCES `funko` (`id_funko`),
  CONSTRAINT `FKn034s3manqas8ulcvksxjq8e4` FOREIGN KEY (`juego`) REFERENCES `juego` (`id_juego`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'juego',NULL,3);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sugerencias`
--

DROP TABLE IF EXISTS `sugerencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sugerencias` (
  `id_sugerencias` bigint NOT NULL AUTO_INCREMENT,
  `fecha_sugerencia` datetime(6) DEFAULT NULL,
  `sugerencia` varchar(255) NOT NULL,
  `usuario` bigint NOT NULL,
  PRIMARY KEY (`id_sugerencias`),
  KEY `FKg0gvcv3ekblyv9b1nv0yrnp7n` (`usuario`),
  CONSTRAINT `FKg0gvcv3ekblyv9b1nv0yrnp7n` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sugerencias`
--

LOCK TABLES `sugerencias` WRITE;
/*!40000 ALTER TABLE `sugerencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `sugerencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `edad` int NOT NULL,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Perez','password1',25,'juan.perez@example.com','Juan','juanp'),(2,'Gomez','password2',30,'maria.gomez@example.com','Maria','mariag'),(3,'Martinez','password3',35,'pedro.martinez@example.com','Pedro','pedrom'),(4,'Garcia','password4',28,'laura.garcia@example.com','Laura','laurag'),(5,'Lopez','password5',32,'luis.lopez@example.com','Luis','luisl'),(6,'Hernandez','password6',29,'ana.hernandez@example.com','Ana','anah'),(7,'Sanchez','password7',27,'carlos.sanchez@example.com','Carlos','carloss'),(8,'Torres','password8',24,'sofia.torres@example.com','Sofia','sofiat'),(9,'Ramirez','password9',31,'diego.ramirez@example.com','Diego','diegor'),(10,'Flores','password10',26,'lucia.flores@example.com','Lucia','luciaf');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-19  8:15:32
