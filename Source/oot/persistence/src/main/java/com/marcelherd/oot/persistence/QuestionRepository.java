package com.marcelherd.oot.persistence;

import java.util.List;

public interface QuestionRepository {

	List<String> findAllQuestions();
	
}
