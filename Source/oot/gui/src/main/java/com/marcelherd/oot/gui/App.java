package com.marcelherd.oot.gui;

import java.util.List;

import com.marcelherd.oot.persistence.QuestionService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        QuestionService questionService = new QuestionService();
        List<String> questions = questionService.findAllQuestions();
        for (String question : questions) {
        	System.out.println("Die Frage lautet: " + question);
        }
    }
}
