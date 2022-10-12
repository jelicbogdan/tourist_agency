/*
SQLyog Community
MySQL - 10.4.24-MariaDB : Database - turistickaagencija
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`turistickaagencija` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `turistickaagencija`;

/*Table structure for table `aranzman` */

DROP TABLE IF EXISTS `aranzman`;

CREATE TABLE `aranzman` (
  `sifraAranzmana` int(11) NOT NULL AUTO_INCREMENT,
  `destinacija` varchar(255) NOT NULL,
  `sifraProdavca` int(11) NOT NULL,
  PRIMARY KEY (`sifraAranzmana`),
  KEY `sifraProdavca` (`sifraProdavca`),
  CONSTRAINT `aranzman_ibfk_1` FOREIGN KEY (`sifraProdavca`) REFERENCES `prodavac` (`sifraProdavca`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `aranzman` */

LOCK TABLES `aranzman` WRITE;

insert  into `aranzman`(`sifraAranzmana`,`destinacija`,`sifraProdavca`) values 
(2,'Nis',1),
(3,'Novi Sad',2);

UNLOCK TABLES;

/*Table structure for table `hotel` */

DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `sifraHotela` int(11) NOT NULL AUTO_INCREMENT,
  `nazivHotela` varchar(255) NOT NULL,
  PRIMARY KEY (`sifraHotela`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `hotel` */

LOCK TABLES `hotel` WRITE;

insert  into `hotel`(`sifraHotela`,`nazivHotela`) values 
(1,'Fontana'),
(2,'Srbija'),
(3,'Slavija'),
(4,'Holidej in'),
(5,'Ramada'),
(6,'Paradise');

UNLOCK TABLES;

/*Table structure for table `hotelaranzman` */

DROP TABLE IF EXISTS `hotelaranzman`;

CREATE TABLE `hotelaranzman` (
  `sifraAranzmana` int(11) NOT NULL,
  `sifraHotela` int(11) NOT NULL,
  `datumOd` date NOT NULL,
  `datumDo` date NOT NULL,
  PRIMARY KEY (`sifraAranzmana`,`sifraHotela`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `hotelaranzman` */

LOCK TABLES `hotelaranzman` WRITE;

insert  into `hotelaranzman`(`sifraAranzmana`,`sifraHotela`,`datumOd`,`datumDo`) values 
(2,1,'2022-11-01','2022-11-03'),
(2,2,'2022-11-06','2022-11-10'),
(3,2,'2022-11-22','2022-11-25');

UNLOCK TABLES;

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `sifraKlijenta` int(11) NOT NULL AUTO_INCREMENT,
  `imeKlijenta` varchar(255) NOT NULL,
  `prezimeKlijenta` varchar(255) NOT NULL,
  `brojTelefona` varchar(255) NOT NULL,
  `adresa` varchar(255) NOT NULL,
  `sifraMesta` int(11) NOT NULL,
  PRIMARY KEY (`sifraKlijenta`),
  KEY `sifraMesta` (`sifraMesta`),
  CONSTRAINT `klijent_ibfk_1` FOREIGN KEY (`sifraMesta`) REFERENCES `mesto` (`sifraMesta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `klijent` */

LOCK TABLES `klijent` WRITE;

insert  into `klijent`(`sifraKlijenta`,`imeKlijenta`,`prezimeKlijenta`,`brojTelefona`,`adresa`,`sifraMesta`) values 
(1,'Petar','Peric','0604123654','Ive Ivica',1),
(2,'Goran','Gordic','0614569874','Olje Olic 10',2),
(3,'Ivan','Ivic','0625478963','Mire Miric',3);

UNLOCK TABLES;

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `sifraMesta` int(11) NOT NULL AUTO_INCREMENT,
  `nazivMesta` varchar(255) NOT NULL,
  `postanskiBroj` varchar(255) NOT NULL,
  PRIMARY KEY (`sifraMesta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `mesto` */

LOCK TABLES `mesto` WRITE;

insert  into `mesto`(`sifraMesta`,`nazivMesta`,`postanskiBroj`) values 
(1,'Beograd','011'),
(2,'Novi Sad','021'),
(3,'Nis','018'),
(4,'Zajecar','019');

UNLOCK TABLES;

/*Table structure for table `prodavac` */

DROP TABLE IF EXISTS `prodavac`;

CREATE TABLE `prodavac` (
  `sifraProdavca` int(11) NOT NULL AUTO_INCREMENT,
  `imeProdavca` varchar(255) NOT NULL,
  `prezimeProdavca` varchar(255) NOT NULL,
  `korisnickoIme` varchar(255) NOT NULL,
  `lozinka` varchar(255) NOT NULL,
  PRIMARY KEY (`sifraProdavca`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `prodavac` */

LOCK TABLES `prodavac` WRITE;

insert  into `prodavac`(`sifraProdavca`,`imeProdavca`,`prezimeProdavca`,`korisnickoIme`,`lozinka`) values 
(1,'Miljan','Milic','a','a'),
(2,'Srdjan','Srlic','b','b');

UNLOCK TABLES;

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `sifraRacuna` int(11) NOT NULL AUTO_INCREMENT,
  `datumIzdavanja` date NOT NULL,
  `ukupnaVrednost` double NOT NULL,
  `sifraKlijenta` int(11) NOT NULL,
  `sifraProdavca` int(11) NOT NULL,
  PRIMARY KEY (`sifraRacuna`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `racun` */

LOCK TABLES `racun` WRITE;

insert  into `racun`(`sifraRacuna`,`datumIzdavanja`,`ukupnaVrednost`,`sifraKlijenta`,`sifraProdavca`) values 
(1,'2022-11-08',12000,2,1);

UNLOCK TABLES;

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `redniBroj` int(11) NOT NULL AUTO_INCREMENT,
  `sifraRacuna` int(11) NOT NULL,
  `sifraAranzmana` int(11) NOT NULL,
  `popust` int(11) NOT NULL,
  `iznos` double NOT NULL,
  PRIMARY KEY (`redniBroj`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `stavkaracuna` */

LOCK TABLES `stavkaracuna` WRITE;

insert  into `stavkaracuna`(`redniBroj`,`sifraRacuna`,`sifraAranzmana`,`popust`,`iznos`) values 
(1,1,2,20,5000),
(2,1,3,13,10000);

UNLOCK TABLES;

/*Table structure for table `transport` */

DROP TABLE IF EXISTS `transport`;

CREATE TABLE `transport` (
  `sifraTransporta` int(11) NOT NULL AUTO_INCREMENT,
  `nazivTransporta` varchar(255) NOT NULL,
  PRIMARY KEY (`sifraTransporta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `transport` */

LOCK TABLES `transport` WRITE;

insert  into `transport`(`sifraTransporta`,`nazivTransporta`) values 
(1,'Terra'),
(2,'Sever'),
(3,'Nis'),
(4,'Air');

UNLOCK TABLES;

/*Table structure for table `transportaranzman` */

DROP TABLE IF EXISTS `transportaranzman`;

CREATE TABLE `transportaranzman` (
  `sifraAranzmana` int(11) NOT NULL,
  `sifraTransporta` int(11) NOT NULL,
  `datumPolaska` date NOT NULL,
  `datumOdlaska` date NOT NULL,
  PRIMARY KEY (`sifraAranzmana`,`sifraTransporta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `transportaranzman` */

LOCK TABLES `transportaranzman` WRITE;

insert  into `transportaranzman`(`sifraAranzmana`,`sifraTransporta`,`datumPolaska`,`datumOdlaska`) values 
(2,2,'2022-11-02','2022-11-05'),
(2,3,'2022-11-14','2022-11-19');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
