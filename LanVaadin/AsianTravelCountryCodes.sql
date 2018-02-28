CREATE DATABASE  IF NOT EXISTS `asiantravel` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `asiantravel`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: asiantravel
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `countrycodes`
--

DROP TABLE IF EXISTS `countrycodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `countrycodes` (
  `country_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `country_Name` varchar(50) NOT NULL,
  `text_Description` varchar(4000) DEFAULT NULL,
  `html_Description` mediumtext,
  `image` mediumblob,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countrycodes`
--

LOCK TABLES `countrycodes` WRITE;
/*!40000 ALTER TABLE `countrycodes` DISABLE KEYS */;
INSERT INTO `countrycodes` (`country_id`, `country_Name`, `text_Description`, `html_Description`, `image`) VALUES (4,'Laos','Laos is a Southeast Asian country traversed by the Mekong River and known for mountainous terrain, French colonial architecture, hill tribe settlements and Buddhist monasteries.','https://www.google.com/destination?q=laos+travel&rlz=1C1OPRA_enUS559US559&site=search&output=search&dest_mid=/m/0ftp8&dest_mid=/m/07lmr8&dest_mid=/m/043pzmp&dest_mid=/m/01c__w&dest_mid=/m/04hhv&sa=X&ved=0ahUKEwjhn8f84LfZAhXCnOAKHYpXA3sQ7NEBCEgoADAA',''),(6,'France','France, in Western Europe, encompasses medieval cities, alpine villages and Mediterranean beaches. Paris, its capital, is famed for its fashion houses, classical art museums including the Louvre and monuments like the Eiffel Tower','https://www.ricksteves.com/europe/france',''),(7,'Gemany','Germany is a Western European country with a landscape of forests, rivers, mountain ranges and North Sea beaches. It has over 2 millennia of history','http://www.kensingtontours.com/Travel/Tours/Germany?c3api=8443,38294370137,kwd-141898262&iv_=__iv_p_1_a_184009446_g_38294370137_w_kwd-141898262_h_9007472_ii__d_c_n_g_c_181638874965_k_germany%20travel%20guide_m_p_l__t__e__r_1t3_vi__&gclid=Cj0KCQiAzrTUBRCnARIsAL0mqcxDitAzpb5VGEO2Wcu8k48k0swCzxAob7F0r0KkokwR5XZOBdYReqgaAueGEALw_wcB',''),(8,'Viet Name','Vietnam is a Southeast Asian country on the South China Sea known for its beaches, rivers, Buddhist pagodas and bustling cities','http://www.vietnam-guide.com/',''),(9,'China','China is a populous nation in East Asia whose vast landscape encompasses grassland, desert, mountains, lakes, rivers and more than 14,000km of coastline','http://www.chinadiscovery.com/customize-china-tour.html?gclid=Cj0KCQiAzrTUBRCnARIsAL0mqcxeHic5VZykQDDHiZ080ca9xuFMpEDpnYHX7hsqk-D1QPwt_lcSQDkaAoL5EALw_wcB',''),(10,'Cambodia','Cambodia is a Southeast Asian nation whose landscape spans low-lying plains, the Mekong Delta, mountains and Gulf of Thailand coastline','https://www.indochinaodysseytours.com/cambodia.html?gclid=Cj0KCQiAzrTUBRCnARIsAL0mqczo3YITz203L_rZtU6P9_yIIq3fGDNyOcgt30G2S1fqYa3XSMscPUQaAlGNEALw_wcB',''),(11,'Indonesia','Indonesia, a Southeast Asian nation made up of thousands of volcanic islands, is home to hundreds of ethnic groups speaking many different languages. It’s known for beaches, volcanoes, Komodo dragons and jungles sheltering elephants, orangutans and tigers','https://www.gadventures.com/destinations/asia/indonesia/?phonecode=UK_PPC_2&gclid=Cj0KCQiAzrTUBRCnARIsAL0mqcxaTypZslHBUixXirdJwVerAoS4zehmNTmeRpEeDmJ8nhTl_GBn-zUaAhbVEALw_wcB','');
/*!40000 ALTER TABLE `countrycodes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-28 15:20:27
