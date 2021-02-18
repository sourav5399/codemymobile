-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.21 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for codemymobile
CREATE DATABASE IF NOT EXISTS `codemymobile` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `codemymobile`;

-- Dumping structure for table codemymobile.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table codemymobile.hibernate_sequence: ~1 rows (approximately)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(6);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table codemymobile.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL,
  `avatar_uri` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table codemymobile.user: ~5 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `avatar_uri`, `first_name`, `last_name`) VALUES
	(1, 'https://upload.wikimedia.org/wikipedia/en/7/7e/Jim-halpert.jpg', 'Jim', 'Halpert'),
	(2, 'https://upload.wikimedia.org/wikipedia/en/thumb/6/67/Pam_Beesley.jpg/220px-Pam_Beesley.jpg', 'Pam', 'Beesly'),
	(3, 'https://upload.wikimedia.org/wikipedia/en/d/dc/MichaelScott.png', 'Michael', 'Scott'),
	(4, 'https://upload.wikimedia.org/wikipedia/en/c/cd/Dwight_Schrute.jpg', 'Dwight', 'Schrute'),
	(5, 'https://upload.wikimedia.org/wikipedia/en/6/60/Office-1200-baumgartner1.jpg', 'Kevin', 'Malone');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table codemymobile.user_relations
CREATE TABLE IF NOT EXISTS `user_relations` (
  `friend_id` int NOT NULL,
  `requester_id` int NOT NULL,
  PRIMARY KEY (`friend_id`,`requester_id`),
  KEY `FKja1j51ghf34kiae0y4tfp9vrj` (`requester_id`),
  CONSTRAINT `FK35d9paa2vkfu0t9t5r87o17qi` FOREIGN KEY (`friend_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKja1j51ghf34kiae0y4tfp9vrj` FOREIGN KEY (`requester_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table codemymobile.user_relations: ~12 rows (approximately)
/*!40000 ALTER TABLE `user_relations` DISABLE KEYS */;
INSERT INTO `user_relations` (`friend_id`, `requester_id`) VALUES
	(3, 1),
	(4, 1),
	(4, 2),
	(5, 2),
	(1, 3),
	(4, 3),
	(1, 4),
	(2, 4),
	(3, 4),
	(2, 5);
/*!40000 ALTER TABLE `user_relations` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
