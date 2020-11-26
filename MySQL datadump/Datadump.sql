-- MySQL dump 10.13  Distrib 8.0.21, for macos10.15 (x86_64)
--
-- Host: localhost    Database: InventoryApp
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `CLIENT`
--

DROP TABLE IF EXISTS `CLIENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLIENT` (
  `Customer_ID` int NOT NULL,
  `LName` varchar(20) NOT NULL,
  `FName` varchar(20) NOT NULL,
  `Type` varchar(1) NOT NULL DEFAULT 'R',
  `PhoneNum` varchar(12) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `PostalCode` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`Customer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENT`
--

LOCK TABLES `CLIENT` WRITE;
/*!40000 ALTER TABLE `CLIENT` DISABLE KEYS */;
INSERT INTO `CLIENT` VALUES (1,'Jones','Jon','R','111111101','111 Allgood- Atlanta- GA','45000'),(2,'Mark','Justin','R','111111102','2342 May- Atlanta- GA','40000'),(3,'Knight','Brad','R','111111103','176 Main St.- Atlanta- GA','44000'),(4,'Zell','Josh','R','222222201','266 McGrady- Milwaukee- WI','56000'),(5,'Vile','Andy','R','222222202','1967 Jordan- Milwaukee- WI','53000'),(6,'Brand','Tom','R','222222203','112 Third St- Milwaukee- WI','62500'),(7,'Vos','Jenny','R','222222204','263 Mayberry- Milwaukee- WI','61000'),(8,'Carter','Chris','R','222222205','565 Jordan- Milwaukee- WI','43000'),(9,'Chase','Jeff','R','333333301','145 Bradbury- Sacramento- CA','44000'),(10,'Smith','John','R','123456789','731 Fondren- Houston- TX','30000'),(11,'English','Joyce','R','453453453','5631 Rice- Houston- TX','25000'),(12,'Narayan','Ramesh','R','666884444','971 Fire Oak- Humble- TX','38000'),(13,'Bays','Bonnie','R','444444401','111 Hollow- Milwaukee- WI','70000'),(14,'Best','Alec','R','444444402','233 Solid- Milwaukee- WI','60000'),(15,'Snedden','Sam','R','444444403','987 Windy St- Milwaukee- WI','48000'),(16,'Ball','Nandita','R','555555501','222 Howard- Sacramento- CA','62000'),(17,'Jarvis','Jill','R','666666601','6234 Lincoln- Chicago- IL','36000'),(18,'King','Kate','R','666666602','1976 Boone Trace- Chicago- IL','44000'),(19,'Leslie','Lyle','R','666666603','417 Hancock Ave- Chicago- IL','41000'),(20,'Small','Gerald','R','666666607','122 Ball Street- Dallas- TX','29000'),(21,'Head','Arnold','C','666666608','233 Spring St- Dallas- TX','33000'),(22,'Pataki','Helga','C','666666609','101 Holyoke St- Dallas- TX','32000'),(23,'King','Billie','C','666666604','556 Washington- Chicago- IL','38000'),(24,'Kramer','Jon','C','666666605','1988 Windy Creek- Seattle- WA','41500'),(25,'King','Ray','C','666666606','213 Delk Road- Seattle- WA','44500'),(26,'Drew','Naveen','C','666666610','198 Elm St- Philadelphia- PA','34000'),(27,'Reedy','Carl','C','666666611','213 Ball St- Philadelphia- PA','32000'),(28,'Hall','Sammy','C','666666612','433 Main Street- Miami- FL','37000'),(29,'Bacher','Red','C','666666613','196 Elm Street- Miami- FL','33500'),(30,'Wong','Franklin','C','333445555','638 Voss- Houston- TX','40000'),(31,'Wallace','Jennifer','C','987654321','291 Berry- Bellaire- TX','43000'),(32,'Jabbar','Ahmad','C','987987987','980 Dallas- Houston- TX','25000'),(33,'Zelaya','Alicia','C','999887777','3321 Castle- Spring- TX','25000'),(34,'James','Jared','C','111111100','123 Peachtree- Atlanta- GA','85000'),(35,'Wallis','Evan','C','222222200','134 Pelham- Milwaukee- WI','92000'),(36,'Grace','Kim','C','333333300','6677 Mills Ave- Sacramento- CA','79000'),(37,'Freed','Alex','C','444444400','4333 Pillsbury- Milwaukee- WI','89000'),(38,'James','John','C','555555500','7676 Bloomington- Sacramento- CA','81000'),(39,'Bender','Bob','C','666666600','8794 Garfield- Chicago- IL','96000'),(40,'Borg','James','C','888665555','450 Stone- Houston- TX','55000'),(500,'Talan','Shanice','C','','','');
/*!40000 ALTER TABLE `CLIENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CREDENTIAL`
--

DROP TABLE IF EXISTS `CREDENTIAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CREDENTIAL` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CREDENTIAL`
--

LOCK TABLES `CREDENTIAL` WRITE;
/*!40000 ALTER TABLE `CREDENTIAL` DISABLE KEYS */;
INSERT INTO `CREDENTIAL` VALUES ('Admin','123');
/*!40000 ALTER TABLE `CREDENTIAL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ELECTRICAL`
--

DROP TABLE IF EXISTS `ELECTRICAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ELECTRICAL` (
  `ToolID` int NOT NULL,
  `PowerType` varchar(2) NOT NULL,
  PRIMARY KEY (`ToolID`),
  KEY `ToolID_idx` (`ToolID`),
  CONSTRAINT `ToolID` FOREIGN KEY (`ToolID`) REFERENCES `TOOL` (`ToolID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ELECTRICAL`
--

LOCK TABLES `ELECTRICAL` WRITE;
/*!40000 ALTER TABLE `ELECTRICAL` DISABLE KEYS */;
INSERT INTO `ELECTRICAL` VALUES (1020,'AC'),(1021,'AC'),(1022,'AC'),(1023,'AC'),(1024,'AC'),(1025,'AC'),(1026,'AC'),(1027,'AC'),(1028,'AC'),(1029,'AC'),(1030,'DC'),(1031,'DC'),(1032,'DC'),(1033,'DC'),(1034,'DC'),(1035,'DC'),(1036,'DC'),(1037,'DC'),(1038,'DC'),(1039,'DC'),(1040,'DC'),(1050,'AC'),(5000,'AC'),(6001,'AC');
/*!40000 ALTER TABLE `ELECTRICAL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INTERNATIONAL`
--

DROP TABLE IF EXISTS `INTERNATIONAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `INTERNATIONAL` (
  `Supplier_ID` int NOT NULL,
  `ImportTax` varchar(20) NOT NULL,
  PRIMARY KEY (`Supplier_ID`),
  CONSTRAINT `Supplier_ID` FOREIGN KEY (`Supplier_ID`) REFERENCES `SUPPLIER` (`SupplierID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INTERNATIONAL`
--

LOCK TABLES `INTERNATIONAL` WRITE;
/*!40000 ALTER TABLE `INTERNATIONAL` DISABLE KEYS */;
INSERT INTO `INTERNATIONAL` VALUES (8010,'6%'),(8011,'6%'),(8012,'6%'),(8013,'6%'),(8014,'6%'),(8015,'6%'),(8016,'6%'),(8017,'10%'),(8018,'10%'),(8019,'10%'),(8020,'10%');
/*!40000 ALTER TABLE `INTERNATIONAL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ORDERLINE`
--

DROP TABLE IF EXISTS `ORDERLINE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ORDERLINE` (
  `Order_ID` int NOT NULL,
  `Tool_ID` int NOT NULL,
  `Sup_ID` int DEFAULT NULL,
  `Quantity` int NOT NULL,
  PRIMARY KEY (`Order_ID`,`Tool_ID`),
  KEY `Sup_ID_idx` (`Sup_ID`),
  KEY `Tool_ID_idx` (`Tool_ID`),
  CONSTRAINT `Order_ID` FOREIGN KEY (`Order_ID`) REFERENCES `ORDERS` (`OrderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Sup_ID` FOREIGN KEY (`Sup_ID`) REFERENCES `SUPPLIER` (`SupplierID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Tool_ID` FOREIGN KEY (`Tool_ID`) REFERENCES `TOOL` (`ToolID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ORDERLINE`
--

LOCK TABLES `ORDERLINE` WRITE;
/*!40000 ALTER TABLE `ORDERLINE` DISABLE KEYS */;
INSERT INTO `ORDERLINE` VALUES (1000,1005,8012,1512),(10000,1001,8004,41),(10000,1002,8001,34),(10000,1003,8020,39),(10000,1004,8003,42),(10000,1005,8012,1523),(10000,1009,8006,38),(10000,1011,8011,16),(10000,1023,8014,37),(10000,5000,8001,15),(10004,6001,8002,40);
/*!40000 ALTER TABLE `ORDERLINE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ORDERS`
--

DROP TABLE IF EXISTS `ORDERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ORDERS` (
  `OrderID` int NOT NULL AUTO_INCREMENT,
  `Order_Date` date NOT NULL,
  PRIMARY KEY (`OrderID`),
  UNIQUE KEY `Order_Date_UNIQUE` (`Order_Date`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ORDERS`
--

LOCK TABLES `ORDERS` WRITE;
/*!40000 ALTER TABLE `ORDERS` DISABLE KEYS */;
INSERT INTO `ORDERS` VALUES (1000,'2020-11-24'),(10000,'2020-11-25'),(10004,'2020-11-26');
/*!40000 ALTER TABLE `ORDERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PURCHASES`
--

DROP TABLE IF EXISTS `PURCHASES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PURCHASES` (
  `Cust_id` int NOT NULL,
  `Tool` int NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`Cust_id`,`Tool`,`Date`),
  KEY `Tool_idx` (`Tool`),
  CONSTRAINT `Cust_id` FOREIGN KEY (`Cust_id`) REFERENCES `CLIENT` (`Customer_ID`) ON DELETE RESTRICT,
  CONSTRAINT `Tool` FOREIGN KEY (`Tool`) REFERENCES `TOOL` (`ToolID`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PURCHASES`
--

LOCK TABLES `PURCHASES` WRITE;
/*!40000 ALTER TABLE `PURCHASES` DISABLE KEYS */;
/*!40000 ALTER TABLE `PURCHASES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SUPPLIER`
--

DROP TABLE IF EXISTS `SUPPLIER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SUPPLIER` (
  `SupplierID` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Type` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `CName` varchar(45) NOT NULL,
  `Phone` varchar(45) NOT NULL,
  PRIMARY KEY (`SupplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SUPPLIER`
--

LOCK TABLES `SUPPLIER` WRITE;
/*!40000 ALTER TABLE `SUPPLIER` DISABLE KEYS */;
INSERT INTO `SUPPLIER` VALUES (8001,'Grommet Builders','L','788 30th St.- SE- Calgary','Fred','123-123-1223'),(8002,'Pong Works','L','749 Dufferin Blvd.- SE- Calgary','Bart','123-123-1223'),(8003,'Wiley Inc.','L','26 40th St.- SE- Calgary','BillyBob','123-123-1223'),(8004,'Winork Manufacturing Inc.','L','156 51st Ave.- SE- Calgary','Marty','123-123-1223'),(8005,'Grab Bag Inc.','L','138 42nd Ave.- NE- Calgary','Monty','123-123-1223'),(8006,'Paddy\'s Manufacturing','L','311 McCall Way- NE- Calgary','Barney','123-123-1223'),(8007,'Smickles Industries','L','966 Smed Lane- SE- Calgary','Lisa','123-123-1223'),(8008,'Thangs Inc.','L','879 37th Ave.- NE- Calgary','Thelma','123-123-1223'),(8009,'Flip Works Inc.','L','472 Ogden Dale Rd.- SE- Calgary','Rory','123-123-1223'),(8010,'Irkle Industries','I','754 Sunridge Way- NE- Calgary','Irma','123-123-1223'),(8011,'Biff Builders','I','690 19th St.- NE- Calgary','Borjn','123-123-1223'),(8012,'Twinkles Inc.','I','318 29th St.-NE- Calgary','Barkley','123-123-1223'),(8013,'Piddles Industries','I','238 112th Ave.- NE- Calgary','Parnell','123-123-1223'),(8014,'Tic Tac Manufacturing','I','598 Palmer Rd.- NE- Calgary','Teisha','123-123-1223'),(8015,'Knock Knock Inc.','I','363 42nd Ave.- NE- Calgary','Ned','123-123-1223'),(8016,'Corky Things Inc.','I','35 McCall Way- NE- Calgary','Corrine','123-123-1223'),(8017,'E & O Industries','I','883 44th St.- SE- Calgary','Stan','123-123-1223'),(8018,'Fiddleys Makes Stuff Inc.','I','350 27th St.- NE- Calgary','Fredda','123-123-1223'),(8019,'Horks and Stuff Manufacturing','I','997 42nd Ave.- NE- Calgary','Harold','123-123-1223'),(8020,'Wings Works','I','754 48th St.- SE- Calgary','Wing','123-123-1223');
/*!40000 ALTER TABLE `SUPPLIER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TOOL`
--

DROP TABLE IF EXISTS `TOOL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TOOL` (
  `ToolID` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Type` varchar(1) NOT NULL,
  `Quantity` int NOT NULL,
  `Price` decimal(18,2) NOT NULL,
  `SupplierID` int NOT NULL,
  PRIMARY KEY (`ToolID`),
  KEY `SupplierID_idx` (`SupplierID`),
  CONSTRAINT `SupplierID` FOREIGN KEY (`SupplierID`) REFERENCES `SUPPLIER` (`SupplierID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TOOL`
--

LOCK TABLES `TOOL` WRITE;
/*!40000 ALTER TABLE `TOOL` DISABLE KEYS */;
INSERT INTO `TOOL` VALUES (1000,'Knock Bits','N',63,12.67,8015),(1001,'Widgets','N',9,35.50,8004),(1002,'Grommets','N',16,23.45,8001),(1003,'Wedges','N',11,10.15,8020),(1004,'Wing Bats','N',8,11.25,8003),(1005,'Twinkies','N',-1473,15.75,8012),(1006,'Wiggles','N',30,12.34,8020),(1007,'Bing Bobs','N',25,2.39,8005),(1008,'Wog Wits','N',298,19.99,8004),(1009,'Barney Bits','N',12,23.59,8006),(1010,'Willie Widgits','N',87,12.99,8003),(1011,'Barge Bogs','N',34,2.99,8011),(1012,'Poggy Pogs','N',99,1.10,8002),(1013,'Pardle Pins','N',400,0.69,8013),(1014,'Piddley Wicks','N',54,5.19,8013),(1015,'Iggy Orks','N',20,49.95,8010),(1016,'Crank Cribs','N',885,0.29,8005),(1017,'Thingies','N',67,45.98,8008),(1018,'Orf Dappers','N',32,19.98,8018),(1019,'Piff Knocks','N',82,4.95,8002),(1020,'Knit Piks','E',66,6.75,8015),(1021,'Piddley Pins','E',370,0.25,8020),(1022,'Tic Tocs','E',87,1.36,8014),(1023,'Tin Wits','E',13,5.67,8014),(1024,'Thinga-ma-bobs','E',40,10.98,8012),(1025,'Fling Flobs','E',254,2.33,8009),(1026,'Barn Bins','E',45,88.67,8006),(1027,'Flap Wrappers','E',89,44.88,8009),(1028,'Pong Pangs','E',2345,0.10,8002),(1029,'Oof Tongs','E',345,8.49,8011),(1030,'Nic Nacs','E',238,2.99,8015),(1031,'Tork Tins','E',376,0.95,8012),(1032,'Lilly Larks','E',56,12.99,8007),(1033,'Minnie Morks','E',800,1.95,8007),(1034,'Cork Handles','E',654,2.66,8016),(1035,'Ding Darns','E',1208,0.15,8019),(1036,'Erk Orks','E',498,3.99,8017),(1037,'Foo Figs','E',234,5.89,8018),(1038,'Googly Eyes','E',756,6.99,8001),(1039,'Handy Pandies','E',321,4.35,8017),(1040,'Inny Outies','E',219,3.45,8010),(1050,'Computer','E',12,12.00,8001),(2010,'flower','N',12,15.00,8003),(5000,'Laptop','E',35,12.00,8001),(6001,'Crazy','E',10,13.00,8002);
/*!40000 ALTER TABLE `TOOL` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `decrease_op` AFTER UPDATE ON `tool` FOR EACH ROW BEGIN
IF new.Quantity < 40 THEN
INSERT IGNORE INTO ORDERS (Order_Date) VALUES(Date(Now()));
INSERT INTO ORDERLINE(Order_ID, Tool_ID, Sup_ID, Quantity) VALUES (
			(SELECT O.OrderID FROM ORDERS AS O WHERE O.Order_Date = DATE(NOW())),
            new.ToolID,new.SupplierID,(50-new.Quantity)) 
            ON DUPLICATE KEY UPDATE ORDERLINE.Quantity = (50-new.Quantity);
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping routines for database 'InventoryApp'
--
/*!50003 DROP PROCEDURE IF EXISTS `add_electrical` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_electrical`(IN id int, IN tname varchar(45), IN qty int, IN price decimal(18,2),IN sup int, IN Ttype varchar(45), IN power varchar(45))
BEGIN
INSERT INTO TOOL
	VALUES (id,tname,Ttype,qty,price,sup);
INSERT INTO ELECTRICAL
	VALUES(id,power);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_tool` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_tool`(IN id int, IN tname varchar(45), IN qty int, IN price decimal(18,2),IN sup int, IN Ttype varchar(45))
BEGIN
INSERT INTO TOOL
	VALUES (id,tname,Ttype,qty,price,sup);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_customer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_customer`(IN Customer_ID int , IN LName varchar(20), IN FName varchar(20), IN Ctype varchar(45), IN PhoneNum varchar(12), IN Address varchar(50), IN PostalCode varchar(7))
BEGIN
INSERT INTO CLIENT
	VALUES (Customer_ID,LName, FName, CType, PhoneNum, Address, PostalCode)
    ON DUPLICATE KEY UPDATE CLIENT.LName = LName, CLIENT.FName = FName, 
									CLIENT.Type = CType,CLIENT.PhoneNum = PhoneNum,
                                    CLIENT.Address = Address, CLIENT.PostalCode = PostalCode;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `decrease_qty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `decrease_qty`(IN id int, IN qty int)
BEGIN
UPDATE TOOL AS T
SET T.Quantity = (T.Quantity - qty)
WHERE T.ToolID = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_customer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_customer`(IN Customer_ID int)
BEGIN
DELETE 
	FROM CLIENT AS C
    WHERE C.Customer_ID = Customer_ID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_tool` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_tool`(IN id int)
BEGIN
DELETE 
	FROM TOOL AS T
    WHERE T.ToolID = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `find_all_tools` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `find_all_tools`()
BEGIN
SELECT T.ToolID,T.Name,T.Type,T.Quantity, T.Price, T.SupplierID,E.PowerType
	FROM TOOL as T
    LEFT JOIN ELECTRICAL AS E
    ON T.ToolID = E.ToolID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `find_orderlines` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `find_orderlines`(IN ordId int)
BEGIN
SELECT O.Order_ID AS Order_ID, T.Name AS Tool, S.Name AS Supplier, O.Quantity AS Quantity
	FROM ORDERLINE AS O
    LEFT JOIN TOOL AS T ON O.Tool_ID = T.ToolID
    LEFT JOIN SUPPLIER AS S ON  T.SupplierID = S.SupplierID
    WHERE O.Order_ID = ordID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `find_orders` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `find_orders`()
BEGIN
SELECT * FROM ORDERS;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_credentials` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_credentials`(IN Username varchar(20), IN Password varchar(45))
BEGIN
SELECT *
	FROM CREDENTIAL AS C
    WHERE C.Username = Username AND C.Password = Password;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_customerID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customerID`(IN id INT)
BEGIN
SELECT * 
	FROM CLIENT AS C
    WHERE C.Customer_ID = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_customerName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customerName`(IN name varchar(20))
BEGIN
SELECT *
	FROM CLIENT AS C
    WHERE C.LName = name;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_customerType` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customerType`(IN type varchar(45))
BEGIN
SELECT *
	FROM CLIENT AS C
    WHERE C.Type = type
    ORDER BY C.LName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `search_toolID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_toolID`(IN id int)
BEGIN
SELECT T.ToolID, T.Name, T.Type,T.Quantity, T.Price, T.SupplierID, E.PowerType
FROM TOOL as T 
LEFT JOIN ELECTRICAL AS E
ON T.ToolID = E.ToolID
WHERE T.ToolID = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `search_toolName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_toolName`(IN name varchar(45))
BEGIN
SELECT T.ToolID, T.Name, T.Type,T.Quantity, T.Price, T.SupplierID, E.PowerType
	FROM TOOL as T
    LEFT JOIN ELECTRICAL AS E
    ON T.ToolID = E.ToolID
    WHERE T.Name = name;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-26 16:39:50
