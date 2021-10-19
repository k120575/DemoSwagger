DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
                        `bookId` int(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        `author` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;