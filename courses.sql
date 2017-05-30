-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.35-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.4.0.5148
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных education
CREATE DATABASE IF NOT EXISTS `education` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `education`;

-- Дамп структуры для таблица education.course
CREATE TABLE IF NOT EXISTS `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(50) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `auditorium` int(11) DEFAULT NULL,
  `teacher_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FK_f99pwvmr9fmufq1478fslhvwt` (`teacher_user_id`),
  CONSTRAINT `FK_f99pwvmr9fmufq1478fslhvwt` FOREIGN KEY (`teacher_user_id`) REFERENCES `teacher` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.course: ~2 rows (приблизительно)
DELETE FROM `course`;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`course_id`, `course_name`, `duration`, `auditorium`, `teacher_user_id`) VALUES
	(2, 'q', 12, 12, 1),
	(36, '5', 5, 5, 1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Дамп структуры для таблица education.student
CREATE TABLE IF NOT EXISTS `student` (
  `user_id` int(11) NOT NULL,
  `level` tinyint(1) DEFAULT NULL,
  `average` float DEFAULT NULL,
  `student_id_card` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK_bkix9btnoi1n917ll7bplkvg5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.student: ~2 rows (приблизительно)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`user_id`, `level`, `average`, `student_id_card`) VALUES
	(2, 5, 6.8, 547),
	(13, 2, 1.9, 1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Дамп структуры для таблица education.teacher
CREATE TABLE IF NOT EXISTS `teacher` (
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK_i5wqs2ds2vpmfpbcdxi9m2jvr` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.teacher: ~3 rows (приблизительно)
DELETE FROM `teacher`;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`user_id`) VALUES
	(1),
	(3),
	(16);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

-- Дамп структуры для таблица education.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.user: ~6 rows (приблизительно)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `surname`, `login`, `password`, `role`) VALUES
	(1, 'Константин', 'Орлов', 'KOrl', '123', 2),
	(2, 'Валерия', 'Ершова', 'VErs', '123', 1),
	(3, 'Степан', 'Пирогов', 'SPir', '123', 2),
	(4, 'Анастасия', 'Медведева', 'AMed', '123', 3),
	(13, 'Student', 'new', 'news', '123123', 1),
	(16, 'Teacher', 'new', 'newt', '111111', 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
