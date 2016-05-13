package com.marcelherd.oot.gui;

import java.util.List;

import com.marcelherd.oot.persistence.entity.Question;
import com.marcelherd.oot.persistence.repository.QuestionService;
import com.marcelherd.oot.persistence.repository.QuestionServiceFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        QuestionService questionService = QuestionServiceFactory.getInstance();
        List<Question> questions = questionService.findAll();
        for (Question question : questions) {
        	System.out.println("Die Frage lautet: " + question);
        }
    }
}
