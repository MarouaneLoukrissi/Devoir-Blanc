-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Dec 13, 2024 at 06:49 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `devoirblanc`
--

-- --------------------------------------------------------

--
-- Table structure for table `incident`
--

CREATE TABLE `incident` (
  `reference` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `membre_identifiant` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `incident`
--

INSERT INTO `incident` (`reference`, `time`, `status`, `membre_identifiant`) VALUES
('vhgcvgf', 'cgtfcfg', 'cgffcfd', '2'),
('vhgvh', 'cvghcgfc', 'fcggfxddf', '1'),
('vhjvdz', 'hbdzjhd', 'hvjdzjhdv', '1');

-- --------------------------------------------------------

--
-- Table structure for table `membre`
--

CREATE TABLE `membre` (
  `identifiant` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `membre`
--

INSERT INTO `membre` (`identifiant`, `nom`, `prenom`, `email`, `phone`) VALUES
('1', 'marouane', 'loukrissi', 'marouaneloukrissi10@gmail.com', '0604828756'),
('170e790c-90bf-49e0-acc2-ac2eb5986758', '', '', '', ''),
('2', 'bvbgv', 'ctgfc', 'cfgdxfd', '949861'),
('4ac43458-9979-4052-bccf-b2e76282b7f8', 'nhbhb', 'bhbh', 'bhhbvgv', 'bgv'),
('618baf1c-21d7-4745-b3f2-a2e74136a265', 'nom1', 'penom1', 'email1', 'phone1'),
('75f2339f-bca5-454b-9e83-1980334712aa', 'nhbhb', 'bhbh', 'bhhbvgv', 'bgv'),
('8f09643a-cf49-4a1d-a17b-f91878e76a3d', 'nom1', 'penom1', 'email1', 'phone1'),
('a5c96709-2d1b-4eca-944f-cdb781cf5a83', 'loukrissi', 'asmaa', 'asmaaloukrissi10@gmail.com', '0625369874'),
('ba6fc446-e469-41d5-b2ab-ed51cf7a12fb', 'vhgvghfc', 'tfgcffgxd', 'fgcgfcfdx', 'gfcfxdfdx');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `incident`
--
ALTER TABLE `incident`
  ADD PRIMARY KEY (`reference`),
  ADD KEY `incident_id_fk` (`membre_identifiant`);

--
-- Indexes for table `membre`
--
ALTER TABLE `membre`
  ADD PRIMARY KEY (`identifiant`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `incident`
--
ALTER TABLE `incident`
  ADD CONSTRAINT `incident_id_fk` FOREIGN KEY (`membre_identifiant`) REFERENCES `membre` (`identifiant`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
