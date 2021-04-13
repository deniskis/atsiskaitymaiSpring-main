-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 13, 2021 at 02:44 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atsiskaitymai`
--

-- --------------------------------------------------------

--
-- Table structure for table `apmokejimai`
--

CREATE TABLE `apmokejimai` (
  `id` int(10) UNSIGNED NOT NULL,
  `saskaitos_id` int(10) UNSIGNED NOT NULL,
  `suma` decimal(12,2) NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Dumping data for table `apmokejimai`
--

INSERT INTO `apmokejimai` (`id`, `saskaitos_id`, `suma`, `data`) VALUES
(1, 1, '100.00', '2021-04-21'),
(2, 2, '100.00', '2021-04-21'),
(8, 2, '50.00', '2021-04-22');

-- --------------------------------------------------------

--
-- Table structure for table `klientai`
--

CREATE TABLE `klientai` (
  `id` int(10) UNSIGNED NOT NULL,
  `pav` varchar(255) COLLATE utf8_lithuanian_ci NOT NULL,
  `flag_fizinis` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Dumping data for table `klientai`
--

INSERT INTO `klientai` (`id`, `pav`, `flag_fizinis`) VALUES
(1, 'Maxima', 1),
(2, 'Rimi', 0),
(3, 'Lidl', 0),
(4, 'Iki', 0);

-- --------------------------------------------------------

--
-- Table structure for table `saskaitos`
--

CREATE TABLE `saskaitos` (
  `id` int(10) UNSIGNED NOT NULL,
  `data` date NOT NULL,
  `suma` int(11) NOT NULL,
  `klientai_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Dumping data for table `saskaitos`
--

INSERT INTO `saskaitos` (`id`, `data`, `suma`, `klientai_id`) VALUES
(1, '2021-04-21', 100, 3),
(2, '2021-04-21', 200, 3),
(3, '2021-04-21', 200, 3),
(4, '2021-04-21', 400, 3),
(10, '2021-04-14', 500, 1),
(11, '2021-04-14', 700, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `apmokejimai`
--
ALTER TABLE `apmokejimai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `saskaitos_id` (`saskaitos_id`);

--
-- Indexes for table `klientai`
--
ALTER TABLE `klientai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `saskaitos`
--
ALTER TABLE `saskaitos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `klientai_id` (`klientai_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `apmokejimai`
--
ALTER TABLE `apmokejimai`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `klientai`
--
ALTER TABLE `klientai`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `saskaitos`
--
ALTER TABLE `saskaitos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `apmokejimai`
--
ALTER TABLE `apmokejimai`
  ADD CONSTRAINT `apmokejimai_ibfk_2` FOREIGN KEY (`saskaitos_id`) REFERENCES `saskaitos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `saskaitos`
--
ALTER TABLE `saskaitos`
  ADD CONSTRAINT `saskaitos_ibfk_1` FOREIGN KEY (`klientai_id`) REFERENCES `klientai` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
