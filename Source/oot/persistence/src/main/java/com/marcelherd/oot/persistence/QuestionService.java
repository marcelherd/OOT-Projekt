package com.marcelherd.oot.persistence;

import java.util.Arrays;
import java.util.List;

public class QuestionService implements QuestionRepository {
	
	public List<String> findAllQuestions() {
		return Arrays.asList("Wie macht die Kuh?", "Welche Farbe hat das Auto?");
	}

}
