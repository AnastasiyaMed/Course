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

-- Дамп структуры для таблица education.courses
CREATE TABLE IF NOT EXISTS `courses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `auditorium` int(11) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pgvq2criscl9xm2fxx5j4o9o1` (`user_id`),
  CONSTRAINT `FK_pgvq2criscl9xm2fxx5j4o9o1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.courses: ~6 rows (приблизительно)
DELETE FROM `courses`;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` (`id`, `auditorium`, `duration`, `name`, `user_id`) VALUES
	(1, 502, 120, 'Боль и унижение', 2),
	(2, 201, 60, 'Муки совести', NULL),
	(3, 123, 123, 'Новые новости', 2),
	(4, 13, 123, 'sesezwesy', 2),
	(5, 666, 2, 'Солнечные дни', 2),
	(6, 26, 432, 'Животноводство', 5);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;

-- Дамп структуры для таблица education.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.roles: ~2 rows (приблизительно)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'STUDENT'),
	(2, 'TEACHER'),
	(3, 'ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Дамп структуры для таблица education.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ow0gan20590jrb00upg3va2fn` (`login`),
  KEY `FK_krvotbtiqhudlkamvlpaqus0t` (`role_id`),
  CONSTRAINT `FK_krvotbtiqhudlkamvlpaqus0t` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.users: ~5 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `first_name`, `last_name`, `login`, `password`, `role_id`) VALUES
	(1, 'qwerty', 'qwerty', 'qwerty', '11111111', 1),
	(2, 'prepod', 'prepod', 'prepod', '11111111', 2),
	(3, 'admin', 'admin', 'administrator', '11111111', 3),
	(4, 'Степан', 'Рыжиков', 'solnyshko', '11111111', 1),
	(5, 'Лариса', 'Ручкина', 'loriella', '11111111', 2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Дамп структуры для таблица education.users_has_courses
CREATE TABLE IF NOT EXISTS `users_has_courses` (
  `user_id` bigint(20) NOT NULL,
  `course_id` bigint(20) NOT NULL,
  KEY `FK_q8yc3n1umbrfq64ffk05o11s1` (`course_id`),
  KEY `FK_23lwc84ag7dyc8l6l4imf68kf` (`user_id`),
  CONSTRAINT `FK_23lwc84ag7dyc8l6l4imf68kf` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_q8yc3n1umbrfq64ffk05o11s1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.users_has_courses: ~1 rows (приблизительно)
DELETE FROM `users_has_courses`;
/*!40000 ALTER TABLE `users_has_courses` DISABLE KEYS */;
INSERT INTO `users_has_courses` (`user_id`, `course_id`) VALUES
	(1, 2);
/*!40000 ALTER TABLE `users_has_courses` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
