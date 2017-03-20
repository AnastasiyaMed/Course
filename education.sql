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
  `teacher_teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`,`teacher_teacher_id`),
  KEY `fk_course_teacher1_idx` (`teacher_teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.course: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
REPLACE INTO `course` (`course_id`, `course_name`, `duration`, `auditorium`, `teacher_teacher_id`) VALUES
	(2, 'Криптография', 120, 120, 1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Дамп структуры для таблица education.student
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `level` tinyint(1) DEFAULT NULL,
  `average` float DEFAULT NULL,
  `student_id_card` int(11) DEFAULT NULL,
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`user_user_id`),
  KEY `fk_student_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_student_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.student: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
REPLACE INTO `student` (`student_id`, `level`, `average`, `student_id_card`, `user_user_id`) VALUES
	(11, 0, 0, 122566, 1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Дамп структуры для таблица education.student_has_course
CREATE TABLE IF NOT EXISTS `student_has_course` (
  `student_student_id` int(11) NOT NULL,
  `course_course_id` int(11) NOT NULL,
  `mark` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_student_id`,`course_course_id`),
  KEY `fk_student_has_course_course1_idx` (`course_course_id`),
  KEY `fk_student_has_course_student1_idx` (`student_student_id`),
  CONSTRAINT `fk_student_has_course_course1` FOREIGN KEY (`course_course_id`) REFERENCES `course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_has_course_student1` FOREIGN KEY (`student_student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.student_has_course: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `student_has_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_has_course` ENABLE KEYS */;

-- Дамп структуры для таблица education.teacher
CREATE TABLE IF NOT EXISTS `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`teacher_id`,`user_user_id`),
  KEY `fk_teacher_user_idx` (`user_user_id`),
  CONSTRAINT `fk_teacher_user` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.teacher: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
REPLACE INTO `teacher` (`teacher_id`, `user_user_id`) VALUES
	(5, 1);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

-- Дамп структуры для таблица education.user
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы education.user: ~7 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`user_id`, `name`, `surname`, `login`, `password`, `role`) VALUES
	(1, 'Константин', 'Орлов', 'KOrl', '123', 2),
	(2, 'Валерия', 'Ершова', 'VErs', '123', 1),
	(3, 'Степан', 'Пирогов', 'SPir', '123', 2),
	(4, 'Анастасия', 'Медведева', 'AMed', '123', 3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
