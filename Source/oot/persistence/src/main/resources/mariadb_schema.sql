CREATE TABLE `questions` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`question` TEXT NOT NULL,
	`answerA` TEXT NULL,
	`answerB` TEXT NULL,
	`answerC` TEXT NULL,
	`answerD` TEXT NULL,
	`correctAnswer` TEXT NOT NULL,
	`difficulty` TEXT NOT NULL,
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB
;

CREATE TABLE `highscores` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` TEXT NOT NULL,
	`sum` INT(11) NOT NULL,
	`date` DATE NOT NULL,
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB
;
