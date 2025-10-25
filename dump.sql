-- MySQL dump 10.13  Distrib 8.0.43, for Linux (x86_64)
--
-- Host: localhost    Database: regionkommune
-- ------------------------------------------------------
-- Server version	8.0.43-0ubuntu0.24.04.1

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
-- Table structure for table `kommune`
--

DROP TABLE IF EXISTS `kommune`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kommune` (
  `kode` varchar(4) NOT NULL,
  `href` varchar(255) DEFAULT NULL,
  `navn` varchar(255) DEFAULT NULL,
  `region` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`kode`),
  KEY `FKs59qfrpri3ivhfdfe1k8kxh7m` (`region`),
  CONSTRAINT `FKs59qfrpri3ivhfdfe1k8kxh7m` FOREIGN KEY (`region`) REFERENCES `region` (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kommune`
--

LOCK TABLES `kommune` WRITE;
/*!40000 ALTER TABLE `kommune` DISABLE KEYS */;
INSERT INTO `kommune` VALUES ('0101','https://api.dataforsyningen.dk/kommuner/0101','København','1084'),('0147','https://api.dataforsyningen.dk/kommuner/0147','Frederiksberg','1084'),('0151','https://api.dataforsyningen.dk/kommuner/0151','Ballerup','1084'),('0153','https://api.dataforsyningen.dk/kommuner/0153','Brøndby','1084'),('0155','https://api.dataforsyningen.dk/kommuner/0155','Dragør','1084'),('0157','https://api.dataforsyningen.dk/kommuner/0157','Gentofte','1084'),('0159','https://api.dataforsyningen.dk/kommuner/0159','Gladsaxe','1084'),('0161','https://api.dataforsyningen.dk/kommuner/0161','Glostrup','1084'),('0163','https://api.dataforsyningen.dk/kommuner/0163','Herlev','1084'),('0165','https://api.dataforsyningen.dk/kommuner/0165','Albertslund','1084'),('0167','https://api.dataforsyningen.dk/kommuner/0167','Hvidovre','1084'),('0169','https://api.dataforsyningen.dk/kommuner/0169','Høje-Taastrup','1084'),('0173','https://api.dataforsyningen.dk/kommuner/0173','Lyngby-Taarbæk','1084'),('0175','https://api.dataforsyningen.dk/kommuner/0175','Rødovre','1084'),('0183','https://api.dataforsyningen.dk/kommuner/0183','Ishøj','1084'),('0185','https://api.dataforsyningen.dk/kommuner/0185','Tårnby','1084'),('0187','https://api.dataforsyningen.dk/kommuner/0187','Vallensbæk','1084'),('0190','https://api.dataforsyningen.dk/kommuner/0190','Furesø','1084'),('0201','https://api.dataforsyningen.dk/kommuner/0201','Allerød','1084'),('0210','https://api.dataforsyningen.dk/kommuner/0210','Fredensborg','1084'),('0217','https://api.dataforsyningen.dk/kommuner/0217','Helsingør','1084'),('0219','https://api.dataforsyningen.dk/kommuner/0219','Hillerød','1084'),('0223','https://api.dataforsyningen.dk/kommuner/0223','Hørsholm','1084'),('0230','https://api.dataforsyningen.dk/kommuner/0230','Rudersdal','1084'),('0240','https://api.dataforsyningen.dk/kommuner/0240','Egedal','1084'),('0250','https://api.dataforsyningen.dk/kommuner/0250','Frederikssund','1084'),('0253','https://api.dataforsyningen.dk/kommuner/0253','Greve','1085'),('0259','https://api.dataforsyningen.dk/kommuner/0259','Køge','1085'),('0260','https://api.dataforsyningen.dk/kommuner/0260','Halsnæs','1084'),('0265','https://api.dataforsyningen.dk/kommuner/0265','Roskilde','1085'),('0269','https://api.dataforsyningen.dk/kommuner/0269','Solrød','1085'),('0270','https://api.dataforsyningen.dk/kommuner/0270','Gribskov','1084'),('0306','https://api.dataforsyningen.dk/kommuner/0306','Odsherred','1085'),('0316','https://api.dataforsyningen.dk/kommuner/0316','Holbæk','1085'),('0320','https://api.dataforsyningen.dk/kommuner/0320','Faxe','1085'),('0326','https://api.dataforsyningen.dk/kommuner/0326','Kalundborg','1085'),('0329','https://api.dataforsyningen.dk/kommuner/0329','Ringsted','1085'),('0330','https://api.dataforsyningen.dk/kommuner/0330','Slagelse','1085'),('0336','https://api.dataforsyningen.dk/kommuner/0336','Stevns','1085'),('0340','https://api.dataforsyningen.dk/kommuner/0340','Sorø','1085'),('0350','https://api.dataforsyningen.dk/kommuner/0350','Lejre','1085'),('0360','https://api.dataforsyningen.dk/kommuner/0360','Lolland','1085'),('0370','https://api.dataforsyningen.dk/kommuner/0370','Næstved','1085'),('0376','https://api.dataforsyningen.dk/kommuner/0376','Guldborgsund','1085'),('0390','https://api.dataforsyningen.dk/kommuner/0390','Vordingborg','1085'),('0400','https://api.dataforsyningen.dk/kommuner/0400','Bornholm','1084'),('0410','https://api.dataforsyningen.dk/kommuner/0410','Middelfart','1083'),('0411','https://api.dataforsyningen.dk/kommuner/0411','Christiansø','1084'),('0420','https://api.dataforsyningen.dk/kommuner/0420','Assens','1083'),('0430','https://api.dataforsyningen.dk/kommuner/0430','Faaborg-Midtfyn','1083'),('0440','https://api.dataforsyningen.dk/kommuner/0440','Kerteminde','1083'),('0450','https://api.dataforsyningen.dk/kommuner/0450','Nyborg','1083'),('0461','https://api.dataforsyningen.dk/kommuner/0461','Odense','1083'),('0479','https://api.dataforsyningen.dk/kommuner/0479','Svendborg','1083'),('0480','https://api.dataforsyningen.dk/kommuner/0480','Nordfyns','1083'),('0482','https://api.dataforsyningen.dk/kommuner/0482','Langeland','1083'),('0492','https://api.dataforsyningen.dk/kommuner/0492','Ærø','1083'),('0510','https://api.dataforsyningen.dk/kommuner/0510','Haderslev','1083'),('0530','https://api.dataforsyningen.dk/kommuner/0530','Billund','1083'),('0540','https://api.dataforsyningen.dk/kommuner/0540','Sønderborg','1083'),('0550','https://api.dataforsyningen.dk/kommuner/0550','Tønder','1083'),('0561','https://api.dataforsyningen.dk/kommuner/0561','Esbjerg','1083'),('0563','https://api.dataforsyningen.dk/kommuner/0563','Fanø','1083'),('0573','https://api.dataforsyningen.dk/kommuner/0573','Varde','1083'),('0575','https://api.dataforsyningen.dk/kommuner/0575','Vejen','1083'),('0580','https://api.dataforsyningen.dk/kommuner/0580','Aabenraa','1083'),('0607','https://api.dataforsyningen.dk/kommuner/0607','Fredericia','1083'),('0615','https://api.dataforsyningen.dk/kommuner/0615','Horsens','1082'),('0621','https://api.dataforsyningen.dk/kommuner/0621','Kolding','1083'),('0630','https://api.dataforsyningen.dk/kommuner/0630','Vejle','1083'),('0657','https://api.dataforsyningen.dk/kommuner/0657','Herning','1082'),('0661','https://api.dataforsyningen.dk/kommuner/0661','Holstebro','1082'),('0665','https://api.dataforsyningen.dk/kommuner/0665','Lemvig','1082'),('0671','https://api.dataforsyningen.dk/kommuner/0671','Struer','1082'),('0706','https://api.dataforsyningen.dk/kommuner/0706','Syddjurs','1082'),('0707','https://api.dataforsyningen.dk/kommuner/0707','Norddjurs','1082'),('0710','https://api.dataforsyningen.dk/kommuner/0710','Favrskov','1082'),('0727','https://api.dataforsyningen.dk/kommuner/0727','Odder','1082'),('0730','https://api.dataforsyningen.dk/kommuner/0730','Randers','1082'),('0740','https://api.dataforsyningen.dk/kommuner/0740','Silkeborg','1082'),('0741','https://api.dataforsyningen.dk/kommuner/0741','Samsø','1082'),('0746','https://api.dataforsyningen.dk/kommuner/0746','Skanderborg','1082'),('0751','https://api.dataforsyningen.dk/kommuner/0751','Aarhus','1082'),('0756','https://api.dataforsyningen.dk/kommuner/0756','Ikast-Brande','1082'),('0760','https://api.dataforsyningen.dk/kommuner/0760','Ringkøbing-Skjern','1082'),('0766','https://api.dataforsyningen.dk/kommuner/0766','Hedensted','1082'),('0773','https://api.dataforsyningen.dk/kommuner/0773','Morsø','1081'),('0779','https://api.dataforsyningen.dk/kommuner/0779','Skive','1082'),('0787','https://api.dataforsyningen.dk/kommuner/0787','Thisted','1081'),('0791','https://api.dataforsyningen.dk/kommuner/0791','Viborg','1082'),('0810','https://api.dataforsyningen.dk/kommuner/0810','Brønderslev','1081'),('0813','https://api.dataforsyningen.dk/kommuner/0813','Frederikshavn','1081'),('0820','https://api.dataforsyningen.dk/kommuner/0820','Vesthimmerlands','1081'),('0825','https://api.dataforsyningen.dk/kommuner/0825','Læsø','1081'),('0840','https://api.dataforsyningen.dk/kommuner/0840','Rebild','1081'),('0846','https://api.dataforsyningen.dk/kommuner/0846','Mariagerfjord','1081'),('0849','https://api.dataforsyningen.dk/kommuner/0849','Jammerbugt','1081'),('0851','https://api.dataforsyningen.dk/kommuner/0851','Aalborg','1081'),('0860','https://api.dataforsyningen.dk/kommuner/0860','Hjørring','1081');
/*!40000 ALTER TABLE `kommune` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `region` (
  `kode` varchar(4) NOT NULL,
  `href` varchar(255) DEFAULT NULL,
  `navn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES ('1081','https://api.dataforsyningen.dk/regioner/1081','Region Nordjylland'),('1082','https://api.dataforsyningen.dk/regioner/1082','Region Midtjylland'),('1083','https://api.dataforsyningen.dk/regioner/1083','Region Syddanmark'),('1084','https://api.dataforsyningen.dk/regioner/1084','Region Hovedstaden'),('1085','https://api.dataforsyningen.dk/regioner/1085','Region Sjælland');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-05  8:18:29
