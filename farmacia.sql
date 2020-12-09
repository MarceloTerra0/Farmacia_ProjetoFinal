-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: farmacia
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `armazem`
--

DROP TABLE IF EXISTS `armazem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `armazem` (
  `id_farmacia` int NOT NULL,
  `id_produto` int NOT NULL,
  `qtd_produto` int NOT NULL,
  PRIMARY KEY (`id_farmacia`,`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armazem`
--

LOCK TABLES `armazem` WRITE;
/*!40000 ALTER TABLE `armazem` DISABLE KEYS */;
INSERT INTO `armazem` VALUES (1,1,28),(1,2,40),(1,3,98),(1,4,20),(1,5,90),(2,1,12),(2,2,76),(2,3,45),(2,4,13),(2,5,39);
/*!40000 ALTER TABLE `armazem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargos`
--

LOCK TABLES `cargos` WRITE;
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` VALUES (1,'Funcionário'),(2,'Gerente'),(3,'Chefe');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `quantidade_compras` int NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  PRIMARY KEY (`id`,`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Marcelo original',24,'(65) 94269-6969','123.456.789-00'),(2,'Marcelo2',5,'(65) 96969-6262','123.456.789-12'),(3,'marcelo3',0,'(65) 96363-6969','666.555.444-33'),(4,'marcelo marcelo?',0,'(65) 96969-6969','789.456.123-78'),(5,'Marcelo213',0,'(65) 96229-6969','123.321.123-32'),(6,'Marcelinho creu',1,'(65) 96969-6969','456.789.123-45'),(7,'Marcelo malvado',2,'(65) 96666-6666','666.666.666-66');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farmacias`
--

DROP TABLE IF EXISTS `farmacias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farmacias` (
  `id_farmacia` int NOT NULL,
  `dinheiro` decimal(10,2) NOT NULL,
  `nome_farmacia` varchar(45) NOT NULL,
  PRIMARY KEY (`id_farmacia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmacias`
--

LOCK TABLES `farmacias` WRITE;
/*!40000 ALTER TABLE `farmacias` DISABLE KEYS */;
INSERT INTO `farmacias` VALUES (1,12357.67,'Filial 1'),(2,5000.00,'Filial 2');
/*!40000 ALTER TABLE `farmacias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `salario` decimal(7,2) NOT NULL,
  `login` varchar(20) NOT NULL,
  `senha` varchar(128) NOT NULL,
  `id_farmacia` int NOT NULL,
  `comissao` decimal(7,2) NOT NULL,
  `cargo` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'testando',800.00,'teste','b123e9e19d217169b981a61188920f9d28638709a5132201684d792b9264271b7f09157ed4321b1c097f7a4abecfc0977d40a7ee599c845883bd1074ca23c4af',1,0.00,0),(2,'Marcelo',100.00,'teste1','e7932f1b609431aae3e96e6ab99d9ebe383ad19b6e866d434ab12193d1c85b3206d8ec79fb490a1887028c18371d5040f59c854d0a326bc9d230bb950e190c16',1,0.79,1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_vendas`
--

DROP TABLE IF EXISTS `historico_vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico_vendas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_farmacia` int NOT NULL,
  `id_funcionario` int NOT NULL,
  `id_cliente` int NOT NULL,
  `dataVenda` datetime NOT NULL,
  `valor_total` decimal(7,2) NOT NULL,
  `valor_desconto_aplicado` decimal(7,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_vendas`
--

LOCK TABLES `historico_vendas` WRITE;
/*!40000 ALTER TABLE `historico_vendas` DISABLE KEYS */;
INSERT INTO `historico_vendas` VALUES (5,1,1,1,'2020-12-06 02:02:03',827.99,745.19),(6,1,1,1,'2020-12-06 12:36:29',827.99,745.19),(7,1,1,1,'2020-12-06 12:38:21',827.99,745.19),(8,1,1,1,'2020-12-06 12:39:42',800.00,720.00),(9,1,2,2,'2020-12-09 03:20:53',9.00,0.00),(10,1,2,1,'2020-12-09 03:24:40',45.00,40.50),(11,1,2,2,'2020-12-09 04:29:02',9.00,9.00),(12,1,2,2,'2020-12-09 08:00:14',3.00,3.00),(13,1,2,1,'2020-12-09 11:05:39',3.00,2.70),(14,1,2,6,'2020-12-09 17:16:23',53.00,53.00),(15,1,2,2,'2020-12-09 17:23:53',3.00,3.00),(16,1,2,2,'2020-12-09 17:25:45',3.00,3.00),(17,1,2,7,'2020-12-09 18:39:11',5.00,5.00),(18,1,2,7,'2020-12-09 18:41:55',12.00,12.00);
/*!40000 ALTER TABLE `historico_vendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `preco` decimal(9,2) NOT NULL,
  `preco_fornecedor` decimal(9,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Buscopan',3.00,2.50),(2,'Dipirona',5.00,4.00),(3,'Dorflex',6.00,4.50),(4,'Neosaldina',7.00,5.50),(5,'Torsilax',8.00,6.50);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda` (
  `id_venda` int NOT NULL,
  `id_produto_vendido` int NOT NULL,
  `qtd_produto_vendido` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (5,1,5),(5,2,8),(6,1,5),(6,2,8),(7,1,5),(7,2,8),(8,1,5),(8,2,8),(9,1,3),(10,1,5),(10,2,6),(11,1,3),(12,1,1),(13,1,1),(14,2,10),(14,1,1),(15,1,1),(16,1,1),(17,2,1),(18,1,4);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-09 19:01:27
