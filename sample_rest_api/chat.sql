-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 13, 2018 at 06:35 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chat`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_message`
--

CREATE TABLE `tb_message` (
  `message_id` int(6) NOT NULL,
  `message_body` text NOT NULL,
  `message_sender` varchar(20) NOT NULL,
  `message_to` varchar(20) NOT NULL,
  `message_unread` int(1) NOT NULL,
  `message_post_date` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_message`
--

INSERT INTO `tb_message` (`message_id`, `message_body`, `message_sender`, `message_to`, `message_unread`, `message_post_date`) VALUES
(1, 'Ada dimana bro', '1', '2', 1, '2018-08-09 17:00:00.000000'),
(2, 'Ada Dikantor', '2', '1', 1, '2018-08-10 08:12:05.763390'),
(4, 'nga ada dimana ?', '2', '1', 1, '2018-08-10 08:14:51.279489'),
(5, 'kita ada di kantor', '1', '2', 1, '2018-08-10 08:14:56.479262'),
(6, 'Kapan kitorang bakudapa?', '1', '2', 1, '2018-08-10 14:47:43.677220'),
(7, 'ngana suka kapan ?', '2', '1', 1, '2018-08-10 14:48:11.502027'),
(8, 'bagaimana hari minggu bro ?', '2', '1', 1, '2018-08-10 14:48:22.541881'),
(9, 'bro marijo cabut ', '1', '2', 0, '2018-08-10 16:04:12.064330'),
(10, 'bagaimana hari minggu bro ?', '2', '1', 1, '2018-08-10 16:05:25.425505'),
(11, 'bro marijo cabut ', '1', '2', 0, '2018-08-10 16:06:15.152004'),
(12, 'bro marijo cabut ', '1', '2', 0, '2018-08-10 16:09:19.778932'),
(13, 'broo', '1', '2', 0, '2018-08-10 16:10:48.154337'),
(14, 'broo', '1', '2', 0, '2018-08-10 16:16:09.521099'),
(15, 'bagaimana hari minggu bro ?', '2', '1', 1, '2018-08-10 16:16:57.901108'),
(16, 'bagaimana hari minggu bro ?', '2', '1', 1, '2018-08-10 16:20:59.195545'),
(17, 'broo', '1', '2', 0, '2018-08-10 16:21:23.575053'),
(18, 'broo', '1', '2', 0, '2018-08-10 16:21:30.473350'),
(19, 'kk', '1', '2', 0, '2018-08-10 16:22:53.663808');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `user_id` int(4) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`user_id`, `nama`, `email`, `created_at`) VALUES
(1, 'basri umar', 'basriumar12@gmail.com', '2018-08-09 17:00:00.000000'),
(2, 'dayat', 'dayat@dattel.asia', '2018-08-09 17:00:00.000000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_message`
--
ALTER TABLE `tb_message`
  ADD PRIMARY KEY (`message_id`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_message`
--
ALTER TABLE `tb_message`
  MODIFY `message_id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `user_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
