package com.marcelherd.oot.persistence.repository.question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.marcelherd.oot.persistence.domain.Question;
import com.marcelherd.oot.persistence.domain.Question.Difficulty;

/**
 * @author Richard Vladimirskij
 * 
 * QuestionCreator - parses a Tab-Separated-Value file into the Question Database for WWM.
 * The file needs the format: QUESTION|ANSWER A|ANSWER B|ANSWER C|ANSWER D|CORRECT ANSWER|DIFFICULTY
 * per line. Also you need to ensure the question array is initiated with the correct length before you execute this program.
 * Finally, you may need to change the directory the file is loaded from.
 * */


public class QuestionCreator {

	public static void main(String[] args) {
		//Set-up column arrays
		String[] questions = new String[20];
		String[] answerAs = new String[questions.length];
		String[] answerBs = new String[questions.length];
		String[] answerCs = new String[questions.length];
		String[] answerDs = new String[questions.length];
		String[] correctAnswers = new String[questions.length];
		int[] difficulties = new int[questions.length]; // 0 for EASY, 1 for MEDIUM, 2 for HARD, 3 for VERY_HARD
		String result = "";
		
		//Set-up reader and populate the individual arrays
		try {
			Reader fr = new BufferedReader(new FileReader("c:/easy-questions.csv"));
			
			//Go through the file and separate data into the correct arrays
			int i = 0;
			char currentChar = ' ';
			while(i < questions.length) {
				boolean questionSet = false;
				boolean aSet = false;
				boolean bSet = false;
				boolean cSet = false;
				boolean dSet = false;
				boolean answerSet = false;
				
				result = "";
				while(!questionSet && fr.ready()) { //Fill Current Question
					currentChar = (char)fr.read();
					if(currentChar != '|')
						result += currentChar;
					else
						questionSet = true;
				}
				questions[i] = result;
				
				result = "";
				while(!aSet && fr.ready()) { // Fill Answer A
					currentChar = (char)fr.read();
					if(currentChar != '|')
						result += currentChar;
					else
						aSet = true;
				}
				answerAs[i] = result;
				
				result = "";
				while(!bSet && fr.ready()) { // Fill Answer B
					currentChar = (char)fr.read();
					if(currentChar != '|')
						result += currentChar;
					else
						bSet = true;
				}
				answerBs[i] = result;
				
				result = "";
				while(!cSet && fr.ready()) { // Fill Answer C
					currentChar = (char)fr.read();
					if(currentChar != '|')
						result += currentChar;
					else
						cSet = true;
				}
				answerCs[i] = result;
				
				result = "";
				while(!dSet && fr.ready()) { // Fill Answer D
					currentChar = (char)fr.read();
					if(currentChar != '|')
						result += currentChar;
					else
						dSet = true;
				}
				answerDs[i] = result;
				
				result = "";
				while(!answerSet && fr.ready()) { // Fill Correct Answer
					currentChar = (char)fr.read();
					if(currentChar != '|')
						result += currentChar;
					else
						answerSet = true;
				}
				correctAnswers[i] = result;
				
				//Finally, get the difficulty for this question;
				difficulties[i] = (fr.read() - '0');
				
				i++;	
			}
			
		fr.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Populate the individual questions in the question array
		Question[] payload = new Question[questions.length];
		Difficulty d = Difficulty.EASY;
		for(int i = 0; i < questions.length; i++) {
			payload[i] = new Question();
			payload[i].setId((long)i);
			payload[i].setQuestion(questions[i]);
			payload[i].setAnswerA(answerAs[i]);
			payload[i].setAnswerB(answerBs[i]);
			payload[i].setAnswerC(answerCs[i]);
			payload[i].setAnswerD(answerDs[i]);
			payload[i].setCorrectAnswer(correctAnswers[i]);
			
			if(difficulties[i] == 0)
				d = Difficulty.EASY;
			if(difficulties[i] == 1)
				d = Difficulty.MEDIUM;
			if(difficulties[i] == 2)
				d = Difficulty.HARD;
			if(difficulties[i] == 3)
				d = Difficulty.VERY_HARD;
			payload[i].setDifficulty(d);
		}
		
		//Enter each question from the question array into the database
		JDBCQuestionService qs = new JDBCQuestionService();
		
		for(int i = 0; i < questions.length; i++)
			qs.save(payload[i]);
		
		
		System.out.println("Successfully saved question.");
	}

}
