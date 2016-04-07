-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2016 at 08:53 AM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.6.14

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
  `room_number` int(11) NOT NULL,
  `day_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `allocated`:
--   `id`
--       `student_info` -> `id`
--   `room_number`
--       `current_rooms_info` -> `room_number`
--

--
-- Dumping data for table `allocated`
--

INSERT INTO `allocated` (`id`, `room_number`, `day_time`) VALUES
(2012331002, 2, '2016-03-27 10:37:38'),
(2012331005, 2, '2016-03-25 08:54:10'),
(2012331007, 1, '2016-03-24 20:28:00'),
(2012331013, 1, '2016-03-27 10:37:38'),
(2012331017, 3, '2016-03-25 08:54:11'),
(2012331019, 3, '2016-03-25 08:54:11'),
(2012331020, 2, '2016-03-24 20:28:00'),
(2012331021, 1, '2016-03-24 20:28:00'),
(2012331027, 1, '2016-03-25 08:54:10'),
(2013331017, 4, '2016-03-24 20:28:00'),
(2013331023, 2, '2016-03-24 20:28:00'),
(2013331025, 4, '2016-03-24 20:28:00'),
(2014331014, 4, '2016-03-24 20:28:00'),
(2015331015, 5, '2016-03-24 20:28:00');

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
-- RELATIONS FOR TABLE `bazar_info`:
--   `user_id`
--       `users` -> `id`
--

--
-- Dumping data for table `bazar_info`
--

INSERT INTO `bazar_info` (`user_id`, `day_time`, `amount`, `comment`) VALUES
(1, '2016-03-25 14:04:21', 1300, 'rice , masala'),
(1, '2016-03-27 03:05:28', 300, 'oil');

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
-- RELATIONS FOR TABLE `check_in_out`:
--   `id`
--       `student_info` -> `id`
--

--
-- Dumping data for table `check_in_out`
--

INSERT INTO `check_in_out` (`id`, `day_time`, `type`) VALUES
(2012331027, '2016-03-25 14:02:58', 'IN'),
(2012331002, '2016-03-25 14:03:48', 'IN'),
(2013331009, '2016-03-25 14:08:11', 'IN'),
(2013331009, '2016-03-25 14:09:35', 'OUT'),
(2014331014, '2016-03-25 14:14:41', 'IN'),
(2012331005, '2016-03-25 14:14:59', 'IN'),
(2012331049, '2016-03-27 03:04:24', 'IN'),
(2012331049, '2016-03-27 03:10:01', 'OUT'),
(2012331005, '2016-03-27 09:37:51', 'OUT'),
(2012331007, '2016-03-27 09:38:11', 'IN'),
(2012331007, '2016-03-27 09:38:16', 'OUT'),
(2012331019, '2016-03-27 09:38:31', 'IN'),
(2012331019, '2016-03-27 09:38:36', 'OUT'),
(2012331019, '2016-03-27 09:38:41', 'IN'),
(2012331019, '2016-03-27 09:38:47', 'OUT'),
(2012331019, '2016-03-27 09:38:59', 'IN'),
(2012331019, '2016-03-27 09:39:03', 'OUT'),
(2012331020, '2016-03-27 09:39:31', 'IN'),
(2012331020, '2016-03-27 09:39:35', 'OUT'),
(2012331020, '2016-03-27 09:39:42', 'IN'),
(2012331017, '2016-03-27 10:40:20', 'IN'),
(2012331017, '2016-03-27 10:40:32', 'OUT'),
(2012331049, '2016-03-30 09:10:29', 'IN'),
(2012331049, '2016-03-30 09:11:13', 'OUT'),
(2012331049, '2016-03-30 09:12:45', 'IN');

-- --------------------------------------------------------

--
-- Table structure for table `current_rooms_info`
--

CREATE TABLE `current_rooms_info` (
  `room_number` int(11) NOT NULL,
  `capacity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `current_rooms_info`:
--   `room_number`
--       `hall_info` -> `room_number`
--

--
-- Dumping data for table `current_rooms_info`
--

INSERT INTO `current_rooms_info` (`room_number`, `capacity`) VALUES
(1, 0),
(2, 0),
(3, 2),
(4, 1),
(5, 3),
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
-- RELATIONS FOR TABLE `gardian_info`:
--

--
-- Dumping data for table `gardian_info`
--

INSERT INTO `gardian_info` (`id`, `gardian_name`, `gardian_email`, `gardian_password`) VALUES
(155, 'Gardian of the galaxy', NULL, 'a'),
(168, 'M Mahtab Hossain', NULL, 'a'),
(172, 'Md. Majed Ali', NULL, 'b'),
(188, 'Gardian ONE', NULL, 'a');

