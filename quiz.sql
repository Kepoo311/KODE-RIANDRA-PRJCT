-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 22, 2024 at 08:13 PM
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
-- Database: `quiz`
--

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `ID` int(11) NOT NULL,
  `QuizID` varchar(255) NOT NULL,
  `nomor_soal` int(11) NOT NULL,
  `Question` text NOT NULL,
  `OptionA` text NOT NULL,
  `OptionB` text NOT NULL,
  `OptionC` text NOT NULL,
  `OptionD` text NOT NULL,
  `CorrectAnswer` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`ID`, `QuizID`, `nomor_soal`, `Question`, `OptionA`, `OptionB`, `OptionC`, `OptionD`, `CorrectAnswer`) VALUES
(5, '901', 1, 'Apa ibu kota Indonesia?', 'Surabaya', 'Bandung', 'Jakarta', 'Medan', 'Jakarta'),
(6, '901', 2, 'Siapa penemu lampu?', 'Albert Einstein', 'Nikola Tesla', 'Thomas Edison', 'Alexander Graham Bell', 'Thomas Edison'),
(7, '901', 3, 'Siapa penulis novel \"Laskar Pelangi\"?', 'Andrea Hirata', 'Dee Lestari', 'Tere Liye', 'Ika Natassa', 'Andrea Hirata'),
(8, '901', 4, 'Berapa banyak hari dalam satu tahun?', '365', '366', '360', '364', '365'),
(9, '901', 5, 'Siapa pencipta lagu \"Indonesia Raya\"?', 'W.R. Supratman', 'Iwan Fals', 'Guruh Soekarnoputra', 'Slamet Riyanto', 'W.R. Supratman'),
(10, '901', 6, 'Apa simbol kimia untuk emas?', 'E', 'Ag', 'Au', 'G', 'Au'),
(11, '901', 7, 'Siapa pelukis \"Mona Lisa\"?', 'Vincent van Gogh', 'Pablo Picasso', 'Leonardo da Vinci', 'Michelangelo', 'Leonardo da Vinci'),
(12, '901', 8, 'Siapa pahlawan yang terkenal dari Jawa Barat?', 'Diponegoro', 'Cut Nyak Dien', 'Tuanku Imam Bonjol', 'Ki Hajar Dewantara', 'Ki Hajar Dewantara'),
(13, '901', 9, 'Apa nama sungai terpanjang di dunia?', 'Sungai Nil', 'Sungai Amazon', 'Sungai Mississippi', 'Sungai Yangtze', 'Sungai Nil'),
(14, '901', 10, 'Siapa ilmuwan yang merumuskan hukum gravitasi?', 'Isaac Newton', 'Albert Einstein', 'Galileo Galilei', 'Stephen Hawking', 'Isaac Newton'),
(15, '901', 11, 'Apa nama planet terdekat dari matahari?', 'Venus', 'Mars', 'Jupiter', 'Mercury', 'Mercury'),
(16, '901', 12, 'Siapa penulis \"Doraemon\"?', 'Osamu Tezuka', 'Leiji Matsumoto', 'Fujiko F. Fujio', 'Hayao Miyazaki', 'Fujiko F. Fujio'),
(17, '901', 13, 'Apa nama ibukota Jepang?', 'Kyoto', 'Osaka', 'Tokyo', 'Hiroshima', 'Tokyo'),
(18, '901', 14, 'Siapa aktor utama dalam film \"Pirates of the Caribbean\"?', 'Johnny Depp', 'Brad Pitt', 'Leonardo DiCaprio', 'Tom Hanks', 'Johnny Depp'),
(19, '901', 15, 'Apa nama patung yang terkenal di Rio de Janeiro?', 'Statue of Liberty', 'Christ the Redeemer', 'Eiffel Tower', 'Big Ben', 'Christ the Redeemer'),
(20, '901', 16, 'Siapa presiden Amerika Serikat yang pertama?', 'Abraham Lincoln', 'George Washington', 'Thomas Jefferson', 'John Adams', 'George Washington'),
(21, '901', 17, 'Apa nama sungai yang melintasi Mesir?', 'Sungai Amazon', 'Sungai Tigris', 'Sungai Euphrates', 'Sungai Nil', 'Sungai Nil'),
(22, '901', 18, 'Siapa penulis \"Harry Potter\"?', 'J.R.R. Tolkien', 'George Orwell', 'J.K. Rowling', 'Charles Dickens', 'J.K. Rowling'),
(23, '901', 19, 'Apa ibukota Perancis?', 'Berlin', 'Roma', 'London', 'Paris', 'Paris'),
(24, '901', 20, 'Siapa ilmuwan yang menemukan radioaktivitas?', 'Marie Curie', 'Albert Einstein', 'Niels Bohr', 'Ernest Rutherford', 'Marie Curie'),
(25, '901', 21, 'Apa nama sungai terpanjang di Eropa?', 'Sungai Thames', 'Sungai Volga', 'Sungai Danube', 'Sungai Seine', 'Sungai Volga');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `absen` int(11) NOT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT 0,
  `nama` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `marks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `absen`, `is_admin`, `nama`, `password`, `marks`) VALUES
(5, 99, 1, 'admin', 'admin', 2),
(6, 76, 0, 'user', 'user', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `absen` (`absen`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
