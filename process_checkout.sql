-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 07, 2019 at 07:20 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `process_checkout`
--

-- --------------------------------------------------------

--
-- Table structure for table `area`
--

CREATE TABLE `area` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `area`
--

INSERT INTO `area` (`id`, `name`) VALUES
(1, 'Splits'),
(2, 'Gage'),
(3, 'Heat Treat'),
(4, 'Shell'),
(5, 'TestArea'),
(6, 'Another Test'),
(7, 'Just a Test');

-- --------------------------------------------------------

--
-- Table structure for table `process`
--

CREATE TABLE `process` (
  `id` int(11) NOT NULL,
  `id_area` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `process`
--

INSERT INTO `process` (`id`, `id_area`, `name`) VALUES
(21, 1, 'Test'),
(22, 1, 'Test2'),
(23, 2, 'medicion');

-- --------------------------------------------------------

--
-- Table structure for table `processuser`
--

CREATE TABLE `processuser` (
  `id` int(11) NOT NULL,
  `id_area` int(11) NOT NULL,
  `id_process` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `processuser`
--

INSERT INTO `processuser` (`id`, `id_area`, `id_process`, `id_user`) VALUES
(1, 1, 21, 14),
(2, 1, 22, 15),
(3, 1, 22, 16),
(4, 1, 22, 16),
(5, 1, 21, 16),
(6, 1, 21, 16),
(7, 2, 23, 18),
(8, 2, 23, 17);

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(11) NOT NULL,
  `id_process` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `dateRegistered` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date` date NOT NULL,
  `microcell` int(11) NOT NULL,
  `produce` int(11) NOT NULL,
  `estimate` int(11) NOT NULL,
  `scrap` int(11) NOT NULL,
  `diference` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `id_area` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `admin` tinyint(4) NOT NULL,
  `turn` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `id_area`, `name`, `last_name`, `username`, `password`, `admin`, `turn`) VALUES
(8, 0, 'Gabriel', 'Becerra', 'GBECERRA', 'gbecerra', 1, 0),
(14, 1, 'Johnny', 'Cage', 'JCAGE', 'pass', 0, 1),
(15, 1, 'Pedro', 'Gonzalez', 'PGONZALEZ', 'p', 0, 1),
(16, 1, 'Carlos', 'Santana', 'CSANTANA', 'pass', 0, 1),
(17, 2, 'Camila', 'Becerra', 'CBECERRA', 'pass', 0, 2),
(18, 2, 'Jesus', 'Becerra', 'JBECERRA', 's', 0, 1),
(19, 2, 'Guadalupe', 'Trujillo', 'GTRUJILLO', 'p', 0, 1),
(20, 3, 'Fernando', 'Mata', 'FMATA', 'p', 0, 2),
(21, 1, 'Fernando', 'Mata', 'FMATA', 'p', 0, 1),
(22, 1, 'Julio', 'Perez', 'JPEREZ', 'p', 0, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `process`
--
ALTER TABLE `process`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `processuser`
--
ALTER TABLE `processuser`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `area`
--
ALTER TABLE `area`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `process`
--
ALTER TABLE `process`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `processuser`
--
ALTER TABLE `processuser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
