package com.marcelherd.oot.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.marcelherd.oot.persistence.entity.Question;
import com.marcelherd.oot.persistence.entity.Question.Difficulty;
import com.marcelherd.oot.persistence.repository.QuestionService;
import com.marcelherd.oot.persistence.repository.QuestionServiceFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static GameDifficulty difficulty = GameDifficulty.EASY;
	
    public static void main( String[] args )
    {
        QuestionService questionService = QuestionServiceFactory.getInstance();
        
        List<Question> questions = questionService.findAll(); // Gesamter Fragen-Pool

        List<Question> easyQuestions = questionService.findByDifficulty(Difficulty.EASY); // einfache Fragen
        List<Question> mediumQuestions = questionService.findByDifficulty(Difficulty.MEDIUM); // mittlere Fragen
        List<Question> hardQuestions = questionService.findByDifficulty(Difficulty.HARD); // schwere Fragen
        List<Question> veryHardQuestions = questionService.findByDifficulty(Difficulty.VERY_HARD); // sehr schwere Fragen
        
        Collections.shuffle(easyQuestions); // zufällige Fragen auswählen
        
        List<Question> selectedQuestions = new ArrayList<Question>(); // Fragen-Pool für die aktuelle Sitzung
        for (int i = 0; i < difficulty.easyQuestions; i++) {
        	selectedQuestions.add(easyQuestions.get(i));
        }
        // analog mit den anderen Schwierigkeiten
    }
    
    enum GameDifficulty {

    	EASY(10, 4, 1, 0),
    	MEDIUM(6, 5, 3, 1),
    	HARD(4, 4, 5, 2);

    	final int easyQuestions;
    	final int mediumQuestions;
    	final int hardQuestions;
    	final int veryHardQuestions;
    	
    	GameDifficulty(int easyQuestions, int mediumQuestions, int hardQuestions, int veryHardQuestions) {
    		this.easyQuestions = easyQuestions;
    		this.mediumQuestions = mediumQuestions;
    		this.hardQuestions = hardQuestions;
    		this.veryHardQuestions = veryHardQuestions;
    	}
    	
    }
    
}
