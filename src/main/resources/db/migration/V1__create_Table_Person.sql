CREATE TABLE IF NOT EXISTS `persons` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `first_name` varchar(15) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `last_name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
)