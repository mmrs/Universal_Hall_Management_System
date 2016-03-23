-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 23, 2016 at 11:32 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uhms`
--

-- --------------------------------------------------------

--
-- Table structure for table `allocated`
--

CREATE TABLE `allocated` (
  `id` int(11) NOT NULL,
  `room_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `allocated`
--

INSERT INTO `allocated` (`id`, `room_number`) VALUES
(2012331005, 1),
(2012331007, 1),
(2012331021, 1),
(2012331020, 2),
(2013331017, 2),
(2013331023, 2),
(2012331002, 4),
(2013331025, 5),
(2014331014, 5),
(2015331015, 5);

-- --------------------------------------------------------

--
-- Table structure for table `bazar_info`
--

CREATE TABLE `bazar_info` (
  `user_id` int(11) NOT NULL,
  `day_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` int(11) NOT NULL,
  `comment` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bazar_info`
--

INSERT INTO `bazar_info` (`user_id`, `day_time`, `amount`, `comment`) VALUES
(1, '2016-03-23 10:29:14', 2500, 'Mosla,Vim,soyabean  oil');

-- --------------------------------------------------------

--
-- Table structure for table `check_in_out`
--

CREATE TABLE `check_in_out` (
  `id` int(11) NOT NULL,
  `day_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` varchar(5) NOT NULL DEFAULT 'IN'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `check_in_out`
--

INSERT INTO `check_in_out` (`id`, `day_time`, `type`) VALUES
(2012331049, '2016-03-06 09:08:17', 'IN'),
(2012331049, '2016-03-06 09:08:23', 'OUT'),
(2012331049, '2016-03-06 09:08:30', 'IN'),
(2012331049, '2016-03-06 09:25:53', 'OUT'),
(2012331049, '2016-03-06 09:26:02', 'IN'),
(2012331017, '2016-03-07 19:23:11', 'IN');

-- --------------------------------------------------------

--
-- Table structure for table `current_rooms_info`
--

CREATE TABLE `current_rooms_info` (
  `room_number` int(11) NOT NULL,
  `capacity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `current_rooms_info`
--

INSERT INTO `current_rooms_info` (`room_number`, `capacity`) VALUES
(1, 1),
(2, 1),
(3, 4),
(4, 3),
(5, 1),
(6, 4),
(7, 4),
(8, 4),
(9, 4),
(10, 4),
(11, 4),
(12, 4),
(13, 4),
(14, 4),
(15, 4),
(16, 4),
(17, 4),
(18, 4),
(19, 4),
(20, 4),
(21, 4),
(22, 4),
(23, 4),
(24, 4),
(25, 4),
(26, 4),
(27, 4),
(28, 4),
(29, 4),
(30, 4);

-- --------------------------------------------------------

--
-- Table structure for table `gardian_info`
--

CREATE TABLE `gardian_info` (
  `id` int(11) NOT NULL,
  `gardian_name` varchar(60) NOT NULL,
  `gardian_email` varchar(40) DEFAULT NULL,
  `gardian_password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gardian_info`
--

INSERT INTO `gardian_info` (`id`, `gardian_name`, `gardian_email`, `gardian_password`) VALUES
(168, 'M Mahtab Hossain', NULL, 'a'),
(172, 'Md. Majed Ali', NULL, 'a');

-- --------------------------------------------------------

--
-- Table structure for table `hall_info`
--

CREATE TABLE `hall_info` (
  `floor_number` int(11) NOT NULL,
  `room_number` int(11) NOT NULL,
  `capacity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hall_info`
--

INSERT INTO `hall_info` (`floor_number`, `room_number`, `capacity`) VALUES
(1, 1, 4),
(1, 2, 4),
(1, 3, 4),
(1, 4, 4),
(2, 5, 4),
(2, 6, 4),
(2, 7, 4),
(2, 8, 4),
(3, 9, 4),
(3, 10, 4),
(3, 11, 4),
(3, 12, 4),
(2, 13, 4),
(2, 14, 4),
(2, 15, 4),
(2, 16, 4),
(2, 17, 4),
(2, 18, 4),
(2, 19, 4),
(2, 20, 4),
(3, 21, 4),
(3, 22, 4),
(3, 23, 4),
(3, 24, 4),
(3, 25, 4),
(3, 26, 4),
(3, 27, 4),
(3, 28, 4),
(3, 29, 4),
(3, 30, 4);

-- --------------------------------------------------------

--
-- Table structure for table `meal_due_table`
--

CREATE TABLE `meal_due_table` (
  `id` int(11) NOT NULL,
  `total_meal` int(11) NOT NULL,
  `year_month` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total_due` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meal_due_table`
--

INSERT INTO `meal_due_table` (`id`, `total_meal`, `year_month`, `total_due`) VALUES
(2012331007, 2, '2016-02-29 18:00:00', 60),
(2012331009, 2, '2016-02-29 18:00:00', 60),
(2012331011, 5, '2016-02-29 18:00:00', 150),
(2012331013, 1, '2016-02-29 18:00:00', 30),
(2012331015, 1, '2016-02-29 18:00:00', 30),
(2012331017, 21, '2016-02-29 18:00:00', 630),
(2012331020, 1, '2016-02-29 18:00:00', 30),
(2012331029, 2, '2016-02-29 18:00:00', 60),
(2012331034, 2, '2016-02-29 18:00:00', 60),
(2012331049, 15, '2016-02-29 18:00:00', 450),
(2012331055, 1, '2016-02-29 18:00:00', 30),
(2012331074, 3, '2016-02-29 18:00:00', 90),
(2013331017, 2, '2016-02-29 18:00:00', 60),
(2013331023, 2, '2016-02-29 18:00:00', 60);

-- --------------------------------------------------------

--
-- Table structure for table `meal_log`
--

CREATE TABLE `meal_log` (
  `id` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `day_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meal_log`
--

INSERT INTO `meal_log` (`id`, `type`, `quantity`, `day_time`) VALUES
(2012331049, 'BREAKFAST', 1, '2016-03-06 22:17:43'),
(2012331049, 'BREAKFAST', 1, '2016-03-06 22:18:15'),
(2012331049, 'BREAKFAST', 1, '2016-03-06 22:18:48'),
(2012331049, 'BREAKFAST', 8, '2016-03-06 22:18:55'),
(2012331055, 'BREAKFAST', 1, '2016-03-06 22:20:39'),
(2012331034, 'DINNER', 2, '2016-03-06 22:45:54'),
(2012331011, 'LUNCH', 5, '2016-03-06 17:09:23'),
(2012331049, 'DINNER', 1, '2016-03-07 06:16:16'),
(2012331049, 'DINNER', 1, '2016-03-07 07:52:22'),
(2012331049, 'LUNCH', 1, '2016-03-07 07:55:36'),
(2012331029, 'DINNER', 2, '2016-03-07 08:00:42'),
(2012331015, 'LUNCH', 1, '2016-03-07 10:05:07'),
(2012331074, 'LUNCH', 2, '2016-03-07 10:28:17'),
(2012331074, 'BREAKFAST', 1, '2016-03-07 10:29:23'),
(2012331009, 'DINNER', 2, '2016-03-07 10:30:58'),
(2012331049, 'BREAKFAST', 1, '2016-03-07 19:22:22'),
(2012331007, 'LUNCH', 2, '2016-03-08 16:12:54'),
(2012331017, 'BREAKFAST', 10, '2016-03-20 04:58:20'),
(2012331017, 'LUNCH', 6, '2016-03-20 04:58:28'),
(2012331017, 'BREAKFAST', 5, '2016-03-20 04:58:46'),
(2013331017, 'LUNCH', 2, '2016-03-22 11:53:55'),
(2013331023, 'LUNCH', 2, '2016-03-22 12:16:15'),
(2012331013, 'BREAKFAST', 1, '2016-03-22 19:01:51'),
(2012331020, 'LUNCH', 1, '2016-03-22 19:01:51');

-- --------------------------------------------------------

--
-- Table structure for table `meal_rate`
--

CREATE TABLE `meal_rate` (
  `year_month` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rate` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meal_rate`
--

INSERT INTO `meal_rate` (`year_month`, `rate`) VALUES
('2016-02-29 18:00:00', 30),
('2016-03-31 18:00:00', 55),
('2016-04-30 18:00:00', 50);

-- --------------------------------------------------------

--
-- Table structure for table `student_gardian_relation`
--

CREATE TABLE `student_gardian_relation` (
  `student_id` int(11) NOT NULL,
  `gardian_id` int(11) NOT NULL,
  `relation` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_gardian_relation`
--

INSERT INTO `student_gardian_relation` (`student_id`, `gardian_id`, `relation`) VALUES
(2012331002, 168, 'UNCLE'),
(2012331017, 168, 'FATHER'),
(2012331027, 172, 'UNCLE'),
(2012331049, 172, 'FATHER'),
(2013331017, 172, 'UNCLE');

-- --------------------------------------------------------

--
-- Table structure for table `student_info`
--

CREATE TABLE `student_info` (
  `id` int(11) NOT NULL,
  `student_name` varchar(60) NOT NULL,
  `student_dept` varchar(10) NOT NULL,
  `student_session` int(15) NOT NULL,
  `student_phone` varchar(15) NOT NULL,
  `student_email` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`id`, `student_name`, `student_dept`, `student_session`, `student_phone`, `student_email`) VALUES
(2012331002, 'Md. Udoy', 'CSE', 2012, '01717', 'udoy@gmail.com'),
(2012331005, 'Farzad Bin Fazle', 'CSE', 2012, '01682655816', 'farzad@gmail.com'),
(2012331007, 'Md. Tanveer Islam', 'EEE', 2012, '01717749951', 'tanveer@sust.com'),
(2012331013, 'Bishwajit Purkayastha', 'CSE', 2012, '01939918278', 'bishwa@sust.edu'),
(2012331017, 'M. Tahmid Hossain', 'CSE', 2012, '01682052337', 'th@gmail.com'),
(2012331019, 'Sudipto Chandra Das', 'CSE', 2012, '01759686204', 'dipu@sust.edu'),
(2012331020, 'Raihan Ahmed', 'CEE', 2012, '01740910749', 'raihan@sust.edu'),
(2012331021, 'Md. Shahed Mamon', 'EEE', 2012, '01767529965', 'shahed@gmail.com'),
(2012331027, 'Md. kazi nayeem', 'CSE', 2012, '01755', 'nayeem@gmail.com'),
(2012331049, 'Md. Moshiur Rahman', 'CSE', 2012, '01521428358', 'moshiur.siyam@gmail.com'),
(2013331017, 'Arnov', 'CSE', 2013, '017155', 'arnov@gmail.com'),
(2013331023, 'Mehedi Al Hasan Mehedi ', 'EEE', 2013, '01912712138', 'al@sust.edu'),
(2013331025, 'Md. Sharif Siddique Sharif ', 'CEE', 2014, '01677576804', 'sharif@sust.edu'),
(2014331014, 'Summit Haque', 'CSE', 2014, '01677311158', 'summit@sust.edu'),
(2015331015, 'Monsadur Rahman', 'ME', 2015, '01937012488', 'rahman@sust.edu');

-- --------------------------------------------------------

--
-- Table structure for table `student_status`
--

CREATE TABLE `student_status` (
  `id` int(11) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'current'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_status`
--

INSERT INTO `student_status` (`id`, `status`) VALUES
(2012331002, 'current'),
(2012331005, 'current'),
(2012331007, 'current'),
(2012331013, 'current'),
(2012331017, 'current'),
(2012331019, 'current'),
(2012331020, 'current'),
(2012331021, 'current'),
(2012331027, 'current'),
(2012331049, 'passed'),
(2013331017, 'current'),
(2013331023, 'current'),
(2013331025, 'current'),
(2014331014, 'current'),
(2015331015, 'current');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` smallint(6) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `user_type` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `full_name`, `user_name`, `password`, `user_type`) VALUES
(1, 'ADMINISTRATOR', 'admin', 'admin', 1),
(2, 'Tahmid Hossain', 'olee', 'olee', 1),
(3, 'Moshiur Rahman', 'mmrs', 'mmrs', 1),
(4, 'Rahman Miah', 'a', 'a', 2),
(5, 'meal manager shopon', 'b', 'b', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allocated`
--
ALTER TABLE `allocated`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `id_2` (`id`),
  ADD KEY `room_number` (`room_number`);

--
-- Indexes for table `bazar_info`
--
ALTER TABLE `bazar_info`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `check_in_out`
--
ALTER TABLE `check_in_out`
  ADD KEY `id` (`id`);

--
-- Indexes for table `current_rooms_info`
--
ALTER TABLE `current_rooms_info`
  ADD PRIMARY KEY (`room_number`),
  ADD KEY `room_number` (`room_number`),
  ADD KEY `room_number_2` (`room_number`),
  ADD KEY `room_number_3` (`room_number`);

--
-- Indexes for table `gardian_info`
--
ALTER TABLE `gardian_info`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `hall_info`
--
ALTER TABLE `hall_info`
  ADD PRIMARY KEY (`room_number`),
  ADD KEY `room_number` (`room_number`),
  ADD KEY `room_number_2` (`room_number`);

--
-- Indexes for table `meal_due_table`
--
ALTER TABLE `meal_due_table`
  ADD KEY `year_month` (`year_month`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `meal_log`
--
ALTER TABLE `meal_log`
  ADD KEY `id` (`id`),
  ADD KEY `id_2` (`id`),
  ADD KEY `id_3` (`id`);

--
-- Indexes for table `meal_rate`
--
ALTER TABLE `meal_rate`
  ADD PRIMARY KEY (`year_month`),
  ADD KEY `year/month` (`year_month`),
  ADD KEY `year_month` (`year_month`);

--
-- Indexes for table `student_gardian_relation`
--
ALTER TABLE `student_gardian_relation`
  ADD KEY `fk_sgr1` (`student_id`),
  ADD KEY `fk_sgr2` (`gardian_id`);

--
-- Indexes for table `student_info`
--
ALTER TABLE `student_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `student_phone` (`student_phone`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `student_status`
--
ALTER TABLE `student_status`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_name` (`user_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bazar_info`
--
ALTER TABLE `bazar_info`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `hall_info`
--
ALTER TABLE `hall_info`
  MODIFY `room_number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_gardian_relation`
--
ALTER TABLE `student_gardian_relation`
  ADD CONSTRAINT `fk_sgr1` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`id`),
  ADD CONSTRAINT `fk_sgr2` FOREIGN KEY (`gardian_id`) REFERENCES `gardian_info` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
