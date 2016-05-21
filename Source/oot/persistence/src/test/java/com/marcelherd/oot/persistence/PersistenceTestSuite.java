package com.marcelherd.oot.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.marcelherd.oot.persistence.repository.question.QuestionServiceEmptyTest;
import com.marcelherd.oot.persistence.repository.question.QuestionServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
	DatabaseTest.class,
	QuestionServiceTest.class,
	QuestionServiceEmptyTest.class
})
public class PersistenceTestSuite {

}
