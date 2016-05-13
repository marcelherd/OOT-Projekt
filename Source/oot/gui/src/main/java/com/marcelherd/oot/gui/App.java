package com.marcelherd.oot.gui;

import java.util.List;

import com.marcelherd.oot.persistence.QuestionService;
import com.marcelherd.oot.persistence.model.Question;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        QuestionService questionService = new QuestionService();
        List<Question> questions = questionService.findAll();
        for (Question question : questions) {
        	System.out.println("Die Frage lautet: " + question);
        }
    }
}