-- --------------------------------------------------------

--
-- Table structure for table `hall_info`
--

CREATE TABLE `hall_info` (
  `floor_number` int(11) NOT NULL,
  `room_number` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `hall_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `hall_info`:
--

--
-- Dumping data for table `hall_info`
--

INSERT INTO `hall_info` (`floor_number`, `room_number`, `capacity`, `hall_id`) VALUES
(1, 1, 4, 0),
(1, 2, 4, 0),
(1, 3, 4, 0),
(1, 4, 4, 0),
(2, 5, 4, 0),
(2, 6, 4, 0),
(2, 7, 4, 0),
(2, 8, 4, 0),
(3, 9, 4, 0),
(3, 10, 4, 0),
(3, 11, 4, 0),
(3, 12, 4, 0),
(2, 13, 4, 0),
(2, 14, 4, 0),
(2, 15, 4, 0),
(2, 16, 4, 0),
(2, 17, 4, 0),
(2, 18, 4, 0),
(2, 19, 4, 0),
(2, 20, 4, 0),
(3, 21, 4, 0),
(3, 22, 4, 0),
(3, 23, 4, 0),
(3, 24, 4, 0),
(3, 25, 4, 0),
(3, 26, 4, 0),
(3, 27, 4, 0),
(3, 28, 4, 0),
(3, 29, 4, 0),
(3, 30, 4, 0);

-- --------------------------------------------------------

--
-- Table structure for table `meal_due_table`
--

CREATE TABLE `meal_due_table` (
  `id` int(11) NOT NULL,
  `total_meal` int(11) NOT NULL,
  `year_month` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total_due` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `meal_due_table`:
--   `id`
--       `student_info` -> `id`
--   `year_month`
--       `meal_rate` -> `year_month`
--

--
-- Dumping data for table `meal_due_table`
--

INSERT INTO `meal_due_table` (`id`, `total_meal`, `year_month`, `total_due`) VALUES
(2012331002, 7, '2016-02-29 18:00:00', 123.0769230769231),
(2012331005, 6, '2016-02-29 18:00:00', 105.4945054945055),
(2012331007, 3, '2016-02-29 18:00:00', 52.74725274725275),
(2012331013, 4, '2016-02-29 18:00:00', 70.32967032967034),
(2012331017, 4, '2016-02-29 18:00:00', 70.32967032967034),
(2012331019, 6, '2016-02-29 18:00:00', 105.4945054945055),
(2012331020, 7, '2016-02-29 18:00:00', 123.0769230769231),
(2012331021, 5, '2016-02-29 18:00:00', 87.91208791208791),
(2012331027, 6, '2016-02-29 18:00:00', 105.4945054945055),
(2012331049, 7, '2016-02-29 18:00:00', 123.0769230769231),
(2013331009, 8, '2016-02-29 18:00:00', 140.65934065934067),
(2013331017, 6, '2016-02-29 18:00:00', 105.4945054945055),
(2013331023, 3, '2016-02-29 18:00:00', 52.74725274725275),
(2013331025, 7, '2016-02-29 18:00:00', 123.0769230769231),
(2014331014, 5, '2016-02-29 18:00:00', 87.91208791208791),
(2015331015, 7, '2016-02-29 18:00:00', 123.0769230769231);

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
-- RELATIONS FOR TABLE `meal_log`:
--   `id`
--       `student_info` -> `id`
--

--
-- Dumping data for table `meal_log`
--

INSERT INTO `meal_log` (`id`, `type`, `quantity`, `day_time`) VALUES
(2012331002, 'LUNCH', 1, '2016-03-25 14:06:40'),
(2012331005, 'DINNER', 1, '2016-03-25 14:06:40'),
(2012331013, 'DINNER', 1, '2016-03-25 14:06:40'),
(2012331017, 'BREAKFAST', 1, '2016-03-25 14:06:40'),
(2012331019, 'BREAKFAST', 1, '2016-03-25 14:06:40'),
(2012331020, 'LUNCH', 1, '2016-03-25 14:06:40'),
(2012331021, 'DINNER', 1, '2016-03-25 14:06:40'),
(2012331027, 'LUNCH', 1, '2016-03-25 14:06:40'),
(2012331049, 'BREAKFAST', 1, '2016-03-25 14:06:40'),
(2013331009, 'LUNCH', 1, '2016-03-25 14:06:40'),
(2013331017, 'BREAKFAST', 1, '2016-03-25 14:06:40'),
(2013331023, 'LUNCH', 1, '2016-03-25 14:06:40'),
(2013331025, 'BREAKFAST', 1, '2016-03-25 14:06:40'),
(2014331014, 'DINNER', 1, '2016-03-25 14:06:40'),
(2015331015, 'LUNCH', 1, '2016-03-25 14:06:40'),
(2013331009, 'LUNCH', 1, '2016-03-25 14:10:13'),
(2013331009, 'BREAKFAST', 2, '2016-03-25 14:10:38'),
(2012331002, 'BREAKFAST', 1, '2016-03-25 14:12:21'),
(2012331005, 'LUNCH', 1, '2016-03-25 14:12:21'),
(2012331005, 'DINNER', 1, '2016-03-25 14:12:21'),
(2012331013, 'BREAKFAST', 1, '2016-03-25 14:12:21'),
(2012331017, 'DINNER', 1, '2016-03-25 14:12:21'),
(2012331019, 'LUNCH', 1, '2016-03-25 14:12:21'),
(2012331020, 'DINNER', 1, '2016-03-25 14:12:21'),
(2012331027, 'BREAKFAST', 1, '2016-03-25 14:12:21'),
(2012331049, 'LUNCH', 1, '2016-03-25 14:12:21'),
(2013331009, 'LUNCH', 1, '2016-03-25 14:12:21'),
(2013331009, 'DINNER', 1, '2016-03-25 14:12:21'),
(2013331017, 'BREAKFAST', 1, '2016-03-25 14:12:21'),
(2014331014, 'LUNCH', 1, '2016-03-25 14:12:21'),
(2015331015, 'BREAKFAST', 1, '2016-03-25 14:12:21'),
(2015331015, 'DINNER', 1, '2016-03-25 14:12:21'),
(2012331002, 'BREAKFAST', 1, '2016-03-25 14:12:42'),
(2012331002, 'LUNCH', 1, '2016-03-25 14:12:42'),
(2012331019, 'DINNER', 1, '2016-03-25 14:12:42'),
(2012331020, 'BREAKFAST', 1, '2016-03-25 14:12:42'),
(2012331021, 'BREAKFAST', 1, '2016-03-25 14:12:42'),
(2012331021, 'DINNER', 1, '2016-03-25 14:12:42'),
(2012331049, 'LUNCH', 1, '2016-03-25 14:12:42'),
(2013331009, 'LUNCH', 1, '2016-03-25 14:12:42'),
(2013331025, 'BREAKFAST', 1, '2016-03-25 14:12:42'),
(2013331025, 'LUNCH', 1, '2016-03-25 14:12:42'),
(2014331014, 'DINNER', 1, '2016-03-25 14:12:42'),
(2012331005, 'BREAKFAST', 1, '2016-03-25 14:12:51'),
(2012331013, 'DINNER', 1, '2016-03-25 14:12:51'),
(2012331019, 'LUNCH', 1, '2016-03-25 14:12:51'),
(2012331020, 'DINNER', 1, '2016-03-25 14:12:51'),
(2012331021, 'LUNCH', 1, '2016-03-25 14:12:51'),
(2012331049, 'DINNER', 1, '2016-03-25 14:12:51'),
(2013331017, 'LUNCH', 1, '2016-03-25 14:12:51'),
(2013331025, 'BREAKFAST', 1, '2016-03-25 14:12:51'),
(2015331015, 'BREAKFAST', 1, '2016-03-25 14:12:51'),
(2015331015, 'DINNER', 1, '2016-03-25 14:12:51'),
(2012331002, 'LUNCH', 1, '2016-03-25 14:13:03'),
(2012331002, 'DINNER', 1, '2016-03-25 14:13:03'),
(2012331005, 'DINNER', 1, '2016-03-25 14:13:03'),
(2012331007, 'BREAKFAST', 1, '2016-03-25 14:13:03'),
(2012331017, 'LUNCH', 1, '2016-03-25 14:13:03'),
(2012331019, 'DINNER', 1, '2016-03-25 14:13:03'),
(2012331020, 'BREAKFAST', 1, '2016-03-25 14:13:03'),
(2012331020, 'LUNCH', 1, '2016-03-25 14:13:03'),
(2012331027, 'DINNER', 1, '2016-03-25 14:13:03'),
(2012331049, 'BREAKFAST', 1, '2016-03-25 14:13:03'),
(2012331049, 'LUNCH', 1, '2016-03-25 14:13:03'),
(2013331017, 'BREAKFAST', 1, '2016-03-25 14:13:03'),
(2013331017, 'DINNER', 1, '2016-03-25 14:13:03'),
(2013331023, 'LUNCH', 1, '2016-03-25 14:13:03'),
(2013331025, 'BREAKFAST', 1, '2016-03-25 14:13:03'),
(2014331014, 'DINNER', 1, '2016-03-25 14:13:03'),
(2015331015, 'LUNCH', 1, '2016-03-25 14:13:03'),
(2012331027, 'LUNCH', 2, '2016-03-27 03:03:34'),
(2012331007, 'LUNCH', 1, '2016-03-27 03:03:44'),
(2013331025, 'LUNCH', 1, '2016-03-27 03:03:44'),
(2012331002, 'DINNER', 1, '2016-03-30 08:47:19'),
(2012331005, 'DINNER', 1, '2016-03-30 08:47:19'),
(2012331007, 'DINNER', 1, '2016-03-30 08:47:19'),
(2012331013, 'DINNER', 1, '2016-03-30 08:47:19'),
(2012331017, 'DINNER', 1, '2016-03-30 08:47:20'),
(2012331019, 'DINNER', 1, '2016-03-30 08:47:20'),
(2012331020, 'DINNER', 1, '2016-03-30 08:47:20'),
(2012331021, 'DINNER', 1, '2016-03-30 08:47:20'),
(2012331027, 'DINNER', 1, '2016-03-30 08:47:20'),
(2012331049, 'DINNER', 1, '2016-03-30 08:47:20'),
(2013331009, 'DINNER', 1, '2016-03-30 08:47:20'),
(2013331017, 'DINNER', 1, '2016-03-30 08:47:20'),
(2013331023, 'DINNER', 1, '2016-03-30 08:47:21'),
(2013331025, 'DINNER', 1, '2016-03-30 08:47:21'),
(2014331014, 'DINNER', 1, '2016-03-30 08:47:21'),
(2015331015, 'DINNER', 1, '2016-03-30 08:47:21');

-- --------------------------------------------------------

--
-- Table structure for table `meal_rate`
--

CREATE TABLE `meal_rate` (
  `year_month` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rate` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `meal_rate`:
--

--
-- Dumping data for table `meal_rate`
--

INSERT INTO `meal_rate` (`year_month`, `rate`) VALUES
('2016-01-31 18:00:00', 0),
('2016-02-29 18:00:00', 17.582417582417584),
('2016-03-31 18:00:00', 0);

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
-- RELATIONS FOR TABLE `student_gardian_relation`:
--   `student_id`
--       `student_info` -> `id`
--   `gardian_id`
--       `gardian_info` -> `id`
--

--
-- Dumping data for table `student_gardian_relation`
--

INSERT INTO `student_gardian_relation` (`student_id`, `gardian_id`, `relation`) VALUES
(2012331002, 155, 'UNCLE'),
(2012331005, 188, 'BROTHER'),
(2012331017, 168, 'FATHER'),
(2012331027, 172, 'UNCLE'),
(2012331049, 172, 'FATHER'),
(2013331009, 155, 'BROTHER'),
(2013331017, 172, 'UNCLE'),
(2014331014, 188, 'BROTHER-IN-LAW');

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
-- RELATIONS FOR TABLE `student_info`:
--

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`id`, `student_name`, `student_dept`, `student_session`, `student_phone`, `student_email`) VALUES
(2012331002, 'Md. Udoy', 'CSE', 2012, '01717', 'udoy@gmail.com'),
(2012331005, 'Farzad Bin Fazle', 'ME', 2012, '01682655816', 'farzad@gmail.com'),
(2012331007, 'Md. Tanveer Islam', 'EEE', 2012, '01717749951', 'tanveer@sust.com'),
(2012331013, 'Bishwajit Purkayastha', 'CSE', 2012, '01939918278', 'bishwa@sust.edu'),
(2012331017, 'M. Tahmid Hossain', 'CSE', 2012, '01682052337', 'th@gmail.com'),
(2012331019, 'Sudipto Chandra Das', 'IPE', 2012, '01759686204', 'dipu@sust.edu'),
(2012331020, 'Raihan Ahmed', 'CEE', 2012, '01740910749', 'raihan@sust.edu'),
(2012331021, 'Md. Shahed Mamon', 'EEE', 2012, '01767529965', 'shahed@gmail.com'),
(2012331027, 'Md. kazi nayeem', 'ARC', 2012, '01755', 'nayeem@gmail.com'),
(2012331049, 'Md. Moshiur Rahman', 'CSE', 2012, '01521428358', 'moshiur.siyam@gmail.com'),
(2013331009, 'Shakhawat Amin', 'ARC', 2012, '2222', NULL),
(2013331017, 'Arnov', 'ME', 2013, '017155', 'arnov@gmail.com'),
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
-- RELATIONS FOR TABLE `student_status`:
--   `id`
--       `student_info` -> `id`
--

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
-- RELATIONS FOR TABLE `users`:
--

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
  ADD KEY `user_id` (`user_id`),
  ADD KEY `user_id_2` (`user_id`);

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
  ADD PRIMARY KEY (`student_id`),
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
