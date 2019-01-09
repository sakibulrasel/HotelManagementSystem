-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema hotel
--

CREATE DATABASE IF NOT EXISTS hotel;
USE hotel;

--
-- Definition of table `food`
--

DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `idfood` int(10) unsigned NOT NULL auto_increment,
  `foo_id` varchar(45) NOT NULL,
  `f_name` varchar(45) NOT NULL,
  `f_price` double NOT NULL,
  `f_netprice` double NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  `description` longtext NOT NULL,
  `f_url` varchar(200) NOT NULL,
  `discount` double NOT NULL,
  PRIMARY KEY  (`idfood`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food`
--

/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` (`idfood`,`foo_id`,`f_name`,`f_price`,`f_netprice`,`qty`,`description`,`f_url`,`discount`) VALUES 
 (2,'1001','pizza',500,400,5,'sgsdgsdfg','pizza.jpg',100),
 (3,'123','Burger',200,100,8,'aljfodjjisd','burger.jpg',100);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;


--
-- Definition of table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `idreservation` int(10) unsigned NOT NULL auto_increment,
  `Room_No` varchar(45) NOT NULL,
  `Room_Type` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `Sex` varchar(45) NOT NULL,
  `Age` int(10) unsigned NOT NULL,
  `Mobile` varchar(45) NOT NULL,
  `Arrival` date NOT NULL,
  `Departure` date NOT NULL,
  `Charges` double NOT NULL,
  `Advance` double NOT NULL,
  `Days` int(10) unsigned NOT NULL,
  `Total` double NOT NULL,
  `Due` double NOT NULL,
  PRIMARY KEY  (`idreservation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` (`idreservation`,`Room_No`,`Room_Type`,`Name`,`Address`,`City`,`Sex`,`Age`,`Mobile`,`Arrival`,`Departure`,`Charges`,`Advance`,`Days`,`Total`,`Due`) VALUES 
 (1,'101','sfg','sfg','asfd','Dhaka','Male',45,'23454','2018-10-18','2018-10-19',33333,333,6,0,0),
 (4,'102','asdf','asdf','asdf','Dhaka','Male',25,'7454578','2018-10-12','2018-10-19',5000,10000,5,0,0);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;


--
-- Definition of table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `room_no` varchar(45) NOT NULL,
  `book` varchar(45) NOT NULL,
  `room_type` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `r_url` varchar(45) NOT NULL,
  `discount` double NOT NULL,
  `description` longtext NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` (`id`,`room_no`,`book`,`room_type`,`price`,`r_url`,`discount`,`description`) VALUES 
 (1,'103','Unbooked','dASD',4444,'1.PNG',111,'AFDAF'),
 (2,'103','Unbooked','dASD',4444,'1.PNG',111,'AFDAF'),
 (3,'11111','Unbooked','qrrwqr',5000,'pizza.jpg',100,'afasfa');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `iduser` int(10) unsigned NOT NULL auto_increment,
  `uname` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `fullname` varchar(45) NOT NULL,
  `u_email` varchar(45) NOT NULL,
  `u_regDate` date NOT NULL,
  PRIMARY KEY  (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`iduser`,`uname`,`pass`,`role`,`fullname`,`u_email`,`u_regDate`) VALUES 
 (1,'sakibul','1991','Admin','','','0000-00-00'),
 (2,'admin','123','Manager','','','0000-00-00'),
 (3,'rasel','123','Event','','','0000-00-00'),
 (4,'tuhin','1122','Admin','','','0000-00-00'),
 (5,'tuhin','1122','Admin','','','0000-00-00'),
 (6,'akhtar','123','Manager','','','0000-00-00');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
