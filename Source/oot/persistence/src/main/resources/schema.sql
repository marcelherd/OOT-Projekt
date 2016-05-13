CREATE TABLE `questions` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`question`	TEXT NOT NULL,
	`answerA`	TEXT,
	`answerB`	TEXT,
	`answerC`	TEXT,
	`answerD`	TEXT,
	`correctAnswer`	TEXT NOT NULL,
	`difficulty`	TEXT NOT NULL
);