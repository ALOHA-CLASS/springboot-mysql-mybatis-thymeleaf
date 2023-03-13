CREATE TABLE `reply` (
  `reply_no` int NOT NULL AUTO_INCREMENT,
  `writer` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `content` text COLLATE utf8mb4_bin,
  `parent_no` int DEFAULT NULL,
  `depth_no` int NOT NULL DEFAULT '1',
  `seq_no` int NOT NULL DEFAULT '1',
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`reply_no`)
);
